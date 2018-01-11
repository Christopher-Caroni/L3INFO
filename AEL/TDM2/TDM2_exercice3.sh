#bin/bash


echo -e "\n** Q1 :\n"
egrep --color=auto "BIS|TER" bano-59009.csv


echo -e "\n** Q2 :\n"
egrep --color=auto "Ruelle" bano-59009.csv


echo -e "\n** Q3 :\n"
egrep --color=auto -m 10 "[[:alnum:]]*,[[:digit:]]*,[[:upper:]]*,[[:alnum:]]*,[[:alnum:]]*,([[:digit:]]|\.)*,([[:digit:]]|\.)*" bano-59009.csv


echo -e "\nTEST :\n"
egrep --color=auto -m 10 "([[:upper:]]*\s[[:upper:]]*)*" bano-59009.csv
