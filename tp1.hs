-- auteur :  Leprêtre Guillaume et Caroni Christopher
--TP 1 : Premier contact avec Haskell

sommeDeXaY :: (Enum a, Num a) => a -> a -> a
sommeDeXaY x y = sum[x..y]

somme :: [Int] -> Int
somme [] = 0
somme (n:ns) = n + somme ns

mylast :: [a] -> a
mylast [] = error "liste vide"
mylast xs = xs !! ((length xs) - 1)

myinit :: [a] -> a
myinit [] = error "liste vide"
myinit xs = head xs
