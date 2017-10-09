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

\echo '\n4eme question\n'
\echo 'Avec exists'
select distinct anom
from articles as a natural join catalogue as c
where exists ( select anom
                from catalogue as c2 natural join articles as a2
                where c.fid != c2.fid and a.anom = a2.anom);

\echo '\n6eme question\n'
select aid
from articles as a natural join catalogue natural join fournisseurs as f
where f.fnom = 'kiventout' and f.fid <> some (
    select fid
    from catalogue as c
    where a.aid = c.aid);

\echo '\n8eme question\n'
select distinct fnom
from fournisseurs as f natural join catalogue as c
where exists (
  select max(prix)
  from catalogue as c2
  where c.fid = c2.fid);

/*
à changer
*/
