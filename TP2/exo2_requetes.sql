/*
Exercice 2
Auteur1: Lepretre Guillaume
Auteur2 : Christopher Caroni
*/

--Q1.
select fnom as fournisseur, fad as adresse
from fournisseurs;
--Q2.
select distinct fnom as fournisseur
from fournisseurs as f, Catalogue as c
where prix between 10 and 20 and c.fid=f.fid;
--Q3.
select distinct anom
from Articles as a, Catalogue as c
where a.aid=c.aid and (acoul='rouge' or acoul='vert') and prix between 10 and 20;
--Q4.
select max(prix), min(prix)
from Catalogue;
--Q5
select distinct fnom as fournisseur
from Fournisseurs as f, Articles as a, Catalogue as c
where c.aid = a.aid and c.fid= f.fid and (acoul = 'argente' or acoul='magenta');
--Q6
select a1.aid as article_rouge, a2.aid as article_vert
from Articles as a1, Articles as a2
where a1.acoul='rouge' and a2.acoul='vert';
--Q7
select distinct fnom as fournisseur
from Catalogue as c, Articles as a, Fournisseurs as f
where not(acoul='noir') and not(acoul='argente') and c.aid = a.aid and c.fid= f.fid;
--Q8
select fnom as fournisseur, fad as adresse
from Fournisseurs as f inner join Catalogue as c on f.fid = c.fid
where prix > 1000;
--Q9
select distinct aid
from Catalogue;
--Q10
select count(*)
from Articles;
--Q11
select count(*)
from Catalogue;
--Q12
select count(distinct aid)
from catalogue;
--Q13
Lorsque le tous les articles du catalogue sont différents
--Q14
select count(distinct acoul)
from Articles;
