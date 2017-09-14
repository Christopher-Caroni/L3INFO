# COO TP1

## Intro
TP1 de COO sur les generics en java.

## How to
### Exercice 2
Pour chaque exercice, il faut lancer le `main()` correspondant et vérifier les sorties attendus ou décommenter les lignes `// NE COMPILE PAS`et vérifier qu'elles ne compilent pas.

### Exercice 3
Soit lancer le `main()` et vérifier les sorties ou lancer les tests unitaires de `CollectorTest`.


## Précisions code

### Précisions sur les commentaires // NE COMPILE PAS

#### Exercice 2

 - **VegetableListChoser**
-	 > //	Apple chosenApple = lcl.chose("which apple ? ",lApples);

		Cette ligne ne compile pas parce que la méthode `choose()`n'accepte que des sous classes de `Vegetable`. Or, `lApples` implémente Fruit et n'a aucune relation avec `Vegetable`.

 - **ClonableVegetableListChoser**
-	 >// Rutabaga chosenRutabaga = lclc.chose("which rutabaga ? ",lRutabagas);  
	 
	 `choose()` n'accepte que des sous classes de `Vegetable` et `Cloneable` en même temps. Or `lRutabagas` étend `Vegetable` mais pas `Cloneable`.

-	>// Apple chosenApple = lclc.chose("which apple ? ",lApples);
	
		`lApples` ne répond toujours pas au types acceptés par choose comme précédemment.


#### Exercice 3
 - **Collector**
-	 >// carrotCollector2.take(p1);
	 
	 `carrotCollector2` n'accepte que des `Carrot` alors que `p1` est un `Apple`. Ces deux n'ont aucune relation.
	 
-	 >// carrotCollector1.giveTo(appleCollector1);

		`carrotCollector1` ne peut que donner à des classes acceptant des super classes de `Carrot`. Or `Apple` n'a aucune relation avec `Carrot` sauf `Object` mais  dont il est la sous classe.

-	>// vegetableCollector.giveTo(carrotCollector1);

		`vegetableCollector` ne peut que donner à des classes acceptant des super classes de `Vegetable`. Or, `carrotCollector1` accepte des `Carrot` qui est une sous classe de `Vegetable` et non une super classe.
		
-	> // appleCollector1.giveTo(vegetableCollector);

		`appleCollector1` ne peut que donner à des classes acceptant des super classes de `Apple`. Or, `vegetableCollector` accepte des `Vegetable` qui n'est pas une super classe de `Apple`.