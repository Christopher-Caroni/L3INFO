Bienvenue sur notre TP Single Page Application
===================



----------
<p>TP réalisé dans le cadre de l'option Javascript et son environnement par Christopher Caroni et Leprêtre Guillaume. 
Ce projet sera évalué par notre professeur Jean Christophe Routier.</p>

<p>Dans ce tp, nous avons une gestion d'étudiants en single page application, développée avec l'environnemnt Node JS</p>

# Mise en place du TP :

- Installer l'environnement avec la commande `npm install`
- Créer un dossier pour la base de donnée MongoDB
- Lancer le serveur MongoDB avec la commande `mongod --dbpath <dossier>`
- Vous pouvez importez des étudiants avec la commande `mongoimport --db etudiants --collection etudiants --type csv --file ./etudiants.csv --headerline`
- Lancer la commande `nodemon` pour que le serveur puisse se lancer
- Aller sur l'adresse suivante : `127.0.0.1:3000` afin d'apprécier la page web