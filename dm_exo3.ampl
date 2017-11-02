reset;

set PARCELLES;
set LEGUMES circular;

param N_ANNEES integer >= 0;
set ANNEES := 1 .. N_ANNEES circular;

param rendement {LEGUMES} >= 0;
param prix_vente {LEGUMES} >= 0;
param besoin_richesse {LEGUMES} >= 0;
param apport_richesse {LEGUMES} >= 0;

param richesse_initiale {PARCELLES} >= 0;


/*
est_affecte[a,l,p] =
- 1: si le légume est affecté à la parcelle
- 0: sinon
*/
var est_affecte {ANNEES, LEGUMES, PARCELLES} binary;

/*
la richesse de la parcelle à la fin de l'année indicée
*/
var richesse_fin_annee {ANNEES, PARCELLES} >= 0;

/*
On maximize la richesse des parcelles a la fin des 6 ans
*/
maximize richesse_min {p in PARCELLES} :
	richesse_fin_annee[6, p];


/*
Tous les ans, chaque parcelle DOIT être cultivée
*/
subject to parcelle_doit_etre_cultivee {a in ANNEES, p in PARCELLES} :
  sum {l in LEGUMES}
    est_affecte[a, l, p] = 1;

/*
Tous les ans, pour toute parcelle, cette parcelle ne peut être cultivée par un seul légume à la fois
*/
/*
subject to max_un_legume_par_parcelle {a in ANNEES, p in PARCELLES} :
  sum {l in LEGUMES}
    est_affecte[a, l, p] <= 1;
*/

/*
Pour chaque année a, pour une parcelle p, un légume l ne peut y être cultivé que si le légume précédant
dans le cycle y était aussi cultivé à l'année précédente.

CAS INTIIAL:
Pour l'année a==1, pour une parcelle p, un légume l ne peut y être cultivé que si
le besoin en richese de ce légume est inféreur à la richesse initiale de cette parcelle
*/
subject to cycle_legume_parcelle {a in ANNEES, p in PARCELLES, l in LEGUMES} :
	est_affecte[a, l, p] <=
	if a != 1 then
		est_affecte[prev(a), prev(l), p]
	else
		if besoin_richesse[l] <= richesse_fin_annee[a, p] then
			1
		else
			0;



/*
Pour chaque année (a) (sauf a==1), la richesse d'une parcelle est égale à la richesse de la parcelle
à l'année (a-1) moins le rendement du légume cultivé, plus l'apport de ce légume.

CAS INTIIAL:
Pour (a==1), la fin de l'année initiale, la richesse est égale à la richesse intiale,
moins le rendement du légume cultivé, plus l'apport de ce légume.
*/
subject to richesse_cycle {a in ANNEES, p in PARCELLES, l in LEGUMES} :
	richesse_fin_annee[a, p] =
	if a == 1 then
		richesse_initiale[p] - (besoin_richesse[l] * est_affecte[a, l, p]) + (apport_richesse[l] * est_affecte[a, l, p])
	else
		richesse_fin_annee[prev(a), p] - (besoin_richesse[l] * est_affecte[a, l, p]) + (apport_richesse[l] * est_affecte[a, l, p]);

data;

param N_ANNEES := 6;


set PARCELLES := A B C D E F G;
set LEGUMES := fruit feuille racine gousse engrais;



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
