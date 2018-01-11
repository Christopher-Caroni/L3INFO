/*
Exercice 3:
Auteur1: Lepretre Guillaume
Auteur2 : Christopher Caroni
*/
--Q1
select f.fid
from fournisseurs as f,Articles as a,catalogue as c
where f.fid = c.fid and a.aid = c.aid and acoul='vert';
--Q2
--sans join
Select round(avg(prix::numeric),2)
from articles as a, catalogue as c
where a.aid = c.aid and acoul='rouge';
--avec join
Select round(avg(prix::numeric),2)
from articles as a inner join catalogue as c
on a.aid = c.aid
where acoul='rouge';
-- avec alias
Select round(avg(prix::numeric),2) as PRIX_ROND_articles_rouge
from articles as a, catalogue as c
where a.aid = c.aid and acoul='rouge';
--Q3
select distinct fnom
from fournisseurs as f left outer join catalogue as c
on f.fid = c.fid
where aid is NULL;
--Q4
select distinct a.aid
from articles as a left outer join catalogue as c
on a.aid = c.aid
where fid is NULL;
--Q5
select distinct a.aid
from articles as a
where a.aid not in (select c.aid
                    from catalogue);
