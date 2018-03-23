var express = require('express');
var router = express.Router();

// import controller for books
var controller = require('../controllers/etudiantsRest');

router.get('/', controller.home );
router.get( '/:etudiantId', controller.getEtudiant );
router.post( '/', controller.createEtudiant );
router.put( '/:etudiantId', controller.updateEtudiant );
router.delete( '/:etudiantId', controller.deleteEtudiant );

module.exports = router;
