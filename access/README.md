#   `maccess`

Ce répertoire correspond aux exercices de la section
[Vérifier les droits d’accès... et expliquer](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdfs-cmd.html#access).

Ce répertoire devra contenir **exclusivement** les fichiers :
`README.md`, `Makefile`, `prlimit.c`, `maccess.c` et soit `tests.sh`
soit `session.txt`.
En particulier, un dépôt de code ne doit jamais contenir les fichiers
compilés (`.o`, exécutable, etc.).

Ce répertoire contient une version initiale de `maccess.c` pour
illustrer l’utilisation de `getopt` et ainsi vous aider à démarrer.

Vous éditerez ce fichier pour qu’il contienne un compte-rendu du
travail effectué (qu’est-ce qui marche, qu’est-ce qui ne marche pas,
etc.).

# Ce que nous avons fait :

Durant ce tp nous avons:
- créer la fonction prlimit() qui affiche les valeurs de NAME_MAX et PATH_MAX
- permis à la commande macces de tester les droits d'accès d'un ou plusieurs fichiers
- créer un programme bash test_access afin de tester et de prouver les différentes possibilités de la commande maccess tout en montrant les différentes erreurs (que l'on peu montrer)

Ainsi la commande maccess peux :
- tester la lecture/l'écriture/l'acces d'un fichier et de montrer une erreur si -v est passé en argument
- ce test de droit s'effectue sur un ou plusieurs fichier

Liste des erreurs montrés : 
- 'EACCESS' - permission denied & pas permis de traverser un dir dans le pathname
- 'ENOENT' -  no such file
- 'ENOTDIR' - un element du chemin d'access n'est pas un repertoire

La plupart des autres erreurs ne peuvent être démontrer. Par exemple l'erreur : 'EROFS'  On demande une écriture sur un système de fichiers en lecture seule
