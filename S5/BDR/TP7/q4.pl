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