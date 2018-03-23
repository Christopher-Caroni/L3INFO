#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "sys/wait.h"

#include "graphe.h"

/*
prend un graphe pour creer un fichier .dot qu'on utilisera
pour creer un fichier .ps avec dot -Tps X.dot -o outfile
*/
void graphe2visu(tGraphe graphe, char *outfile)
{
  FILE *file;
  char commande[80];
  char dotfile[80];
  int ret;
  int i;
  tArc arc;
  char *fleche;
  tNomSommet nom_orig;
  tNomSommet nom_dest;

  fleche = malloc(3 * sizeof(char));
  snprintf(dotfile, 80, "%s.dot", outfile);

  file = fopen(dotfile, "w");
  if (file==NULL)
  {
    halt ("Ouverture du fichier %s en écriture impossible\n", dotfile);
  }

  if (grapheEstOriente(graphe))
  {
    fprintf(file, "digraph {\n");
    snprintf(fleche, 3, "%s", "->");
  } else {
    fprintf(file, "graph {\n");
    snprintf(fleche, 3, "%s", "--");
  }


  for (i=0;i<grapheNbArcs(graphe);i++)
  {
    arc = grapheRecupArcNumero(graphe, i);
    grapheRecupNomSommet(graphe, arc.orig, nom_orig);
    grapheRecupNomSommet(graphe, arc.dest, nom_dest);
    fprintf(file, "%s %s %s;\n", nom_orig, fleche, nom_dest);
  }

  fprintf(file, "}");
  free(fleche);
  fclose(file);

  sprintf(commande, "dot -Tps %s -o %s", dotfile, outfile);
  ret = system(commande);
  if (WEXITSTATUS(ret))
  {
    halt("La commande suivante a échoué\n%s\n", commande);
  }
}

int main(int argc, char **argv)
{
  tGraphe graphe;

  if (argc != 3) {
    halt("Usage : %s FichierGraphe\n fichierSortie.ps", argv[0]);
  }

  graphe = grapheAlloue();
  grapheChargeFichier(graphe, argv[1]);

  graphe2visu(graphe, argv[2]);

  grapheLibere(graphe);
  return 0;
}
