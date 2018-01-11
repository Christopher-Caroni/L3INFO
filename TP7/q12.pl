% Q12
schemaQ12([a,b,c,d,e]).
fdsQ12([ [[a,b],[c]], [[c,d],[e]],[[d,e],[b]] ]).

% prints all the candidate keys of R
% schemaQ12(R), fdsQ12(F), candkey(R,F,K).
% R = [a, b, c, d, e],
% F = [[[a, b], [c]], [[c, d], [e]], [[d, e], [b]]],
% K = [a, d, e] .

% returns a decomposition of R into 3NF in the R3NF variable
% schemaQ12(R), fdsQ12(F), threenf(R,F,R3NF).
% R = [a, b, c, d, e],
% F = [[[a, b], [c]], [[c, d], [e]], [[d, e], [b]]],
% R3NF = [[a, b, c], [c, d, e], [d, e, b], [a, d, e]] .

% returns in D a decomposition of R into BCNF.
% schemaQ12(R), fdsQ12(F), bcnf(R,F,D).
Scheme to decompose = [a,b,c,d,e] Offending FD: [a,b]-->[c]
%Scheme to decompose = [a,b,d,e] Offending FD: [d,e]-->[b]
%Final Result is:
%[a,d,e]
%[a,b,c]
%[d,e,b]
%R = [a, b, c, d, e],
%F = [[[a, b], [c]], [[c, d], [e]], [[d, e], [b]]],
%D = [[a, d, e], [a, b, c], [d, e, b]] .

% Q12.2
schemaQ12_2([courseno,secno,offeringdept,credithours,courselevel,
instructorssn,semester,year, dayshours,roomno,
noofstudents]).
fdsQ12_2([ [[courseno],[offeringdept, credithours, courselevel]], [[courseno, secno, semester, year],[dayshours, roomno, noofstudents, instructorssn]], [[roomno, dayshours, semester, year],[instructorssn, courseno, secno]] ]).

 % prints all the candidate keys of R
 % schemaQ12_2(R), fdsQ12_2(F), candkey(R,F,K).
 %R = [courseno, secno, offeringdept, credithours, courselevel, instructorssn, semester, year, dayshours|...],
 %F = [[[courseno], [offeringdept, credithours, courselevel]], [[courseno, secno, semester, year], [dayshours, roomno, noofstudents, instructorssn]], [[roomno, dayshours, semester, year], [instructorssn, courseno, secno]]],
 %K = [semester, year, dayshours, roomno] .

 % returns a decomposition of R into 3NF in the R3NF variable
 % schemaQ12_2(R), fdsQ12_2(F), threenf(R,F,R3NF).
 %R = [courseno, secno, offeringdept, credithours, courselevel, instructorssn, semester, year, dayshours|...],
 %F = [[[courseno], [offeringdept, credithours, courselevel]], [[courseno, secno, semester, year], [dayshours, roomno, noofstudents, instructorssn]], [[roomno, dayshours, semester, year], [instructorssn, courseno, secno]]],
 %R3NF = [[courseno, courselevel, credithours, offeringdept], [courseno, secno, semester, year, dayshours, noofstudents, roomno], [roomno, dayshours, semester, year, courseno, instructorssn|...]] .

 % returns in D a decomposition of R into BCNF.
 % schemaQ12_2(R), fdsQ12_2(F), bcnf(R,F,D).
 %Scheme to decompose = [courseno,secno,offeringdept,credithours,courselevel,instructorssn,semester,year,dayshours,roomno,noofstudents] Offending FD: [courseno]-->[courselevel,credithours,offeringdept]
 %Final Result is:
[courseno,secno,instructorssn,semester,year,dayshours,roomno,noofstudents]
[courseno,courselevel,credithours,offeringdept]

%R = [courseno, secno, offeringdept, credithours, courselevel, instructorssn, semester, year, dayshours|...],
%F = [[[courseno], [offeringdept, credithours, courselevel]], [[courseno, secno, semester, year], [dayshours, roomno, noofstudents, instructorssn]], [[roomno, dayshours, semester, year], [instructorssn, courseno, secno]]],
%D = [[courseno, secno, instructorssn, semester, year, dayshours, roomno, noofstudents], [courseno, courselevel, credithours, offeringdept]] .