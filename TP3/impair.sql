--Q1
 \echo 'Question 1'
select Max(prix)
from catalogue;

--Q3
 \echo 'Question 3'
select fnom
from catalogue natural join fournisseurs
where prix >=(select max(prix) from catalogue);

--Q5
 \echo 'Question 5'
select  anom, count(f.fid) as nb_fournisseur, min(prix), max(prix)
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by anom
having count(f.fid) > 1;

--Q7
 \echo 'Question 7'
select acoul as COULEUR, avg(prix) as PRIX_MOYEN
from articles natural join catalogue
group by acoul
order by PRIX_MOYEN asc;

--Q9
\echo 'Question 9'
select  anom, count(f.fid) as nb_fournisseur
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by anom;

--Q11
\echo 'Question 11'
select fnom, anom
from catalogue natural join articles natural join fournisseurs
group by fnom, anom
having count(anom) > 1;

--Q13
\echo 'Question 13'
select substring(acoul from 1 for 1) as c, count(*)
from articles
group by acoul
order by acoul asc;
