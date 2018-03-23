const dbConnection = require('../controllers/db');
var mongoose = require('mongoose');

var etudiantSchema = new mongoose.Schema(
    {
        nom : String,
        prenom : String,
        groupe : String
    }
);

module.exports = etudiantSchema;


var Etudiants = dbConnection.model('Etudiants',etudiantSchema,"etudiants");
module.exports.schema = etudiantSchema;
module.exports.model = Etudiants;