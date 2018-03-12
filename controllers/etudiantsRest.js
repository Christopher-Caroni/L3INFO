var Etudiants = require('../models/etudiants').model;


var home =
    (req,res) =>
        Etudiants.find()
            .then( allEtu => res.status(200).json(allEtu) );

var getEtudiant =
    (req,res) =>
        Etudiants.findById( req.params.etudiantId )
            .then( etudiant => res.status(200).json(etudiant) );

var createEtudiant =
    (req,res) => {
        let newEtudiant = { ...req.body };
        Etudiants.create(newEtudiant)
            .then( etudiant => res.status(200).json(etudiant) );
    }

var updateEtudiant =
    (req, res) => {
        let updatedEtudiant = { ...req.body };
        Etudiants.findByIdAndUpdate( req.params.etudiantId, updatedEtudiant, { new : true } )
            .then( etudiant => res.status(200).json(etudiant) );
    }

var deleteEtudiant =
    (req,res) =>
        Etudiants.findByIdAndRemove( req.params.etudiantId )
            .then( () => res.status(200).end() );


module.exports.home = home;
module.exports.getEtudiant = getEtudiant;
module.exports.createEtudiant = createEtudiant;
module.exports.updateEtudiant = updateEtudiant;
module.exports.deleteEtudiant = deleteEtudiant;
