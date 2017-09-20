#   `du`

Ce répertoire correspond aux exercices de la section
[Parcours d’une hiérarchie](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdfs-cmd.html#du).

Ce répertoire devra contenir **exclusivement** les fichiers :
`README.md`, `Makefile`, `mdu.c` et soit `tests.sh` soit
`session.txt`.
En particulier, un dépôt de code ne doit jamais contenir les fichiers
compilés (`.o`, exécutable, etc.).

# Ce que nous avons fait :

Durant ce tp nous avons:
- créer la commande `mdu`
- permis à la commande `mdu` de tester la taille reelle
- permis à la commande `mdu` de tester la taille apparante
- permis à la commande `mdu` de tester tout cela en suivant les liens symbollique
- creer un fichier test.sh pour monter que notre commande fait la meme chose que la commande `du`

Ainsi la commande mdu peux :
- calculer la taille de l'occupation reelle (en blocks) avec `mdu pathname`
- calculer la taille apparante avec `mdu -b pathname`
- suivre les liens symbollique avec `mdu -L pathname`
