#include "sys/wait.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "graphe.h"
/*
gcc -Wall -g -std=c99 labyrinthe_2.c graphe.c -o labyrinthe
*/


typedef enum {ROUGE=0, BLEU=1, VERT=2} tCouleur;
typedef tCouleur tTabCouleur[MAX_SOMMETS];

const char* getENum(int couleur){
  switch (couleur) {
    case 0: return "RED";
    case 1: return "BLUE";
    case 2: return "GREEN";
    default: return NULL;
  }
}

void graphe2visu(tGraphe graphe, char *outfile, tTabCouleur tab) {
  FILE *fic;
  char commande[80];
  char dotfile[80]; /* le fichier dot pour cr´eer le ps */
  int ret;
  int nbArcs;
  tArc arc;
  tNomSommet origine;
  tNomSommet destination;
  tNomSommet nomSommet;

  /* on va creer un fichier pour graphviz, dans le fichier "outfile".dot */
  strcpy(dotfile, outfile);
  strcat(dotfile, ".dot");
  fic = fopen(dotfile, "w");


  if (fic==NULL){
    halt ("Ouverture du fichier %s en écriture impossible\n", dotfile);
  }

  nbArcs = grapheNbArcs(graphe);

  fprintf(fic, "graph {\n");

  for(int i=0; i<grapheNbSommets(graphe); i++){
    grapheRecupNomSommet(graphe, i, nomSommet);
    fprintf(fic, "%s [color=%s]\n", nomSommet, getENum(tab[i]));
  }
  for(int i=0; i<nbArcs; i++ ){
    arc = grapheRecupArcNumero(graphe, i);
    grapheRecupNomSommet(graphe,arc.orig, origine);
    grapheRecupNomSommet(graphe,arc.dest,destination);

      fprintf(fic, " %s -- %s \n", origine, destination);
  }


  fprintf(fic, "}");


  fclose(fic);
  sprintf(commande, "dot -Tps %s -o %s.ps", dotfile, outfile);
  ret = system(commande);
  if (WEXITSTATUS(ret)){
    halt("La commande suivante a échouée\n%s\n", commande);
  }
}


void colorierToutSauf(tGraphe graphe, tCouleur couleur,tTabCouleur tab, int exclu ){
  int nbSommet;
  int i;

  nbSommet = grapheNbSommets(graphe);

  for(i=0; i<nbSommet; i++){

    if(i != exclu){
      tab[i]= couleur;
    }
  }
}
void parcourt_Chaine2Sommets(tGraphe graphe, char *depart, char *arrivee){

  tTabCouleur tab;
  tPileSommets pile;
  tNomSommet nomSommet;
  int possedeVoisinBleu;
  int sortie_trouvee;
  int nbVoisins;
  int voisin;
  int i;
  int s;
  int s2;
  int x;


  s = grapheChercheSommetParNom(graphe, depart);
  s2 = grapheChercheSommetParNom(graphe, arrivee);
  sortie_trouvee = 0;

  colorierToutSauf(graphe, BLEU, tab, s);

  pile = pileSommetsAlloue();
  tab[s] = VERT;

  pileSommetsEmpile(pile, s);

  while(!pileSommetsEstVide (pile) && sortie_trouvee != 1)
  {
    x = pileSommetsTete(pile);
    if(x == s2){
      sortie_trouvee = 1;
    }
    nbVoisins = grapheNbVoisinsSommet(graphe, x);
    possedeVoisinBleu = 0;
    i =0;
    while (!possedeVoisinBleu && i<nbVoisins) {
      voisin = grapheVoisinSommetNumero(graphe, x, i);
      if(tab[voisin] == BLEU){
        grapheRecupNomSommet(graphe, voisin, nomSommet);
        printf("visited %s\n", nomSommet);
        tab[voisin] = VERT;
        pileSommetsEmpile(pile, voisin);
        possedeVoisinBleu = 1;
      }
      i++;
    }
    if(possedeVoisinBleu == 0)
    {
      tab[x] = ROUGE;
      pileSommetsDepile(pile);
    }
  }

  if(sortie_trouvee == 1){
    printf("\n Lien trouve entre les deux chaines !\n");
  }else{
    printf("\n Aucun lien trouve entre les deux chaines\n");
  }

  graphe2visu(graphe,"graphe",tab);

}

int main(int argc, char *argv[]) {


  tGraphe graphe;

  if (argc<4) {
    halt("Uage : %s FichierGraphe\n", argv[0]);
  }

  graphe = grapheAlloue();

  grapheChargeFichier(graphe,  argv[1]);
  parcourt_Chaine2Sommets(graphe, argv[2], argv[3]);
  grapheLibere(graphe);

  exit(EXIT_SUCCESS);
}
