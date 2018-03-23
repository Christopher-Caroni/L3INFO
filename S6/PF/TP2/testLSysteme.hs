module Main where
import LSysteme

main :: IO ()
main = do
  putStrLn "motSuivant vonKoch \"F-F++F-F\" :"
  print (motSuivant vonKoch "F-F++F-F")
