import Test.QuickCheck



data Arbre coul val =  Noeud {
                              coul :: coul,
                              val :: val,
                              gauche :: Arbre coul val,
                              droite :: Arbre coul val
                              }
                      | Feuille deriving Show



mapArbre :: (a -> b) -> Arbre c a -> Arbre c b
mapArbre _ Feuille         = Feuille
mapArbre f (Noeud c v g d) = Noeud c (f v) (mapArbre f g) (mapArbre f d)


hauteur :: Arbre c v -> Int
hauteur Feuille         = 0
hauteur (Noeud _ _ g d) = if lg > ld
                         then lg
                         else ld

                         where lg = 1 + hauteur g
                               ld = 1 + hauteur d

taille :: Arbre c v -> Int
taille Feuille = 0
taille (Noeud _ _ g d) = 1 + taille g + taille d

-- f (valeur noeud, valeur gauche, valeur droite)
dimension :: (b -> b -> b) -> b -> Arbre c a -> b
dimension f def Feuille         = def
dimension f def (Noeud _ v g d) = f (dimension f def g) (dimension f def d)

-- hauteur max de cet arbre
hauteur' :: Arbre c v -> Int
hauteur' = dimension (\g d -> 1 + max g d ) 0

-- nombre total de noeuds
taille' :: Arbre c v -> Int
taille' = dimension (\g d -> 1 + g + d ) 0

peigneGauche :: [(c,a)] -> Arbre c a
peigneGauche []     = Feuille
peigneGauche ((x1,x2):xs) = (Noeud x1 x2 (peigneGauche xs) Feuille)

prop_hauteurPeigne :: [(c,a)] -> Bool
prop_hauteurPeigne xs = length xs == hauteur' (peigneGauche xs)

prop_taillePeigne :: [(c,a)] -> Bool
prop_taillePeigne xs = length xs == taille' (peigneGauche xs)

estComplet :: Arbre c a -> Bool
estComplet Feuille         = True
estComplet (Noeud _ _ g d) = (hauteur' g == hauteur' d) && estComplet g && estComplet d
-- hauteur g == hauteur d ne suffit pas car cest la hauteur max, il faut donc rappeller estcomplet sur ce sous-arbre

estComplet' :: Arbre c a -> Bool
estComplet' arbre = snd (dimension (\(h1,comp_g) (h2,comp_d) -> (1 + max h1 h2, h1 == h2 && comp_g && comp_d) ) (0, True) arbre)
-- dans la paire resultat, on calcule: d'un côté on calcule l'hauteur, et de l'autre on verifie si ces hauteurs nous indique si ce noeud est complet
-- les deux parametres sont donc arbre gauche=(hauteur, noeud complet?), arbre droit=(hauteur, noeud complet?)


main :: IO ()
main = undefined
