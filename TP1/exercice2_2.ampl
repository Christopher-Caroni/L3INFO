set PUB_ACHETES;

param budget >= 0;
param personnes_semaines_disponibles >= 0;

param consommateur_potentiel {PUB_ACHETES} >= 0;
param prix_pub {PUB_ACHETES} >= 0;
param achat_min {PUB_ACHETES} >= 0;
param personnes_semaines_necessaires {PUB_ACHETES} >= 0;

var qte_achete {p in PUB_ACHETES} >= achat_min [p];

maximize consommateurs_touches :
  sum {p in PUB_ACHETES} qte_achete [p] * consommateur_potentiel [p];

subject to budget_limitee :
  sum {p in PUB_ACHETES}
    (qte_achete [p] * prix_pub [p]) <= budget;

subject to personnes_semaines_limitees :
  sum {p in PUB_ACHETES}
    (qte_achete [p] * personnes_semaines_necessaires [p]) <= personnes_semaines_disponibles;



data;

set PUB_ACHETES := minute_tv page_magazine;

param budget := 1000000;
param personnes_semaines_disponibles = 100;

param:              consommateur_potentiel    prix_pub   achat_min  personnes_semaines_necessaires:=
minute_tv                1800000               20000        10              1
page_magazine            1000000               10000         0              3;
