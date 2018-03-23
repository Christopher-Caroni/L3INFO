#bin/bash

echo -e "\n** Q1 :\n"
egrep --color=auto "nez" Cyrano.txt

echo -e "\n** Q2 :\n"
egrep --color=auto "\(.*\)" Cyrano.txt

echo -e "\n** Q3 :\n"
egrep --color=auto -w "[[:alpha:]]{4}" Cyrano.txt

echo -e "\n** Q4 :\n"
egrep --color=auto "[[:alpha:]]*[[:space:]]:" Cyrano.txt
