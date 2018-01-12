/*
  Guillaume Lepretre
  Christopher Caroni
*/

/* Question 1 */

longueur([],0).
longueur([_|XS],Y) :- longueur(XS,N), Y is N + 1.

/* Question 2 */

somme([],0).
somme([X|XS],Y) :- somme(XS,N), Y is N + X.

/* Question 3 */

membre(X, [Y|T]) :- X = Y.
membre(X, [Y|T]) :- X \= Y, membre(X, T).

/* Question 4 */

/* ajoute HEAD a la liste Tail et retourne dans [Head|Tail] */
ajoute_en_tete(Head, Tail, [Head| Tail]).

/* Question 5 */

ajoute_en_queue(Add,[],[Add]).
ajoute_en_queue(Add,[Head|Tail], [Head|Newtail]) :- ajoute_en_queue(Add,Tail, Newtail).

/* Question 6 */

extraire_tete_v1([Head|Tail],Head,Tail).
extraire_tete(Oldlist, Head, Tail) :- ajoute_en_tete(Head, Tail, Oldlist).

/* Question 7 */

concatene(Premier, [], Premier).
concatene(Premier, [Head|Tail], Res) :- ajoute_en_queue(Head, Premier, Newlist), concatene(Newlist, Tail, Res).

/* Question 8 */

/* Tris sur les listes */

/* Question 9 */

/* Question 10 */

/* Question 11 */

/* Question 12 */

/* Question 13 */

/* Question 14 */

/* Question 15 */

/* Opérations de base sur les ensembles */

/* Question 16 */

/* Question 17 */

/* Question 18 */

/* Question 19 */

/* Question 20 */

/* Question 21 */
