/* Exemple 1 */
package exemple1;

%%

%unicode
/*
MOT_USUEL=[:letter:]+
*/
ENTIER_SIMPLE=[0-9]+
IDENTIFICATEUR=[a-zA-Z][a-zA-Z0-9]*
OPERATEUR=[-\+*/]

%%

{IDENTIFICATEUR}|{ENTIER_SIMPLE}|{OPERATEUR}
      {return new Yytoken(yytext());}


[^[:letter:]0-9]+|[:letter:]
      {}
