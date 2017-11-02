set PARCELLES;
set LEGUMES;
set ANNEES;

param rendement {LEGUMES} >= 0;
param prix_vente {LEGUMES} >= 0;
param besoin_richesse {LEGUMES} >= 0;
param apport_richesse {LEGUMES} >= 0;

/*
peux_etre_cultivee_premiere_annee[l, p] =
- 1: si le légume l a un besoin en richesse inférieur à la richesse de la parcelle param
- 0: sinon
*/
param peux_etre_cultivee_premiere_annee {LEGUMES, PARCELLES} binary;

/*
peux_etre_cultivee_premiere_annee[l1, l2] =
- 1: si le légume l1 peut suivre le legume l2
- 0: sinon
*/
param legume_peut_suivre {LEGUMES, LEGUMES} binary;

/*
est_affecte[a,l,p] =
- 1: si le légume est affecté à la parcelle
- 0: sinon
*/
var est_affecte {ANNEES, LEGUMES, PARCELLES} binary;

/*
On maximize la richesse des parcelles pour la dernière année
*/
maximize richesse :
	  sum {l in LEGUMES}
		sum {p in PARCELLES}
		  est_affecte[6, l, p] * apport_richesse[l];

/*
La premiere année, pour toutes les parcelles, le légume ne peut être affecté que si
son besoin en richesse est compatible avec la richesse initiale de la parcelle
*/
subject to compatibilite_premiere_annee_legume_parcelle {p in PARCELLES, l in LEGUMES} :
  est_affecte[1, l, p] <= peux_etre_cultivee_premiere_annee[l ,p];

/*
Pour les années i de 2 à 5, pour toutes les parcelles, le légume ne peut être affecté à l'année (i)
que si un légume spécifque a été cultivé à l'année (i-1)
*/
subject to compatibilite_cycle_legume_parcelle {a in 2..6, p in PARCELLES, l in LEGUMES} :
  est_affecte[a, l1, p] <= legume_peut_suivre[l1 ,l2] ET est_affecte[a-1, l2, p] == 1 ;

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

param legume_peut_suivre :
						fruit		feuille		racine		gousse		engrais
fruit					0				0					0					0						1
feuille				1				0					0					0						0
racine				0				1					0					0						0
gousse				0				0					1					0						0
engrais				0				0					0					1						0;
