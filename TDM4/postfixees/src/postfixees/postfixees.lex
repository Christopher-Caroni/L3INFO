package postfixees;

%%

%unicode
%line
%column

ENTIER_SIMPLE=[0-9]+
PLUS=[+]|plus
MOINS=[-]|plus
FACTEUR=[*]|plus
DIVISION=[/]|plus

%%

{ENTIER_SIMPLE}
      { return new Valeur(yytext()); }

{PLUS}
      { return new Plus(yytext()); }

{MOINS}
      { return new Moins(yytext()); }

{FACTEUR}
      { return new Facteur(yytext()); }

{DIVISION}
      { return new Division(yytext()); }

/* ajouter le cas des espaces et fins de ligne */
[\s]
  {}

/* ajouter les autres tokens */
