% Q2
schemaQ2([ename,ssn,bdate,address,dnumber,dname,dmgrssn]).
fdsQ2([ [[ssn],[ename,bdate,address, dnumber]], [[dnumber],[dname, dmgrssn]] ]).

% cloture de ssn
% schemaQ2(R), fdsQ2(F), xplus(R,F,[ssn], Xplus).
% Resultat: Xplus = [address, bdate, dmgrssn, dname, dnumber, ename, ssn].

% cloture de dnumber
% schemaQ2(R), fdsQ2(F), xplus(R,F,[dnumber], Xplus).
% Resultat: Xplus = [dmgrssn, dname, dnumber].