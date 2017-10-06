/*
Auteur 1: Lepretre Guillaume
Auteur 2: Caroni Christopher
*/

--Q1
 \echo 'Question 1'
select Max(prix)
from catalogue;

-- Q2
\echo '\nQuestion 2\n'
select a.anom, c.prix
from catalogue as c natural join articles as a
where prix >= (select max(prix) from catalogue);

--Q3
 \echo 'Question 3'
select fnom
from catalogue natural join fournisseurs
where prix >=(select max(prix) from catalogue);

-- Q4
-- il faut trouver 3 micro sd et pas 4
\echo '\nQuestion 4\n'
select anom as article, count(*) as nb_a
from (select anom, acoul
      from articles
      group by anom, acoul) as dummy
group by anom;

--Q5
 \echo 'Question 5'
select  anom, count(f.fid) as nb_fournisseur, min(prix), max(prix)
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
 \echo 'Question 7'
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
\echo 'Question 9'
select  anom, count(f.fid) as nb_fournisseur
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by anom;

-- Q10
\echo '\nQuestion 10\n'

select f.fnom as FOURNISSEURS, count(a.anom) as nb_a
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by fnom, acoul
having count(a.anom)>1;

--Q11
\echo 'Question 11'
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
\echo 'Question 13'
select substring(acoul from 1 for 1) as c, count(*)
from articles
group by acoul
order by acoul asc;

-- Q14
echo -e 'ON et USING ont la même performance \n
USING est plus clair mais il faut que le nom de la colonne soit la meme pour les deux tables \n
Donc dans l\'autre cas il faut utiliser ON'

