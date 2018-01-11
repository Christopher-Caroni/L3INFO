/*
Auteur 1: Lepretre Guillaume
Auteur 2: Caroni Christopher
*/

---------------------   REPONSES AU TP 3 ----------------------
 \echo '\n TP 3\n'

--Q1
 \echo '\nQuestion 1\n'
select Max(prix)
from catalogue;

-- Q2
\echo '\nQuestion 2\n'
select a.anom, c.prix
from catalogue as c natural join articles as a
where prix >= (select max(prix) from catalogue);

--Q3
 \echo '\nQuestion 3\n'
select fnom
from catalogue natural join fournisseurs
where prix >=(select max(prix) from catalogue);

-- Q4
\echo '\nQuestion 4\n'
select anom as article , count(distinct acoul) as nb_coul 
from articles 
group by anom ;

--Q5
 \echo '\nQuestion 5\n'
select  anom, count(distinct f.fid) as nb_fournisseur, min(prix), max(prix)
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by anom
having count(f.fid) > 1;

-- Q6
\echo '\nQuestion 6\n'
select acoul
from articles
group by acoul
having count(*) = 1;

--Q7
 \echo '\nQuestion 7\n'
select acoul as COULEUR, avg(prix) as PRIX_MOYEN
from articles natural join catalogue
group by acoul
order by PRIX_MOYEN asc;

-- Q8
\echo '\nQuestion 8\n'
select aid, acoul, count(*)
from catalogue natural join articles
group by aid, acoul;

--Q9
\echo '\nQuestion 9\n'
select  anom, count(f.fid) as nb_fournisseur
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by anom;

-- Q10
\echo '\nQuestion 10\n'

select fnom as FOURNISSEUR, count(distinct articles.acoul)as NB_A 
from fournisseurs join catalogue ON catalogue.fid = fournisseurs.fid JOIN articles on articles.aid = catalogue.aid 
group by fnom ;

--Q11
\echo '\nQuestion 11\n'
select fnom, anom
from catalogue natural join articles natural join fournisseurs
group by fnom, anom
having count(anom) > 1;

-- Q12
\echo '\nQuestion 12\n'
select anom
from articles natural join catalogue
group by anom
having count(anom)=1;

--Q13
\echo '\nQuestion 13\n'
select substring(acoul from 1 for 1) as c, count(*)
from articles
group by c
order by c asc;

-- Q14
/*ON et USING ont la même performance
USING est plus clair mais il faut que le nom de la colonne soit la meme pour les deux table
Donc dans l\'autre cas il faut utiliser ON'*/

