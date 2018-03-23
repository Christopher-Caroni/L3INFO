var Etudiants = require('../models/etudiants').model;

var etudiants =
    (req, res) =>
        Etudiants.find()
            .then(allEtudiants => res.render("etudiants",
                {
                    title : 'Liste d\'étudiants',
                    etudiantsData : allEtudiants
                }));

module.exports = etudiants;