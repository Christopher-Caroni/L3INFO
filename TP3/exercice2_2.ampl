set USINES;
set QUALITE;

param cap_production {USINES, QUALITE};
param qte_stock {QUALITE};
param cout_par_papier {USINES};
param commande {QUALITE};


var jours_usine_en_fonction {p in USINES} >= 0;


minimize cout_engendre :
  sum {u in USINES}
    jours_usine_en_fonction [u] * cout_jour [u];

subject to prod_minimum :
  sum {q in QUALITE}
    qte_produite [q] >= commande [q];



contraintees
- il fait produire assez pour la commande
  pour chaque qualite q de papier
    la production de q est >= a la commande de q


data;


set USINES := usine_A usine_B;

param cap_production:     prod_inf_jour    prod_moy_jour    prod_sup_jour   :=
usine_A                        8                 1                 2
usine_B                        2                 1                 7 ;


param : QUALITE :     semaine_1       semaine_2     semaine_3 :=
        qual_inf        16              18              22
        qual_moy        10               8               9
        qial_sup        20              14              23;






param:      QUALITE:             qual_inf      qual_moy      qual_sup :=
        commande_semaine_1          16              10             20
        commande_semaine_2          18               8             14
        commande_semaine_3          22               9             23;
