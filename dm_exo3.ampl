reset;

set PARCELLES;
set LEGUMES;
set ANNEES;

param rendement {LEGUMES} >= 0;
param prix_vente {LEGUMES} >= 0;
param besoin_richesse {LEGUMES} >= 0;
param apport_richesse {LEGUMES} >= 0;
param richesse_initiale {PARCELLES} >= 0;
param bidon {PARCELLES} >= 0;

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

var richesse {ANNEES, PARCELLES} >= 0;

/*
On maximize la richesse des parcelles pour la dernière année
*/
maximize richesse_min {a in ANNEES} :
	  sum {l in LEGUMES}
			sum {p in PARCELLES}
			  est_affecte[a, l, p] * apport_richesse[l];

/*
La premiere année, pour toutes les parcelles, le légume ne peut être affecté que si
son besoin en richesse est compatible avec la richesse initiale de la parcelle
*/
subject to compatibilite_premiere_annee_legume_parcelle {p in PARCELLES, l in LEGUMES} :
  est_affecte[1, l, p] <= richesse_initiale[p] * besoin_richesse[l];

/*
Pour les années i de 2 à 5, pour toutes les parcelles, le légume ne peut être affecté à l'année (i)
que si un légume spécifque a été cultivé à l'année (i-1)
*/
subject to compatibilite_cycle_legume_parcelle {a in 1..6, p in PARCELLES, l1 in LEGUMES, l2 in LEGUMES} :
	est_affecte[a, l1, p] <=
		(if a <> 1 and l1 <> l2 then est_affecte[prev(a), l2, p] else est_affecte[a, l1, p]);


subject to richesse_premiere_annee_legume_parcelle {p in PARCELLES, l in LEGUMES} :
	richesse[1, p] =
		(if (est_affecte[1, l, p] == 1) then (richesse_initiale[p] - besoin_richesse[l]) else richesse[1, p]);

subject to richesse_legume_parcelle {a in 1..6, p in PARCELLES, l in LEGUMES} :
	richesse[a, p] =
		(if a <> 1 and est_affecte[a, l, p] == 1 then (richesse[prev(a), p] - besoin_richesse[l]) else richesse[a, p]);




data;

set PARCELLES := A B C D E F G;
set LEGUMES := fruit feuille racine gousse engrais;
set ANNEES := 1 2 3 4 5 6;


param : richesse_initiale :=
A						43.2
B						12.1
C						20.8
D						16.8
E						5.7
F						16.3
G						15.1;

param :     rendement   prix_vente    besoin_richesse  apport_richesse   :=
fruit         2.7           4.3             20.2              0
feuille       2.6           1.2             10.1              0
racine        3.4           2.7             5.5               0
gousse        0.5           3.3               0             3.5
engrais         0             0               0            25.8;


param legume_peut_suivre :
						fruit		feuille		racine		gousse		engrais :=
fruit					0				0					0					0						1
feuille				1				0					0					0						0
racine				0				1					0					0						0
gousse				0				0					1					0						0
engrais				0				0					0					1						0;
