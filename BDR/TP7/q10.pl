% Q10
schemaQ10([a,b,c,d,e,f,h,i]).
fdsQ10([ [[a,b],[c]], [[b,d],[e, f]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).

% prints all the candidate keys of R
% schemaQ10(R), fdsQ10(F), candkey(R,F,K).
%  R = [a, b, c, d, e, f, g, h, i|...],
%  F = [[[a, b], [c]], [[b, d], [e, f]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
%  K = [a, b, d] ;

% puts the the minimal cover of R in MinF
% schemaQ10(R),fdsQ10(F),mincover(R,F,MinF).
%  R = [a, b, c, d, e, f, g, h, i|...],
%  F = [[[a, b], [c]], [[b, d], [e, f]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
%  MinF = [[[a, b], [c]], [[b], [f]], [[b, d], [e]], [[d], [i, j]], [[f], [g, h]]] ;

% returns a decomposition of R into 3NF in the R3NF variable
% schemaQ10(R), fdsQ10(F), threenf(R,F,R3NF).
%  R = [a, b, c, d, e, f, g, h, i|...],
%  F = [[[a, b], [c]], [[b, d], [e, f]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
%  R3NF = [[a, b, c], [b, f], [b, d, e], [d, i, j], [f, g, h], [a, b, d]] .


