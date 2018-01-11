% Q1
schema([a,c,d,e,h]).
fds1([ [[a],[c]], [[a,c],[d]], [[e],[a,d]], [[e],[h]] ]).
fds2([ [[a],[c,d]], [[e],[a,h]] ]).

% test equivalence
% repQ1() :- schema(R), fds1(F1), fds2(F2), equiv(R,F1,F2).

%Resultat: true
%R = [a, c, d, e, h],
%F1 = [[[a], [c]], [[a, c], [d]], [[e], [a, d]], [[e], [h]]],
%F2 = [[[a], [c, d]], [[e], [a, h]]] .

% Q2
schemaQ2([ename,ssn,bdate,address,dnumber,dname,dmgrssn]).
fdsQ2([ [[ssn],[ename,bdate,address, dnumber]], [[dnumber],[dname, dmgrssn]] ]).

% cloture de ssn
% schemaQ2(R), fdsQ2(F), xplus(R,F,[ssn], Xplus).
% Resultat: Xplus = [address, bdate, dmgrssn, dname, dnumber, ename, ssn].

% cloture de dnumber
% schemaQ2(R), fdsQ2(F), xplus(R,F,[dnumber], Xplus).
% Resultat: Xplus = [dmgrssn, dname, dnumber].


% Q3
% couverture minimale des dependances de Q2
% schemaQ2(R),fdsQ2(F),mincover(R,F,MinF).

% Resultat: MinF = [[[dnumber], [dmgrssn, dname]], [[ssn], [address, bdate, dnumber, ename]]]


% test equivalence
% repQ3() :- schemaQ2(R),fdsQ2(F), equiv(R,F,[[[dnumber], [dmgrssn, dname]], [[ssn], [address, bdate, dnumber, ename]]]).

% Resultat: true
%R = [ename, ssn, bdate, address, dnumber, dname, dmgrssn],
%F = [[[ssn], [ename, bdate, address, dnumber]], [[dnumber], [dname, dmgrssn]]] .

% Q4
schemaQ4([a, b, c, d, e, f, g, h, i]).
fdsQ4([ [[a,b],[c]], [[a],[d, e]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

% clé de R
% schemaQ4(R), fdsQ4(F), superkey(R,F,K).
% Resultat: false

% 3NF de R
% schemaQ4(R), fdsQ4(F), threenf(R,F,R3NF).

% Resultat: true
% R = [a, b, c, d, e, f, g, h, i],
% F = [[[a, b], [c]], [[a], [d, e]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
% R3NF = [[a, d, e], [a, b, c], [b, f], [d, i, j], [f, g, h]]

% Q5
fdsQ5([ [[a,b],[c]], [[b,d],[e,f]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

% clé de R
% schemaQ4(R), fdsQ5(F), superkey(R,F,K).
% Résultat: false

% 3NF de R
% schemaQ4(R), fdsQ5(F), threenf(R,F,R3NF).
% Resultat : false

% Q6
schemaQ6([a, b, c, d, e]).
fdsQ6([ [[a,b],[c]], [[c,d],[e]],[[d,e],[b]] ]).

% is AB candidate key?
% schemaQ6(R), fdsQ6(F), candkey(R,F,[a,b]).
% Resultat: false
% is ABD candidate key?
% schemaQ6(R), fdsQ6(F), candkey(R,F,[a,b,d]).
% Resultat: true
% R = [a, b, c, d, e],
% F = [[[a, b], [c]], [[c, d], [e]], [[d, e], [b]]] .


% Q7
schemaQ7([courseno,secno,offeringdept,credithours,courselevel, instructorssn,semester,year, dayshours,roomno, noofstudents]).
fdsQ7([ [[courseno],[offeringdept, credithours, courselevel]], [[courseno, secno, semester, year],[dayshours, roomno, noofstudents, instructorssn]],
[[roomno, dayshours, semester, year],[instructorssn, courseno, secno]] ]).


% clé de R
% schemaQ7(R), fdsQ7(F), candkey(R,F,K).
% Resultat: K = [semester, year, dayshours, roomno] .

% 3NF de R
% schemaQ7(R), fdsQ7(F), threenf(R,F,R3NF).
% Resultat: R3NF = [[courseno, courselevel, credithours, offeringdept], [courseno, secno, semester, year, dayshours, noofstudents, roomno], [roomno, dayshours, semester, year, courseno, instructorssn|...]] .

% Q8
schemaQ8([propertyid,countyname,lotno,area,price,taxrate]).
fdsQ8([ [[propertyid],[countyname, lotno, area, price, taxrate]], [[countyname, lotno],[propertyid, area, price, taxrate]],[[countyname],[taxrate]] ]).
decompQ8([[propertyis,area,lotno],[area,countyname],[area,price],[countyname,taxrate] ]).

% tests if decompQ8 is a lossless decomposition of schemaQ8
% schemaQ8(R), fdsQ8(F), decompQ8(D), ljd(R,F,D).
/* Resultat:
[[b,1,1],[b,1,2],[a,3],[a,4],[b,1,5],[b,1,6]]
[[b,2,1],[a,2],[b,2,3],[a,4],[b,2,5],[a,6]]
[[b,3,1],[b,3,2],[b,3,3],[a,4],[a,5],[b,3,6]]
[[b,4,1],[a,2],[b,4,3],[b,4,4],[b,4,5],[a,6]]
false.
*/


% Q9
schemaQ9([a,b,c,d,e,f,h,i]).
fdsQ9([ [[a,b],[c]], [[a],[d, e]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).

% prints all the candidate keys of R
% schemaQ9(R), fdsQ9(F), candkey(R,F,K).

% puts the the minimal cover of R in MinF
% schemaQ9(R),fdsQ9(F),mincover(R,F,MinF).

% returns a decomposition of R into 3NF in the R3NF variable
% schemaQ9(R), fdsQ9(F), threenf(R,F,R3NF).

% Q10
schemaQ10([a,b,c,d,e,f,h,i]).
fdsQ10([ [[a,b],[c]], [[b,d],[e, f]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).

% prints all the candidate keys of R
% schemaQ10(R), fdsQ10(F), candkey(R,F,K).

% puts the the minimal cover of R in MinF
% schemaQ10(R),fdsQ10(F),mincover(R,F,MinF).

% returns a decomposition of R into 3NF in the R3NF variable
% schemaQ10(R), fdsQ10(F), threenf(R,F,R3NF).

% Q11
schemaQ11([a,b,c,d,e,f,h,i]).
fdsQ11([ [[a,b],[c]], [[a],[d, e]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).

% returns in D a decomposition of R into BCNF.
% schemaQ11(R), fdsQ11(F), bcnf(R,F,D).

% with new functional dependancies:
fdsQ11_2([ [[a,b],[c]], [[b,d],[e, f]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).
% returns in D a decomposition of R into BCNF.
% schemaQ11(R), fdsQ11_2(F), bcnf(R,F,D).

% Q12
schemaQ12([a,b,c,d,e]).
fdsQ12([ [[a,b],[c]], [[c,d],[e]],[[d,e],[b]] ]).

% prints all the candidate keys of R
% schemaQ12(R), fdsQ12(F), candkey(R,F,K).

% returns a decomposition of R into 3NF in the R3NF variable
% schemaQ12(R), fdsQ12(F), threenf(R,F,R3NF).

% returns in D a decomposition of R into BCNF.
% schemaQ12(R), fdsQ12(F), bcnf(R,F,D).

% Q12.2
schemaQ12_2([courseno,secno,offeringdept,credithours,courselevel,
instructorssn,semester,year, dayshours,roomno,
noofstudents]).
fdsQ12_2([ [[courseno],[offeringdept, credithours, courselevel]], [[courseno, secno, semester, year],[dayshours, roomno, noofstudents, instructorssn]], [[roomno, dayshours, semester, year],[instructorssn, courseno, secno]] ]).

 % prints all the candidate keys of R
 % schemaQ12_2(R), fdsQ12_2(F), candkey(R,F,K).

 % returns a decomposition of R into 3NF in the R3NF variable
 % schemaQ12_2(R), fdsQ12_2(F), threenf(R,F,R3NF).

 % returns in D a decomposition of R into BCNF.
 % schemaQ12_2(R), fdsQ12_2(F), bcnf(R,F,D).

 % Q13
 schemaQ13([a,b,c,d,e,f,h,i]).
 fdsQ13([ [[a,b],[c]], [[a],[d,e]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).
 d1([r1,r2,r3,r4,r5]).
r1([a,b,c]).
r2([a,d,e]).
r3([b,f]).
r4([f,g,h]).
r5([d,i,j]).


% schema(R), fds(F), d1(D), fpd(R,F,D).


% schema(R), fds(F), decomp(D), ljd(R,F,D).
% [[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5],[b,1,6],[b,1,7],[b,1,8],[b,1,9],[b,1,10]]
% [[b,2,1],[b,2,2],[b,2,3],[b,2,4],[b,2,5],[b,2,6],[b,2,7],[b,2,8],[b,2,9],[b,2,10]]
% [[b,3,1],[b,3,2],[b,3,3],[b,3,4],[b,3,5],[b,3,6],[b,3,7],[b,3,8],[b,3,9],[b,3,10]]
% [[b,4,1],[b,4,2],[b,4,3],[b,4,4],[b,4,5],[b,4,6],[b,4,7],[b,4,8],[b,4,9],[b,4,10]]
% [[b,5,1],[b,5,2],[b,5,3],[b,5,4],[b,5,5],[b,5,6],[b,5,7],[b,5,8],[b,5,9],[b,5,10]]

% Q14
schemaQ14([m,y,p,mp,c]).

fdsQ14([ [[m],[m,p]],
      [[m,y],[p]],
      [[mp],[c]] ]).




%schema(R), fds(F), candkey(R,F,[m]).
%false.

%schema(R), fds(F), candkey(R,F,[m,y]).
%false.

%schema(R), fds(F), candkey(R,F,[m,c]).
%false.

%schema(R), fds(F), is3NF(R,F).
%false.

%schema(R), fds(F), isBCNF(R,F).
%false.


%d([ [[m,y,p],[m,mp,class]] ]).

%schema(R), fds(F), d(D), ljd(R,F,D).
%[[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5]].

