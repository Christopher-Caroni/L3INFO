set PARCELLES;
set LEGUMES;
set ANNEES;

param rendement {LEGUMES} >= 0;
param prix_vente {LEGUMES} >= 0;
param besoin_richesse {LEGUMES} >= 0;
param apport_richesse {LEGUMES} >= 0;
param peux_etre_cultivee_premiere_annee {LEGUMES, PARCELLES} binary;

var est_affecte {ANNEES, LEGUMES, PARCELLES} binary;
/*
est_affecte[a,l,p] =
- 1 si le légume est affecté à la parcelle
- 0 sinon
*/


data;

set PARCELLES := A B C D E F G;
set LEGUMES := fruit feuille racine gousse engrais;
set ANNEES := 1 2 3 4 5 6;


param :     rendement   prix_vente    besoin_richesse  apport_richesse   :=
fruit         2.7           4.3             20.2              0
feuille       2.6           1.2             10.1              0
racine        3.4           2.7             5.5               0
gousse        0.5           3.3               0             3.5
engrais         0             0               0            25.8;

param peux_etre_cultivee_premiere_annee :
        A   B   C   D   E   F   G :=
fruit   1   0   1   0   0   0   0
feuille 1   1   1   1   0   1   1
racine  1   1   1   1   1   1   1
gousse  1   1   1   1   1   1   1
engrais 1   1   1   1   1   1   1;
