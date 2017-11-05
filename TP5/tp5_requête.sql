/*
Auteurs :
Caroni Christopher 
Lepretre Guillaume
*/
-- Q1
\echo '\nQuestion 1\n'

select c.eid, max(a.portee)
from certifications as c natural join avions as a
group by c.eid
having (count(*) >= 2);

-- Q2
\echo '\n2eme question\n'

select enom
from employes as e
where e.salaire < all (
      select min(prix)
      from vols
      where dep='CDG' and arr='NOU'
);

-- Q3
\echo '\nQuestion 3\n'
\echo '\nVersion 1\n'
select e.eid
from certifications as c natural join avions as a natural join employes as e
where exists (
  select *
  from certifications as c2
  where e.eid = c2.eid
)
group by e.eid
having e.salaire > 100000;

\echo '\nVersion 2\n'


-- Q4
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

-- Q5
\echo '\nQuestion 5\n'
select e.enom
from employes as e natural join certifications as c natural join avions as a
where e.eid IN (
  select c2.eid
  from certifications as c2
)
and a.portee > 1500
group by e.eid
having count(*) >= 2;


-- Q6
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

-- Q7
\echo '\nQuestion 7\n'
select e.eid
from employes as e
where e.salaire = (
  select max(e2.salaire)
  from employes as e2
  where e2.salaire != (
    select max(salaire)
    from employes
  )
);

-- Q8
\echo '\n8eme question\n'

select distinct e.enom
from employes as e natural join certifications as c natural join avions as a
where a.portee > 2000 and not exists
    (select e2.eid 
    from employes as e2 natural join certifications as c2 natural join avions as a2 where e.eid = e2.eid and upper(a2.anom) like '%BOEING%');

-- Q9
\echo '\nQuestion 9\n'
select e.enom, e.salaire
from employes as e
where not exists(
    select eid
    from certifications as c
    where e.eid = c.eid
)
and e.salaire >=(
    select avg(salaire)
    from employes  
);
-- Q10
\echo '\n10eme question\n'

select (@AVG(e.salaire) - AVG(e2.salaire)) as diff_salaire, AVG(e.salaire) as Moy_salaire_employe, AVG(e2.salaire) as Moy_salaire_pilote 
from employes as e, employes as e2
where exists (
  select *
  from certifications as c
  where c.eid = e2.eid
);

-- Q11
\echo '\nQuestion 11\n'
SELECT h_dep from vols where UPPER(dep) = 'MADISON' and UPPER(arr) ='NEW YORK' and extract(hour from h_arr )< 18;

/*
Insertion pour tester la q11:
insert into vols values(666,'Madison','New York',789, '2016-04-12 16:00:00','2016-04-12 18:15:00',195);
*/
-- Q12
\echo '\n12eme question\n'
