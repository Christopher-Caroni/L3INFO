% Q3
% couverture minimale des dependances de Q2
% schemaQ2(R),fdsQ2(F),mincover(R,F,MinF).

% Resultat: MinF = [[[dnumber], [dmgrssn, dname]], [[ssn], [address, bdate, dnumber, ename]]]


% test equivalence
% repQ3() :- schemaQ2(R),fdsQ2(F), equiv(R,F,[[[dnumber], [dmgrssn, dname]], [[ssn], [address, bdate, dnumber, ename]]]).

% Resultat: true
%R = [ename, ssn, bdate, address, dnumber, dname, dmgrssn],
%F = [[[ssn], [ename, bdate, address, dnumber]], [[dnumber], [dname, dmgrssn]]] .