import Parser
import Data.Char
import Data.Maybe
import System.IO

type Nom = String

data Expression = Lam Nom Expression
                | App Expression Expression
                | Var Nom
                | Lit Litteral
                deriving (Show,Eq)

data Litteral = Entier Integer
              | Bool   Bool
              deriving (Show,Eq)

-- zero ou plusieurs espaces
espacesP :: Parser ()
espacesP = do many (car ' ')
              pure (())

-- un Nom, pas d'espaces au debut et consomme espaces apres
nomP :: Parser Nom
nomP = do res <- some (carQuand isAlpha)
          espacesP
          pure (res)

-- un expression, pas d'espaces au debut et consomme espaces apres
varP :: Parser Expression
varP = do res <- nomP
          pure (Var res)

applique :: [Expression] -> Expression
applique [e]      = e
applique [e1, e2] = App e1 e2
applique es       = App (applique (init es)) (last es)

applique' :: [Expression] -> Expression
applique' = foldl1 App


-- plusieurs Var sous forme de App
exprsP :: Parser Expression
exprsP = do exprs <- some exprP
            pure (applique exprs)

-- une Lam
lambdaP :: Parser Expression
lambdaP = do chaine "\\" <|> chaine "λ"
             espacesP
             lam <- nomP
             chaine "-> "
             exprs <- exprsP
             pure (Lam lam exprs)

-- une Lam ou une Var
exprP :: Parser Expression
exprP = do lambdaP <|> exprParentheseeP <|> nombreP <|> booleenP <|> varP


-- des Var ou des Lam entre parantheses et consomme les espaces apres
exprParentheseeP :: Parser Expression
exprParentheseeP = do car '('
                      res <- exprsP <|> exprP
                      car ')'
                      espacesP
                      pure res

stringToDigit :: String -> Int
stringToDigit xs = read xs -- char to digit

nombreP :: Parser Expression
nombreP = do cs <- some (carQuand isDigit)
             espacesP
             pure(Lit (Entier (read cs)))


booleenP :: Parser Expression
booleenP = do cs <- (chaine "True" <|> chaine "False")
              espacesP
              pure(Lit (Bool (read cs)))

expressionP :: Parser Expression
expressionP = do espacesP
                 exprsP

ras :: String -> Expression
ras cs = case (runParser expressionP cs) of
              Nothing   -> error "Erreur d’analyse syntaxique"
              Just(r,_) -> r

data ValeurA = VLitteralA Litteral
             | VFonctionA (ValeurA -> ValeurA)


instance Show ValeurA where
   show (VFonctionA _) = "λ"
   show (VLitteralA (Entier e)) = show e
   show (VLitteralA (Bool b)) = show b

type Environnement a = [(Nom, a)]

interpreteA :: Environnement ValeurA -> Expression -> ValeurA
interpreteA _   (Lit l)          = VLitteralA l
interpreteA env (Lam n e)        = VFonctionA (\x -> interpreteA ((n, x):env) e)
interpreteA env (Var n)          = case lookup n env of
                                        Nothing -> error "variable is not in environnement"
                                        Just(v) -> v
interpreteA env (App e1 e2)      = f (interpreteA env e2)
  where f = case interpreteA env e1 of
                  (VLitteralA _) -> error "first expression is not a function"
                  (VFonctionA r) -> r

getInteger :: ValeurA -> Integer
getInteger (VLitteralA (Entier i)) = i
getInteger _                       = error "cannot get integer from non litteral"

negA :: ValeurA
negA = VFonctionA (\x -> VLitteralA (Entier (-getInteger x)))

addA :: ValeurA
addA = VFonctionA f
       where f (VLitteralA (Entier x)) = VFonctionA g
                    where g (VLitteralA (Entier y)) = VLitteralA (Entier (x + y))
                          g e = error ("Expected an Integer, received, \"" ++ (show e))
             f e = error ("Expected an Integer, received, \"" ++ (show e))

releveBinOpEntierA :: (Integer -> Integer -> Integer) -> ValeurA
releveBinOpEntierA op = VFonctionA f
       where f (VLitteralA (Entier x)) = VFonctionA g
                    where g (VLitteralA (Entier y)) = VLitteralA (Entier (op x y))
                          g e = error ("Expected an Integer, received, \"" ++ (show e))
             f e = error ("Expected an Integer, received, \"" ++ (show e))

envA :: Environnement ValeurA
envA = [ ("neg",   negA)
       , ("add",   releveBinOpEntierA (+))
       , ("soust", releveBinOpEntierA (-))
       , ("mult",  releveBinOpEntierA (*))
       , ("quot",  releveBinOpEntierA quot)
       , ("if", ifthenelseA) ]


getBool :: ValeurA -> Bool
getBool (VLitteralA (Bool b)) = b
getBool _                        = error "cannot get boolean from a non litteral"

ifthenelseA :: ValeurA
ifthenelseA = VFonctionA (\cond -> VFonctionA
                                  (\res_true ->
                                      VFonctionA
                                      (\res_false -> if getBool cond
                                                     then res_true
                                                     else res_false)
                                      )
                         )


-------------- Interprete avec erreurs --------------

data ValeurB = VLitteralB Litteral
            | VFonctionB (ValeurB -> ErrValB)

type MsgErreur = String
type ErrValB   = Either MsgErreur ValeurB

instance Show ValeurB where
   show (VFonctionB _)          = "λ "
   show (VLitteralB (Entier n)) = show n
   show (VLitteralB (Bool n))   = show n


messErrVarNonDef :: Nom -> MsgErreur
messErrVarNonDef n = "Error : variable " ++ n ++ " not defined"

messErrAppLitLeft :: Litteral -> MsgErreur
messErrAppLitLeft l = "Error : " ++ show l ++ " not a function"

--interpreteB :: Environnement ValeurB -> Expression -> Maybe ValeurB
--interpreteB =



main :: IO ()
main = do putStr "minilang> "
          hFlush stdout
          fin <- isEOF
          if fin
              then putStrLn "bye"
              else do cmd <- getLine
                      print (interpreteA envA (ras cmd))
                      main
