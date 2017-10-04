#/bin/bash

#initialisation
mkdir test

cd ./test

touch fileA.txt
echo -e " 1- j ecris dans le fichierA" > fileA.txt
touch fileB.txt
echo -e " 1- j ecris dans le ficherB\n 2- encore\n 3- et encore\n 4- toujours \n 5- et avec des sauts\n 6- a la ligne\n 7- toujours \n 8- et \n 9- encore \n 10- des sauts" > fileB.txt
touch fileC.txt
echo -e " 1- j ecris dans le ficherC\n 2- avec un retour à la ligne\n 3- à la fin de mon fichier\n" > fileC.txt

#start testing
cd ..
echo -e "\n Contenu du fichierA :\n"
cat ./test/fileA.txt
echo -e "\n Contenu du fichierB :\n"
cat ./test/fileB.txt
echo -e "\n Contenu du fichierC :\n"
cat ./test/fileC.txt

#test des differents fichiers

echo -e "\n tail ./test/fileB.txt -n 2 : \n"
tail ./test/fileB.txt -n 2
echo -e "\n mtail ./test/fileB.txt -n 2 : \n"
./mtail ./test/fileB.txt -n 2

echo -e "fichierA qui contient moins que le nombre de lignes demandé"

echo -e "\n tail ./test/fileA.txt -n 5 : \n"
tail ./test/fileA.txt -n 5
echo -e "\n mtail ./test/fileA.txt -n 5 : \n"
./mtail ./test/fileA.txt -n 5

echo -e "\nTest n°3: fichierC dont le dernier octet est une fin de ligne:"

echo -e "\nresult of \"tail ./test/fileC.txt -n 2\" : \n"
tail ./test/fileC.txt -n 2
echo -e "\n mtail ./test/fileC.txt -n 2 : \n"
./mtail ./test/fileC.txt -n 2

rm -r ./test
