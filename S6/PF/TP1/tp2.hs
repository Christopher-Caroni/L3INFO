-- auteur :  Leprêtre Guillaume et Caroni Christopher
--TP 2 : Deuxieme contact avec Haskell

import Graphics.Gloss

alterne :: [a] -> [a]
alterne [] = []
alterne [x] = [x]
alterne (x:_:xs) = x : alterne xs

combine :: (a -> b -> c) -> [a] -> [b] -> [c]
combine _ [] [] = []
combine _ [] _ = []
combine _ _ [] = []
combine f (x:xs) (y:ys) = f x y : combine f xs ys

pasPascal :: [Int] -> [Int]
pasPascal [] = [1]
pasPascal l = [1] ++ zipWith (+) (tail l) (init l) ++ [1]

pascal :: [[Int]]
pascal = iterate pasPascal []

pointAintercaler :: Point -> Point -> Point
pointAintercaler (xA,yA) (xB,yB) = Point( (xA + xB)/2 + (yB − yA)/2, (yA + yB)/2 + (xA − xB)/2 )
