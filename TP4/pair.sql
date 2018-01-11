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
select distinct aid
from catalogue as c
where exists (
  select aid
  from catalogue as c2 natural join articles as a2
  where c.aid = c2.aid
  group by aid
  having count(fid)>=2
);

\echo '\n6eme question\n'
select a.aid, a.anom, a.acoul
from articles as a natural join catalogue natural join fournisseurs as f
where f.fnom = 'kiventout' and f.fid = all (
    select fid
    from catalogue as c
    where a.aid = c.aid);

\echo '\n8eme question\n'
select fnom
from fournisseurs as f natural join catalogue as c
where not exists (
  select fid
  from catalogue as c2
  where c2.prix>c.prix);

\echo '\n10eme question\n'
select distinct fnom, anom
from fournisseurs as f natural join catalogue as c natural join articles as a
where exists (
  select aid
  from articles as a2 natural join catalogue as c2
  where a.anom=a2.anom and a.acoul!=a2.acoul and c2.fid = c.fid
);

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

\echo '\n14eme question\n'
select fid, fnom
from fournisseurs as f natural join catalogue as c natural join articles as a
where not exists(
  select aid
  from catalogue as c2 natural join articles as a2
  where c2.fid=c.fid and a2.acoul != 'rouge'
);
