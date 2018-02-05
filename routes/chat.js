var express = require('express');
var router = express.Router();

var chatController = require('../controllers/chat');

router.get('/', chatController.chat);

module.exports = router;