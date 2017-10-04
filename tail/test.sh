#/bin/bash

#initialisation
mkdir test

cd ./test

touch fileA.txt
echo -e "l.1- j ecris dans le fichierA" > fileA.txt
touch fileB.txt
echo -e "l.1- j ecris dans le ficherB\nl.2- encore\nl.3- et encore\nl.4- toujours \nl.5- et avec des sauts\nl.6- a la ligne\nl.7- toujours \nl.8- et \nl.9- encore \nl.10- des sauts" > fileB.txt
touch fileC.txt
echo -e "l.1- j ecris dans le ficherC\nl.2- avec un retour à la ligne\nl.3- à la fin de mon fichier\n" > fileC.txt

#start testing
cd ..
echo -e "\nContenu du fichierA :\n"
cat ./test/fileA.txt
echo -e "\nContenu du fichierB :\n"
cat ./test/fileB.txt
echo -e "\nContenu du fichierC :\n"
cat ./test/fileC.txt

#test des differents fichiers

echo -e "\nStarting Tests:\n"


echo -e "\nTest n°1: fichierB"

echo -e "\nresult of \"tail ./test/fileB.txt -n 2\" : \n"
echo "--start--"
tail ./test/fileB.txt -n 2
echo "--end--"
echo -e "\nresult of \"mtail ./test/fileB.txt -n 2\" : \n"
echo "--start--"
./mtail ./test/fileB.txt -n 2
echo "--end--"

echo -e "\nTest n°2: fichierA qui contient moins que le nombre de lignes demandé"

echo -e "\nresult of \"tail ./test/fileA.txt -n 5\" : \n"
echo "--start--"
tail ./test/fileA.txt -n 5
echo "--end--"
echo -e "\nresult of \"mtail ./test/fileA.txt -n 5\" : \n"
echo "--start--"
./mtail ./test/fileA.txt -n 5
echo "--end--"

echo -e "\nTest n°3: fichierC dont le dernier octet est une fin de ligne:"

echo -e "\nresult of \"tail ./test/fileC.txt -n 2\" : \n"
echo "--start--"
tail ./test/fileC.txt -n 2
echo "--end--"
echo -e "\nresult of \"mtail ./test/fileC.txt -n 2\" : \n"
echo "--start--"
./mtail ./test/fileC.txt -n 2
echo "--end--"

rm -r ./test
