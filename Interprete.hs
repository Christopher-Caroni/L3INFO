import Parser
import Data.Char

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

exprP :: Parser Expression
exprP = varP


-- plusieurs Var sous forme de App
exprsP :: Parser Expression
exprsP = do exprs <- some exprP
            pure (applique exprs)

-- une Lam
lambdaP :: Parser Expression
lambdaP = do chaine "\\"
             espacesP
             lam <- nomP
             chaine "-> "
             exprs <- exprsP
             pure (Lam lam exprs)

-- une Lam ou une Var
exprP' :: Parser Expression
exprP' = do exprP <|> lambdaP


-- des Var ou des Lam entre parantheses et consomme les espaces apres
exprParentheseeP :: Parser Expression
exprParentheseeP = do car '('
                      res <- exprsP <|> exprP'
                      car ')'
                      espacesP
                      pure res
-- Expression finale
exprP'' :: Parser Expression
exprP'' = do exprP' <|> exprParentheseeP

-- Expressions finale
exprsP' :: Parser Expression
exprsP' = do exprs <- some exprP''
             pure (applique exprs)

stringToDigit :: String -> Int
stringToDigit xs = xs -- char to digit

nombreP :: Parser Expression
nombreP = do some carQuand isDigit

             pure(Lit (Entier ))










--main :: IO ()
--main = _
