package postfixees;

%%

%unicode
%line
%column

ENTIER_SIMPLE=[0-9]+
PLUS=[+]|plus
MOINS=[-]|plus
MULT=[*]|plus
QUO=[/]|plus
OPP=opp

%%

{ENTIER_SIMPLE}
      { return new Valeur(yytext()); }

{PLUS}
      { return new Plus(yytext()); }

{MOINS}
      { return new Moins(yytext()); }

{MULT}
      { return new Mult(yytext()); }

{QUO}
      { return new Quo(yytext()); }
{OPP}
      { return new Opp(yytext()); }

/* ajouter le cas des espaces et fins de ligne */
[\s]
  {}

/* ajouter les autres tokens */
