const express = require('express');
const path = require('path');
const favicon = require('serve-favicon');
const logger = require('morgan');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');

// get connection to database
var dbConnection = require('./controllers/db.js');

// routes
var index = require('./routes/index');
var books = require('./routes/books');
var error = require('./routes/error');
var bookrest = require('./routes/bookrest');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));


app.use('/', index);
app.use('/books', books);
app.use('/bookrest', bookrest);

// error handler
app.use(error);


module.exports = app;
