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

                  \echo '\n2eme question\n'
                  \echo 'Avec exists'
                  select a.anom
                  from articles as a
                  where a.acoul = 'rouge' and not exists(
                      select *
                      from articles as a2
                      where a.anom = a2.anom and a2.acoul = 'vert');

                  \echo 'Avec ALL'
                  select a.anom
                  from articles as a
                  where a.acoul = 'rouge' and anom != all (
                      select a2.anom
                      from articles as a2
                      where a.anom = a2.anom and a2.acoul = 'vert');

                  \echo 'Avec IN'
                  select a.anom
                  from articles as a
                  where a.acoul = 'rouge' and anom not in (
                      select a2.anom
                      from articles as a2
                      where a.anom = a2.anom and a2.acoul = 'vert');


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

\echo '\n4eme question\n'
select distinct aid
from catalogue as c
where exists (
  select aid
  from catalogue as c2 natural join articles as a2
  where c.aid = c2.aid
  group by aid
  having count(fid)>=2
);


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

\echo '\n6eme question\n'
select a.aid, a.anom, a.acoul
from articles as a natural join catalogue natural join fournisseurs as f
where f.fnom = 'kiventout' and f.fid = all (
    select fid
    from catalogue as c
    where a.aid = c.aid);

\echo '\nQuestion 7\n'
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

\echo '\n8eme question\n'
select fnom
from fournisseurs as f natural join catalogue as c
where not exists (
  select fid
  from catalogue as c2
  where c2.prix>c.prix);

\echo '\nQuestion 9\n'
select a.anom, min(prix) as prix_min, max(prix) as prix_max
from articles as a natural join catalogue as c
where exists (
  select c2.fid
  from articles as a2 natural join catalogue as c2
  where a.anom = a2.anom
  and c2.fid != c.fid
)
group by a.anom;

\echo '\n10eme question\n'
select distinct fnom, anom
from fournisseurs as f natural join catalogue as c natural join articles as a
where exists (
  select aid
  from articles as a2 natural join catalogue as c2
  where a.anom=a2.anom and a.acoul!=a2.acoul and c2.fid = c.fid
);

\echo '\nQuestion 11\n'
select a.anom
from articles as a natural join catalogue as c
where not exists (
  select c2.fid
  from catalogue as c2 natural join articles as a2
  where c2.fid != c.fid
  and a2.anom = a.anom
)
group by a.anom;

\echo '\n12eme question\n'
\echo 'Avec exists'
select distinct aid
from articles as a natural join catalogue as c
where not exists(
  select aid
  from catalogue as c2
  where c.aid = c2.aid and prix <= 100
);

\echo 'Avec All'
select distinct aid
from articles as a natural join catalogue as c
where aid != all(
  select aid
  from catalogue as c2
  where c.aid = c2.aid and prix <= 100
);

\echo '\nQuestion 13: les articles vendus aux USA et non uniquement\n'
select distinct c.aid
from catalogue as c
where exists (
  select *
  from fournisseurs as f
  where f.fid = c.fid
  and f.fad like '%USA%'
);


\echo '\n14eme question\n'
select fid, fnom
from fournisseurs as f natural join catalogue as c natural join articles as a
where not exists(
  select aid
  from catalogue as c2 natural join articles as a2
  where c2.fid=c.fid and a2.acoul != 'rouge'
);

\echo '\nQuestion 15\n'
select distinct f.fnom
from fournisseurs as f natural join catalogue as c natural join articles as a
group by f.fnom, a.acoul
having count(*) = (
  select count(*)
  from articles as a2
  where a2.acoul = 'rouge'
)
and a.acoul = 'rouge';
