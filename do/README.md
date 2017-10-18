#   `do`

Ce répertoire correspond à l’exercice
« [Exécutions de commandes](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdps-exec.html#do) : `do` ».

Ce répertoire devra contenir **exclusivement** les fichiers :
`README.md`, `Makefile`, `do.c` et `tests.sh` ainsi que les fichiers
fournis.

Vous éditerez ce fichier pour qu’il contienne un compte-rendu du
travail effectué (ce qui marche, ce qui ne marche pas, etc.).


##  Fichiers fournis

Ce répertoire contient quelques fichiers qui pourront vous servir pour
la dernière version de `do`.
Vous trouverez ainsi :

-   un module `makeargv` fournissant deux fonctions (`makeargv` et
    `freeargv`) permettant de découper une chaîne de caractères en un
    tableau de type `argv`,
-   une petite commande `args` dont le code vous servira d’exemple
    d’utilisation de `makeargv`.

# Ce que nous avons fait :

Durant ce tp nous avons:
- Crée la commande `do.c` qui execute des commandes passés en paramètre
- Cette commande gère les arguments `-a` `-o` `-c` `-k`
- L'argument `-a` fait la conjonction des commandes
- L'argument `-o` fait la disjonction des commandes
- L'argument `-c` stop l'execution des commandes lorsque la conjonction ou disjonction est faux (renvois 1)
- L'argument `-k` kill les commande non terminés 

