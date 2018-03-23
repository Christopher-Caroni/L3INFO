% Q9
schemaQ9([a,b,c,d,e,f,h,i]).
fdsQ9([ [[a,b],[c]], [[a],[d, e]],[[b],[f]] ,[[f],[g,h]] ,[[d],[i,j]] ]).

% prints all the candidate keys of R
% schemaQ9(R), fdsQ9(F), candkey(R,F,K).
  %R = [a, b, c, d, e, f, g, h, i|...],
  %F = [[[a, b], [c]], [[a], [d, e]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
  %K = [a, b] .

% puts the the minimal cover of R in MinF
% schemaQ9(R),fdsQ9(F),mincover(R,F,MinF).
  %R = [a, b, c, d, e, f, g, h, i|...],
  %F = [[[a, b], [c]], [[a], [d, e]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
  %MinF = [[[a], [d, e]], [[a, b], [c]], [[b], [f]], [[d], [i, j]], [[f], [g, h]]] ;

% returns a decomposition of R into 3NF in the R3NF variable
% schemaQ9(R), fdsQ9(F), threenf(R,F,R3NF).
  %R = [a, b, c, d, e, f, g, h, i|...],
  %F = [[[a, b], [c]], [[a], [d, e]], [[b], [f]], [[f], [g, h]], [[d], [i, j]]],
  %R3NF = [[a, d, e], [a, b, c], [b, f], [d, i, j], [f, g, h]] .