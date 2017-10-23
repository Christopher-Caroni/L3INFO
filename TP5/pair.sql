\echo '\n2eme question\n'
select enom
from employes as e
where e.salaire < all (
      select min(prix)
      from vols
      where dep='CDG' and arr='NOU'
);

\echo '\n4eme question\n'
\echo 'avec exists\n'
select distinct enom
from employes as e natural join certifications as c
where exists (
  select *
  from avions as a natural join certifications as c2
  where c.aid = c2.aid and a.portee > 1500
);

\echo 'avec group by : faux \n'
select distinct enom
from employes as e;

\echo '\n6eme question\n'
select distinct e.enom
from employes as e natural join certifications as c natural join avions as a
where a.portee > 1500 and e.eid in(
  select c2.eid
  from certifications as c2
)
and exists(
  select *
  from avions as a2
  where a.aid = a2.aid and anom like'Boeing%'
);


\echo '\n8eme question\n'
select distinct e.enom
from employes as e natural join certifications as c natural join avions as a
where a.portee > 2000 and e.eid in(
  select c2.eid
  from certifications as c2
)
and not exists(
  select *
  from avions as a2
  where a.aid = a2.aid and anom like'Boeing%'
);

\echo '\n10eme question\n'
select (@AVG(e.salaire) - AVG(e2.salaire)) as diff_salaire, AVG(e.salaire) as Moy_salaire_employe, AVG(e2.salaire) as Moy_salaire_pilote 
from employes as e, employes as e2
where exists (
  select *
  from certifications as c
  where c.eid = e2.eid
);/*
(select salaire
  from employes natural join certifications
) as Moy_salaire_pilote;
*/
\echo '\n12eme question\n'
