import Parser
import Data.Char
import Data.Maybe

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
interpreteA env (Var n)          = fromJust (lookup n env)
interpreteA env (App e1 e2)      = f (interpreteA env e2)
  where f = case interpreteA env e1 of
                  (VLitteralA _) -> error "first expression is not a function"
                  (VFonctionA r) -> r










--main :: IO ()
--main = _
