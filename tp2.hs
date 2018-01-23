type Symbole  = Char
type Mot      = [Symbole]
type Axiome   = Mot
type Regles   = Symbole -> Mot
type LSysteme = [Mot]

--la récursivité,
motSuivant :: Regles -> Mot -> Mot

--une fonction bien choisie du Prelude,
motSuivant' :: Regles -> Mot -> Mot

--une liste en compréhension.
motSuivant'' :: Regles -> Mot -> Mot
