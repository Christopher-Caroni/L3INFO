#! /bin/sh -uf
# mcat -- campagne d'appels à mcat-scd
#
# Exemple de script shell, à compléter pour vos tests

# La commande à tester
MCAT=./mcat-scd
# le fichier à lui mettre en entrée
MCAT_INPUT=bigfile
# Le fichier de temps à générer
TIME_FILE=mcat-tm.dat

# la commande gnu time
TIME_CMD="/usr/bin/time"
# les options de cette commande
TIME_OPT="-f %e %U %S"

# initialisation du fichier de résultats
rm -f $TIME_FILE && echo "# real user sys" > $TIME_FILE

# un exemple de boucle
for str in  foo bar gee ; do
    echo $str
done

# un autre exemple de boucle
for size in `awk 'BEGIN { for( i=1; i<=8388608; i*=2 ) print i }'`; do
    export MCAT_BUFSIZ=$size
    echo $MCAT_BUFSIZ
done

# un exemple de redirection des sorties standard et d'erreur
$TIME_CMD "$TIME_OPT" ls > /dev/null 2>> $TIME_FILE
