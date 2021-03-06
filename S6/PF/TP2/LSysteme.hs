module LSysteme where

type Symbole  = Char
type Mot      = [Symbole]
type Axiome   = Mot
type Regles   = Symbole -> Mot
type LSysteme = [Mot]

-- 1e méthode: la récursivité,
motSuivant :: Regles -> Mot -> Mot
motSuivant r [x] = r x
motSuivant r (x:xs) = r x ++ motSuivant r xs


-- Definiton vonKoch
regleVonKoch :: Axiome
regleVonKoch = "F-F++F-F"

vonKoch :: Symbole -> Mot
vonKoch '+' = "+"
vonKoch '-' = "-"
vonKoch 'F' = regleVonKoch
vonKoch _ = fail ""
-- fin Definiton

--une fonction bien choisie du Prelude
-- map tous les elements puis concatene
motSuivant' :: Regles -> Mot -> Mot
motSuivant' = concatMap

--une liste en compréhension.
--motSuivant'' :: Regles -> Mot -> Mot

lsysteme :: Axiome -> Regles -> LSysteme
lsysteme a r = iterate (motSuivant r) a
