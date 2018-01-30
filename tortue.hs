-- auteur :  Leprêtre Guillaume et Caroni Christopher

module Tortue where

import Graphics.Gloss
import LSysteme


type EtatTortue = (Point, Float)

-- l’état de la tortue et le chemin qu’elle a parcouru jusqu’à maintenant
type EtatDessin = (EtatTortue, Path)

type Config = (EtatTortue -- État initial de la tortue
              ,Float      -- Longueur initiale d’un pas
              ,Float      -- Facteur d’échelle
              ,Float      -- Angle pour les rotations de la tortue
              ,[Symbole]) -- Liste des symboles compris par la tortue


etatInitial :: Config -> EtatTortue
etatInitial (x,_,_,_,_) = x

longueurPas :: Config -> Float
etatInitial (_,x,_,_,_) = x

facteurEchelle :: Config -> Float
etatInitial (_,_,x,_,_) = x

angle :: Config -> Float
etatInitial (_,_,_,x,_) = x

symbolesTortue :: Config -> [Symbole]
etatInitial (_,_,_,_,x) = x

avance :: Config -> EtatTortue -> EtatTortue
avance conf ((x,y),a) = ((x',y'),a)
  where x' = x + (longueurPas conf) * (cos a)
        y' = y + (longueurPas conf) * (sin a)

tourneAGauche :: Config -> EtatTortue -> EtatTortue
tourneAGauche conf (_,cap) = (_,cap')
  where cap' = cap + (angle conf)

tourneADroite :: Config -> EtatTortue -> EtatTortue
tourneADroite conf (_,cap) = (_,cap')
    where cap' = cap - (angle conf)

filtreSymbolesTortue :: Config -> Mot -> Mot
filtreSymbolesTortue conf = filter(`elem` symbolesTortue conf)

-- calcule le nouvel état atteint par l’exécution de l’ordre correspondant au symbole donné en partant de l’état donné
interpreteSymbole :: Config -> EtatDessin -> Symbole -> EtatDessin
interpreteSymbole conf (etat, path) s = (etat', path ++ [fst etat'])
    where etat' | s == 'F'  = avance conf etat
                | s == '+'  = tourneAGauche conf etat
                | s == '-'  = tourneADroite conf etat
                | otherwise = error "wrong symbol"

interpreteMot :: Config -> Mot -> Picture
interpreteMot conf mot = line (snd (foldl (interpreteSymbole conf) firstEtat motsReconnus))
    where firstPoint = fst (etatInitial conf)
          firstEtat = (etatInitial conf, [firstPoint])
          motsReconnus = filtreSymbolesTortue conf mot

dessin :: Picture
dessin = interpreteMot (((-150,0),0),100,1,pi/3,"F+-") "F+F--F+F"

main :: IO()
main = display (InWindow "L-système" (1000, 1000) (0, 0)) white dessin
