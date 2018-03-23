set title "Temps et vitesse d'execution"
set logscale x
set xlabel "taille en octets"
set logscale y
set ylabel "temps reel en s temps systeme/s"
set style data linespoints
plot "mcat-tm-fsync.dat" using 1:2 title "temps réel", \
     "mcat-tm-fsync.dat" using 1:4 title "temps système", \
     "mcat-tm-fsync.dat" using 1:3 title "temps user"
pause -1  "Hit return to continue"
