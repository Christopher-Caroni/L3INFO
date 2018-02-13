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
dimension :: (a -> b -> b -> b) -> b -> Arbre c a -> b
dimension f def Feuille         = def
dimension f def (Noeud _ v g d) = f v (dimension f def g) (dimension f def d)

-- hauteur max de cet arbre
hauteur' :: Arbre c v -> Int
hauteur' = dimension (\_ g d -> 1 + max g d ) 0

-- nombre total de noeuds
taille' :: Arbre c v -> Int
taille' = dimension (\_ g d -> 1 + g + d ) 0

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
estComplet' arbre = snd (dimension (\_ (v1,g) (v2,d) -> (1 + max v1 v2,g == d) ) (0, True) arbre)


main :: IO ()
main = undefined
