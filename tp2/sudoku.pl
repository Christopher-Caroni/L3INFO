% Logique - TP3

% Guillaume Lepretre
% Caroni Christopher


grille([[_,_,_,_,_,_,_,_,_],
        [_,_,_,_,_,3,_,8,5],
        [_,_,1,_,2,_,_,_,_],
        [_,_,_,5,_,7,_,_,_],
        [_,_,4,_,_,_,1,_,_],
        [_,9,_,_,_,_,_,_,_],
        [5,_,_,_,_,_,_,7,3],
        [_,_,2,_,1,_,_,_,_],
        [_,_,_,_,4,_,_,_,9]]).

% question 1
printline([]) :- writeln("|").
printline([X|XS]) :- integer(X), write("|"), write(X), printline(XS).
printline([X|XS]) :- not(integer(X)), write("| "), printline(XS).

% question 2
print([]).
print([X|XS]) :- printline(X), print(XS).

% question 3
bonnelongueur([], 0) :- !.
bonnelongueur([_|XS], RES) :- !, bonnelongueur(XS, R), RES is R + 1.

% question 4
bonnetaille([], _) :- !.
bonnetaille([X|XS], RES) :- !, bonnelongueur(X, RES), bonnetaille(XS, RES).


:- use_module(library(clpfd)).


% question 5
verifie([]) :- !.
verifie([X|XS]) :- !, all_distinct(X), X ins 1..9, verifie(XS).

% question 6
eclate([], R, R) :- !.
eclate([X|L], [], [[X]|R]) :- !, eclate(L, [], R).
eclate([X1|L], [X2|L2], [X3|R]) :- !, eclate(L, L2, R), X3 = [X1|X2].

% question 7
transp([], []) :- !.
transp([X|L], R) :- transp(L, R1), eclate(X, R1, R).

% question 8
decoupe([], [], [], []) :- !.
decoupe([L11,L12,L13|L1S], [L21,L22,L23|L2S], [L31,L32,L33|L3S], [[L11,L12,L13,L21,L22,L23,L31,L32,L33]|RS]) :- !, decoupe(L1S, L2S, L3S, RS).

% question 9
ajoute_en_queue(Add,[],[Add]).
ajoute_en_queue(Add,[Head|Tail], [Head|Newtail]) :- ajoute_en_queue(Add,Tail, Newtail).

concatene(Premier, [], Premier).
concatene(Premier, [Head|Tail], Res) :- ajoute_en_queue(Head, Premier, Newlist), concatene(Newlist, Tail, Res).

carres([],_) :- !.
carres([X,Y,Z|XS], RES) :- decoupe(X,Y,Z, HEAD), carres(XS, TAIL), concatene(HEAD, TAIL, RES).

% question 10
solution(X) :- verifie(X), transp(X,Y), verifie(Y),	carres(Y, Z), verifie(Z).
