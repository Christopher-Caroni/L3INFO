-- Q1
\echo '\nQuestion 1\n'

select c.eid, max(a.portee)
from certifications as c natural join avions as a
group by c.eid
having (count(*) >= 2);

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

-- Q7
\echo '\nQuestion 7\n'

-- Q9
\echo '\nQuestion 9\n'
