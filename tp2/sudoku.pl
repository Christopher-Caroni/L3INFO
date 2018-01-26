 /*
  Guillaume Lepretre
  Christopher Caroni
*/

grille([[_,_,_,_,_,_,_,_,_],
        [_,_,_,_,_,3,_,8,5],
        [_,_,1,_,2,_,_,_,_],
        [_,_,_,5,_,7,_,_,_],
        [_,_,4,_,_,_,1,_,_],
        [_,9,_,_,_,_,_,_,_],
        [5,_,_,_,_,_,_,7,3],
        [_,_,2,_,1,_,_,_,_],
        [_,_,_,_,4,_,_,_,9]]).

/* Question 1 */
printline([]):- writeln('|').
printline([X|XS]):- integer(X), !, write("|"), write(X), printline(XS).
printline([X|XS]):- !, write("| "), printline(XS).

/* Question 2 */
print([]).
print([X|XS]):- printline(X), print(XS).
/* Question 3 */
bonnelongueur(X,Y):- length(X,Y).

/* Question 4 */
bonnetaille([],_):- !.
bonnetaille([X|XS],Y):- !, bonnelongueur(X,Y), bonnetaille(XS,Y).

?- use_module(library(clpfd)).

/* Question 5 */
verifier([]).
verifier([X | L]) :- X >= 1, X =< 9, verifier(L).

verifie([]).
verifie([X|L]) :- verifier(X), all_distinct(X), verifie(L).

/* Question 6 */
eclate([], RES, RES) :- !.
eclate([X | XS], [], [[X] | RES]) :- !, eclate(XS, [], RES).
eclate([X | XS], [Y | YS], [INS | RES]) :- !, eclate(XS, YS, RES), INS = [X | Y].

/* Question 7 */
transp([], []) :- !.
transp([X|XS], RES) :- transp(XS, NOUV), eclate(X, NOUV, RES).

/* Question 8 */

/* Question 9 */

/* Question 10 */

/* Question 11 */
