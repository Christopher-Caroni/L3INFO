module Main where

import Graphics.Gloss

main = animate (InWindow "Dragon" (500, 500) (0, 0)) white (dragonAnime (50,250) (450,250))

dragonAnime a b t = Line (dragon a b !! (round t `mod` 20))

pointAintercaler :: Point -> Point -> Point
pointAintercaler (xA, yA) (xB, yB) = ((xA + xB)/2 + (yB - yA)/2, (yA + yB)/2 + (xA - xB)/2)

pasDragon :: Path -> Path
pasDragon [] = []
pasDragon [xa] = [xa]
pasDragon [xa, xb] = xa : pointAintercaler xa xb : [xb]
pasDragon (xa : xb : xc : xs) =
    xa : pointAintercaler xa xb : xb : pointAintercaler xc xb : pasDragon (xc:xs)
    
dragon :: Point -> Point -> [Path]
dragon (xA, yA) (xB, yB) = iterate pasDragon [(xA, yA),(xB, yB)]
