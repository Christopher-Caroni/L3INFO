% Q14
schemaQ14([m,y,p,mp,c]).

fdsQ14([ [[m],[m,p]],
      [[m,y],[p]],
      [[mp],[c]] ]).
      
%schema(R), fds(F), candkey(R,F,[m]).
%Resultat: false.

%schema(R), fds(F), candkey(R,F,[m,y]).
%Resultat:false.

%schema(R), fds(F), candkey(R,F,[m,c]).
%Resultat: false.

%schema(R), fds(F), is3NF(R,F).
%Resultat: false.

%schema(R), fds(F), isBCNF(R,F).
%Resultat: false.


%d([ [[m,y,p],[m,mp,class]] ]).

%schema(R), fds(F), d(D), ljd(R,F,D).
%[[b,1,1],[b,1,2],[b,1,3],[b,1,4],[b,1,5]].