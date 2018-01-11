Bienvenue sur notre TP Piscine
===================



----------
<p>Mini projet réalisé dans le cadre de la Conception Orienté Objet par Christopher Caroni et Leprêtre Guillaume. Ce projet sera évalué par notre professeur de TD Quentin Baert. Dans ce tp, vous pouvez gérer une piscine...</p>

# Composition du TP :

- Une archive `Maven`
- Le code source dans `src/main`
- Les tests unitaire dans `src/test`
- Les différents UML dans `/diagrams`. Attention: tous les diagrammes ne sont pas présentés dans ce readme,
  et certains diagrammes peuvent "cacher" des classes car elles ne présentent qu'une petite de ces vue.
- Le `README.md` de ce tp


# Mise en place du tp:

- Télécharger l'archive à l'aide de la commande `git clone`
-  Compiler avec la commande `mvn package`
- Vous pouvez générer la javadoc avec la commande `mvn javadoc:javadoc`
- Pour lancer le programme, exécuter la commande  `java -jar COO-Pool-1.0-SNAPSHOT.jar` dans le dossier `target`


# Diposition des classes :

Si vous voulez voir des détails spécifique sur nos UML, dirigez vous dans le dossier `/diagrams` où vous trouverez des UML pour les différents package.
<p>Vous pouvez voir ci-dessous l'UML complet de notre projet :</p>

![image](diagrams/coo.png)



# Tests :

Lors de la réalisation de notre tp, nous avons déveloper en `TDD` (Test Driven Developement) où le but est de coder les tests avant de coder les différentes méthodes.
Cette méthode est souvent utilisé dans les entreprises et à l'avantage de ne jamais être surpris d'un `bug`. En effet, le but est de réalisé les tests et le code pas à pas
et de vérifier le tout en executant ces tests. Par conséquent, si le test ne fonctionne pas, le problème viens soit de la `méthode/classe` crée, soit du `test` lui même.
Par le biais du fichier `.gitlab-ci.yml`, nous pouvons executer les tests de notre projet avec Maven, directement sur git.
<p>Ainsi, vous pouvez voir ci-dessous que les tests exécutés sont correcte :</p>

Master branch:
[![pipeline status](https://gitlab-etu.fil.univ-lille1.fr/caroni/COO-Pool/badges/master/pipeline.svg)](https://gitlab-etu.fil.univ-lille1.fr/caroni/COO-Pool/commits/master)

Vous pouvez voir ci-dessous l'UML des différents test: 


![image](diagrams/tests.png)

# Précision de code :

## Logger

- Le Logger est une classe permettant d'avoir des traces d'exécutions
- Il peut remplacer le `System.out.println("String")`, en utilisant `Logger.info("String")`
- Il permet de  `configurer` les traces d'exécutions, par exemple en produisant le texte à la fois sur la sortie standard et dans un fichier `.log`
- Ainsi, dans `/src/main/resources` et `/src/test/resources` nous avons des fichier de configuration spécifiques à l'éxécution pour le logger utilisé par ce projet.
- Grâce à cela, il n'y a aucune trace à l'écran lors de la phase `exécution des tests` avec Maven
- Tout est redirigé vers un fichier `.log` dans le dossier `logs/test/DATE.log`

## SwimmerTest

Cette classe permet de tester la classe `Swimmer` qui étend la classe `SequentialScheduler`, lui-même testé par `SequentialSchedulerTest`.
On pourrait s'attendre à ce que l'on teste `Swimmer` en héritant de la classe `SequentialScheduler` mais comme Swimmer est une classe concrète qui possède une éxécution
spécifique, il agit différemment de SequentialScheduler et ainsi doit être testé d'une manière différente. Ceci est parce qu'un Swimmer possède un nombre et des actions
prédéfinies lors de sa construction, actions qui définissement `Swimmer`. Il serait alors inutile de tester Swimmer avec les tests de SequentialSchedulerTest car il faudrait alors
tester une version simplifiée, ce qui reviendrait à tester SequentialScheduler.  
La solution est une classe de teste commune à SequentialSchedulerTest et SwimmerTest: `GenericSchedulerTest`.

