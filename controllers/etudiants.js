var Etudiants = require('../models/etudiants').model;

var etudiants =
    (req, res) =>
        res.render(Etudiants);

module.exports =
(req, res, next) =>
      res.render('etudiants', {title : 'liste des etudiants'});
