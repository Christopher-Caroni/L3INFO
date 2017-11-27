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

% Q6
schemaQ6([a, b, c, d, e]).
fdsQ6([ [[a,b],[c]], [[c,d],[e]],[[d,e],[b]] ]).

% is AB candidate key?
% schemaQ6(R), fdsQ6(F), candkey(R,F,[a,b]).
% is ABD candidate key?
% schemaQ6(R), fdsQ6(F), candkey(R,F,[a,b,d]).

% Q7
schemaQ7([courseno,secno,offeringdept,credithours,courselevel, instructorssn,semester,year, dayshours,roomno, noofstudents]).
fdsQ7([ [[courseno],[offeringdept, credithours, courselevel]], [[courseno, secno, semester, year],[dayshours, roomno, noofstudents, instructorssn]],
[[roomno, dayshours, semester, year],[instructorssn, courseno, secno]] ]).


% clé de R
% schemaQ7(R), fdsQ7(F), candkey(R,F,K).

% 3NF de R
% schemaQ7(R), fdsQ7(F), threenf(R,F,R3NF).

% Q8
schemaQ8([propertyid,countyname,lotno,area,price,taxrate]).
fdsQ8([ [[propertyid],[countyname, lotno, area, price, taxrate]], [[countyname, lotno],[propertyid, area, price, taxrate]],[[countyname],[taxrate]] ]).
decompQ8([[propertyis,area,lotno],[area,countyname],[area,price],[countyname,taxrate] ]).

% tests lossless decomposition
% schemaQ8(R), fdsQ8(F), decompQ8(D), ljd(R,F,D).
