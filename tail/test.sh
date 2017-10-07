#!/bin/bash

RED='\033[0;31m'
LBLUE='\033[0;36m'
NC='\033[0m' # No Color

#initialisation
mkdir test
cd test

touch fileA.txt
echo -e "l.1- j ecris dans le fichierA" > fileA.txt
touch fileB.txt
echo -e "l.1- j ecris dans le ficherB\nl.2- encore\nl.3- et encore\nl.4- toujours \nl.5- et avec des sauts\nl.6- a la ligne\nl.7- toujours \nl.8- et \nl.9- encore \nl.10- des sauts" > fileB.txt
touch fileC.txt
echo -e "l.1- j ecris dans le ficherC\nl.2- avec un retour à la ligne\nl.3- à la fin de mon fichier\n" > fileC.txt


#test des differents fichiers
cd ..
echo -e "\n${RED}Compiling...${NC}"
make clean
make

echo -e "\n${RED}Starting Tests:\n"

echo -e "\nTest n°1: fichierB\n"

echo -e "\n${RED}Contenu du fichierB :${NC}\n"
echo -e "${LBLUE}--start--${NC}"
cat test/fileB.txt
echo -e "${LBLUE}--end--${NC}"

echo -e "\nresult of \"tail -n 2 test/fileB.txt\" : ${NC}\n"
echo -e "${LBLUE}--start--${NC}"
tail -n 2 test/fileB.txt
echo -e "${LBLUE}--end--${NC}"
echo -e "\nresult of \"mtail -n 2 test/fileB.txt\" : \n"
echo -e "${LBLUE}--start--${NC}"
./mtail.exe -n 2 test/fileB.txt
echo -e "${LBLUE}--end--${NC}"

echo -e "\n${RED}Test n°2: fichierA qui contient moins que le nombre de lignes demandé"

echo -e "\n${RED}Contenu du fichierA :${NC}\n"
echo -e "${LBLUE}--start--${NC}"
cat test/fileA.txt
echo -e "${LBLUE}--end--${NC}"

echo -e "\nresult of \"tail -n 5 test/fileA.txt\" : ${NC}\n"
echo -e "${LBLUE}--start--${NC}"
tail -n 5 test/fileA.txt
echo -e "${LBLUE}--end--${NC}"
echo -e "\nresult of \"mtail -n 5 test/fileA.txt\" : \n"
echo -e "${LBLUE}--start--${NC}"
./mtail.exe -n 5 test/fileA.txt
echo -e "${LBLUE}--end--${NC}"

echo -e "\n${RED}Test n°3: fichierC dont le dernier octet est une fin de ligne:"

echo -e "\n${RED}Contenu du fichierC :${NC}\n"
echo -e "${LBLUE}--start--${NC}"
cat test/fileC.txt
echo -e "${RED}${LBLUE}--end--${NC}"

echo -e "\nresult of \"tail -n 2 test/fileC.txt \" : ${NC}\n"
echo -e "${LBLUE}--start--${NC}"
tail -n 2 test/fileC.txt
echo -e "${LBLUE}--end--${NC}"
echo -e "\nresult of \"mtail -n 2test/fileC.txt\" : \n"
echo -e "${LBLUE}--start--${NC}"
./mtail.exe -n 2 test/fileC.txt
echo -e "${LBLUE}--end--${NC}"

rm -r test
