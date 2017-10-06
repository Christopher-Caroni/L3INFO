-- Q2
\echo '\nQuestion 2\n'
select a.anom, c.prix
from catalogue as c natural join articles as a
where prix >= (select max(prix) from catalogue);

-- Q4
-- il faut trouver 3 micro sd et pas 4
\echo '\nQuestion 4\n'
select anom as article, count(*) as nb_a
from (select anom, acoul
      from articles
      group by anom, acoul) as dummy
group by anom;

-- Q6
\echo '\nQuestion 6\n'
select acoul
from articles
group by acoul
having count(*) = 1;

-- Q8
\echo '\nQuestion 8\n'
select aid, acoul, count(*)
from catalogue natural join articles
group by aid, acoul;

-- Q10
\echo '\nQuestion 10\n'

select f.fnom as FOURNISSEURS, count(a.anom) as nb_a
from articles as a, fournisseurs as f, catalogue as c
where a.aid = c.aid and f.fid = c.fid
group by fnom, acoul
having count(a.anom)>1;


-- Q12
\echo '\nQuestion 12\n'
select anom
from articles natural join catalogue
group by anom
having count(anom)=1;


-- Q14
/*
ON et USING ont la même performance
USING est plus clair mais il faut que le nom de la colonne soit la meme pour les deux tables
Donc dans l'autre cas il faut utiliser ON
*/
