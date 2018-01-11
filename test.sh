#! /bin/bash

DEBUG=false

if [ "$#" -eq 1 ]
then
  test "-d" != $1 && echo "param not recognized" &&  echo  "usage: $0 \[-d\]" && exit 1
  echo "debug mode"
  DEBUG=true
fi

# le dossier de tests
TEST_DIR="testing"

# La commande qui genere le genome
ALEA=./aleazard
# Le fichier de sortie du genome
ALEA_OUTPUT=$TEST_DIR/genome

# La commande à tester
COMPT=./compteur-gc
# le fichier à lui mettre en entrée
COMPT_INPUT=$ALEA_OUTPUT


# la commande gnu time
TIME_CMD="/usr/bin/time"
# les options de cette commande
TIME_OPT="-f %e"
# Le fichier de temps à générer
TIME_FILE=$TEST_DIR/COMPT-TM.dat

mkdir -p $TEST_DIR

# initialisation du fichier de résultats
rm -f $TIME_FILE && echo -e "# genome_count\tthread_count\tcount_time" > $TIME_FILE

# pour taille genome de 10² a 10⁹
for genome_size in `awk 'BEGIN { for( i=100; i<=1000000000; i*=10 ) print i }'`; do
    # initialisation du genome
    rm -rf $ALEA_OUTPUT$genome_size
    echo "creating genome with size $genome_size"
    if [ $DEBUG = "true" ]
    then
      echo "nothing"
    else
      $ALEA $genome_size > $ALEA_OUTPUT$genome_size
    fi

    # pour n_threads de 2⁰ à 2⁵
    for thread_count in `awk 'BEGIN { for( i=1; i<=32; i*=2 ) print i }'`; do
        echo -ne "\t$genome_size\t$thread_count" >> $TIME_FILE
        echo "executing for genome size $genome_size and thread_count $thread_count"
        if [ $DEBUG = "true" ]
        then
          echo "nothing"
        else
          $TIME_CMD "$TIME_OPT" $COMPT $COMPT_INPUT$genome_size $thread_count> /dev/null 2>> $TIME_FILE
        fi
    done
done

#gnuplot run.gnu &
