#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "graphe.h"



int main(int argc, char **argv)
{
  tGraphe graphe;
  int nb_sommets;
  int i;
  int nb_voisins;
  int max_voisins;
  tNomSommet nom_sommet;


  if (argc != 2) {
    halt("Usage : %s FichierGraphe\n", argv[0]);
  }
  max_voisins = 0;

  graphe = grapheAlloue();

  grapheChargeFichier(graphe,  argv[1]);

  nb_sommets = grapheNbSommets(graphe);

  printf("Liste des sommets sans voisins\n");

  for (i=0;i<nb_sommets;i++)
  {
      nb_voisins = grapheNbVoisinsSommet(graphe, i);
      if (nb_voisins > max_voisins)
      {
        max_voisins = nb_voisins;
      }
      if (nb_voisins == 0)
      {
        grapheRecupNomSommet(graphe, i, nom_sommet);
        printf("- %d : %s\n", i, nom_sommet);
      }
  }

  printf("Sommets avec le plus de voisins (%d voisins)\n", max_voisins);


  for (i=0;i<nb_sommets;i++)
  {
      nb_voisins = grapheNbVoisinsSommet(graphe, i);
      if (nb_voisins == max_voisins)
      {
        grapheRecupNomSommet(graphe, i, nom_sommet);
        printf("- %d : %s\n", i, nom_sommet);
      }
  }

  return 0;
}
