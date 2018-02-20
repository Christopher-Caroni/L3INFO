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

complet :: Int -> [(c, a)] -> Arbre c a
complet 0 [] = Feuille
complet 0 _  = error ""
complet hauteur liste  = Noeud c val (complet (hauteur-1) listeg) (complet (hauteur-1) listed)
  where (listeg , (c, val):listed) = splitAt  (length liste `quot` 2) liste

--Q12
repeat' :: a -> [a]
repeat' = iterate id

allcharacter :: [((),Char)]
allcharacter = foldr (\x y-> ((), x) : y) [] ['a'..]


complet4 :: Arbre String Char
complet4 = complet 4 [("blue", 'a'), ("blue", 'b'), ("blue", 'c'),
                      ("blue", 'd'), ("blue", 'e'), ("blue", 'f'), ("blue", 'g'),
                      ("blue", 'h'), ("blue", 'i'), ("blue", 'j'),
                      ("blue", 'k'), ("blue", 'l'), ("blue", 'm'),
                      ("blue", 'n'), ("blue", 'o')]

aplatit :: Arbre c a -> [(c, a)]
aplatit Feuille =   []
aplatit (Noeud coul val g d) = aplatit g ++ [(coul, val)] ++ aplatit d


prop_aplatit4 :: Bool
prop_aplatit4 = map snd (aplatit complet4) == "abcdefghijklmno"

element :: Eq a => a -> Arbre c a -> Bool
element _ Feuille = False
element val (Noeud _ v g d) = (v == val) || (element val g) || (element val d)

noeud :: (c -> String) -> (a -> String) -> (c,a) -> String
noeud f g (c,val) = g val ++ " [color=" ++ f c ++ ", fontcolor=" ++ f c ++ "]"

arcs :: Arbre c a -> [(a, a)]
arcs Feuille = []
arcs (Noeud _ _ Feuille Feuille) = []
arcs (Noeud _ v g Feuille) = [(v, val g)] ++ (arcs g)
arcs (Noeud _ v Feuille d) = [(v, val d)] ++ (arcs d)
arcs (Noeud _ v g d) = [(v, val g), (v, val d)] ++ (arcs g) ++ (arcs d)

-- (noeud,noeud)
arc :: (a -> String) -> (a,a) -> String
arc f (n1,n2) = f n1 ++ " -> " ++ f n2

-- header
-- noeuds
-- arcs
dotise :: String -> (c -> String) -> (a -> String) -> Arbre c a -> String
dotise nom fcoul fval abr = unlines (header ++ map (noeud fcoul fval) (aplatit abr) ++ dotArcs ++ footer)
  where header = ["digraph \"" ++ nom ++ "\" {", "node [fontname=\"DejaVu-Sans\", shape=circle]"]
        dotArcs  = map (arc fval) (arcs abr)
        footer = ["}"]

elementR :: Ord a => Arbre c a -> a -> Bool
elementR Feuille r          = False
elementR (Noeud _ v g d) r  | r == v = True
                            | r < v  = elementR g r
                            | r > v  = elementR d r

data Couleur = Rouge
              | Noir


type ArbreRN a = Arbre Couleur a


main :: IO ()
main = undefined
