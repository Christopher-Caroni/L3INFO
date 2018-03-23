#/bin/bash



#initialisation
mkdir test

cd ./test
touch fileA.txt
echo "j ecris dans le fichierA" > fileA.txt
touch fileB.txt
echo "j ecris dans le ficherB encore et encore" > fileB.txt

mkdir dir1

cd ./dir1

touch fileC.txt
echo "j ecris dans le fichierC encore, encore ..\n Toujours et toujour..\n Encore plus" > fileC.txt
ln -s dir2 lien

mkdir dir2

cd ./dir2

touch fileD.txt
echo "petit fichier" > fileD.txt

#start testing
cd ../../..
echo -e "displaying test files \n"
tree test

echo -e "\n testing will now start: \n"


#test with blocks
echo -e "\n du -B 512 test:\n"
du -B 512 test

echo -e "\n mdu test :\n"
./mdu test

echo -e "\n du -B -L 512 test:\n"
du -B 512 -L test

echo -e "\n mdu -L test :\n"
./mdu -L test

#test with real
echo -e "\n du -b test :\n"
du -b ./test

echo -e "\n mdu -b test:\n"
./mdu -b test

echo -e "\n du -b -L test :\n"
du -b -L ./test

echo -e "\n mdu -b -L test:\n"
./mdu -b -L test

rm -r test
