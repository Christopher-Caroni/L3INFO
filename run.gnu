set title "Vitesse d'éxécution en fonction de la taille du genome et nombre de threads"
set logscale x
set dgrid3d 30,30
set pm3d
splot 'testing/COMPT-TM.dat' using 1:2:3 with lines
