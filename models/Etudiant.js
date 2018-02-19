var mongoose = require('mongoose');

var etudiantSchema = new mongoose.Schema(
    {
        nom : String,
        prenom : String,
        groupe : String
    }
);

module.exports = etudiantSchema;