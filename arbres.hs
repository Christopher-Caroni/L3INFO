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


hauteur :: Arbre c v -> Integer
hauteur Feuille         = 0
hauteur (Noeud _ _ g d) = if lg > ld
                         then lg
                         else ld

                         where lg = 1 + hauteur g
                               ld = 1 + hauteur d

taille :: Arbre c v -> Integer
taille Feuille = 0
taille (Noeud _ _ g d) = 1 + taille g + taille d

foldArbre :: Integer b => (a -> b -> b -> b) -> b -> Arbre c v -> b
foldArbre f n Feuille         = n
foldArbre f n (Noeud _ v g d) = f v (foldArbre f n g) (foldArbre f n d)

hauteur' :: Arbre c v -> Integer
hauteur' = foldArbre (\_ g d -> 1 + max g d ) 0

taille' :: Arbre c v -> Integer
taille' = foldArbre (\_ g d -> 1 + g + d ) 0




main :: IO ()
main = undefined
