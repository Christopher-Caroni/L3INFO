set PARCELLES;
set LEGUMES;

param rendement {LEGUMES} >= 0;
param prix_vente {LEGUMES} >= 0;
param besoin_richesse {LEGUMES} >= 0;
param apport_richesse {LEGUMES} >= 0;
param peux_etre_cultivee {LEGUMES, PARCELLES} binary;

/*
est_affecte[l,p] =
- 1 si le légume est affecté à la parcelle
- 0 sinon
*/
var est_affecte {LEGUMES, PARCELLES} binary;

maximize richesse :
  sum {l in LEGUMES}
    sum {p in PARCELLES}
      est_affecte[l, p] * apport_richesse[l];

/*
pour tous les légumes, ce légume doit être cultivée au minimum une fois
*/
subject to nb_min_culture_par_legume {l in LEGUMES} :
  sum {p in PARCELLES}
    est_affecte[l,p] >= 1;

/*
pour toutes nos parcelles, cette parcelle ne peut être cultivée par un seul légume à la fois
*/
subject to max_un_legume_cultive_par_parcelle {p in PARCELLES} :
  sum {l in LEGUMES}
    est_affecte[l,p] <= 1;

/*
pour une parcelle et un légume quelconque, ce légume ne peut y être cultivée, que si son besoin
de richesse est compatible avec la richesse initiale de la parcelle
*/
subject to compatibilite_legume_parcelle {p in PARCELLES, l in LEGUMES} :
  est_affecte[l, p] <= peux_etre_cultivee[l ,p];

data;

set PARCELLES := A B C D E F G;
set LEGUMES := fruit feuille racine gousse engrais;


param :     rendement   prix_vente    besoin_richesse  apport_richesse   :=
fruit         2.7           4.3             20.2              0
feuille       2.6           1.2             10.1              0
racine        3.4           2.7             5.5               0
gousse        0.5           3.3               0             3.5
engrais         0             0               0            25.8;

param peux_etre_cultivee :
        A   B   C   D   E   F   G :=
fruit   1   0   1   0   0   0   0
feuille 1   1   1   1   0   1   1
racine  1   1   1   1   1   1   1
gousse  1   1   1   1   1   1   1
engrais 1   1   1   1   1   1   1;
