var express = require('express');
var router = express.Router();

var etudiantController = require('../controllers/etudiants');

router.get('/', etudiantController);

module.exports = router;