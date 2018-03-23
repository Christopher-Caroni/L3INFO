% Q8
schemaQ8([propertyid,countyname,lotno,area,price,taxrate]).
fdsQ8([ [[propertyid],[countyname, lotno, area, price, taxrate]], [[countyname, lotno],[propertyid, area, price, taxrate]],[[countyname],[taxrate]] ]).
decompQ8([[propertyis,area,lotno],[area,countyname],[area,price],[countyname,taxrate] ]).

% tests if decompQ8 is a lossless decomposition of schemaQ8
% schemaQ8(R), fdsQ8(F), decompQ8(D), ljd(R,F,D).
/* Resultat:

/*
  schema(R), fds(F), lots1ax(D), ljd(R,F,D).
  [[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5],[b,1,6]]
  [[b,2,1],[b,2,2],[b,2,3],[b,2,4],[b,2,5],[b,2,6]]
  [[b,3,1],[b,3,2],[b,3,3],[b,3,4],[b,3,5],[b,3,6]]
  false.

  schema(R), fds(F), lots1ay(D), ljd(R,F,D).
  [[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5],[b,1,6]]
  [[b,2,1],[b,2,2],[b,2,3],[b,2,4],[b,2,5],[b,2,6]]
  false.

  schema(R), fds(F), lots1b(D), ljd(R,F,D).
  [[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5],[b,1,6]]
  [[b,2,1],[b,2,2],[b,2,3],[b,2,4],[b,2,5],[b,2,6]]
  false.

  schema(R), fds(F), lots2(D), ljd(R,F,D).
  [[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5],[b,1,6]]
  [[b,2,1],[b,2,2],[b,2,3],[b,2,4],[b,2,5],[b,2,6]]
  false.

*/