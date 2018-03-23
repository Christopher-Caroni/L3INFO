set USINES;


param prod_inferieur {USINES} >= 0;
param prod_moyenne {USINES} >= 0;
param prod_superieure {USINES} >= 0;
param cout_jour {USINES} >= 0;

var jours_usine_en_fonction {p in USINES} >= 0;

minimize cout_engendre :
  sum {p in USINES}
    jours_usine_en_fonction [p] * cout_jour [p];

subject to prod_min_inf :
  sum {p in USINES}
    jours_usine_en_fonction [p] * prod_inferieur [p] >= 16;

subject to prod_min_moy :
  sum {p in USINES}
    jours_usine_en_fonction [p] * prod_moyenne [p] >= 5;

subject to prod_min_sup :
  sum {p in USINES}
    jours_usine_en_fonction [p] * prod_superieure [p] >= 20;




data;

set USINES := usine_A usine_B;

param:    prod_inferieur    prod_moyenne    prod_superieure     cout_jour :=
usine_A       8                 1                 2               1000
usine_B       2                 1                 7               2000;
