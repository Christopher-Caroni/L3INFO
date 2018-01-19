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

?- use_module(library(clpfd)).

/* Question 5 */

/* Question 6 */

/* Question 7 */

/* Question 8 */

/* Question 9 */

/* Question 10 */

/* Question 11 */
