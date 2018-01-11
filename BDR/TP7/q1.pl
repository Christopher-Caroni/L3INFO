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