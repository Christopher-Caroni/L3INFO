module Tortue where

import Graphics.Gloss
import LSysteme


type EtatTortue = (Point, Float)

type EtatDessin = (EtatTortue, Path)

type Config = (EtatTortue -- État initial de la tortue
              ,Float      -- Longueur initiale d’un pas
              ,Float      -- Facteur d’échelle
              ,Float      -- Angle pour les rotations de la tortue
              ,[Symbole]) -- Liste des symboles compris par la tortue


etatInitial :: Config -> EtatTortue
etatInitial (a,_,_,_,_) = a
