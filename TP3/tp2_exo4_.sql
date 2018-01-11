/*
Auteur 1: Lepretre Guillaume
Auteur 2: Caroni Christopher
*/

---------------------   REPONSES AU TP 2 ----------------------
 \echo '\n TP 2\n'
-- Exercice 4

-- Q1
\echo '\nQuestion 1\n'
select upper(fnom) from fournisseurs;

-- Q2
\echo '\nQuestion 2\n'
select fid, aid, CEIL(prix) as PRIX_ROND from catalogue;

-- Q3
\echo '\nQuestion 5\n'
select fnom from fournisseurs where fad LIKE '%Paris' ;

-- Q4
\echo '\nQuestion 4\n'
select * from fournisseurs where fnom SIMILAR TO '%[ei]%[ei]%' ;

-- Q5
\echo '\nQuestion 5\n'
select * from fournisseurs where fnom SIMILAR TO '%[aA]%' ;