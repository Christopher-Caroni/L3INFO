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