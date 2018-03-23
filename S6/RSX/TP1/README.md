# TP1 Réseaux

## Composition:
Les différentes exercices sont séparés dans leurs paquets respectifs: `ex1`, `ex2`, `ex3` (et `ex3gui`).

## Fonctionnement

Pour l'exercice 3, il suffit de lancer le main dans `App` ou `GuiApp` dans le package `ex3` et `ex3gui`.

Avec `App`, on peut envoyer et recevoir des messages par le terminal.  
Avec `GuiApp`, tous les messages reçus sont affichés au centre, et on peut taper un message dans la cadre du bas avant d'appuyer sur `entrée` ou le bouton `Send` pour enovyer son message.

A noter que `GuiApp` n'introduit pas de nouvelles fonctionnalités mais ne sert qu'à afficher les messages envoyés/recus grâce a `SingleMulticastClientServer`