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

myget :: [a] -> Int -> a
myget (a:as) 0 = a
myget (a:as) b = myget as (b - 1)

myplus :: [a] -> [a] -> [a]
myplus [] l = l
myplus l [] = l
myplus (x:xs) (y:ys) = x : myplus xs (y:ys)

myconcat :: [[a]] -> [a]
myconcat [] = []
myconcat (xs : xss) = myplus xs (myconcat xss)

mymap :: (a->b) -> [a] -> [b]
mymap _ [] = []
mymap f (x:xs) = f x : (mymap f xs)

q8 :: [a] -> Int
q8 [] = 0
q8 xs = somme (map (\x -> 1) xs)

fctN :: (a -> a) -> a -> Int -> a
fctN _ x 0 = x
fctN fct x i = fctN fct (fct x) (i-1)

q9 :: (a -> a) -> a -> Int -> [a]
q9 _ _ 0 = []
q9 fct x i = (q9 fct x (i-1)) ++ [(fctN fct x (i-1))]

q9Iterate :: (a -> a) -> a -> Int -> [a]
q9Iterate fct x i = take i (iterate fct x)

q10 :: Int -> [Int]
q10 n = q9 (\x -> x+1) 0 n
