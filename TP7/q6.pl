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