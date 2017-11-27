% Q1
schema([a,c,d,e,h]).
fds1([ [[a],[c]], [[a,c],[d]], [[e],[a,d]], [[e],[h]] ]).
fds2([ [[a],[c,d]], [[e],[a,h]] ]).

% test equivalence
% repQ1() :- schema(R), fds1(F1), fds2(F2), equiv(R,F1,F2).

% Q2
schemaQ2([ename,ssn,bdate,address,dnumber,dname,dmgrssn]).
fdsQ2([ [[ssn],[ename,bdate,address, dnumber]], [[dnumber],[dname, dmgrssn]] ]).

% cloture de ssn
% schemaQ2(R), fdsQ2(F), xplus(R,F,[ssn], Xplus).

% cloture de dnumber
% schemaQ2(R), fdsQ2(F), xplus(R,F,[dnumber], Xplus).


% Q3
% couverture minimale des dependances de Q2
% schemaQ2(R),fdsQ2(F),mincover(R,F,MinF).

% résultat:
% MinF = [[[dnumber], [dmgrssn, dname]], [[ssn], [address, bdate, dnumber, ename]]]

% test equivalence
% repQ3() :- schemaQ2(R),fdsQ2(F),mincover(R,F,MinF), equiv(R,F,MinF).


% Q4
schemaQ4([a, b, c, d, e, f, g, h, i]).
fdsQ4([ [[a,b],[c]], [[a],[d, e]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

% clé de R
% schemaQ4(R), fdsQ4(F), superkey(R,F,K).

% 3NF de R
% schemaQ4(R), fdsQ4(F), threenf(R,F,R3NF).

% Q5
fdsQ5([ [[a,b],[c]], [[b,d],[e,f]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

% clé de R
% schemaQ4(R), fdsQ5(F), superkey(R,F,K).

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

% tests if decompQ8 is a lossless decomposition of schemaQ8
% schemaQ8(R), fdsQ8(F), decompQ8(D), ljd(R,F,D).


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
fdsQ12_2([ [[courseno,[offeringdept, credithours, courselevel]],
 [[courseno, secno, semester, year],[dayshours, roomno, noofstudents, instructorssn]],
 [[roomno, dayshours, semester, year],[instructorssn, courseno, secno]] ]).

 % prints all the candidate keys of R
 % schemaQ12_2(R), fdsQ12_2(F), candkey(R,F,K).

 % returns a decomposition of R into 3NF in the R3NF variable
 % schemaQ12_2(R), fdsQ12_2(F), threenf(R,F,R3NF).

 % returns in D a decomposition of R into BCNF.
 % schemaQ12_2(R), fdsQ12_2(F), bcnf(R,F,D).
