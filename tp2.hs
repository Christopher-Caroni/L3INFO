alterne :: [a] -> [a]
alterne [] = []
alterne [x] = [x]
alterne (x:_:xs) = x : alterne xs

combine :: (a -> b -> c) -> [a] -> [b] -> [c]
combine _ [] [] = []
combine _ [] _ = []
combine _ _ [] = []
combine f (x:xs) (y:ys) = f x y : combine f xs ys
