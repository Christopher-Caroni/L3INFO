#   `tail`

Ce répertoire correspond aux exercices de la section
[Afficher la fin d’un
fichier](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdfs-cmd.html#tail)
(versions simpliste et efficace de `tail`).

# Ce que nous avons fait :

Durant ce tp nous avons:
- crée la commande `mtail` qui reproduis la commande `tail -n`
- il y a `deux façons` de faire dans cette commande
- la premiere avec `tail_simpliste` qui est plus simple mais qui lis 2 fois tout le fichier
- la deuxieme `tail_efficace` qui lis la fin du fichier avec `la fonction lseek()` et `un tampon`
- tester la commande `mtail` avec differents cas d'utilisation par le biais d'un shell
