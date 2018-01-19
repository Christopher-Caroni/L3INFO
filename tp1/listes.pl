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

/* on ajoute les head de la 2eme liste a la fin de la 1ere liste jusqu'à ce qu'il se vide */
concatene(Premier, [], Premier).
concatene(Premier, [Head|Tail], Res) :- ajoute_en_queue(Head, Premier, Newlist), concatene(Newlist, Tail, Res).

/* Question 8 */

/* on ajoute les head de la 1ere liste a une nouvelle, en boucle jusqu'à la liste soit vide. Elle est
alors renversé */

retourne([], Vide, Vide).
retourne([Head|Tail], Vide, Res) :- ajoute_en_tete(Head, Vide, Ajoute) , retourne(Tail, Ajoute, Res).


/* Tris sur les listes */

/* Question 9 */
/* insère un élément dans une liste à la bonne place. */

insert_trie(E, [], [E]) :- !.
insert_trie(E, [X|XS], R) :- E =< X, !, ajoute_en_tete(E, [X|XS], R).
insert_trie(E, [X|XS], [X|Y]) :- E > X, !, insert_trie(E, XS, Y).

/* Question 10 */

tri_insert([], []) :- !.
tri_insert([X | L1], R) :- tri_insert(L1, T), insert_trie(X, T, R).

/* Question 11 */
/* divise une liste en deux parties égales (à un élément près) */

divise([], [], []).
divise([X], [X], []).
divise([X1,X2|XS], [X1|Y], [X2|Z]) :- divise(XS, Y, Z).

/* Question 12 */
/* fusionne deux listes, en conservant l'ordre des éléments. */
fusion(X, [], X).
fusion(X, [Y|YS], R) :- insert_trie(Y, X, T), fusion(T, YS, R).

/* Question 13 */
/* trie une liste avec l'algorithme de tri fusion */
tri_fusion(X, L) :- divise(X, Y, Z), tri_insert(Y, YRES), tri_insert(Z, ZRES), fusion(YRES, ZRES, L).

/* Question 14 */
/* étant donné un élément et une liste produit deux listes, l'une contenant les élément plus grands et l'autre contenant les éléments plus petits. */
balance(_, [], [], []) :- !.
balance(X, [Y|YS], [Y|R1], R2) :- Y < X, !, balance(X, YS, R1, R2).
balance(X, [Y|YS], R1, [Y|R2]) :- Y >= X, !, balance(X, YS, R1, R2).

/* Question 15 */

/* Opérations de base sur les ensembles */

/* Question 16 */

/* Question 17 */

/* Question 18 */

/* Question 19 */

/* Question 20 */

/* Question 21 */
