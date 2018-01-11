
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "sys/wait.h"

#include "graphe.h"

/* Couleurs */
typedef enum {ROUGE=0, BLEU=1, VERT=2} tCouleur;
typedef tCouleur tTabCouleurs[MAX_SOMMETS];

/*
graphe: le graphe a parcourir
tabCouleurs: le tableau ou stocker les Couleurs
couleur: la couleur à stocker
num_exclu: le numero du sommet a exclure
*/
void colorieSauf(tGraphe graphe, tTabCouleurs tabCouleurs, tCouleur couleur, int nom_exclu)
{
  int i;
  int nbSommets;

  nbSommets = grapheNbSommets(graphe);
  for (i=0;i<nbSommets;i++)
  {
    if (i != nom_exclu)
    {
      tabCouleurs[i] = couleur;
    }
  }
}

void plusCourteChaine(tGraphe graphe, char *nom_depart)
{
  /*
  tabCouleurs[i] correspond à la couleur du sommet i
  */
  tTabCouleurs tabCouleurs;
  tFileSommets file;
  tNumeroSommet s;
  int nbSommets;

  int d[MAX_SOMMETS];
  tNumeroSommet pred[MAX_SOMMETS];

  tNumeroSommet x;
  int i;
  int nbVoisins;
  tNumeroSommet y;
  tNomSommet nomSommet;


  s = grapheChercheSommetParNom(graphe, nom_depart);
  nbSommets = grapheNbSommets(graphe);
  colorieSauf(graphe, tabCouleurs, BLEU, s);


  file = fileSommetsAlloue();
  for (i=0;i<nbSommets;i++) {
    d[i] = 0;
    pred[i] = 0;
  }

  tabCouleurs[s] = VERT;

  fileSommetsEnfile(file, s);

  while (!fileSommetsEstVide(file))
  {
      x = fileSommetsDefile(file);
      nbVoisins = grapheNbVoisinsSommet(graphe, x);
      for (i=0;i<nbVoisins;i++)
      {
        /*
        printf("%d neighbour of %d\n", i, x);
        */
        y = grapheVoisinSommetNumero(graphe, x, i);
        if (tabCouleurs[y] == BLEU)
        {
          tabCouleurs[y] = VERT;
          fileSommetsEnfile(file, y);
          d[y] = d[x] + 1;
          pred[y] = x;
        }
      }
      tabCouleurs[x] = ROUGE;
  }

  for (i=0;i<nbSommets;i++) {
    grapheRecupNomSommet(graphe, i, nomSommet);
    printf("\nDistance from %s to %s\n", nom_depart, nomSommet);
    printf("distance[%s]=%d\n", nomSommet, d[i]);
    printf("distance prev[%s]=%d\n", nomSommet, pred[i]);
  }


  return;
}


int main(int argc, char **argv)
{
  tGraphe graphe;

  if (argc != 3) {
    halt("Usage : %s <fichier_graphe/\"alea\"> <nom_sommet_depart>\n", argv[0]);
  }

  graphe = grapheAlloue();
  if (strncmp("alea", argv[1], 4) == 0)
  {
    printf("using random graphe\n");
    grapheAleatoire(graphe, 100, 1, 0.1);
  } else
  {
    grapheChargeFichier(graphe, argv[1]);
  }


  plusCourteChaine(graphe, argv[2]);

  grapheLibere(graphe);
  return 0;
}
