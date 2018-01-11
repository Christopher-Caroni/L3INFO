/*
Exercice 4:
Auteur1: Lepretre Guillaume
Auteur2 : Christopher Caroni
*/

--Q1
select upper(fnom)
from fournisseurs;
--Q2
select fid, aid, round(AVG(prix)) as PRIX_ROND
from catalogue
group by fid, aid;
--Q3
select fnom
from fournisseurs
where fad like '% Paris';
--Q4
select fnom
from fournisseurs
where fnom like '%i%e%' or fnom like '%e%i%';
--Q5
select fnom
from fournisseurs
where fnom like '%a%' or fnom like '%A%';
