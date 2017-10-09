-- Q1
\echo '\nQuestion 1\n'
\echo 'Couleurs rares\n'
select a1.acoul
from articles as a1
where not exists (select acoul
                  from articles as a2
                  where a1.acoul = a2.acoul
                  and a1.aid != a2.aid);


\echo 'Couleurs avec au moins deux articles\n'
select distinct a1.acoul
from articles as a1
where exists (select acoul
                  from articles as a2
                  where a1.acoul = a2.acoul
                  and a1.aid != a2.aid);


\echo '\nQuestion 3\n'
-- a verifier
select distinct f1.fnom
from fournisseurs as f1 natural join (
                select c1.fid, c1.prix
                from catalogue as c1
                group by c1.fid, c1.aid
                having c1.prix > (select avg(prix)
                                from catalogue as c2
                                where c2.aid = c1.aid)
) as above_avg;


\echo '\nQuestion 5\n'
\echo 'Avec IN\n'
select fid
from fournisseurs
where fid not in (
          select fid
          from catalogue
);

\echo 'Avec ALL\n'
select fid
from fournisseurs
where fid != ALL (
          select fid
          from catalogue
);



\echo '\nQuestion 7\n'
-- en cours
/*
select les fids
where la déclaration suivante est fausse:
il existe un anom dans articles dont le aid n'nest pas dans catalogue
pour un fid voulu
*/
select f.fid
from fournisseurs as f
where not exists (
          select a.anom
          from articles as a
          where not exists (
                  select a2.anom
                  from catalogue as c2 natural join articles as a2
                  where f.fid = c2.fid
                  and a.anom = a2.anom
          )
);
