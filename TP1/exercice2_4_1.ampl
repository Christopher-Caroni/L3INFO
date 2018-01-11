set PUB_ACHETES;

param budget >= 0;
param personnes_jours_disponibles >= 0;

param consommateur_potentiel {PUB_ACHETES} >= 0;
param prix_pub {PUB_ACHETES} >= 0;
param achat_min {PUB_ACHETES} >= 0;
param personnes_jours_necessaires {PUB_ACHETES} >= 0;

var qte_achete {p in PUB_ACHETES} >= achat_min [p];

maximize consommateurs_touches :
  sum {p in PUB_ACHETES} qte_achete [p] * consommateur_potentiel [p];

subject to budget_limitee :
  sum {p in PUB_ACHETES}
    (qte_achete [p] * prix_pub [p]) <= budget;

subject to personnes_semaines_limitees :
  sum {p in PUB_ACHETES}
    (qte_achete [p] * personnes_jours_necessaires [p]) <= personnes_jours_disponibles;



data;

set PUB_ACHETES := minute_tv page_magazine minute_radio;

param budget := 1000000;
param personnes_jours_disponibles := 500;

param:              consommateur_potentiel    prix_pub   achat_min  personnes_jours_necessaires:=
minute_tv                1800000               20000        10               5
page_magazine            1000000               10000         2              15
minute_radio              250000                2000         0               1;
