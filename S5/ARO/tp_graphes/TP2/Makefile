CC=gcc
CFLAGS=-Wall -std=c99 -g

testAnalyseur: graphe.o
q8: graphe.o


fichier.ps: q8 q2.graphe
  ./$^

%.ps: %.dot
  dot -Tps $< -o $@

view_%: %.ps
  evince $<
