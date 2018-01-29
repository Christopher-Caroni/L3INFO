/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 2);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Mobile = function () {
    function Mobile(aCanvas, srcImage, x, y, vx, vy) {
        _classCallCheck(this, Mobile);

        this.myCanvas = aCanvas;
        this.context = this.myCanvas.getContext("2d");

        this.imgMobile = new Image();
        this.imgLoaded = false;
        this.imgMobile.addEventListener("load", this.imgLoadListener.bind(this));
        this.imgMobile.src = srcImage;

        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    _createClass(Mobile, [{
        key: "draw",
        value: function draw() {
            if (this.imgLoaded === true) {
                this.context.drawImage(this.imgMobile, this.x, this.y);
            }
        }
    }, {
        key: "move",
        value: function move() {
            this.x += this.vx;
            this.y += this.vy;
        }
    }, {
        key: "imgLoadListener",
        value: function imgLoadListener() {
            this.imgLoaded = true;
        }
    }]);

    return Mobile;
}();

exports.default = Mobile;

/***/ }),
/* 1 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "images/imgb3ed500bab96ecd82052a2aedf9b2e04.png";

/***/ }),
/* 2 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _Game = __webpack_require__(3);

var _Game2 = _interopRequireDefault(_Game);

__webpack_require__(9);

var _flyingSaucerPetit = __webpack_require__(1);

var _flyingSaucerPetit2 = _interopRequireDefault(_flyingSaucerPetit);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function setupGame(theCanvas) {
    var game = new _Game2.default(theCanvas);
    game.constructor = undefined;
    Object.getPrototypeOf(game).constructor = undefined;

    window.addEventListener('keydown', game.keyDownActionHandler.bind(game));
    window.addEventListener('keyup', game.keyUpActionHandler.bind(game));

    var scoreSpan = document.getElementById("score");
    game.setHTMLScore(scoreSpan);

    return game;
}

function setupButtons(game) {
    var newSaucerButton = document.getElementById("nouvelleSoucoupe");
    newSaucerButton.addEventListener("click", game.addSaucer.bind(game));
    document.getElementById("newSaucerButtonImg").src = _flyingSaucerPetit2.default;

    var infiniteSaucers = document.getElementById("flotteSoucoupes");
    infiniteSaucers.addEventListener("click", game.infiniteSaucers.bind(game));
    document.getElementById("infiniteSaucersButtonImg").src = _flyingSaucerPetit2.default;
}

var setup = function setup() {
    var theCanvas = document.getElementById("stars");
    var game = setupGame(theCanvas);

    setupButtons(game);

    game.animate();
};

window.addEventListener("DOMContentLoaded", setup);

/***/ }),
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Starship = __webpack_require__(4);

var _Starship2 = _interopRequireDefault(_Starship);

var _Saucer = __webpack_require__(6);

var _Saucer2 = _interopRequireDefault(_Saucer);

var _Shoot = __webpack_require__(7);

var _Shoot2 = _interopRequireDefault(_Shoot);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Game = function () {
    function Game(aCanvas) {
        _classCallCheck(this, Game);

        this.myCanvas = aCanvas;
        this.raf = undefined;
        this.context = this.myCanvas.getContext('2d');

        this.starship = new _Starship2.default(this.myCanvas, 40, this.myCanvas.height / 2);

        this.saucers = [];
        this.shoots = [];
        this.score = 0;

        this.firstDraw = true;

        this.scoreSpan = undefined;
    }

    _createClass(Game, [{
        key: 'addSaucer',
        value: function addSaucer() {
            var x = this.myCanvas.width;
            var y = Math.floor(Math.random() * this.myCanvas.height);

            this.saucers.push(new _Saucer2.default(this.myCanvas, x, y, this));
        }
    }, {
        key: 'infiniteSaucers',
        value: function infiniteSaucers() {
            // TODO
        }
    }, {
        key: 'removeSaucer',
        value: function removeSaucer(saucer) {
            this.saucers = this.saucers.filter(function (e) {
                return e !== saucer;
            });
            this.updateScoreOnLostSaucer();
        }
    }, {
        key: 'addShoot',
        value: function addShoot() {
            var x = this.starship.x;
            var y = this.starship.y;

            this.shoots.push(new _Shoot2.default(this.myCanvas, x, y, this));
        }
    }, {
        key: 'removeShoot',
        value: function removeShoot(shoot) {
            this.shoots = this.shoots.filter(function (e) {
                return e !== shoot;
            });
        }
    }, {
        key: 'setScore',
        value: function setScore(updatedScore) {
            this.score = updatedScore;
        }
    }, {
        key: 'loseSaucer',
        value: function loseSaucer() {
            this.score -= 1000;
            this.updateScoreSpan();
        }
    }, {
        key: 'updateScoreOnSaucerShotDown',
        value: function updateScoreOnSaucerShotDown() {
            this.score += 200;
            this.updateScoreSpan();
        }
    }, {
        key: 'animate',
        value: function animate() {
            this.context.clearRect(0, 0, this.myCanvas.width, this.myCanvas.height);

            if (this.firstDraw || this.starship.isMoving()) {
                this.starship.move(this);
                this.firstDraw = false;
            }
            this.starship.draw();

            var _iteratorNormalCompletion = true;
            var _didIteratorError = false;
            var _iteratorError = undefined;

            try {
                for (var _iterator = this.saucers[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
                    var singleSaucer = _step.value;

                    singleSaucer.move();
                    singleSaucer.draw();
                }
            } catch (err) {
                _didIteratorError = true;
                _iteratorError = err;
            } finally {
                try {
                    if (!_iteratorNormalCompletion && _iterator.return) {
                        _iterator.return();
                    }
                } finally {
                    if (_didIteratorError) {
                        throw _iteratorError;
                    }
                }
            }

            var _iteratorNormalCompletion2 = true;
            var _didIteratorError2 = false;
            var _iteratorError2 = undefined;

            try {
                for (var _iterator2 = this.shoots[Symbol.iterator](), _step2; !(_iteratorNormalCompletion2 = (_step2 = _iterator2.next()).done); _iteratorNormalCompletion2 = true) {
                    var singleShoot = _step2.value;

                    singleShoot.move();
                    singleShoot.draw();
                }
            } catch (err) {
                _didIteratorError2 = true;
                _iteratorError2 = err;
            } finally {
                try {
                    if (!_iteratorNormalCompletion2 && _iterator2.return) {
                        _iterator2.return();
                    }
                } finally {
                    if (_didIteratorError2) {
                        throw _iteratorError2;
                    }
                }
            }

            this.raf = window.requestAnimationFrame(this.animate.bind(this));
        }
    }, {
        key: 'keyDownActionHandler',
        value: function keyDownActionHandler(event) {
            if (event.keyCode === 32) {
                this.addShoot();
                console.log("shoot");
            }

            switch (event.key) {
                case "ArrowUp":
                case "Up":
                    this.starship.moveUp();
                    break;
                case "ArrowDown":
                case "Down":
                    this.starship.moveDown();
                    break;
                default:
                    return;
            }

            event.preventDefault();
        }
    }, {
        key: 'keyUpActionHandler',
        value: function keyUpActionHandler(event) {

            switch (event.key) {
                case "ArrowUp":
                case "Up":
                case "ArrowDown":
                case "Down":
                    this.starship.stopMove();
                    break;
                default:
                    return;
            }
            event.preventDefault();
        }
    }, {
        key: 'setHTMLScore',
        value: function setHTMLScore(scoreSpan) {
            this.scoreSpan = scoreSpan;
        }
    }, {
        key: 'updateScoreSpan',
        value: function updateScoreSpan() {
            this.scoreSpan.innerHTML = this.score;
        }
    }]);

    return Game;
}();

exports.default = Game;

/***/ }),
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

var _Mobile2 = __webpack_require__(0);

var _Mobile3 = _interopRequireDefault(_Mobile2);

var _vaisseauBallonPetit = __webpack_require__(5);

var _vaisseauBallonPetit2 = _interopRequireDefault(_vaisseauBallonPetit);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var MoveState = { UP: 0, DOWN: 1, NONE: 2 };

var Starship = function (_Mobile) {
    _inherits(Starship, _Mobile);

    function Starship(aCanvas, initX, initY) {
        _classCallCheck(this, Starship);

        var _this = _possibleConstructorReturn(this, (Starship.__proto__ || Object.getPrototypeOf(Starship)).call(this, aCanvas, _vaisseauBallonPetit2.default, initX, initY, 0, 8));

        _this.moving = MoveState.NONE;

        _this.ogVY = _this.vy;
        _this.ogVX = _this.vx;
        return _this;
    }

    _createClass(Starship, [{
        key: 'moveUp',
        value: function moveUp() {
            this.moving = MoveState.UP;
        }
    }, {
        key: 'moveDown',
        value: function moveDown() {
            this.moving = MoveState.DOWN;
        }
    }, {
        key: 'move',
        value: function move() {
            var calcY = void 0;
            if (this.moving === MoveState.DOWN) {
                this.vy = this.ogVY;
            } else if (this.moving === MoveState.UP) {
                this.vy = -this.ogVY;
            }

            calcY = this.y + this.vy;
            if (this.validMove(1, calcY)) {
                _get(Starship.prototype.__proto__ || Object.getPrototypeOf(Starship.prototype), 'move', this).call(this);
            }
        }
    }, {
        key: 'stopMove',
        value: function stopMove() {
            this.moving = MoveState.NONE;
        }
    }, {
        key: 'validMove',
        value: function validMove(calcX, calcY) {
            return calcX > 0 && calcY > 0 && calcX < this.myCanvas.width - 40 && calcY < this.myCanvas.height - 40;
        }
    }, {
        key: 'isMoving',
        value: function isMoving() {
            return this.moving === MoveState.UP || this.moving === MoveState.DOWN;
        }
    }, {
        key: 'up',
        get: function get() {
            return this.moving === MoveState.UP;
        }
    }, {
        key: 'down',
        get: function get() {
            return this.moving === MoveState.DOWN;
        }
    }]);

    return Starship;
}(_Mobile3.default);

exports.default = Starship;

/***/ }),
/* 5 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "images/imge1bf45cee89f1ffc97d7cab6c41bd7c8.png";

/***/ }),
/* 6 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

var _Mobile2 = __webpack_require__(0);

var _Mobile3 = _interopRequireDefault(_Mobile2);

var _flyingSaucerPetit = __webpack_require__(1);

var _flyingSaucerPetit2 = _interopRequireDefault(_flyingSaucerPetit);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Saucer = function (_Mobile) {
    _inherits(Saucer, _Mobile);

    function Saucer(aCanvas, x, y, game) {
        _classCallCheck(this, Saucer);

        var _this = _possibleConstructorReturn(this, (Saucer.__proto__ || Object.getPrototypeOf(Saucer)).call(this, aCanvas, _flyingSaucerPetit2.default, x, y, -3, 0));

        _this.game = game;
        return _this;
    }

    _createClass(Saucer, [{
        key: 'move',
        value: function move() {
            _get(Saucer.prototype.__proto__ || Object.getPrototypeOf(Saucer.prototype), 'move', this).call(this);

            if (this.x <= 0) {
                this.game.removeSaucer(this);
            }
        }
    }]);

    return Saucer;
}(_Mobile3.default);

exports.default = Saucer;

/***/ }),
/* 7 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

var _Mobile2 = __webpack_require__(0);

var _Mobile3 = _interopRequireDefault(_Mobile2);

var _shoot = __webpack_require__(8);

var _shoot2 = _interopRequireDefault(_shoot);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Shoot = function (_Mobile) {
    _inherits(Shoot, _Mobile);

    function Shoot(aCanvas, x, y, game) {
        _classCallCheck(this, Shoot);

        var _this = _possibleConstructorReturn(this, (Shoot.__proto__ || Object.getPrototypeOf(Shoot)).call(this, aCanvas, _shoot2.default, x, y, 8, 0));

        _this.game = game;
        return _this;
    }

    _createClass(Shoot, [{
        key: 'move',
        value: function move() {
            _get(Shoot.prototype.__proto__ || Object.getPrototypeOf(Shoot.prototype), 'move', this).call(this);

            if (this.x >= this.myCanvas.width) {
                this.game.removeShoot(this);
            }
        }
    }]);

    return Shoot;
}(_Mobile3.default);

exports.default = Shoot;

/***/ }),
/* 8 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "images/imgc8f996cf083f4ebf7a6e363f50eab606.png";

/***/ }),
/* 9 */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(10);
if(typeof content === 'string') content = [[module.i, content, '']];
// Prepare cssTransformation
var transform;

var options = {"hmr":true}
options.transform = transform
// add the styles to the DOM
var update = __webpack_require__(14)(content, options);
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {
	// When the styles change, update the <style> tags
	if(!content.locals) {
		module.hot.accept("!!../../node_modules/css-loader/index.js!./style.css", function() {
			var newContent = require("!!../../node_modules/css-loader/index.js!./style.css");
			if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
			update(newContent);
		});
	}
	// When the module is disposed, remove the <style> tags
	module.hot.dispose(function() { update(); });
}

/***/ }),
/* 10 */
/***/ (function(module, exports, __webpack_require__) {

var escape = __webpack_require__(11);
exports = module.exports = __webpack_require__(12)(false);
// imports


// module
exports.push([module.i, "html {\n  background-color : rgba(0,0,0,0.5);\n}\n#stars {    \n    display : block;\n    margin : auto;\n    background-image: url(" + escape(__webpack_require__(13)) + ");\n    background-repeat: repeat-x;\n    background-size: cover;\n    background-position : 0px 0px;\n    border : 2px solid white;\n    \n}\n\n  #stars {\n    animation-duration: 30s;\n    animation-name: starsSlide;\n    animation-iteration-count: infinite;\n    animation-timing-function: linear;\n  }\n \n\n@keyframes starsSlide {\n    from {\n      background-position : 1200px 0px;\n    }\n    \n    to {\n     background-position : 0px 0px;     \n    }\n  }\n\n\n\ndiv#control {\n  text-align : center;\n  margin : 10px;\n}\n\nbutton {\n  font-size : 40px; \n}\n\nspan#score{\n  display : inline-block;\n  width : 100px;\n  font-size : 30px;\n  text-align : right;\n  background-color : white;\n  padding : 4px;\n  margin : 4px;\n}", ""]);

// exports


/***/ }),
/* 11 */
/***/ (function(module, exports) {

module.exports = function escape(url) {
    if (typeof url !== 'string') {
        return url
    }
    // If url is already wrapped in quotes, remove them
    if (/^['"].*['"]$/.test(url)) {
        url = url.slice(1, -1);
    }
    // Should url be wrapped?
    // See https://drafts.csswg.org/css-values-3/#urls
    if (/["'() \t\n]/.test(url)) {
        return '"' + url.replace(/"/g, '\\"').replace(/\n/g, '\\n') + '"'
    }

    return url
}


/***/ }),
/* 12 */
/***/ (function(module, exports) {

/*
	MIT License http://www.opensource.org/licenses/mit-license.php
	Author Tobias Koppers @sokra
*/
// css base code, injected by the css-loader
module.exports = function(useSourceMap) {
	var list = [];

	// return the list of modules as css string
	list.toString = function toString() {
		return this.map(function (item) {
			var content = cssWithMappingToString(item, useSourceMap);
			if(item[2]) {
				return "@media " + item[2] + "{" + content + "}";
			} else {
				return content;
			}
		}).join("");
	};

	// import a list of modules into the list
	list.i = function(modules, mediaQuery) {
		if(typeof modules === "string")
			modules = [[null, modules, ""]];
		var alreadyImportedModules = {};
		for(var i = 0; i < this.length; i++) {
			var id = this[i][0];
			if(typeof id === "number")
				alreadyImportedModules[id] = true;
		}
		for(i = 0; i < modules.length; i++) {
			var item = modules[i];
			// skip already imported module
			// this implementation is not 100% perfect for weird media query combinations
			//  when a module is imported multiple times with different media queries.
			//  I hope this will never occur (Hey this way we have smaller bundles)
			if(typeof item[0] !== "number" || !alreadyImportedModules[item[0]]) {
				if(mediaQuery && !item[2]) {
					item[2] = mediaQuery;
				} else if(mediaQuery) {
					item[2] = "(" + item[2] + ") and (" + mediaQuery + ")";
				}
				list.push(item);
			}
		}
	};
	return list;
};

function cssWithMappingToString(item, useSourceMap) {
	var content = item[1] || '';
	var cssMapping = item[3];
	if (!cssMapping) {
		return content;
	}

	if (useSourceMap && typeof btoa === 'function') {
		var sourceMapping = toComment(cssMapping);
		var sourceURLs = cssMapping.sources.map(function (source) {
			return '/*# sourceURL=' + cssMapping.sourceRoot + source + ' */'
		});

		return [content].concat(sourceURLs).concat([sourceMapping]).join('\n');
	}

	return [content].join('\n');
}

// Adapted from convert-source-map (MIT)
function toComment(sourceMap) {
	// eslint-disable-next-line no-undef
	var base64 = btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap))));
	var data = 'sourceMappingURL=data:application/json;charset=utf-8;base64,' + base64;

	return '/*# ' + data + ' */';
}


/***/ }),
/* 13 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "images/imge29a20418ee63aceb1bc73d172b7367e.png";

/***/ }),
/* 14 */
/***/ (function(module, exports, __webpack_require__) {

/*
	MIT License http://www.opensource.org/licenses/mit-license.php
	Author Tobias Koppers @sokra
*/

var stylesInDom = {};

var	memoize = function (fn) {
	var memo;

	return function () {
		if (typeof memo === "undefined") memo = fn.apply(this, arguments);
		return memo;
	};
};

var isOldIE = memoize(function () {
	// Test for IE <= 9 as proposed by Browserhacks
	// @see http://browserhacks.com/#hack-e71d8692f65334173fee715c222cb805
	// Tests for existence of standard globals is to allow style-loader
	// to operate correctly into non-standard environments
	// @see https://github.com/webpack-contrib/style-loader/issues/177
	return window && document && document.all && !window.atob;
});

var getElement = (function (fn) {
	var memo = {};

	return function(selector) {
		if (typeof memo[selector] === "undefined") {
			var styleTarget = fn.call(this, selector);
			// Special case to return head of iframe instead of iframe itself
			if (styleTarget instanceof window.HTMLIFrameElement) {
				try {
					// This will throw an exception if access to iframe is blocked
					// due to cross-origin restrictions
					styleTarget = styleTarget.contentDocument.head;
				} catch(e) {
					styleTarget = null;
				}
			}
			memo[selector] = styleTarget;
		}
		return memo[selector]
	};
})(function (target) {
	return document.querySelector(target)
});

var singleton = null;
var	singletonCounter = 0;
var	stylesInsertedAtTop = [];

var	fixUrls = __webpack_require__(15);

module.exports = function(list, options) {
	if (typeof DEBUG !== "undefined" && DEBUG) {
		if (typeof document !== "object") throw new Error("The style-loader cannot be used in a non-browser environment");
	}

	options = options || {};

	options.attrs = typeof options.attrs === "object" ? options.attrs : {};

	// Force single-tag solution on IE6-9, which has a hard limit on the # of <style>
	// tags it will allow on a page
	if (!options.singleton && typeof options.singleton !== "boolean") options.singleton = isOldIE();

	// By default, add <style> tags to the <head> element
	if (!options.insertInto) options.insertInto = "head";

	// By default, add <style> tags to the bottom of the target
	if (!options.insertAt) options.insertAt = "bottom";

	var styles = listToStyles(list, options);

	addStylesToDom(styles, options);

	return function update (newList) {
		var mayRemove = [];

		for (var i = 0; i < styles.length; i++) {
			var item = styles[i];
			var domStyle = stylesInDom[item.id];

			domStyle.refs--;
			mayRemove.push(domStyle);
		}

		if(newList) {
			var newStyles = listToStyles(newList, options);
			addStylesToDom(newStyles, options);
		}

		for (var i = 0; i < mayRemove.length; i++) {
			var domStyle = mayRemove[i];

			if(domStyle.refs === 0) {
				for (var j = 0; j < domStyle.parts.length; j++) domStyle.parts[j]();

				delete stylesInDom[domStyle.id];
			}
		}
	};
};

function addStylesToDom (styles, options) {
	for (var i = 0; i < styles.length; i++) {
		var item = styles[i];
		var domStyle = stylesInDom[item.id];

		if(domStyle) {
			domStyle.refs++;

			for(var j = 0; j < domStyle.parts.length; j++) {
				domStyle.parts[j](item.parts[j]);
			}

			for(; j < item.parts.length; j++) {
				domStyle.parts.push(addStyle(item.parts[j], options));
			}
		} else {
			var parts = [];

			for(var j = 0; j < item.parts.length; j++) {
				parts.push(addStyle(item.parts[j], options));
			}

			stylesInDom[item.id] = {id: item.id, refs: 1, parts: parts};
		}
	}
}

function listToStyles (list, options) {
	var styles = [];
	var newStyles = {};

	for (var i = 0; i < list.length; i++) {
		var item = list[i];
		var id = options.base ? item[0] + options.base : item[0];
		var css = item[1];
		var media = item[2];
		var sourceMap = item[3];
		var part = {css: css, media: media, sourceMap: sourceMap};

		if(!newStyles[id]) styles.push(newStyles[id] = {id: id, parts: [part]});
		else newStyles[id].parts.push(part);
	}

	return styles;
}

function insertStyleElement (options, style) {
	var target = getElement(options.insertInto)

	if (!target) {
		throw new Error("Couldn't find a style target. This probably means that the value for the 'insertInto' parameter is invalid.");
	}

	var lastStyleElementInsertedAtTop = stylesInsertedAtTop[stylesInsertedAtTop.length - 1];

	if (options.insertAt === "top") {
		if (!lastStyleElementInsertedAtTop) {
			target.insertBefore(style, target.firstChild);
		} else if (lastStyleElementInsertedAtTop.nextSibling) {
			target.insertBefore(style, lastStyleElementInsertedAtTop.nextSibling);
		} else {
			target.appendChild(style);
		}
		stylesInsertedAtTop.push(style);
	} else if (options.insertAt === "bottom") {
		target.appendChild(style);
	} else if (typeof options.insertAt === "object" && options.insertAt.before) {
		var nextSibling = getElement(options.insertInto + " " + options.insertAt.before);
		target.insertBefore(style, nextSibling);
	} else {
		throw new Error("[Style Loader]\n\n Invalid value for parameter 'insertAt' ('options.insertAt') found.\n Must be 'top', 'bottom', or Object.\n (https://github.com/webpack-contrib/style-loader#insertat)\n");
	}
}

function removeStyleElement (style) {
	if (style.parentNode === null) return false;
	style.parentNode.removeChild(style);

	var idx = stylesInsertedAtTop.indexOf(style);
	if(idx >= 0) {
		stylesInsertedAtTop.splice(idx, 1);
	}
}

function createStyleElement (options) {
	var style = document.createElement("style");

	options.attrs.type = "text/css";

	addAttrs(style, options.attrs);
	insertStyleElement(options, style);

	return style;
}

function createLinkElement (options) {
	var link = document.createElement("link");

	options.attrs.type = "text/css";
	options.attrs.rel = "stylesheet";

	addAttrs(link, options.attrs);
	insertStyleElement(options, link);

	return link;
}

function addAttrs (el, attrs) {
	Object.keys(attrs).forEach(function (key) {
		el.setAttribute(key, attrs[key]);
	});
}

function addStyle (obj, options) {
	var style, update, remove, result;

	// If a transform function was defined, run it on the css
	if (options.transform && obj.css) {
	    result = options.transform(obj.css);

	    if (result) {
	    	// If transform returns a value, use that instead of the original css.
	    	// This allows running runtime transformations on the css.
	    	obj.css = result;
	    } else {
	    	// If the transform function returns a falsy value, don't add this css.
	    	// This allows conditional loading of css
	    	return function() {
	    		// noop
	    	};
	    }
	}

	if (options.singleton) {
		var styleIndex = singletonCounter++;

		style = singleton || (singleton = createStyleElement(options));

		update = applyToSingletonTag.bind(null, style, styleIndex, false);
		remove = applyToSingletonTag.bind(null, style, styleIndex, true);

	} else if (
		obj.sourceMap &&
		typeof URL === "function" &&
		typeof URL.createObjectURL === "function" &&
		typeof URL.revokeObjectURL === "function" &&
		typeof Blob === "function" &&
		typeof btoa === "function"
	) {
		style = createLinkElement(options);
		update = updateLink.bind(null, style, options);
		remove = function () {
			removeStyleElement(style);

			if(style.href) URL.revokeObjectURL(style.href);
		};
	} else {
		style = createStyleElement(options);
		update = applyToTag.bind(null, style);
		remove = function () {
			removeStyleElement(style);
		};
	}

	update(obj);

	return function updateStyle (newObj) {
		if (newObj) {
			if (
				newObj.css === obj.css &&
				newObj.media === obj.media &&
				newObj.sourceMap === obj.sourceMap
			) {
				return;
			}

			update(obj = newObj);
		} else {
			remove();
		}
	};
}

var replaceText = (function () {
	var textStore = [];

	return function (index, replacement) {
		textStore[index] = replacement;

		return textStore.filter(Boolean).join('\n');
	};
})();

function applyToSingletonTag (style, index, remove, obj) {
	var css = remove ? "" : obj.css;

	if (style.styleSheet) {
		style.styleSheet.cssText = replaceText(index, css);
	} else {
		var cssNode = document.createTextNode(css);
		var childNodes = style.childNodes;

		if (childNodes[index]) style.removeChild(childNodes[index]);

		if (childNodes.length) {
			style.insertBefore(cssNode, childNodes[index]);
		} else {
			style.appendChild(cssNode);
		}
	}
}

function applyToTag (style, obj) {
	var css = obj.css;
	var media = obj.media;

	if(media) {
		style.setAttribute("media", media)
	}

	if(style.styleSheet) {
		style.styleSheet.cssText = css;
	} else {
		while(style.firstChild) {
			style.removeChild(style.firstChild);
		}

		style.appendChild(document.createTextNode(css));
	}
}

function updateLink (link, options, obj) {
	var css = obj.css;
	var sourceMap = obj.sourceMap;

	/*
		If convertToAbsoluteUrls isn't defined, but sourcemaps are enabled
		and there is no publicPath defined then lets turn convertToAbsoluteUrls
		on by default.  Otherwise default to the convertToAbsoluteUrls option
		directly
	*/
	var autoFixUrls = options.convertToAbsoluteUrls === undefined && sourceMap;

	if (options.convertToAbsoluteUrls || autoFixUrls) {
		css = fixUrls(css);
	}

	if (sourceMap) {
		// http://stackoverflow.com/a/26603875
		css += "\n/*# sourceMappingURL=data:application/json;base64," + btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap)))) + " */";
	}

	var blob = new Blob([css], { type: "text/css" });

	var oldSrc = link.href;

	link.href = URL.createObjectURL(blob);

	if(oldSrc) URL.revokeObjectURL(oldSrc);
}


/***/ }),
/* 15 */
/***/ (function(module, exports) {


/**
 * When source maps are enabled, `style-loader` uses a link element with a data-uri to
 * embed the css on the page. This breaks all relative urls because now they are relative to a
 * bundle instead of the current page.
 *
 * One solution is to only use full urls, but that may be impossible.
 *
 * Instead, this function "fixes" the relative urls to be absolute according to the current page location.
 *
 * A rudimentary test suite is located at `test/fixUrls.js` and can be run via the `npm test` command.
 *
 */

module.exports = function (css) {
  // get current location
  var location = typeof window !== "undefined" && window.location;

  if (!location) {
    throw new Error("fixUrls requires window.location");
  }

	// blank or null?
	if (!css || typeof css !== "string") {
	  return css;
  }

  var baseUrl = location.protocol + "//" + location.host;
  var currentDir = baseUrl + location.pathname.replace(/\/[^\/]*$/, "/");

	// convert each url(...)
	/*
	This regular expression is just a way to recursively match brackets within
	a string.

	 /url\s*\(  = Match on the word "url" with any whitespace after it and then a parens
	   (  = Start a capturing group
	     (?:  = Start a non-capturing group
	         [^)(]  = Match anything that isn't a parentheses
	         |  = OR
	         \(  = Match a start parentheses
	             (?:  = Start another non-capturing groups
	                 [^)(]+  = Match anything that isn't a parentheses
	                 |  = OR
	                 \(  = Match a start parentheses
	                     [^)(]*  = Match anything that isn't a parentheses
	                 \)  = Match a end parentheses
	             )  = End Group
              *\) = Match anything and then a close parens
          )  = Close non-capturing group
          *  = Match anything
       )  = Close capturing group
	 \)  = Match a close parens

	 /gi  = Get all matches, not the first.  Be case insensitive.
	 */
	var fixedCss = css.replace(/url\s*\(((?:[^)(]|\((?:[^)(]+|\([^)(]*\))*\))*)\)/gi, function(fullMatch, origUrl) {
		// strip quotes (if they exist)
		var unquotedOrigUrl = origUrl
			.trim()
			.replace(/^"(.*)"$/, function(o, $1){ return $1; })
			.replace(/^'(.*)'$/, function(o, $1){ return $1; });

		// already a full url? no change
		if (/^(#|data:|http:\/\/|https:\/\/|file:\/\/\/)/i.test(unquotedOrigUrl)) {
		  return fullMatch;
		}

		// convert the url to a full url
		var newUrl;

		if (unquotedOrigUrl.indexOf("//") === 0) {
		  	//TODO: should we add protocol?
			newUrl = unquotedOrigUrl;
		} else if (unquotedOrigUrl.indexOf("/") === 0) {
			// path should be relative to the base url
			newUrl = baseUrl + unquotedOrigUrl; // already starts with '/'
		} else {
			// path should be relative to current directory
			newUrl = currentDir + unquotedOrigUrl.replace(/^\.\//, ""); // Strip leading './'
		}

		// send back the fixed url(...)
		return "url(" + JSON.stringify(newUrl) + ")";
	});

	// send back the fixed css
	return fixedCss;
};


/***/ })
/******/ ]);
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8vd2VicGFjay9ib290c3RyYXAgZmNkZDI0NTdmNjQwMDUwOGIzYTAiLCJ3ZWJwYWNrOi8vLy4vc3JjL3NjcmlwdHMvTW9iaWxlLmpzIiwid2VicGFjazovLy8uL3NyYy9pbWFnZXMvZmx5aW5nU2F1Y2VyLXBldGl0LnBuZyIsIndlYnBhY2s6Ly8vLi9zcmMvc2NyaXB0cy9tYWluLmpzIiwid2VicGFjazovLy8uL3NyYy9zY3JpcHRzL0dhbWUuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL3NjcmlwdHMvU3RhcnNoaXAuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL2ltYWdlcy92YWlzc2VhdS1iYWxsb24tcGV0aXQucG5nIiwid2VicGFjazovLy8uL3NyYy9zY3JpcHRzL1NhdWNlci5qcyIsIndlYnBhY2s6Ly8vLi9zcmMvc2NyaXB0cy9TaG9vdC5qcyIsIndlYnBhY2s6Ly8vLi9zcmMvaW1hZ2VzL3Nob290LnBuZyIsIndlYnBhY2s6Ly8vLi9zcmMvc3R5bGUvc3R5bGUuY3NzPzc4OTAiLCJ3ZWJwYWNrOi8vLy4vc3JjL3N0eWxlL3N0eWxlLmNzcyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qcyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvY3NzLWJhc2UuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL2ltYWdlcy9jaWVsLW5vY3R1cm5lLnBuZyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvc3R5bGUtbG9hZGVyL2xpYi9hZGRTdHlsZXMuanMiLCJ3ZWJwYWNrOi8vLy4vbm9kZV9tb2R1bGVzL3N0eWxlLWxvYWRlci9saWIvdXJscy5qcyJdLCJuYW1lcyI6WyJNb2JpbGUiLCJhQ2FudmFzIiwic3JjSW1hZ2UiLCJ4IiwieSIsInZ4IiwidnkiLCJteUNhbnZhcyIsImNvbnRleHQiLCJnZXRDb250ZXh0IiwiaW1nTW9iaWxlIiwiSW1hZ2UiLCJpbWdMb2FkZWQiLCJhZGRFdmVudExpc3RlbmVyIiwiaW1nTG9hZExpc3RlbmVyIiwiYmluZCIsInNyYyIsImRyYXdJbWFnZSIsInNldHVwR2FtZSIsInRoZUNhbnZhcyIsImdhbWUiLCJjb25zdHJ1Y3RvciIsInVuZGVmaW5lZCIsIk9iamVjdCIsImdldFByb3RvdHlwZU9mIiwid2luZG93Iiwia2V5RG93bkFjdGlvbkhhbmRsZXIiLCJrZXlVcEFjdGlvbkhhbmRsZXIiLCJzY29yZVNwYW4iLCJkb2N1bWVudCIsImdldEVsZW1lbnRCeUlkIiwic2V0SFRNTFNjb3JlIiwic2V0dXBCdXR0b25zIiwibmV3U2F1Y2VyQnV0dG9uIiwiYWRkU2F1Y2VyIiwiaW5maW5pdGVTYXVjZXJzIiwic2V0dXAiLCJhbmltYXRlIiwiR2FtZSIsInJhZiIsInN0YXJzaGlwIiwiaGVpZ2h0Iiwic2F1Y2VycyIsInNob290cyIsInNjb3JlIiwiZmlyc3REcmF3Iiwid2lkdGgiLCJNYXRoIiwiZmxvb3IiLCJyYW5kb20iLCJwdXNoIiwic2F1Y2VyIiwiZmlsdGVyIiwiZSIsInVwZGF0ZVNjb3JlT25Mb3N0U2F1Y2VyIiwic2hvb3QiLCJ1cGRhdGVkU2NvcmUiLCJ1cGRhdGVTY29yZVNwYW4iLCJjbGVhclJlY3QiLCJpc01vdmluZyIsIm1vdmUiLCJkcmF3Iiwic2luZ2xlU2F1Y2VyIiwic2luZ2xlU2hvb3QiLCJyZXF1ZXN0QW5pbWF0aW9uRnJhbWUiLCJldmVudCIsImtleUNvZGUiLCJhZGRTaG9vdCIsImNvbnNvbGUiLCJsb2ciLCJrZXkiLCJtb3ZlVXAiLCJtb3ZlRG93biIsInByZXZlbnREZWZhdWx0Iiwic3RvcE1vdmUiLCJpbm5lckhUTUwiLCJNb3ZlU3RhdGUiLCJVUCIsIkRPV04iLCJOT05FIiwiU3RhcnNoaXAiLCJpbml0WCIsImluaXRZIiwibW92aW5nIiwib2dWWSIsIm9nVlgiLCJjYWxjWSIsInZhbGlkTW92ZSIsImNhbGNYIiwiU2F1Y2VyIiwicmVtb3ZlU2F1Y2VyIiwiU2hvb3QiLCJyZW1vdmVTaG9vdCJdLCJtYXBwaW5ncyI6IjtBQUFBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOzs7QUFHQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQSxhQUFLO0FBQ0w7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQSxtQ0FBMkIsMEJBQTBCLEVBQUU7QUFDdkQseUNBQWlDLGVBQWU7QUFDaEQ7QUFDQTtBQUNBOztBQUVBO0FBQ0EsOERBQXNELCtEQUErRDs7QUFFckg7QUFDQTs7QUFFQTtBQUNBOzs7Ozs7Ozs7Ozs7Ozs7Ozs7SUM3RHFCQSxNO0FBQ2pCLG9CQUFZQyxPQUFaLEVBQXFCQyxRQUFyQixFQUErQkMsQ0FBL0IsRUFBa0NDLENBQWxDLEVBQXFDQyxFQUFyQyxFQUF5Q0MsRUFBekMsRUFBNkM7QUFBQTs7QUFDekMsYUFBS0MsUUFBTCxHQUFnQk4sT0FBaEI7QUFDQSxhQUFLTyxPQUFMLEdBQWUsS0FBS0QsUUFBTCxDQUFjRSxVQUFkLENBQXlCLElBQXpCLENBQWY7O0FBRUEsYUFBS0MsU0FBTCxHQUFpQixJQUFJQyxLQUFKLEVBQWpCO0FBQ0EsYUFBS0MsU0FBTCxHQUFpQixLQUFqQjtBQUNBLGFBQUtGLFNBQUwsQ0FBZUcsZ0JBQWYsQ0FBZ0MsTUFBaEMsRUFBd0MsS0FBS0MsZUFBTCxDQUFxQkMsSUFBckIsQ0FBMEIsSUFBMUIsQ0FBeEM7QUFDQSxhQUFLTCxTQUFMLENBQWVNLEdBQWYsR0FBcUJkLFFBQXJCOztBQUVBLGFBQUtDLENBQUwsR0FBU0EsQ0FBVDtBQUNBLGFBQUtDLENBQUwsR0FBU0EsQ0FBVDtBQUNBLGFBQUtDLEVBQUwsR0FBVUEsRUFBVjtBQUNBLGFBQUtDLEVBQUwsR0FBVUEsRUFBVjtBQUNIOzs7OytCQUVNO0FBQ0gsZ0JBQUksS0FBS00sU0FBTCxLQUFtQixJQUF2QixFQUE2QjtBQUN6QixxQkFBS0osT0FBTCxDQUFhUyxTQUFiLENBQXVCLEtBQUtQLFNBQTVCLEVBQXVDLEtBQUtQLENBQTVDLEVBQStDLEtBQUtDLENBQXBEO0FBQ0g7QUFDSjs7OytCQUVNO0FBQ0gsaUJBQUtELENBQUwsSUFBVSxLQUFLRSxFQUFmO0FBQ0EsaUJBQUtELENBQUwsSUFBVSxLQUFLRSxFQUFmO0FBQ0g7OzswQ0FFaUI7QUFDZCxpQkFBS00sU0FBTCxHQUFpQixJQUFqQjtBQUNIOzs7Ozs7a0JBN0JnQlosTTs7Ozs7O0FDQXJCLDBGOzs7Ozs7Ozs7QUNBQTs7OztBQUVBOztBQUNBOzs7Ozs7QUFHQSxTQUFTa0IsU0FBVCxDQUFtQkMsU0FBbkIsRUFBOEI7QUFDMUIsUUFBSUMsT0FBTyxtQkFBU0QsU0FBVCxDQUFYO0FBQ0FDLFNBQUtDLFdBQUwsR0FBbUJDLFNBQW5CO0FBQ0FDLFdBQU9DLGNBQVAsQ0FBc0JKLElBQXRCLEVBQTRCQyxXQUE1QixHQUEwQ0MsU0FBMUM7O0FBRUFHLFdBQU9aLGdCQUFQLENBQXdCLFNBQXhCLEVBQW1DTyxLQUFLTSxvQkFBTCxDQUEwQlgsSUFBMUIsQ0FBK0JLLElBQS9CLENBQW5DO0FBQ0FLLFdBQU9aLGdCQUFQLENBQXdCLE9BQXhCLEVBQWlDTyxLQUFLTyxrQkFBTCxDQUF3QlosSUFBeEIsQ0FBNkJLLElBQTdCLENBQWpDOztBQUVBLFFBQUlRLFlBQVlDLFNBQVNDLGNBQVQsQ0FBd0IsT0FBeEIsQ0FBaEI7QUFDQVYsU0FBS1csWUFBTCxDQUFrQkgsU0FBbEI7O0FBRUEsV0FBT1IsSUFBUDtBQUNIOztBQUVELFNBQVNZLFlBQVQsQ0FBc0JaLElBQXRCLEVBQTRCO0FBQ3hCLFFBQUlhLGtCQUFrQkosU0FBU0MsY0FBVCxDQUF3QixrQkFBeEIsQ0FBdEI7QUFDQUcsb0JBQWdCcEIsZ0JBQWhCLENBQWlDLE9BQWpDLEVBQTBDTyxLQUFLYyxTQUFMLENBQWVuQixJQUFmLENBQW9CSyxJQUFwQixDQUExQztBQUNBUyxhQUFTQyxjQUFULENBQXdCLG9CQUF4QixFQUE4Q2QsR0FBOUM7O0FBRUEsUUFBSW1CLGtCQUFrQk4sU0FBU0MsY0FBVCxDQUF3QixpQkFBeEIsQ0FBdEI7QUFDQUssb0JBQWdCdEIsZ0JBQWhCLENBQWlDLE9BQWpDLEVBQTBDTyxLQUFLZSxlQUFMLENBQXFCcEIsSUFBckIsQ0FBMEJLLElBQTFCLENBQTFDO0FBQ0FTLGFBQVNDLGNBQVQsQ0FBd0IsMEJBQXhCLEVBQW9EZCxHQUFwRDtBQUNIOztBQUVELElBQUlvQixRQUFRLFNBQVJBLEtBQVEsR0FBWTtBQUNwQixRQUFJakIsWUFBWVUsU0FBU0MsY0FBVCxDQUF3QixPQUF4QixDQUFoQjtBQUNBLFFBQUlWLE9BQU9GLFVBQVVDLFNBQVYsQ0FBWDs7QUFFQWEsaUJBQWFaLElBQWI7O0FBRUFBLFNBQUtpQixPQUFMO0FBRUgsQ0FSRDs7QUFVQVosT0FBT1osZ0JBQVAsQ0FBd0Isa0JBQXhCLEVBQTRDdUIsS0FBNUMsRTs7Ozs7Ozs7Ozs7Ozs7O0FDeENBOzs7O0FBQ0E7Ozs7QUFDQTs7Ozs7Ozs7SUFHcUJFLEk7QUFDakIsa0JBQVlyQyxPQUFaLEVBQXFCO0FBQUE7O0FBQ2pCLGFBQUtNLFFBQUwsR0FBZ0JOLE9BQWhCO0FBQ0EsYUFBS3NDLEdBQUwsR0FBV2pCLFNBQVg7QUFDQSxhQUFLZCxPQUFMLEdBQWUsS0FBS0QsUUFBTCxDQUFjRSxVQUFkLENBQXlCLElBQXpCLENBQWY7O0FBRUEsYUFBSytCLFFBQUwsR0FBZ0IsdUJBQWEsS0FBS2pDLFFBQWxCLEVBQTRCLEVBQTVCLEVBQWdDLEtBQUtBLFFBQUwsQ0FBY2tDLE1BQWQsR0FBdUIsQ0FBdkQsQ0FBaEI7O0FBRUEsYUFBS0MsT0FBTCxHQUFlLEVBQWY7QUFDQSxhQUFLQyxNQUFMLEdBQWMsRUFBZDtBQUNBLGFBQUtDLEtBQUwsR0FBYSxDQUFiOztBQUVBLGFBQUtDLFNBQUwsR0FBaUIsSUFBakI7O0FBRUEsYUFBS2pCLFNBQUwsR0FBaUJOLFNBQWpCO0FBQ0g7Ozs7b0NBR1c7QUFDUixnQkFBSW5CLElBQUksS0FBS0ksUUFBTCxDQUFjdUMsS0FBdEI7QUFDQSxnQkFBSTFDLElBQUkyQyxLQUFLQyxLQUFMLENBQVdELEtBQUtFLE1BQUwsS0FBZ0IsS0FBSzFDLFFBQUwsQ0FBY2tDLE1BQXpDLENBQVI7O0FBRUEsaUJBQUtDLE9BQUwsQ0FBYVEsSUFBYixDQUFrQixxQkFBVyxLQUFLM0MsUUFBaEIsRUFBMEJKLENBQTFCLEVBQTZCQyxDQUE3QixFQUFnQyxJQUFoQyxDQUFsQjtBQUNIOzs7MENBRWlCO0FBQ2Q7QUFDSDs7O3FDQUVZK0MsTSxFQUFRO0FBQ2pCLGlCQUFLVCxPQUFMLEdBQWUsS0FBS0EsT0FBTCxDQUFhVSxNQUFiLENBQW9CO0FBQUEsdUJBQUtDLE1BQU1GLE1BQVg7QUFBQSxhQUFwQixDQUFmO0FBQ0EsaUJBQUtHLHVCQUFMO0FBQ0g7OzttQ0FFVTtBQUNQLGdCQUFJbkQsSUFBSSxLQUFLcUMsUUFBTCxDQUFjckMsQ0FBdEI7QUFDQSxnQkFBSUMsSUFBSSxLQUFLb0MsUUFBTCxDQUFjcEMsQ0FBdEI7O0FBRUEsaUJBQUt1QyxNQUFMLENBQVlPLElBQVosQ0FBaUIsb0JBQVUsS0FBSzNDLFFBQWYsRUFBeUJKLENBQXpCLEVBQTRCQyxDQUE1QixFQUErQixJQUEvQixDQUFqQjtBQUNIOzs7b0NBRVdtRCxLLEVBQU87QUFDZixpQkFBS1osTUFBTCxHQUFjLEtBQUtBLE1BQUwsQ0FBWVMsTUFBWixDQUFtQjtBQUFBLHVCQUFLQyxNQUFNRSxLQUFYO0FBQUEsYUFBbkIsQ0FBZDtBQUNIOzs7aUNBRVFDLFksRUFBYztBQUNuQixpQkFBS1osS0FBTCxHQUFhWSxZQUFiO0FBQ0g7OztxQ0FFWTtBQUNULGlCQUFLWixLQUFMLElBQWMsSUFBZDtBQUNBLGlCQUFLYSxlQUFMO0FBQ0g7OztzREFFNkI7QUFDMUIsaUJBQUtiLEtBQUwsSUFBYyxHQUFkO0FBQ0EsaUJBQUthLGVBQUw7QUFDSDs7O2tDQUVTO0FBQ04saUJBQUtqRCxPQUFMLENBQWFrRCxTQUFiLENBQXVCLENBQXZCLEVBQTBCLENBQTFCLEVBQTZCLEtBQUtuRCxRQUFMLENBQWN1QyxLQUEzQyxFQUFrRCxLQUFLdkMsUUFBTCxDQUFja0MsTUFBaEU7O0FBRUEsZ0JBQUksS0FBS0ksU0FBTCxJQUFrQixLQUFLTCxRQUFMLENBQWNtQixRQUFkLEVBQXRCLEVBQWdEO0FBQzVDLHFCQUFLbkIsUUFBTCxDQUFjb0IsSUFBZCxDQUFtQixJQUFuQjtBQUNBLHFCQUFLZixTQUFMLEdBQWlCLEtBQWpCO0FBQ0g7QUFDRCxpQkFBS0wsUUFBTCxDQUFjcUIsSUFBZDs7QUFQTTtBQUFBO0FBQUE7O0FBQUE7QUFTTixxQ0FBeUIsS0FBS25CLE9BQTlCLDhIQUF1QztBQUFBLHdCQUE5Qm9CLFlBQThCOztBQUNuQ0EsaUNBQWFGLElBQWI7QUFDQUUsaUNBQWFELElBQWI7QUFDSDtBQVpLO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7O0FBQUE7QUFBQTtBQUFBOztBQUFBO0FBY04sc0NBQXVCLEtBQUtsQixNQUE1QixtSUFBbUM7QUFBQSx3QkFBM0JvQixXQUEyQjs7QUFDL0JBLGdDQUFZSCxJQUFaO0FBQ0FHLGdDQUFZRixJQUFaO0FBQ0g7QUFqQks7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTs7QUFtQk4saUJBQUt0QixHQUFMLEdBQVdkLE9BQU91QyxxQkFBUCxDQUE2QixLQUFLM0IsT0FBTCxDQUFhdEIsSUFBYixDQUFrQixJQUFsQixDQUE3QixDQUFYO0FBQ0g7Ozs2Q0FFb0JrRCxLLEVBQU87QUFDeEIsZ0JBQUdBLE1BQU1DLE9BQU4sS0FBa0IsRUFBckIsRUFBd0I7QUFDcEIscUJBQUtDLFFBQUw7QUFDQUMsd0JBQVFDLEdBQVIsQ0FBWSxPQUFaO0FBQ0g7O0FBRUQsb0JBQVFKLE1BQU1LLEdBQWQ7QUFDSSxxQkFBSyxTQUFMO0FBQ0EscUJBQUssSUFBTDtBQUNJLHlCQUFLOUIsUUFBTCxDQUFjK0IsTUFBZDtBQUNBO0FBQ0oscUJBQUssV0FBTDtBQUNBLHFCQUFLLE1BQUw7QUFDSSx5QkFBSy9CLFFBQUwsQ0FBY2dDLFFBQWQ7QUFDQTtBQUNKO0FBQ0k7QUFWUjs7QUFhQVAsa0JBQU1RLGNBQU47QUFDSDs7OzJDQUdrQlIsSyxFQUFPOztBQUV0QixvQkFBUUEsTUFBTUssR0FBZDtBQUNJLHFCQUFLLFNBQUw7QUFDQSxxQkFBSyxJQUFMO0FBQ0EscUJBQUssV0FBTDtBQUNBLHFCQUFLLE1BQUw7QUFDSSx5QkFBSzlCLFFBQUwsQ0FBY2tDLFFBQWQ7QUFDQTtBQUNKO0FBQ0k7QUFSUjtBQVVBVCxrQkFBTVEsY0FBTjtBQUNIOzs7cUNBRVk3QyxTLEVBQVc7QUFDcEIsaUJBQUtBLFNBQUwsR0FBaUJBLFNBQWpCO0FBQ0g7OzswQ0FFaUI7QUFDZCxpQkFBS0EsU0FBTCxDQUFlK0MsU0FBZixHQUEyQixLQUFLL0IsS0FBaEM7QUFDSDs7Ozs7O2tCQTdIZ0JOLEk7Ozs7Ozs7Ozs7Ozs7Ozs7O0FDTHJCOzs7O0FBQ0E7Ozs7Ozs7Ozs7OztBQUVBLElBQUlzQyxZQUFZLEVBQUNDLElBQUksQ0FBTCxFQUFRQyxNQUFNLENBQWQsRUFBaUJDLE1BQU0sQ0FBdkIsRUFBaEI7O0lBRXFCQyxROzs7QUFDakIsc0JBQVkvRSxPQUFaLEVBQXFCZ0YsS0FBckIsRUFBNEJDLEtBQTVCLEVBQW1DO0FBQUE7O0FBQUEsd0hBQ3pCakYsT0FEeUIsaUNBQ0hnRixLQURHLEVBQ0lDLEtBREosRUFDVyxDQURYLEVBQ2MsQ0FEZDs7QUFFL0IsY0FBS0MsTUFBTCxHQUFjUCxVQUFVRyxJQUF4Qjs7QUFFQSxjQUFLSyxJQUFMLEdBQVksTUFBSzlFLEVBQWpCO0FBQ0EsY0FBSytFLElBQUwsR0FBWSxNQUFLaEYsRUFBakI7QUFMK0I7QUFNbEM7Ozs7aUNBVVE7QUFDTCxpQkFBSzhFLE1BQUwsR0FBY1AsVUFBVUMsRUFBeEI7QUFDSDs7O21DQUVVO0FBQ1AsaUJBQUtNLE1BQUwsR0FBY1AsVUFBVUUsSUFBeEI7QUFDSDs7OytCQUVNO0FBQ0gsZ0JBQUlRLGNBQUo7QUFDQSxnQkFBSSxLQUFLSCxNQUFMLEtBQWdCUCxVQUFVRSxJQUE5QixFQUFvQztBQUNoQyxxQkFBS3hFLEVBQUwsR0FBVSxLQUFLOEUsSUFBZjtBQUNILGFBRkQsTUFFTyxJQUFJLEtBQUtELE1BQUwsS0FBZ0JQLFVBQVVDLEVBQTlCLEVBQWtDO0FBQ3JDLHFCQUFLdkUsRUFBTCxHQUFVLENBQUMsS0FBSzhFLElBQWhCO0FBQ0g7O0FBRURFLG9CQUFRLEtBQUtsRixDQUFMLEdBQVMsS0FBS0UsRUFBdEI7QUFDQSxnQkFBSSxLQUFLaUYsU0FBTCxDQUFlLENBQWYsRUFBa0JELEtBQWxCLENBQUosRUFBOEI7QUFDMUI7QUFDSDtBQUNKOzs7bUNBRVU7QUFDUCxpQkFBS0gsTUFBTCxHQUFjUCxVQUFVRyxJQUF4QjtBQUNIOzs7a0NBRVNTLEssRUFBT0YsSyxFQUFPO0FBQ3BCLG1CQUFPRSxRQUFRLENBQVIsSUFBYUYsUUFBUSxDQUFyQixJQUEyQkUsUUFBUSxLQUFLakYsUUFBTCxDQUFjdUMsS0FBZCxHQUFzQixFQUF6RCxJQUFpRXdDLFFBQVEsS0FBSy9FLFFBQUwsQ0FBY2tDLE1BQWQsR0FBdUIsRUFBdkc7QUFDSDs7O21DQUdVO0FBQ1AsbUJBQU8sS0FBSzBDLE1BQUwsS0FBZ0JQLFVBQVVDLEVBQTFCLElBQWdDLEtBQUtNLE1BQUwsS0FBZ0JQLFVBQVVFLElBQWpFO0FBQ0g7Ozs0QkF6Q1E7QUFDTCxtQkFBTyxLQUFLSyxNQUFMLEtBQWdCUCxVQUFVQyxFQUFqQztBQUNIOzs7NEJBRVU7QUFDUCxtQkFBTyxLQUFLTSxNQUFMLEtBQWdCUCxVQUFVRSxJQUFqQztBQUNIOzs7Ozs7a0JBZmdCRSxROzs7Ozs7QUNMckIsMEY7Ozs7Ozs7Ozs7Ozs7Ozs7O0FDQUE7Ozs7QUFFQTs7Ozs7Ozs7Ozs7O0lBRXFCUyxNOzs7QUFDakIsb0JBQVl4RixPQUFaLEVBQXFCRSxDQUFyQixFQUF3QkMsQ0FBeEIsRUFBMkJnQixJQUEzQixFQUFpQztBQUFBOztBQUFBLG9IQUN2Qm5CLE9BRHVCLCtCQUNIRSxDQURHLEVBQ0FDLENBREEsRUFDRyxDQUFDLENBREosRUFDTyxDQURQOztBQUU3QixjQUFLZ0IsSUFBTCxHQUFZQSxJQUFaO0FBRjZCO0FBR2hDOzs7OytCQUVNO0FBQ0g7O0FBRUEsZ0JBQUksS0FBS2pCLENBQUwsSUFBVSxDQUFkLEVBQWlCO0FBQ2IscUJBQUtpQixJQUFMLENBQVVzRSxZQUFWLENBQXVCLElBQXZCO0FBQ0g7QUFDSjs7Ozs7O2tCQVpnQkQsTTs7Ozs7Ozs7Ozs7Ozs7Ozs7QUNKckI7Ozs7QUFDQTs7Ozs7Ozs7Ozs7O0lBRXFCRSxLOzs7QUFDakIsbUJBQVkxRixPQUFaLEVBQXFCRSxDQUFyQixFQUF3QkMsQ0FBeEIsRUFBMkJnQixJQUEzQixFQUFpQztBQUFBOztBQUFBLGtIQUN2Qm5CLE9BRHVCLG1CQUNSRSxDQURRLEVBQ0xDLENBREssRUFDRixDQURFLEVBQ0MsQ0FERDs7QUFFN0IsY0FBS2dCLElBQUwsR0FBWUEsSUFBWjtBQUY2QjtBQUdoQzs7OzsrQkFFSztBQUNGOztBQUVBLGdCQUFJLEtBQUtqQixDQUFMLElBQVUsS0FBS0ksUUFBTCxDQUFjdUMsS0FBNUIsRUFBbUM7QUFDL0IscUJBQUsxQixJQUFMLENBQVV3RSxXQUFWLENBQXNCLElBQXRCO0FBQ0g7QUFDSjs7Ozs7O2tCQVpnQkQsSzs7Ozs7O0FDSHJCLDBGOzs7Ozs7QUNBQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBLGVBQWU7QUFDZjtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQSxHQUFHO0FBQ0g7QUFDQTtBQUNBLGdDQUFnQyxVQUFVLEVBQUU7QUFDNUMsQzs7Ozs7O0FDekJBO0FBQ0E7QUFDQTs7O0FBR0E7QUFDQSwrQkFBZ0MsdUNBQXVDLEdBQUcsVUFBVSwwQkFBMEIsb0JBQW9CLHFFQUFvRixrQ0FBa0MsNkJBQTZCLG9DQUFvQywrQkFBK0IsU0FBUyxjQUFjLDhCQUE4QixpQ0FBaUMsMENBQTBDLHdDQUF3QyxLQUFLLDhCQUE4QixZQUFZLHlDQUF5QyxPQUFPLGdCQUFnQixxQ0FBcUMsWUFBWSxLQUFLLHFCQUFxQix3QkFBd0Isa0JBQWtCLEdBQUcsWUFBWSxxQkFBcUIsSUFBSSxlQUFlLDJCQUEyQixrQkFBa0IscUJBQXFCLHVCQUF1Qiw2QkFBNkIsa0JBQWtCLGlCQUFpQixHQUFHOztBQUV2N0I7Ozs7Ozs7QUNSQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOzs7Ozs7O0FDZkE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLG1DQUFtQyxnQkFBZ0I7QUFDbkQsSUFBSTtBQUNKO0FBQ0E7QUFDQSxHQUFHO0FBQ0g7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLGdCQUFnQixpQkFBaUI7QUFDakM7QUFDQTtBQUNBO0FBQ0E7QUFDQSxZQUFZLG9CQUFvQjtBQUNoQztBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0EsS0FBSztBQUNMO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0EsR0FBRzs7QUFFSDtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQSxvREFBb0QsY0FBYzs7QUFFbEU7QUFDQTs7Ozs7OztBQzNFQSwwRjs7Ozs7O0FDQUE7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0EsQ0FBQzs7QUFFRDtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLEtBQUs7QUFDTDtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLENBQUM7QUFDRDtBQUNBLENBQUM7O0FBRUQ7QUFDQTtBQUNBOztBQUVBOztBQUVBO0FBQ0E7QUFDQTtBQUNBOztBQUVBOztBQUVBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7O0FBRUE7O0FBRUE7QUFDQTs7QUFFQSxpQkFBaUIsbUJBQW1CO0FBQ3BDO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBOztBQUVBLGlCQUFpQixzQkFBc0I7QUFDdkM7O0FBRUE7QUFDQSxtQkFBbUIsMkJBQTJCOztBQUU5QztBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0EsZ0JBQWdCLG1CQUFtQjtBQUNuQztBQUNBOztBQUVBO0FBQ0E7O0FBRUEsaUJBQWlCLDJCQUEyQjtBQUM1QztBQUNBOztBQUVBLFFBQVEsdUJBQXVCO0FBQy9CO0FBQ0E7QUFDQSxHQUFHO0FBQ0g7O0FBRUEsaUJBQWlCLHVCQUF1QjtBQUN4QztBQUNBOztBQUVBLDJCQUEyQjtBQUMzQjtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBLGdCQUFnQixpQkFBaUI7QUFDakM7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLGNBQWM7O0FBRWQsa0RBQWtELHNCQUFzQjtBQUN4RTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7O0FBRUE7QUFDQTtBQUNBO0FBQ0EsR0FBRztBQUNIO0FBQ0EsR0FBRztBQUNIO0FBQ0E7QUFDQTtBQUNBLEVBQUU7QUFDRjtBQUNBLEVBQUU7QUFDRjtBQUNBO0FBQ0EsRUFBRTtBQUNGO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBLEVBQUU7QUFDRjs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLE1BQU07QUFDTjtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBOztBQUVBO0FBQ0E7O0FBRUEsRUFBRTtBQUNGO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBLEVBQUU7QUFDRjtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0EsR0FBRztBQUNIO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0EsQ0FBQzs7QUFFRDtBQUNBOztBQUVBO0FBQ0E7QUFDQSxFQUFFO0FBQ0Y7QUFDQTs7QUFFQTs7QUFFQTtBQUNBO0FBQ0EsR0FBRztBQUNIO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBLEVBQUU7QUFDRjtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBLHVEQUF1RDtBQUN2RDs7QUFFQSw2QkFBNkIsbUJBQW1COztBQUVoRDs7QUFFQTs7QUFFQTtBQUNBOzs7Ozs7OztBQzVXQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQSx3Q0FBd0MsV0FBVyxFQUFFO0FBQ3JELHdDQUF3QyxXQUFXLEVBQUU7O0FBRXJEO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0EsR0FBRztBQUNIO0FBQ0Esc0NBQXNDO0FBQ3RDLEdBQUc7QUFDSDtBQUNBLDhEQUE4RDtBQUM5RDs7QUFFQTtBQUNBO0FBQ0EsRUFBRTs7QUFFRjtBQUNBO0FBQ0EiLCJmaWxlIjoic2NyaXB0cy9idW5kbGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyIgXHQvLyBUaGUgbW9kdWxlIGNhY2hlXG4gXHR2YXIgaW5zdGFsbGVkTW9kdWxlcyA9IHt9O1xuXG4gXHQvLyBUaGUgcmVxdWlyZSBmdW5jdGlvblxuIFx0ZnVuY3Rpb24gX193ZWJwYWNrX3JlcXVpcmVfXyhtb2R1bGVJZCkge1xuXG4gXHRcdC8vIENoZWNrIGlmIG1vZHVsZSBpcyBpbiBjYWNoZVxuIFx0XHRpZihpbnN0YWxsZWRNb2R1bGVzW21vZHVsZUlkXSkge1xuIFx0XHRcdHJldHVybiBpbnN0YWxsZWRNb2R1bGVzW21vZHVsZUlkXS5leHBvcnRzO1xuIFx0XHR9XG4gXHRcdC8vIENyZWF0ZSBhIG5ldyBtb2R1bGUgKGFuZCBwdXQgaXQgaW50byB0aGUgY2FjaGUpXG4gXHRcdHZhciBtb2R1bGUgPSBpbnN0YWxsZWRNb2R1bGVzW21vZHVsZUlkXSA9IHtcbiBcdFx0XHRpOiBtb2R1bGVJZCxcbiBcdFx0XHRsOiBmYWxzZSxcbiBcdFx0XHRleHBvcnRzOiB7fVxuIFx0XHR9O1xuXG4gXHRcdC8vIEV4ZWN1dGUgdGhlIG1vZHVsZSBmdW5jdGlvblxuIFx0XHRtb2R1bGVzW21vZHVsZUlkXS5jYWxsKG1vZHVsZS5leHBvcnRzLCBtb2R1bGUsIG1vZHVsZS5leHBvcnRzLCBfX3dlYnBhY2tfcmVxdWlyZV9fKTtcblxuIFx0XHQvLyBGbGFnIHRoZSBtb2R1bGUgYXMgbG9hZGVkXG4gXHRcdG1vZHVsZS5sID0gdHJ1ZTtcblxuIFx0XHQvLyBSZXR1cm4gdGhlIGV4cG9ydHMgb2YgdGhlIG1vZHVsZVxuIFx0XHRyZXR1cm4gbW9kdWxlLmV4cG9ydHM7XG4gXHR9XG5cblxuIFx0Ly8gZXhwb3NlIHRoZSBtb2R1bGVzIG9iamVjdCAoX193ZWJwYWNrX21vZHVsZXNfXylcbiBcdF9fd2VicGFja19yZXF1aXJlX18ubSA9IG1vZHVsZXM7XG5cbiBcdC8vIGV4cG9zZSB0aGUgbW9kdWxlIGNhY2hlXG4gXHRfX3dlYnBhY2tfcmVxdWlyZV9fLmMgPSBpbnN0YWxsZWRNb2R1bGVzO1xuXG4gXHQvLyBkZWZpbmUgZ2V0dGVyIGZ1bmN0aW9uIGZvciBoYXJtb255IGV4cG9ydHNcbiBcdF9fd2VicGFja19yZXF1aXJlX18uZCA9IGZ1bmN0aW9uKGV4cG9ydHMsIG5hbWUsIGdldHRlcikge1xuIFx0XHRpZighX193ZWJwYWNrX3JlcXVpcmVfXy5vKGV4cG9ydHMsIG5hbWUpKSB7XG4gXHRcdFx0T2JqZWN0LmRlZmluZVByb3BlcnR5KGV4cG9ydHMsIG5hbWUsIHtcbiBcdFx0XHRcdGNvbmZpZ3VyYWJsZTogZmFsc2UsXG4gXHRcdFx0XHRlbnVtZXJhYmxlOiB0cnVlLFxuIFx0XHRcdFx0Z2V0OiBnZXR0ZXJcbiBcdFx0XHR9KTtcbiBcdFx0fVxuIFx0fTtcblxuIFx0Ly8gZ2V0RGVmYXVsdEV4cG9ydCBmdW5jdGlvbiBmb3IgY29tcGF0aWJpbGl0eSB3aXRoIG5vbi1oYXJtb255IG1vZHVsZXNcbiBcdF9fd2VicGFja19yZXF1aXJlX18ubiA9IGZ1bmN0aW9uKG1vZHVsZSkge1xuIFx0XHR2YXIgZ2V0dGVyID0gbW9kdWxlICYmIG1vZHVsZS5fX2VzTW9kdWxlID9cbiBcdFx0XHRmdW5jdGlvbiBnZXREZWZhdWx0KCkgeyByZXR1cm4gbW9kdWxlWydkZWZhdWx0J107IH0gOlxuIFx0XHRcdGZ1bmN0aW9uIGdldE1vZHVsZUV4cG9ydHMoKSB7IHJldHVybiBtb2R1bGU7IH07XG4gXHRcdF9fd2VicGFja19yZXF1aXJlX18uZChnZXR0ZXIsICdhJywgZ2V0dGVyKTtcbiBcdFx0cmV0dXJuIGdldHRlcjtcbiBcdH07XG5cbiBcdC8vIE9iamVjdC5wcm90b3R5cGUuaGFzT3duUHJvcGVydHkuY2FsbFxuIFx0X193ZWJwYWNrX3JlcXVpcmVfXy5vID0gZnVuY3Rpb24ob2JqZWN0LCBwcm9wZXJ0eSkgeyByZXR1cm4gT2JqZWN0LnByb3RvdHlwZS5oYXNPd25Qcm9wZXJ0eS5jYWxsKG9iamVjdCwgcHJvcGVydHkpOyB9O1xuXG4gXHQvLyBfX3dlYnBhY2tfcHVibGljX3BhdGhfX1xuIFx0X193ZWJwYWNrX3JlcXVpcmVfXy5wID0gXCJcIjtcblxuIFx0Ly8gTG9hZCBlbnRyeSBtb2R1bGUgYW5kIHJldHVybiBleHBvcnRzXG4gXHRyZXR1cm4gX193ZWJwYWNrX3JlcXVpcmVfXyhfX3dlYnBhY2tfcmVxdWlyZV9fLnMgPSAyKTtcblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyB3ZWJwYWNrL2Jvb3RzdHJhcCBmY2RkMjQ1N2Y2NDAwNTA4YjNhMCIsImV4cG9ydCBkZWZhdWx0IGNsYXNzIE1vYmlsZSB7XG4gICAgY29uc3RydWN0b3IoYUNhbnZhcywgc3JjSW1hZ2UsIHgsIHksIHZ4LCB2eSkge1xuICAgICAgICB0aGlzLm15Q2FudmFzID0gYUNhbnZhcztcbiAgICAgICAgdGhpcy5jb250ZXh0ID0gdGhpcy5teUNhbnZhcy5nZXRDb250ZXh0KFwiMmRcIik7XG5cbiAgICAgICAgdGhpcy5pbWdNb2JpbGUgPSBuZXcgSW1hZ2UoKTtcbiAgICAgICAgdGhpcy5pbWdMb2FkZWQgPSBmYWxzZTtcbiAgICAgICAgdGhpcy5pbWdNb2JpbGUuYWRkRXZlbnRMaXN0ZW5lcihcImxvYWRcIiwgdGhpcy5pbWdMb2FkTGlzdGVuZXIuYmluZCh0aGlzKSk7XG4gICAgICAgIHRoaXMuaW1nTW9iaWxlLnNyYyA9IHNyY0ltYWdlO1xuXG4gICAgICAgIHRoaXMueCA9IHg7XG4gICAgICAgIHRoaXMueSA9IHk7XG4gICAgICAgIHRoaXMudnggPSB2eDtcbiAgICAgICAgdGhpcy52eSA9IHZ5O1xuICAgIH1cblxuICAgIGRyYXcoKSB7XG4gICAgICAgIGlmICh0aGlzLmltZ0xvYWRlZCA9PT0gdHJ1ZSkge1xuICAgICAgICAgICAgdGhpcy5jb250ZXh0LmRyYXdJbWFnZSh0aGlzLmltZ01vYmlsZSwgdGhpcy54LCB0aGlzLnkpO1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgbW92ZSgpIHtcbiAgICAgICAgdGhpcy54ICs9IHRoaXMudng7XG4gICAgICAgIHRoaXMueSArPSB0aGlzLnZ5O1xuICAgIH1cblxuICAgIGltZ0xvYWRMaXN0ZW5lcigpIHtcbiAgICAgICAgdGhpcy5pbWdMb2FkZWQgPSB0cnVlO1xuICAgIH1cbn1cblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL01vYmlsZS5qcyIsIm1vZHVsZS5leHBvcnRzID0gX193ZWJwYWNrX3B1YmxpY19wYXRoX18gKyBcImltYWdlcy9pbWdiM2VkNTAwYmFiOTZlY2Q4MjA1MmEyYWVkZjliMmUwNC5wbmdcIjtcblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9pbWFnZXMvZmx5aW5nU2F1Y2VyLXBldGl0LnBuZ1xuLy8gbW9kdWxlIGlkID0gMVxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJpbXBvcnQgR2FtZSBmcm9tICcuL0dhbWUuanMnO1xuXG5pbXBvcnQgJy4uL3N0eWxlL3N0eWxlLmNzcyc7XG5pbXBvcnQgc2F1Y2VyU3JjIGZyb20gJy4uL2ltYWdlcy9mbHlpbmdTYXVjZXItcGV0aXQucG5nJztcblxuXG5mdW5jdGlvbiBzZXR1cEdhbWUodGhlQ2FudmFzKSB7XG4gICAgbGV0IGdhbWUgPSBuZXcgR2FtZSh0aGVDYW52YXMpO1xuICAgIGdhbWUuY29uc3RydWN0b3IgPSB1bmRlZmluZWQ7XG4gICAgT2JqZWN0LmdldFByb3RvdHlwZU9mKGdhbWUpLmNvbnN0cnVjdG9yID0gdW5kZWZpbmVkO1xuXG4gICAgd2luZG93LmFkZEV2ZW50TGlzdGVuZXIoJ2tleWRvd24nLCBnYW1lLmtleURvd25BY3Rpb25IYW5kbGVyLmJpbmQoZ2FtZSkpO1xuICAgIHdpbmRvdy5hZGRFdmVudExpc3RlbmVyKCdrZXl1cCcsIGdhbWUua2V5VXBBY3Rpb25IYW5kbGVyLmJpbmQoZ2FtZSkpO1xuXG4gICAgbGV0IHNjb3JlU3BhbiA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwic2NvcmVcIik7XG4gICAgZ2FtZS5zZXRIVE1MU2NvcmUoc2NvcmVTcGFuKTtcblxuICAgIHJldHVybiBnYW1lO1xufVxuXG5mdW5jdGlvbiBzZXR1cEJ1dHRvbnMoZ2FtZSkge1xuICAgIGxldCBuZXdTYXVjZXJCdXR0b24gPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcIm5vdXZlbGxlU291Y291cGVcIik7XG4gICAgbmV3U2F1Y2VyQnV0dG9uLmFkZEV2ZW50TGlzdGVuZXIoXCJjbGlja1wiLCBnYW1lLmFkZFNhdWNlci5iaW5kKGdhbWUpKTtcbiAgICBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcIm5ld1NhdWNlckJ1dHRvbkltZ1wiKS5zcmMgPSBzYXVjZXJTcmM7XG5cbiAgICBsZXQgaW5maW5pdGVTYXVjZXJzID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJmbG90dGVTb3Vjb3VwZXNcIik7XG4gICAgaW5maW5pdGVTYXVjZXJzLmFkZEV2ZW50TGlzdGVuZXIoXCJjbGlja1wiLCBnYW1lLmluZmluaXRlU2F1Y2Vycy5iaW5kKGdhbWUpKTtcbiAgICBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcImluZmluaXRlU2F1Y2Vyc0J1dHRvbkltZ1wiKS5zcmMgPSBzYXVjZXJTcmM7XG59XG5cbnZhciBzZXR1cCA9IGZ1bmN0aW9uICgpIHtcbiAgICBsZXQgdGhlQ2FudmFzID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJzdGFyc1wiKTtcbiAgICBsZXQgZ2FtZSA9IHNldHVwR2FtZSh0aGVDYW52YXMpO1xuXG4gICAgc2V0dXBCdXR0b25zKGdhbWUpO1xuXG4gICAgZ2FtZS5hbmltYXRlKCk7XG5cbn07XG5cbndpbmRvdy5hZGRFdmVudExpc3RlbmVyKFwiRE9NQ29udGVudExvYWRlZFwiLCBzZXR1cCk7XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gLi9zcmMvc2NyaXB0cy9tYWluLmpzIiwiaW1wb3J0IFN0YXJzaGlwIGZyb20gJy4vU3RhcnNoaXAuanMnO1xuaW1wb3J0IFNhdWNlciBmcm9tICcuL1NhdWNlci5qcyc7XG5pbXBvcnQgU2hvb3QgZnJvbSBcIi4vU2hvb3RcIjtcblxuXG5leHBvcnQgZGVmYXVsdCBjbGFzcyBHYW1lIHtcbiAgICBjb25zdHJ1Y3RvcihhQ2FudmFzKSB7XG4gICAgICAgIHRoaXMubXlDYW52YXMgPSBhQ2FudmFzO1xuICAgICAgICB0aGlzLnJhZiA9IHVuZGVmaW5lZDtcbiAgICAgICAgdGhpcy5jb250ZXh0ID0gdGhpcy5teUNhbnZhcy5nZXRDb250ZXh0KCcyZCcpO1xuXG4gICAgICAgIHRoaXMuc3RhcnNoaXAgPSBuZXcgU3RhcnNoaXAodGhpcy5teUNhbnZhcywgNDAsIHRoaXMubXlDYW52YXMuaGVpZ2h0IC8gMik7XG5cbiAgICAgICAgdGhpcy5zYXVjZXJzID0gW107XG4gICAgICAgIHRoaXMuc2hvb3RzID0gW11cbiAgICAgICAgdGhpcy5zY29yZSA9IDA7XG5cbiAgICAgICAgdGhpcy5maXJzdERyYXcgPSB0cnVlO1xuXG4gICAgICAgIHRoaXMuc2NvcmVTcGFuID0gdW5kZWZpbmVkO1xuICAgIH1cblxuXG4gICAgYWRkU2F1Y2VyKCkge1xuICAgICAgICBsZXQgeCA9IHRoaXMubXlDYW52YXMud2lkdGg7XG4gICAgICAgIGxldCB5ID0gTWF0aC5mbG9vcihNYXRoLnJhbmRvbSgpICogdGhpcy5teUNhbnZhcy5oZWlnaHQpO1xuXG4gICAgICAgIHRoaXMuc2F1Y2Vycy5wdXNoKG5ldyBTYXVjZXIodGhpcy5teUNhbnZhcywgeCwgeSwgdGhpcykpO1xuICAgIH1cblxuICAgIGluZmluaXRlU2F1Y2VycygpIHtcbiAgICAgICAgLy8gVE9ET1xuICAgIH1cblxuICAgIHJlbW92ZVNhdWNlcihzYXVjZXIpIHtcbiAgICAgICAgdGhpcy5zYXVjZXJzID0gdGhpcy5zYXVjZXJzLmZpbHRlcihlID0+IGUgIT09IHNhdWNlcik7XG4gICAgICAgIHRoaXMudXBkYXRlU2NvcmVPbkxvc3RTYXVjZXIoKTtcbiAgICB9XG5cbiAgICBhZGRTaG9vdCgpIHtcbiAgICAgICAgbGV0IHggPSB0aGlzLnN0YXJzaGlwLng7XG4gICAgICAgIGxldCB5ID0gdGhpcy5zdGFyc2hpcC55O1xuXG4gICAgICAgIHRoaXMuc2hvb3RzLnB1c2gobmV3IFNob290KHRoaXMubXlDYW52YXMsIHgsIHksIHRoaXMpKTtcbiAgICB9XG5cbiAgICByZW1vdmVTaG9vdChzaG9vdCkge1xuICAgICAgICB0aGlzLnNob290cyA9IHRoaXMuc2hvb3RzLmZpbHRlcihlID0+IGUgIT09IHNob290KTtcbiAgICB9XG5cbiAgICBzZXRTY29yZSh1cGRhdGVkU2NvcmUpIHtcbiAgICAgICAgdGhpcy5zY29yZSA9IHVwZGF0ZWRTY29yZTtcbiAgICB9XG5cbiAgICBsb3NlU2F1Y2VyKCkge1xuICAgICAgICB0aGlzLnNjb3JlIC09IDEwMDA7XG4gICAgICAgIHRoaXMudXBkYXRlU2NvcmVTcGFuKCk7XG4gICAgfVxuXG4gICAgdXBkYXRlU2NvcmVPblNhdWNlclNob3REb3duKCkge1xuICAgICAgICB0aGlzLnNjb3JlICs9IDIwMDtcbiAgICAgICAgdGhpcy51cGRhdGVTY29yZVNwYW4oKTtcbiAgICB9XG5cbiAgICBhbmltYXRlKCkge1xuICAgICAgICB0aGlzLmNvbnRleHQuY2xlYXJSZWN0KDAsIDAsIHRoaXMubXlDYW52YXMud2lkdGgsIHRoaXMubXlDYW52YXMuaGVpZ2h0KTtcblxuICAgICAgICBpZiAodGhpcy5maXJzdERyYXcgfHwgdGhpcy5zdGFyc2hpcC5pc01vdmluZygpKSB7XG4gICAgICAgICAgICB0aGlzLnN0YXJzaGlwLm1vdmUodGhpcyk7XG4gICAgICAgICAgICB0aGlzLmZpcnN0RHJhdyA9IGZhbHNlO1xuICAgICAgICB9XG4gICAgICAgIHRoaXMuc3RhcnNoaXAuZHJhdygpO1xuXG4gICAgICAgIGZvciAobGV0IHNpbmdsZVNhdWNlciBvZiB0aGlzLnNhdWNlcnMpIHtcbiAgICAgICAgICAgIHNpbmdsZVNhdWNlci5tb3ZlKCk7XG4gICAgICAgICAgICBzaW5nbGVTYXVjZXIuZHJhdygpO1xuICAgICAgICB9XG5cbiAgICAgICAgZm9yKGxldCBzaW5nbGVTaG9vdCBvZiB0aGlzLnNob290cyl7XG4gICAgICAgICAgICBzaW5nbGVTaG9vdC5tb3ZlKCk7XG4gICAgICAgICAgICBzaW5nbGVTaG9vdC5kcmF3KCk7XG4gICAgICAgIH1cblxuICAgICAgICB0aGlzLnJhZiA9IHdpbmRvdy5yZXF1ZXN0QW5pbWF0aW9uRnJhbWUodGhpcy5hbmltYXRlLmJpbmQodGhpcykpO1xuICAgIH1cblxuICAgIGtleURvd25BY3Rpb25IYW5kbGVyKGV2ZW50KSB7XG4gICAgICAgIGlmKGV2ZW50LmtleUNvZGUgPT09IDMyKXtcbiAgICAgICAgICAgIHRoaXMuYWRkU2hvb3QoKTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwic2hvb3RcIik7XG4gICAgICAgIH1cblxuICAgICAgICBzd2l0Y2ggKGV2ZW50LmtleSkge1xuICAgICAgICAgICAgY2FzZSBcIkFycm93VXBcIjpcbiAgICAgICAgICAgIGNhc2UgXCJVcFwiOlxuICAgICAgICAgICAgICAgIHRoaXMuc3RhcnNoaXAubW92ZVVwKCk7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIFwiQXJyb3dEb3duXCI6XG4gICAgICAgICAgICBjYXNlIFwiRG93blwiOlxuICAgICAgICAgICAgICAgIHRoaXMuc3RhcnNoaXAubW92ZURvd24oKTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGRlZmF1bHQ6XG4gICAgICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG5cbiAgICAgICAgZXZlbnQucHJldmVudERlZmF1bHQoKTtcbiAgICB9XG5cblxuICAgIGtleVVwQWN0aW9uSGFuZGxlcihldmVudCkge1xuXG4gICAgICAgIHN3aXRjaCAoZXZlbnQua2V5KSB7XG4gICAgICAgICAgICBjYXNlIFwiQXJyb3dVcFwiOlxuICAgICAgICAgICAgY2FzZSBcIlVwXCI6XG4gICAgICAgICAgICBjYXNlIFwiQXJyb3dEb3duXCI6XG4gICAgICAgICAgICBjYXNlIFwiRG93blwiOlxuICAgICAgICAgICAgICAgIHRoaXMuc3RhcnNoaXAuc3RvcE1vdmUoKTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGRlZmF1bHQ6XG4gICAgICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG4gICAgICAgIGV2ZW50LnByZXZlbnREZWZhdWx0KCk7XG4gICAgfVxuXG4gICAgc2V0SFRNTFNjb3JlKHNjb3JlU3Bhbikge1xuICAgICAgICB0aGlzLnNjb3JlU3BhbiA9IHNjb3JlU3BhbjtcbiAgICB9XG5cbiAgICB1cGRhdGVTY29yZVNwYW4oKSB7XG4gICAgICAgIHRoaXMuc2NvcmVTcGFuLmlubmVySFRNTCA9IHRoaXMuc2NvcmU7XG4gICAgfVxufVxuXG5cblxuLy8gV0VCUEFDSyBGT09URVIgLy9cbi8vIC4vc3JjL3NjcmlwdHMvR2FtZS5qcyIsImltcG9ydCBNb2JpbGUgZnJvbSAnLi9Nb2JpbGUuanMnXG5pbXBvcnQgc3RhcnNoaXBTcmMgZnJvbSAnLi4vaW1hZ2VzL3ZhaXNzZWF1LWJhbGxvbi1wZXRpdC5wbmcnO1xuXG52YXIgTW92ZVN0YXRlID0ge1VQOiAwLCBET1dOOiAxLCBOT05FOiAyfTtcblxuZXhwb3J0IGRlZmF1bHQgY2xhc3MgU3RhcnNoaXAgZXh0ZW5kcyBNb2JpbGUge1xuICAgIGNvbnN0cnVjdG9yKGFDYW52YXMsIGluaXRYLCBpbml0WSkge1xuICAgICAgICBzdXBlcihhQ2FudmFzLCBzdGFyc2hpcFNyYywgaW5pdFgsIGluaXRZLCAwLCA4KTtcbiAgICAgICAgdGhpcy5tb3ZpbmcgPSBNb3ZlU3RhdGUuTk9ORTtcblxuICAgICAgICB0aGlzLm9nVlkgPSB0aGlzLnZ5O1xuICAgICAgICB0aGlzLm9nVlggPSB0aGlzLnZ4O1xuICAgIH1cblxuICAgIGdldCB1cCgpIHtcbiAgICAgICAgcmV0dXJuIHRoaXMubW92aW5nID09PSBNb3ZlU3RhdGUuVVA7XG4gICAgfVxuXG4gICAgZ2V0IGRvd24oKSB7XG4gICAgICAgIHJldHVybiB0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLkRPV047XG4gICAgfVxuXG4gICAgbW92ZVVwKCkge1xuICAgICAgICB0aGlzLm1vdmluZyA9IE1vdmVTdGF0ZS5VUDtcbiAgICB9XG5cbiAgICBtb3ZlRG93bigpIHtcbiAgICAgICAgdGhpcy5tb3ZpbmcgPSBNb3ZlU3RhdGUuRE9XTjtcbiAgICB9XG5cbiAgICBtb3ZlKCkge1xuICAgICAgICBsZXQgY2FsY1k7XG4gICAgICAgIGlmICh0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLkRPV04pIHtcbiAgICAgICAgICAgIHRoaXMudnkgPSB0aGlzLm9nVlk7XG4gICAgICAgIH0gZWxzZSBpZiAodGhpcy5tb3ZpbmcgPT09IE1vdmVTdGF0ZS5VUCkge1xuICAgICAgICAgICAgdGhpcy52eSA9IC10aGlzLm9nVlk7XG4gICAgICAgIH1cblxuICAgICAgICBjYWxjWSA9IHRoaXMueSArIHRoaXMudnk7XG4gICAgICAgIGlmICh0aGlzLnZhbGlkTW92ZSgxLCBjYWxjWSkpIHtcbiAgICAgICAgICAgIHN1cGVyLm1vdmUoKTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIHN0b3BNb3ZlKCkge1xuICAgICAgICB0aGlzLm1vdmluZyA9IE1vdmVTdGF0ZS5OT05FO1xuICAgIH1cblxuICAgIHZhbGlkTW92ZShjYWxjWCwgY2FsY1kpIHtcbiAgICAgICAgcmV0dXJuIGNhbGNYID4gMCAmJiBjYWxjWSA+IDAgJiYgKGNhbGNYIDwgdGhpcy5teUNhbnZhcy53aWR0aCAtIDQwKSAmJiAoY2FsY1kgPCB0aGlzLm15Q2FudmFzLmhlaWdodCAtIDQwKTtcbiAgICB9XG5cblxuICAgIGlzTW92aW5nKCkge1xuICAgICAgICByZXR1cm4gdGhpcy5tb3ZpbmcgPT09IE1vdmVTdGF0ZS5VUCB8fCB0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLkRPV047XG4gICAgfVxufVxuXG5cblxuLy8gV0VCUEFDSyBGT09URVIgLy9cbi8vIC4vc3JjL3NjcmlwdHMvU3RhcnNoaXAuanMiLCJtb2R1bGUuZXhwb3J0cyA9IF9fd2VicGFja19wdWJsaWNfcGF0aF9fICsgXCJpbWFnZXMvaW1nZTFiZjQ1Y2VlODlmMWZmYzk3ZDdjYWI2YzQxYmQ3YzgucG5nXCI7XG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvaW1hZ2VzL3ZhaXNzZWF1LWJhbGxvbi1wZXRpdC5wbmdcbi8vIG1vZHVsZSBpZCA9IDVcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiaW1wb3J0IE1vYmlsZSBmcm9tICcuL01vYmlsZS5qcyc7XG5cbmltcG9ydCBzYXVjZXJTcmMgZnJvbSAnLi4vaW1hZ2VzL2ZseWluZ1NhdWNlci1wZXRpdC5wbmcnO1xuXG5leHBvcnQgZGVmYXVsdCBjbGFzcyBTYXVjZXIgZXh0ZW5kcyBNb2JpbGUge1xuICAgIGNvbnN0cnVjdG9yKGFDYW52YXMsIHgsIHksIGdhbWUpIHtcbiAgICAgICAgc3VwZXIoYUNhbnZhcywgc2F1Y2VyU3JjLCB4LCB5LCAtMywgMCk7XG4gICAgICAgIHRoaXMuZ2FtZSA9IGdhbWU7XG4gICAgfVxuXG4gICAgbW92ZSgpIHtcbiAgICAgICAgc3VwZXIubW92ZSgpO1xuXG4gICAgICAgIGlmICh0aGlzLnggPD0gMCkge1xuICAgICAgICAgICAgdGhpcy5nYW1lLnJlbW92ZVNhdWNlcih0aGlzKTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL1NhdWNlci5qcyIsImltcG9ydCBNb2JpbGUgZnJvbSAnLi9Nb2JpbGUuanMnO1xuaW1wb3J0IHNob290IGZyb20gJy4uL2ltYWdlcy9zaG9vdC5wbmcnO1xuXG5leHBvcnQgZGVmYXVsdCBjbGFzcyBTaG9vdCBleHRlbmRzIE1vYmlsZSB7XG4gICAgY29uc3RydWN0b3IoYUNhbnZhcywgeCwgeSwgZ2FtZSkge1xuICAgICAgICBzdXBlcihhQ2FudmFzLCBzaG9vdCx4LCB5LCA4LCAwKTtcbiAgICAgICAgdGhpcy5nYW1lID0gZ2FtZTtcbiAgICB9XG5cbiAgICBtb3ZlKCl7XG4gICAgICAgIHN1cGVyLm1vdmUoKTtcblxuICAgICAgICBpZiAodGhpcy54ID49IHRoaXMubXlDYW52YXMud2lkdGgpIHtcbiAgICAgICAgICAgIHRoaXMuZ2FtZS5yZW1vdmVTaG9vdCh0aGlzKTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL1Nob290LmpzIiwibW9kdWxlLmV4cG9ydHMgPSBfX3dlYnBhY2tfcHVibGljX3BhdGhfXyArIFwiaW1hZ2VzL2ltZ2M4Zjk5NmNmMDgzZjRlYmY3YTZlMzYzZjUwZWFiNjA2LnBuZ1wiO1xuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vc3JjL2ltYWdlcy9zaG9vdC5wbmdcbi8vIG1vZHVsZSBpZCA9IDhcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiLy8gc3R5bGUtbG9hZGVyOiBBZGRzIHNvbWUgY3NzIHRvIHRoZSBET00gYnkgYWRkaW5nIGEgPHN0eWxlPiB0YWdcblxuLy8gbG9hZCB0aGUgc3R5bGVzXG52YXIgY29udGVudCA9IHJlcXVpcmUoXCIhIS4uLy4uL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyL2luZGV4LmpzIS4vc3R5bGUuY3NzXCIpO1xuaWYodHlwZW9mIGNvbnRlbnQgPT09ICdzdHJpbmcnKSBjb250ZW50ID0gW1ttb2R1bGUuaWQsIGNvbnRlbnQsICcnXV07XG4vLyBQcmVwYXJlIGNzc1RyYW5zZm9ybWF0aW9uXG52YXIgdHJhbnNmb3JtO1xuXG52YXIgb3B0aW9ucyA9IHtcImhtclwiOnRydWV9XG5vcHRpb25zLnRyYW5zZm9ybSA9IHRyYW5zZm9ybVxuLy8gYWRkIHRoZSBzdHlsZXMgdG8gdGhlIERPTVxudmFyIHVwZGF0ZSA9IHJlcXVpcmUoXCIhLi4vLi4vbm9kZV9tb2R1bGVzL3N0eWxlLWxvYWRlci9saWIvYWRkU3R5bGVzLmpzXCIpKGNvbnRlbnQsIG9wdGlvbnMpO1xuaWYoY29udGVudC5sb2NhbHMpIG1vZHVsZS5leHBvcnRzID0gY29udGVudC5sb2NhbHM7XG4vLyBIb3QgTW9kdWxlIFJlcGxhY2VtZW50XG5pZihtb2R1bGUuaG90KSB7XG5cdC8vIFdoZW4gdGhlIHN0eWxlcyBjaGFuZ2UsIHVwZGF0ZSB0aGUgPHN0eWxlPiB0YWdzXG5cdGlmKCFjb250ZW50LmxvY2Fscykge1xuXHRcdG1vZHVsZS5ob3QuYWNjZXB0KFwiISEuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9pbmRleC5qcyEuL3N0eWxlLmNzc1wiLCBmdW5jdGlvbigpIHtcblx0XHRcdHZhciBuZXdDb250ZW50ID0gcmVxdWlyZShcIiEhLi4vLi4vbm9kZV9tb2R1bGVzL2Nzcy1sb2FkZXIvaW5kZXguanMhLi9zdHlsZS5jc3NcIik7XG5cdFx0XHRpZih0eXBlb2YgbmV3Q29udGVudCA9PT0gJ3N0cmluZycpIG5ld0NvbnRlbnQgPSBbW21vZHVsZS5pZCwgbmV3Q29udGVudCwgJyddXTtcblx0XHRcdHVwZGF0ZShuZXdDb250ZW50KTtcblx0XHR9KTtcblx0fVxuXHQvLyBXaGVuIHRoZSBtb2R1bGUgaXMgZGlzcG9zZWQsIHJlbW92ZSB0aGUgPHN0eWxlPiB0YWdzXG5cdG1vZHVsZS5ob3QuZGlzcG9zZShmdW5jdGlvbigpIHsgdXBkYXRlKCk7IH0pO1xufVxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vc3JjL3N0eWxlL3N0eWxlLmNzc1xuLy8gbW9kdWxlIGlkID0gOVxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJ2YXIgZXNjYXBlID0gcmVxdWlyZShcIi4uLy4uL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyL2xpYi91cmwvZXNjYXBlLmpzXCIpO1xuZXhwb3J0cyA9IG1vZHVsZS5leHBvcnRzID0gcmVxdWlyZShcIi4uLy4uL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyL2xpYi9jc3MtYmFzZS5qc1wiKShmYWxzZSk7XG4vLyBpbXBvcnRzXG5cblxuLy8gbW9kdWxlXG5leHBvcnRzLnB1c2goW21vZHVsZS5pZCwgXCJodG1sIHtcXG4gIGJhY2tncm91bmQtY29sb3IgOiByZ2JhKDAsMCwwLDAuNSk7XFxufVxcbiNzdGFycyB7ICAgIFxcbiAgICBkaXNwbGF5IDogYmxvY2s7XFxuICAgIG1hcmdpbiA6IGF1dG87XFxuICAgIGJhY2tncm91bmQtaW1hZ2U6IHVybChcIiArIGVzY2FwZShyZXF1aXJlKFwiLi4vaW1hZ2VzL2NpZWwtbm9jdHVybmUucG5nXCIpKSArIFwiKTtcXG4gICAgYmFja2dyb3VuZC1yZXBlYXQ6IHJlcGVhdC14O1xcbiAgICBiYWNrZ3JvdW5kLXNpemU6IGNvdmVyO1xcbiAgICBiYWNrZ3JvdW5kLXBvc2l0aW9uIDogMHB4IDBweDtcXG4gICAgYm9yZGVyIDogMnB4IHNvbGlkIHdoaXRlO1xcbiAgICBcXG59XFxuXFxuICAjc3RhcnMge1xcbiAgICBhbmltYXRpb24tZHVyYXRpb246IDMwcztcXG4gICAgYW5pbWF0aW9uLW5hbWU6IHN0YXJzU2xpZGU7XFxuICAgIGFuaW1hdGlvbi1pdGVyYXRpb24tY291bnQ6IGluZmluaXRlO1xcbiAgICBhbmltYXRpb24tdGltaW5nLWZ1bmN0aW9uOiBsaW5lYXI7XFxuICB9XFxuIFxcblxcbkBrZXlmcmFtZXMgc3RhcnNTbGlkZSB7XFxuICAgIGZyb20ge1xcbiAgICAgIGJhY2tncm91bmQtcG9zaXRpb24gOiAxMjAwcHggMHB4O1xcbiAgICB9XFxuICAgIFxcbiAgICB0byB7XFxuICAgICBiYWNrZ3JvdW5kLXBvc2l0aW9uIDogMHB4IDBweDsgICAgIFxcbiAgICB9XFxuICB9XFxuXFxuXFxuXFxuZGl2I2NvbnRyb2wge1xcbiAgdGV4dC1hbGlnbiA6IGNlbnRlcjtcXG4gIG1hcmdpbiA6IDEwcHg7XFxufVxcblxcbmJ1dHRvbiB7XFxuICBmb250LXNpemUgOiA0MHB4OyBcXG59XFxuXFxuc3BhbiNzY29yZXtcXG4gIGRpc3BsYXkgOiBpbmxpbmUtYmxvY2s7XFxuICB3aWR0aCA6IDEwMHB4O1xcbiAgZm9udC1zaXplIDogMzBweDtcXG4gIHRleHQtYWxpZ24gOiByaWdodDtcXG4gIGJhY2tncm91bmQtY29sb3IgOiB3aGl0ZTtcXG4gIHBhZGRpbmcgOiA0cHg7XFxuICBtYXJnaW4gOiA0cHg7XFxufVwiLCBcIlwiXSk7XG5cbi8vIGV4cG9ydHNcblxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vbm9kZV9tb2R1bGVzL2Nzcy1sb2FkZXIhLi9zcmMvc3R5bGUvc3R5bGUuY3NzXG4vLyBtb2R1bGUgaWQgPSAxMFxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJtb2R1bGUuZXhwb3J0cyA9IGZ1bmN0aW9uIGVzY2FwZSh1cmwpIHtcbiAgICBpZiAodHlwZW9mIHVybCAhPT0gJ3N0cmluZycpIHtcbiAgICAgICAgcmV0dXJuIHVybFxuICAgIH1cbiAgICAvLyBJZiB1cmwgaXMgYWxyZWFkeSB3cmFwcGVkIGluIHF1b3RlcywgcmVtb3ZlIHRoZW1cbiAgICBpZiAoL15bJ1wiXS4qWydcIl0kLy50ZXN0KHVybCkpIHtcbiAgICAgICAgdXJsID0gdXJsLnNsaWNlKDEsIC0xKTtcbiAgICB9XG4gICAgLy8gU2hvdWxkIHVybCBiZSB3cmFwcGVkP1xuICAgIC8vIFNlZSBodHRwczovL2RyYWZ0cy5jc3N3Zy5vcmcvY3NzLXZhbHVlcy0zLyN1cmxzXG4gICAgaWYgKC9bXCInKCkgXFx0XFxuXS8udGVzdCh1cmwpKSB7XG4gICAgICAgIHJldHVybiAnXCInICsgdXJsLnJlcGxhY2UoL1wiL2csICdcXFxcXCInKS5yZXBsYWNlKC9cXG4vZywgJ1xcXFxuJykgKyAnXCInXG4gICAgfVxuXG4gICAgcmV0dXJuIHVybFxufVxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qc1xuLy8gbW9kdWxlIGlkID0gMTFcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiLypcblx0TUlUIExpY2Vuc2UgaHR0cDovL3d3dy5vcGVuc291cmNlLm9yZy9saWNlbnNlcy9taXQtbGljZW5zZS5waHBcblx0QXV0aG9yIFRvYmlhcyBLb3BwZXJzIEBzb2tyYVxuKi9cbi8vIGNzcyBiYXNlIGNvZGUsIGluamVjdGVkIGJ5IHRoZSBjc3MtbG9hZGVyXG5tb2R1bGUuZXhwb3J0cyA9IGZ1bmN0aW9uKHVzZVNvdXJjZU1hcCkge1xuXHR2YXIgbGlzdCA9IFtdO1xuXG5cdC8vIHJldHVybiB0aGUgbGlzdCBvZiBtb2R1bGVzIGFzIGNzcyBzdHJpbmdcblx0bGlzdC50b1N0cmluZyA9IGZ1bmN0aW9uIHRvU3RyaW5nKCkge1xuXHRcdHJldHVybiB0aGlzLm1hcChmdW5jdGlvbiAoaXRlbSkge1xuXHRcdFx0dmFyIGNvbnRlbnQgPSBjc3NXaXRoTWFwcGluZ1RvU3RyaW5nKGl0ZW0sIHVzZVNvdXJjZU1hcCk7XG5cdFx0XHRpZihpdGVtWzJdKSB7XG5cdFx0XHRcdHJldHVybiBcIkBtZWRpYSBcIiArIGl0ZW1bMl0gKyBcIntcIiArIGNvbnRlbnQgKyBcIn1cIjtcblx0XHRcdH0gZWxzZSB7XG5cdFx0XHRcdHJldHVybiBjb250ZW50O1xuXHRcdFx0fVxuXHRcdH0pLmpvaW4oXCJcIik7XG5cdH07XG5cblx0Ly8gaW1wb3J0IGEgbGlzdCBvZiBtb2R1bGVzIGludG8gdGhlIGxpc3Rcblx0bGlzdC5pID0gZnVuY3Rpb24obW9kdWxlcywgbWVkaWFRdWVyeSkge1xuXHRcdGlmKHR5cGVvZiBtb2R1bGVzID09PSBcInN0cmluZ1wiKVxuXHRcdFx0bW9kdWxlcyA9IFtbbnVsbCwgbW9kdWxlcywgXCJcIl1dO1xuXHRcdHZhciBhbHJlYWR5SW1wb3J0ZWRNb2R1bGVzID0ge307XG5cdFx0Zm9yKHZhciBpID0gMDsgaSA8IHRoaXMubGVuZ3RoOyBpKyspIHtcblx0XHRcdHZhciBpZCA9IHRoaXNbaV1bMF07XG5cdFx0XHRpZih0eXBlb2YgaWQgPT09IFwibnVtYmVyXCIpXG5cdFx0XHRcdGFscmVhZHlJbXBvcnRlZE1vZHVsZXNbaWRdID0gdHJ1ZTtcblx0XHR9XG5cdFx0Zm9yKGkgPSAwOyBpIDwgbW9kdWxlcy5sZW5ndGg7IGkrKykge1xuXHRcdFx0dmFyIGl0ZW0gPSBtb2R1bGVzW2ldO1xuXHRcdFx0Ly8gc2tpcCBhbHJlYWR5IGltcG9ydGVkIG1vZHVsZVxuXHRcdFx0Ly8gdGhpcyBpbXBsZW1lbnRhdGlvbiBpcyBub3QgMTAwJSBwZXJmZWN0IGZvciB3ZWlyZCBtZWRpYSBxdWVyeSBjb21iaW5hdGlvbnNcblx0XHRcdC8vICB3aGVuIGEgbW9kdWxlIGlzIGltcG9ydGVkIG11bHRpcGxlIHRpbWVzIHdpdGggZGlmZmVyZW50IG1lZGlhIHF1ZXJpZXMuXG5cdFx0XHQvLyAgSSBob3BlIHRoaXMgd2lsbCBuZXZlciBvY2N1ciAoSGV5IHRoaXMgd2F5IHdlIGhhdmUgc21hbGxlciBidW5kbGVzKVxuXHRcdFx0aWYodHlwZW9mIGl0ZW1bMF0gIT09IFwibnVtYmVyXCIgfHwgIWFscmVhZHlJbXBvcnRlZE1vZHVsZXNbaXRlbVswXV0pIHtcblx0XHRcdFx0aWYobWVkaWFRdWVyeSAmJiAhaXRlbVsyXSkge1xuXHRcdFx0XHRcdGl0ZW1bMl0gPSBtZWRpYVF1ZXJ5O1xuXHRcdFx0XHR9IGVsc2UgaWYobWVkaWFRdWVyeSkge1xuXHRcdFx0XHRcdGl0ZW1bMl0gPSBcIihcIiArIGl0ZW1bMl0gKyBcIikgYW5kIChcIiArIG1lZGlhUXVlcnkgKyBcIilcIjtcblx0XHRcdFx0fVxuXHRcdFx0XHRsaXN0LnB1c2goaXRlbSk7XG5cdFx0XHR9XG5cdFx0fVxuXHR9O1xuXHRyZXR1cm4gbGlzdDtcbn07XG5cbmZ1bmN0aW9uIGNzc1dpdGhNYXBwaW5nVG9TdHJpbmcoaXRlbSwgdXNlU291cmNlTWFwKSB7XG5cdHZhciBjb250ZW50ID0gaXRlbVsxXSB8fCAnJztcblx0dmFyIGNzc01hcHBpbmcgPSBpdGVtWzNdO1xuXHRpZiAoIWNzc01hcHBpbmcpIHtcblx0XHRyZXR1cm4gY29udGVudDtcblx0fVxuXG5cdGlmICh1c2VTb3VyY2VNYXAgJiYgdHlwZW9mIGJ0b2EgPT09ICdmdW5jdGlvbicpIHtcblx0XHR2YXIgc291cmNlTWFwcGluZyA9IHRvQ29tbWVudChjc3NNYXBwaW5nKTtcblx0XHR2YXIgc291cmNlVVJMcyA9IGNzc01hcHBpbmcuc291cmNlcy5tYXAoZnVuY3Rpb24gKHNvdXJjZSkge1xuXHRcdFx0cmV0dXJuICcvKiMgc291cmNlVVJMPScgKyBjc3NNYXBwaW5nLnNvdXJjZVJvb3QgKyBzb3VyY2UgKyAnICovJ1xuXHRcdH0pO1xuXG5cdFx0cmV0dXJuIFtjb250ZW50XS5jb25jYXQoc291cmNlVVJMcykuY29uY2F0KFtzb3VyY2VNYXBwaW5nXSkuam9pbignXFxuJyk7XG5cdH1cblxuXHRyZXR1cm4gW2NvbnRlbnRdLmpvaW4oJ1xcbicpO1xufVxuXG4vLyBBZGFwdGVkIGZyb20gY29udmVydC1zb3VyY2UtbWFwIChNSVQpXG5mdW5jdGlvbiB0b0NvbW1lbnQoc291cmNlTWFwKSB7XG5cdC8vIGVzbGludC1kaXNhYmxlLW5leHQtbGluZSBuby11bmRlZlxuXHR2YXIgYmFzZTY0ID0gYnRvYSh1bmVzY2FwZShlbmNvZGVVUklDb21wb25lbnQoSlNPTi5zdHJpbmdpZnkoc291cmNlTWFwKSkpKTtcblx0dmFyIGRhdGEgPSAnc291cmNlTWFwcGluZ1VSTD1kYXRhOmFwcGxpY2F0aW9uL2pzb247Y2hhcnNldD11dGYtODtiYXNlNjQsJyArIGJhc2U2NDtcblxuXHRyZXR1cm4gJy8qIyAnICsgZGF0YSArICcgKi8nO1xufVxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvY3NzLWJhc2UuanNcbi8vIG1vZHVsZSBpZCA9IDEyXG4vLyBtb2R1bGUgY2h1bmtzID0gMCIsIm1vZHVsZS5leHBvcnRzID0gX193ZWJwYWNrX3B1YmxpY19wYXRoX18gKyBcImltYWdlcy9pbWdlMjlhMjA0MThlZTYzYWNlYjFiYzczZDE3MmI3MzY3ZS5wbmdcIjtcblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9pbWFnZXMvY2llbC1ub2N0dXJuZS5wbmdcbi8vIG1vZHVsZSBpZCA9IDEzXG4vLyBtb2R1bGUgY2h1bmtzID0gMCIsIi8qXG5cdE1JVCBMaWNlbnNlIGh0dHA6Ly93d3cub3BlbnNvdXJjZS5vcmcvbGljZW5zZXMvbWl0LWxpY2Vuc2UucGhwXG5cdEF1dGhvciBUb2JpYXMgS29wcGVycyBAc29rcmFcbiovXG5cbnZhciBzdHlsZXNJbkRvbSA9IHt9O1xuXG52YXJcdG1lbW9pemUgPSBmdW5jdGlvbiAoZm4pIHtcblx0dmFyIG1lbW87XG5cblx0cmV0dXJuIGZ1bmN0aW9uICgpIHtcblx0XHRpZiAodHlwZW9mIG1lbW8gPT09IFwidW5kZWZpbmVkXCIpIG1lbW8gPSBmbi5hcHBseSh0aGlzLCBhcmd1bWVudHMpO1xuXHRcdHJldHVybiBtZW1vO1xuXHR9O1xufTtcblxudmFyIGlzT2xkSUUgPSBtZW1vaXplKGZ1bmN0aW9uICgpIHtcblx0Ly8gVGVzdCBmb3IgSUUgPD0gOSBhcyBwcm9wb3NlZCBieSBCcm93c2VyaGFja3Ncblx0Ly8gQHNlZSBodHRwOi8vYnJvd3NlcmhhY2tzLmNvbS8jaGFjay1lNzFkODY5MmY2NTMzNDE3M2ZlZTcxNWMyMjJjYjgwNVxuXHQvLyBUZXN0cyBmb3IgZXhpc3RlbmNlIG9mIHN0YW5kYXJkIGdsb2JhbHMgaXMgdG8gYWxsb3cgc3R5bGUtbG9hZGVyXG5cdC8vIHRvIG9wZXJhdGUgY29ycmVjdGx5IGludG8gbm9uLXN0YW5kYXJkIGVudmlyb25tZW50c1xuXHQvLyBAc2VlIGh0dHBzOi8vZ2l0aHViLmNvbS93ZWJwYWNrLWNvbnRyaWIvc3R5bGUtbG9hZGVyL2lzc3Vlcy8xNzdcblx0cmV0dXJuIHdpbmRvdyAmJiBkb2N1bWVudCAmJiBkb2N1bWVudC5hbGwgJiYgIXdpbmRvdy5hdG9iO1xufSk7XG5cbnZhciBnZXRFbGVtZW50ID0gKGZ1bmN0aW9uIChmbikge1xuXHR2YXIgbWVtbyA9IHt9O1xuXG5cdHJldHVybiBmdW5jdGlvbihzZWxlY3Rvcikge1xuXHRcdGlmICh0eXBlb2YgbWVtb1tzZWxlY3Rvcl0gPT09IFwidW5kZWZpbmVkXCIpIHtcblx0XHRcdHZhciBzdHlsZVRhcmdldCA9IGZuLmNhbGwodGhpcywgc2VsZWN0b3IpO1xuXHRcdFx0Ly8gU3BlY2lhbCBjYXNlIHRvIHJldHVybiBoZWFkIG9mIGlmcmFtZSBpbnN0ZWFkIG9mIGlmcmFtZSBpdHNlbGZcblx0XHRcdGlmIChzdHlsZVRhcmdldCBpbnN0YW5jZW9mIHdpbmRvdy5IVE1MSUZyYW1lRWxlbWVudCkge1xuXHRcdFx0XHR0cnkge1xuXHRcdFx0XHRcdC8vIFRoaXMgd2lsbCB0aHJvdyBhbiBleGNlcHRpb24gaWYgYWNjZXNzIHRvIGlmcmFtZSBpcyBibG9ja2VkXG5cdFx0XHRcdFx0Ly8gZHVlIHRvIGNyb3NzLW9yaWdpbiByZXN0cmljdGlvbnNcblx0XHRcdFx0XHRzdHlsZVRhcmdldCA9IHN0eWxlVGFyZ2V0LmNvbnRlbnREb2N1bWVudC5oZWFkO1xuXHRcdFx0XHR9IGNhdGNoKGUpIHtcblx0XHRcdFx0XHRzdHlsZVRhcmdldCA9IG51bGw7XG5cdFx0XHRcdH1cblx0XHRcdH1cblx0XHRcdG1lbW9bc2VsZWN0b3JdID0gc3R5bGVUYXJnZXQ7XG5cdFx0fVxuXHRcdHJldHVybiBtZW1vW3NlbGVjdG9yXVxuXHR9O1xufSkoZnVuY3Rpb24gKHRhcmdldCkge1xuXHRyZXR1cm4gZG9jdW1lbnQucXVlcnlTZWxlY3Rvcih0YXJnZXQpXG59KTtcblxudmFyIHNpbmdsZXRvbiA9IG51bGw7XG52YXJcdHNpbmdsZXRvbkNvdW50ZXIgPSAwO1xudmFyXHRzdHlsZXNJbnNlcnRlZEF0VG9wID0gW107XG5cbnZhclx0Zml4VXJscyA9IHJlcXVpcmUoXCIuL3VybHNcIik7XG5cbm1vZHVsZS5leHBvcnRzID0gZnVuY3Rpb24obGlzdCwgb3B0aW9ucykge1xuXHRpZiAodHlwZW9mIERFQlVHICE9PSBcInVuZGVmaW5lZFwiICYmIERFQlVHKSB7XG5cdFx0aWYgKHR5cGVvZiBkb2N1bWVudCAhPT0gXCJvYmplY3RcIikgdGhyb3cgbmV3IEVycm9yKFwiVGhlIHN0eWxlLWxvYWRlciBjYW5ub3QgYmUgdXNlZCBpbiBhIG5vbi1icm93c2VyIGVudmlyb25tZW50XCIpO1xuXHR9XG5cblx0b3B0aW9ucyA9IG9wdGlvbnMgfHwge307XG5cblx0b3B0aW9ucy5hdHRycyA9IHR5cGVvZiBvcHRpb25zLmF0dHJzID09PSBcIm9iamVjdFwiID8gb3B0aW9ucy5hdHRycyA6IHt9O1xuXG5cdC8vIEZvcmNlIHNpbmdsZS10YWcgc29sdXRpb24gb24gSUU2LTksIHdoaWNoIGhhcyBhIGhhcmQgbGltaXQgb24gdGhlICMgb2YgPHN0eWxlPlxuXHQvLyB0YWdzIGl0IHdpbGwgYWxsb3cgb24gYSBwYWdlXG5cdGlmICghb3B0aW9ucy5zaW5nbGV0b24gJiYgdHlwZW9mIG9wdGlvbnMuc2luZ2xldG9uICE9PSBcImJvb2xlYW5cIikgb3B0aW9ucy5zaW5nbGV0b24gPSBpc09sZElFKCk7XG5cblx0Ly8gQnkgZGVmYXVsdCwgYWRkIDxzdHlsZT4gdGFncyB0byB0aGUgPGhlYWQ+IGVsZW1lbnRcblx0aWYgKCFvcHRpb25zLmluc2VydEludG8pIG9wdGlvbnMuaW5zZXJ0SW50byA9IFwiaGVhZFwiO1xuXG5cdC8vIEJ5IGRlZmF1bHQsIGFkZCA8c3R5bGU+IHRhZ3MgdG8gdGhlIGJvdHRvbSBvZiB0aGUgdGFyZ2V0XG5cdGlmICghb3B0aW9ucy5pbnNlcnRBdCkgb3B0aW9ucy5pbnNlcnRBdCA9IFwiYm90dG9tXCI7XG5cblx0dmFyIHN0eWxlcyA9IGxpc3RUb1N0eWxlcyhsaXN0LCBvcHRpb25zKTtcblxuXHRhZGRTdHlsZXNUb0RvbShzdHlsZXMsIG9wdGlvbnMpO1xuXG5cdHJldHVybiBmdW5jdGlvbiB1cGRhdGUgKG5ld0xpc3QpIHtcblx0XHR2YXIgbWF5UmVtb3ZlID0gW107XG5cblx0XHRmb3IgKHZhciBpID0gMDsgaSA8IHN0eWxlcy5sZW5ndGg7IGkrKykge1xuXHRcdFx0dmFyIGl0ZW0gPSBzdHlsZXNbaV07XG5cdFx0XHR2YXIgZG9tU3R5bGUgPSBzdHlsZXNJbkRvbVtpdGVtLmlkXTtcblxuXHRcdFx0ZG9tU3R5bGUucmVmcy0tO1xuXHRcdFx0bWF5UmVtb3ZlLnB1c2goZG9tU3R5bGUpO1xuXHRcdH1cblxuXHRcdGlmKG5ld0xpc3QpIHtcblx0XHRcdHZhciBuZXdTdHlsZXMgPSBsaXN0VG9TdHlsZXMobmV3TGlzdCwgb3B0aW9ucyk7XG5cdFx0XHRhZGRTdHlsZXNUb0RvbShuZXdTdHlsZXMsIG9wdGlvbnMpO1xuXHRcdH1cblxuXHRcdGZvciAodmFyIGkgPSAwOyBpIDwgbWF5UmVtb3ZlLmxlbmd0aDsgaSsrKSB7XG5cdFx0XHR2YXIgZG9tU3R5bGUgPSBtYXlSZW1vdmVbaV07XG5cblx0XHRcdGlmKGRvbVN0eWxlLnJlZnMgPT09IDApIHtcblx0XHRcdFx0Zm9yICh2YXIgaiA9IDA7IGogPCBkb21TdHlsZS5wYXJ0cy5sZW5ndGg7IGorKykgZG9tU3R5bGUucGFydHNbal0oKTtcblxuXHRcdFx0XHRkZWxldGUgc3R5bGVzSW5Eb21bZG9tU3R5bGUuaWRdO1xuXHRcdFx0fVxuXHRcdH1cblx0fTtcbn07XG5cbmZ1bmN0aW9uIGFkZFN0eWxlc1RvRG9tIChzdHlsZXMsIG9wdGlvbnMpIHtcblx0Zm9yICh2YXIgaSA9IDA7IGkgPCBzdHlsZXMubGVuZ3RoOyBpKyspIHtcblx0XHR2YXIgaXRlbSA9IHN0eWxlc1tpXTtcblx0XHR2YXIgZG9tU3R5bGUgPSBzdHlsZXNJbkRvbVtpdGVtLmlkXTtcblxuXHRcdGlmKGRvbVN0eWxlKSB7XG5cdFx0XHRkb21TdHlsZS5yZWZzKys7XG5cblx0XHRcdGZvcih2YXIgaiA9IDA7IGogPCBkb21TdHlsZS5wYXJ0cy5sZW5ndGg7IGorKykge1xuXHRcdFx0XHRkb21TdHlsZS5wYXJ0c1tqXShpdGVtLnBhcnRzW2pdKTtcblx0XHRcdH1cblxuXHRcdFx0Zm9yKDsgaiA8IGl0ZW0ucGFydHMubGVuZ3RoOyBqKyspIHtcblx0XHRcdFx0ZG9tU3R5bGUucGFydHMucHVzaChhZGRTdHlsZShpdGVtLnBhcnRzW2pdLCBvcHRpb25zKSk7XG5cdFx0XHR9XG5cdFx0fSBlbHNlIHtcblx0XHRcdHZhciBwYXJ0cyA9IFtdO1xuXG5cdFx0XHRmb3IodmFyIGogPSAwOyBqIDwgaXRlbS5wYXJ0cy5sZW5ndGg7IGorKykge1xuXHRcdFx0XHRwYXJ0cy5wdXNoKGFkZFN0eWxlKGl0ZW0ucGFydHNbal0sIG9wdGlvbnMpKTtcblx0XHRcdH1cblxuXHRcdFx0c3R5bGVzSW5Eb21baXRlbS5pZF0gPSB7aWQ6IGl0ZW0uaWQsIHJlZnM6IDEsIHBhcnRzOiBwYXJ0c307XG5cdFx0fVxuXHR9XG59XG5cbmZ1bmN0aW9uIGxpc3RUb1N0eWxlcyAobGlzdCwgb3B0aW9ucykge1xuXHR2YXIgc3R5bGVzID0gW107XG5cdHZhciBuZXdTdHlsZXMgPSB7fTtcblxuXHRmb3IgKHZhciBpID0gMDsgaSA8IGxpc3QubGVuZ3RoOyBpKyspIHtcblx0XHR2YXIgaXRlbSA9IGxpc3RbaV07XG5cdFx0dmFyIGlkID0gb3B0aW9ucy5iYXNlID8gaXRlbVswXSArIG9wdGlvbnMuYmFzZSA6IGl0ZW1bMF07XG5cdFx0dmFyIGNzcyA9IGl0ZW1bMV07XG5cdFx0dmFyIG1lZGlhID0gaXRlbVsyXTtcblx0XHR2YXIgc291cmNlTWFwID0gaXRlbVszXTtcblx0XHR2YXIgcGFydCA9IHtjc3M6IGNzcywgbWVkaWE6IG1lZGlhLCBzb3VyY2VNYXA6IHNvdXJjZU1hcH07XG5cblx0XHRpZighbmV3U3R5bGVzW2lkXSkgc3R5bGVzLnB1c2gobmV3U3R5bGVzW2lkXSA9IHtpZDogaWQsIHBhcnRzOiBbcGFydF19KTtcblx0XHRlbHNlIG5ld1N0eWxlc1tpZF0ucGFydHMucHVzaChwYXJ0KTtcblx0fVxuXG5cdHJldHVybiBzdHlsZXM7XG59XG5cbmZ1bmN0aW9uIGluc2VydFN0eWxlRWxlbWVudCAob3B0aW9ucywgc3R5bGUpIHtcblx0dmFyIHRhcmdldCA9IGdldEVsZW1lbnQob3B0aW9ucy5pbnNlcnRJbnRvKVxuXG5cdGlmICghdGFyZ2V0KSB7XG5cdFx0dGhyb3cgbmV3IEVycm9yKFwiQ291bGRuJ3QgZmluZCBhIHN0eWxlIHRhcmdldC4gVGhpcyBwcm9iYWJseSBtZWFucyB0aGF0IHRoZSB2YWx1ZSBmb3IgdGhlICdpbnNlcnRJbnRvJyBwYXJhbWV0ZXIgaXMgaW52YWxpZC5cIik7XG5cdH1cblxuXHR2YXIgbGFzdFN0eWxlRWxlbWVudEluc2VydGVkQXRUb3AgPSBzdHlsZXNJbnNlcnRlZEF0VG9wW3N0eWxlc0luc2VydGVkQXRUb3AubGVuZ3RoIC0gMV07XG5cblx0aWYgKG9wdGlvbnMuaW5zZXJ0QXQgPT09IFwidG9wXCIpIHtcblx0XHRpZiAoIWxhc3RTdHlsZUVsZW1lbnRJbnNlcnRlZEF0VG9wKSB7XG5cdFx0XHR0YXJnZXQuaW5zZXJ0QmVmb3JlKHN0eWxlLCB0YXJnZXQuZmlyc3RDaGlsZCk7XG5cdFx0fSBlbHNlIGlmIChsYXN0U3R5bGVFbGVtZW50SW5zZXJ0ZWRBdFRvcC5uZXh0U2libGluZykge1xuXHRcdFx0dGFyZ2V0Lmluc2VydEJlZm9yZShzdHlsZSwgbGFzdFN0eWxlRWxlbWVudEluc2VydGVkQXRUb3AubmV4dFNpYmxpbmcpO1xuXHRcdH0gZWxzZSB7XG5cdFx0XHR0YXJnZXQuYXBwZW5kQ2hpbGQoc3R5bGUpO1xuXHRcdH1cblx0XHRzdHlsZXNJbnNlcnRlZEF0VG9wLnB1c2goc3R5bGUpO1xuXHR9IGVsc2UgaWYgKG9wdGlvbnMuaW5zZXJ0QXQgPT09IFwiYm90dG9tXCIpIHtcblx0XHR0YXJnZXQuYXBwZW5kQ2hpbGQoc3R5bGUpO1xuXHR9IGVsc2UgaWYgKHR5cGVvZiBvcHRpb25zLmluc2VydEF0ID09PSBcIm9iamVjdFwiICYmIG9wdGlvbnMuaW5zZXJ0QXQuYmVmb3JlKSB7XG5cdFx0dmFyIG5leHRTaWJsaW5nID0gZ2V0RWxlbWVudChvcHRpb25zLmluc2VydEludG8gKyBcIiBcIiArIG9wdGlvbnMuaW5zZXJ0QXQuYmVmb3JlKTtcblx0XHR0YXJnZXQuaW5zZXJ0QmVmb3JlKHN0eWxlLCBuZXh0U2libGluZyk7XG5cdH0gZWxzZSB7XG5cdFx0dGhyb3cgbmV3IEVycm9yKFwiW1N0eWxlIExvYWRlcl1cXG5cXG4gSW52YWxpZCB2YWx1ZSBmb3IgcGFyYW1ldGVyICdpbnNlcnRBdCcgKCdvcHRpb25zLmluc2VydEF0JykgZm91bmQuXFxuIE11c3QgYmUgJ3RvcCcsICdib3R0b20nLCBvciBPYmplY3QuXFxuIChodHRwczovL2dpdGh1Yi5jb20vd2VicGFjay1jb250cmliL3N0eWxlLWxvYWRlciNpbnNlcnRhdClcXG5cIik7XG5cdH1cbn1cblxuZnVuY3Rpb24gcmVtb3ZlU3R5bGVFbGVtZW50IChzdHlsZSkge1xuXHRpZiAoc3R5bGUucGFyZW50Tm9kZSA9PT0gbnVsbCkgcmV0dXJuIGZhbHNlO1xuXHRzdHlsZS5wYXJlbnROb2RlLnJlbW92ZUNoaWxkKHN0eWxlKTtcblxuXHR2YXIgaWR4ID0gc3R5bGVzSW5zZXJ0ZWRBdFRvcC5pbmRleE9mKHN0eWxlKTtcblx0aWYoaWR4ID49IDApIHtcblx0XHRzdHlsZXNJbnNlcnRlZEF0VG9wLnNwbGljZShpZHgsIDEpO1xuXHR9XG59XG5cbmZ1bmN0aW9uIGNyZWF0ZVN0eWxlRWxlbWVudCAob3B0aW9ucykge1xuXHR2YXIgc3R5bGUgPSBkb2N1bWVudC5jcmVhdGVFbGVtZW50KFwic3R5bGVcIik7XG5cblx0b3B0aW9ucy5hdHRycy50eXBlID0gXCJ0ZXh0L2Nzc1wiO1xuXG5cdGFkZEF0dHJzKHN0eWxlLCBvcHRpb25zLmF0dHJzKTtcblx0aW5zZXJ0U3R5bGVFbGVtZW50KG9wdGlvbnMsIHN0eWxlKTtcblxuXHRyZXR1cm4gc3R5bGU7XG59XG5cbmZ1bmN0aW9uIGNyZWF0ZUxpbmtFbGVtZW50IChvcHRpb25zKSB7XG5cdHZhciBsaW5rID0gZG9jdW1lbnQuY3JlYXRlRWxlbWVudChcImxpbmtcIik7XG5cblx0b3B0aW9ucy5hdHRycy50eXBlID0gXCJ0ZXh0L2Nzc1wiO1xuXHRvcHRpb25zLmF0dHJzLnJlbCA9IFwic3R5bGVzaGVldFwiO1xuXG5cdGFkZEF0dHJzKGxpbmssIG9wdGlvbnMuYXR0cnMpO1xuXHRpbnNlcnRTdHlsZUVsZW1lbnQob3B0aW9ucywgbGluayk7XG5cblx0cmV0dXJuIGxpbms7XG59XG5cbmZ1bmN0aW9uIGFkZEF0dHJzIChlbCwgYXR0cnMpIHtcblx0T2JqZWN0LmtleXMoYXR0cnMpLmZvckVhY2goZnVuY3Rpb24gKGtleSkge1xuXHRcdGVsLnNldEF0dHJpYnV0ZShrZXksIGF0dHJzW2tleV0pO1xuXHR9KTtcbn1cblxuZnVuY3Rpb24gYWRkU3R5bGUgKG9iaiwgb3B0aW9ucykge1xuXHR2YXIgc3R5bGUsIHVwZGF0ZSwgcmVtb3ZlLCByZXN1bHQ7XG5cblx0Ly8gSWYgYSB0cmFuc2Zvcm0gZnVuY3Rpb24gd2FzIGRlZmluZWQsIHJ1biBpdCBvbiB0aGUgY3NzXG5cdGlmIChvcHRpb25zLnRyYW5zZm9ybSAmJiBvYmouY3NzKSB7XG5cdCAgICByZXN1bHQgPSBvcHRpb25zLnRyYW5zZm9ybShvYmouY3NzKTtcblxuXHQgICAgaWYgKHJlc3VsdCkge1xuXHQgICAgXHQvLyBJZiB0cmFuc2Zvcm0gcmV0dXJucyBhIHZhbHVlLCB1c2UgdGhhdCBpbnN0ZWFkIG9mIHRoZSBvcmlnaW5hbCBjc3MuXG5cdCAgICBcdC8vIFRoaXMgYWxsb3dzIHJ1bm5pbmcgcnVudGltZSB0cmFuc2Zvcm1hdGlvbnMgb24gdGhlIGNzcy5cblx0ICAgIFx0b2JqLmNzcyA9IHJlc3VsdDtcblx0ICAgIH0gZWxzZSB7XG5cdCAgICBcdC8vIElmIHRoZSB0cmFuc2Zvcm0gZnVuY3Rpb24gcmV0dXJucyBhIGZhbHN5IHZhbHVlLCBkb24ndCBhZGQgdGhpcyBjc3MuXG5cdCAgICBcdC8vIFRoaXMgYWxsb3dzIGNvbmRpdGlvbmFsIGxvYWRpbmcgb2YgY3NzXG5cdCAgICBcdHJldHVybiBmdW5jdGlvbigpIHtcblx0ICAgIFx0XHQvLyBub29wXG5cdCAgICBcdH07XG5cdCAgICB9XG5cdH1cblxuXHRpZiAob3B0aW9ucy5zaW5nbGV0b24pIHtcblx0XHR2YXIgc3R5bGVJbmRleCA9IHNpbmdsZXRvbkNvdW50ZXIrKztcblxuXHRcdHN0eWxlID0gc2luZ2xldG9uIHx8IChzaW5nbGV0b24gPSBjcmVhdGVTdHlsZUVsZW1lbnQob3B0aW9ucykpO1xuXG5cdFx0dXBkYXRlID0gYXBwbHlUb1NpbmdsZXRvblRhZy5iaW5kKG51bGwsIHN0eWxlLCBzdHlsZUluZGV4LCBmYWxzZSk7XG5cdFx0cmVtb3ZlID0gYXBwbHlUb1NpbmdsZXRvblRhZy5iaW5kKG51bGwsIHN0eWxlLCBzdHlsZUluZGV4LCB0cnVlKTtcblxuXHR9IGVsc2UgaWYgKFxuXHRcdG9iai5zb3VyY2VNYXAgJiZcblx0XHR0eXBlb2YgVVJMID09PSBcImZ1bmN0aW9uXCIgJiZcblx0XHR0eXBlb2YgVVJMLmNyZWF0ZU9iamVjdFVSTCA9PT0gXCJmdW5jdGlvblwiICYmXG5cdFx0dHlwZW9mIFVSTC5yZXZva2VPYmplY3RVUkwgPT09IFwiZnVuY3Rpb25cIiAmJlxuXHRcdHR5cGVvZiBCbG9iID09PSBcImZ1bmN0aW9uXCIgJiZcblx0XHR0eXBlb2YgYnRvYSA9PT0gXCJmdW5jdGlvblwiXG5cdCkge1xuXHRcdHN0eWxlID0gY3JlYXRlTGlua0VsZW1lbnQob3B0aW9ucyk7XG5cdFx0dXBkYXRlID0gdXBkYXRlTGluay5iaW5kKG51bGwsIHN0eWxlLCBvcHRpb25zKTtcblx0XHRyZW1vdmUgPSBmdW5jdGlvbiAoKSB7XG5cdFx0XHRyZW1vdmVTdHlsZUVsZW1lbnQoc3R5bGUpO1xuXG5cdFx0XHRpZihzdHlsZS5ocmVmKSBVUkwucmV2b2tlT2JqZWN0VVJMKHN0eWxlLmhyZWYpO1xuXHRcdH07XG5cdH0gZWxzZSB7XG5cdFx0c3R5bGUgPSBjcmVhdGVTdHlsZUVsZW1lbnQob3B0aW9ucyk7XG5cdFx0dXBkYXRlID0gYXBwbHlUb1RhZy5iaW5kKG51bGwsIHN0eWxlKTtcblx0XHRyZW1vdmUgPSBmdW5jdGlvbiAoKSB7XG5cdFx0XHRyZW1vdmVTdHlsZUVsZW1lbnQoc3R5bGUpO1xuXHRcdH07XG5cdH1cblxuXHR1cGRhdGUob2JqKTtcblxuXHRyZXR1cm4gZnVuY3Rpb24gdXBkYXRlU3R5bGUgKG5ld09iaikge1xuXHRcdGlmIChuZXdPYmopIHtcblx0XHRcdGlmIChcblx0XHRcdFx0bmV3T2JqLmNzcyA9PT0gb2JqLmNzcyAmJlxuXHRcdFx0XHRuZXdPYmoubWVkaWEgPT09IG9iai5tZWRpYSAmJlxuXHRcdFx0XHRuZXdPYmouc291cmNlTWFwID09PSBvYmouc291cmNlTWFwXG5cdFx0XHQpIHtcblx0XHRcdFx0cmV0dXJuO1xuXHRcdFx0fVxuXG5cdFx0XHR1cGRhdGUob2JqID0gbmV3T2JqKTtcblx0XHR9IGVsc2Uge1xuXHRcdFx0cmVtb3ZlKCk7XG5cdFx0fVxuXHR9O1xufVxuXG52YXIgcmVwbGFjZVRleHQgPSAoZnVuY3Rpb24gKCkge1xuXHR2YXIgdGV4dFN0b3JlID0gW107XG5cblx0cmV0dXJuIGZ1bmN0aW9uIChpbmRleCwgcmVwbGFjZW1lbnQpIHtcblx0XHR0ZXh0U3RvcmVbaW5kZXhdID0gcmVwbGFjZW1lbnQ7XG5cblx0XHRyZXR1cm4gdGV4dFN0b3JlLmZpbHRlcihCb29sZWFuKS5qb2luKCdcXG4nKTtcblx0fTtcbn0pKCk7XG5cbmZ1bmN0aW9uIGFwcGx5VG9TaW5nbGV0b25UYWcgKHN0eWxlLCBpbmRleCwgcmVtb3ZlLCBvYmopIHtcblx0dmFyIGNzcyA9IHJlbW92ZSA/IFwiXCIgOiBvYmouY3NzO1xuXG5cdGlmIChzdHlsZS5zdHlsZVNoZWV0KSB7XG5cdFx0c3R5bGUuc3R5bGVTaGVldC5jc3NUZXh0ID0gcmVwbGFjZVRleHQoaW5kZXgsIGNzcyk7XG5cdH0gZWxzZSB7XG5cdFx0dmFyIGNzc05vZGUgPSBkb2N1bWVudC5jcmVhdGVUZXh0Tm9kZShjc3MpO1xuXHRcdHZhciBjaGlsZE5vZGVzID0gc3R5bGUuY2hpbGROb2RlcztcblxuXHRcdGlmIChjaGlsZE5vZGVzW2luZGV4XSkgc3R5bGUucmVtb3ZlQ2hpbGQoY2hpbGROb2Rlc1tpbmRleF0pO1xuXG5cdFx0aWYgKGNoaWxkTm9kZXMubGVuZ3RoKSB7XG5cdFx0XHRzdHlsZS5pbnNlcnRCZWZvcmUoY3NzTm9kZSwgY2hpbGROb2Rlc1tpbmRleF0pO1xuXHRcdH0gZWxzZSB7XG5cdFx0XHRzdHlsZS5hcHBlbmRDaGlsZChjc3NOb2RlKTtcblx0XHR9XG5cdH1cbn1cblxuZnVuY3Rpb24gYXBwbHlUb1RhZyAoc3R5bGUsIG9iaikge1xuXHR2YXIgY3NzID0gb2JqLmNzcztcblx0dmFyIG1lZGlhID0gb2JqLm1lZGlhO1xuXG5cdGlmKG1lZGlhKSB7XG5cdFx0c3R5bGUuc2V0QXR0cmlidXRlKFwibWVkaWFcIiwgbWVkaWEpXG5cdH1cblxuXHRpZihzdHlsZS5zdHlsZVNoZWV0KSB7XG5cdFx0c3R5bGUuc3R5bGVTaGVldC5jc3NUZXh0ID0gY3NzO1xuXHR9IGVsc2Uge1xuXHRcdHdoaWxlKHN0eWxlLmZpcnN0Q2hpbGQpIHtcblx0XHRcdHN0eWxlLnJlbW92ZUNoaWxkKHN0eWxlLmZpcnN0Q2hpbGQpO1xuXHRcdH1cblxuXHRcdHN0eWxlLmFwcGVuZENoaWxkKGRvY3VtZW50LmNyZWF0ZVRleHROb2RlKGNzcykpO1xuXHR9XG59XG5cbmZ1bmN0aW9uIHVwZGF0ZUxpbmsgKGxpbmssIG9wdGlvbnMsIG9iaikge1xuXHR2YXIgY3NzID0gb2JqLmNzcztcblx0dmFyIHNvdXJjZU1hcCA9IG9iai5zb3VyY2VNYXA7XG5cblx0Lypcblx0XHRJZiBjb252ZXJ0VG9BYnNvbHV0ZVVybHMgaXNuJ3QgZGVmaW5lZCwgYnV0IHNvdXJjZW1hcHMgYXJlIGVuYWJsZWRcblx0XHRhbmQgdGhlcmUgaXMgbm8gcHVibGljUGF0aCBkZWZpbmVkIHRoZW4gbGV0cyB0dXJuIGNvbnZlcnRUb0Fic29sdXRlVXJsc1xuXHRcdG9uIGJ5IGRlZmF1bHQuICBPdGhlcndpc2UgZGVmYXVsdCB0byB0aGUgY29udmVydFRvQWJzb2x1dGVVcmxzIG9wdGlvblxuXHRcdGRpcmVjdGx5XG5cdCovXG5cdHZhciBhdXRvRml4VXJscyA9IG9wdGlvbnMuY29udmVydFRvQWJzb2x1dGVVcmxzID09PSB1bmRlZmluZWQgJiYgc291cmNlTWFwO1xuXG5cdGlmIChvcHRpb25zLmNvbnZlcnRUb0Fic29sdXRlVXJscyB8fCBhdXRvRml4VXJscykge1xuXHRcdGNzcyA9IGZpeFVybHMoY3NzKTtcblx0fVxuXG5cdGlmIChzb3VyY2VNYXApIHtcblx0XHQvLyBodHRwOi8vc3RhY2tvdmVyZmxvdy5jb20vYS8yNjYwMzg3NVxuXHRcdGNzcyArPSBcIlxcbi8qIyBzb3VyY2VNYXBwaW5nVVJMPWRhdGE6YXBwbGljYXRpb24vanNvbjtiYXNlNjQsXCIgKyBidG9hKHVuZXNjYXBlKGVuY29kZVVSSUNvbXBvbmVudChKU09OLnN0cmluZ2lmeShzb3VyY2VNYXApKSkpICsgXCIgKi9cIjtcblx0fVxuXG5cdHZhciBibG9iID0gbmV3IEJsb2IoW2Nzc10sIHsgdHlwZTogXCJ0ZXh0L2Nzc1wiIH0pO1xuXG5cdHZhciBvbGRTcmMgPSBsaW5rLmhyZWY7XG5cblx0bGluay5ocmVmID0gVVJMLmNyZWF0ZU9iamVjdFVSTChibG9iKTtcblxuXHRpZihvbGRTcmMpIFVSTC5yZXZva2VPYmplY3RVUkwob2xkU3JjKTtcbn1cblxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vbm9kZV9tb2R1bGVzL3N0eWxlLWxvYWRlci9saWIvYWRkU3R5bGVzLmpzXG4vLyBtb2R1bGUgaWQgPSAxNFxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJcbi8qKlxuICogV2hlbiBzb3VyY2UgbWFwcyBhcmUgZW5hYmxlZCwgYHN0eWxlLWxvYWRlcmAgdXNlcyBhIGxpbmsgZWxlbWVudCB3aXRoIGEgZGF0YS11cmkgdG9cbiAqIGVtYmVkIHRoZSBjc3Mgb24gdGhlIHBhZ2UuIFRoaXMgYnJlYWtzIGFsbCByZWxhdGl2ZSB1cmxzIGJlY2F1c2Ugbm93IHRoZXkgYXJlIHJlbGF0aXZlIHRvIGFcbiAqIGJ1bmRsZSBpbnN0ZWFkIG9mIHRoZSBjdXJyZW50IHBhZ2UuXG4gKlxuICogT25lIHNvbHV0aW9uIGlzIHRvIG9ubHkgdXNlIGZ1bGwgdXJscywgYnV0IHRoYXQgbWF5IGJlIGltcG9zc2libGUuXG4gKlxuICogSW5zdGVhZCwgdGhpcyBmdW5jdGlvbiBcImZpeGVzXCIgdGhlIHJlbGF0aXZlIHVybHMgdG8gYmUgYWJzb2x1dGUgYWNjb3JkaW5nIHRvIHRoZSBjdXJyZW50IHBhZ2UgbG9jYXRpb24uXG4gKlxuICogQSBydWRpbWVudGFyeSB0ZXN0IHN1aXRlIGlzIGxvY2F0ZWQgYXQgYHRlc3QvZml4VXJscy5qc2AgYW5kIGNhbiBiZSBydW4gdmlhIHRoZSBgbnBtIHRlc3RgIGNvbW1hbmQuXG4gKlxuICovXG5cbm1vZHVsZS5leHBvcnRzID0gZnVuY3Rpb24gKGNzcykge1xuICAvLyBnZXQgY3VycmVudCBsb2NhdGlvblxuICB2YXIgbG9jYXRpb24gPSB0eXBlb2Ygd2luZG93ICE9PSBcInVuZGVmaW5lZFwiICYmIHdpbmRvdy5sb2NhdGlvbjtcblxuICBpZiAoIWxvY2F0aW9uKSB7XG4gICAgdGhyb3cgbmV3IEVycm9yKFwiZml4VXJscyByZXF1aXJlcyB3aW5kb3cubG9jYXRpb25cIik7XG4gIH1cblxuXHQvLyBibGFuayBvciBudWxsP1xuXHRpZiAoIWNzcyB8fCB0eXBlb2YgY3NzICE9PSBcInN0cmluZ1wiKSB7XG5cdCAgcmV0dXJuIGNzcztcbiAgfVxuXG4gIHZhciBiYXNlVXJsID0gbG9jYXRpb24ucHJvdG9jb2wgKyBcIi8vXCIgKyBsb2NhdGlvbi5ob3N0O1xuICB2YXIgY3VycmVudERpciA9IGJhc2VVcmwgKyBsb2NhdGlvbi5wYXRobmFtZS5yZXBsYWNlKC9cXC9bXlxcL10qJC8sIFwiL1wiKTtcblxuXHQvLyBjb252ZXJ0IGVhY2ggdXJsKC4uLilcblx0Lypcblx0VGhpcyByZWd1bGFyIGV4cHJlc3Npb24gaXMganVzdCBhIHdheSB0byByZWN1cnNpdmVseSBtYXRjaCBicmFja2V0cyB3aXRoaW5cblx0YSBzdHJpbmcuXG5cblx0IC91cmxcXHMqXFwoICA9IE1hdGNoIG9uIHRoZSB3b3JkIFwidXJsXCIgd2l0aCBhbnkgd2hpdGVzcGFjZSBhZnRlciBpdCBhbmQgdGhlbiBhIHBhcmVuc1xuXHQgICAoICA9IFN0YXJ0IGEgY2FwdHVyaW5nIGdyb3VwXG5cdCAgICAgKD86ICA9IFN0YXJ0IGEgbm9uLWNhcHR1cmluZyBncm91cFxuXHQgICAgICAgICBbXikoXSAgPSBNYXRjaCBhbnl0aGluZyB0aGF0IGlzbid0IGEgcGFyZW50aGVzZXNcblx0ICAgICAgICAgfCAgPSBPUlxuXHQgICAgICAgICBcXCggID0gTWF0Y2ggYSBzdGFydCBwYXJlbnRoZXNlc1xuXHQgICAgICAgICAgICAgKD86ICA9IFN0YXJ0IGFub3RoZXIgbm9uLWNhcHR1cmluZyBncm91cHNcblx0ICAgICAgICAgICAgICAgICBbXikoXSsgID0gTWF0Y2ggYW55dGhpbmcgdGhhdCBpc24ndCBhIHBhcmVudGhlc2VzXG5cdCAgICAgICAgICAgICAgICAgfCAgPSBPUlxuXHQgICAgICAgICAgICAgICAgIFxcKCAgPSBNYXRjaCBhIHN0YXJ0IHBhcmVudGhlc2VzXG5cdCAgICAgICAgICAgICAgICAgICAgIFteKShdKiAgPSBNYXRjaCBhbnl0aGluZyB0aGF0IGlzbid0IGEgcGFyZW50aGVzZXNcblx0ICAgICAgICAgICAgICAgICBcXCkgID0gTWF0Y2ggYSBlbmQgcGFyZW50aGVzZXNcblx0ICAgICAgICAgICAgICkgID0gRW5kIEdyb3VwXG4gICAgICAgICAgICAgICpcXCkgPSBNYXRjaCBhbnl0aGluZyBhbmQgdGhlbiBhIGNsb3NlIHBhcmVuc1xuICAgICAgICAgICkgID0gQ2xvc2Ugbm9uLWNhcHR1cmluZyBncm91cFxuICAgICAgICAgICogID0gTWF0Y2ggYW55dGhpbmdcbiAgICAgICApICA9IENsb3NlIGNhcHR1cmluZyBncm91cFxuXHQgXFwpICA9IE1hdGNoIGEgY2xvc2UgcGFyZW5zXG5cblx0IC9naSAgPSBHZXQgYWxsIG1hdGNoZXMsIG5vdCB0aGUgZmlyc3QuICBCZSBjYXNlIGluc2Vuc2l0aXZlLlxuXHQgKi9cblx0dmFyIGZpeGVkQ3NzID0gY3NzLnJlcGxhY2UoL3VybFxccypcXCgoKD86W14pKF18XFwoKD86W14pKF0rfFxcKFteKShdKlxcKSkqXFwpKSopXFwpL2dpLCBmdW5jdGlvbihmdWxsTWF0Y2gsIG9yaWdVcmwpIHtcblx0XHQvLyBzdHJpcCBxdW90ZXMgKGlmIHRoZXkgZXhpc3QpXG5cdFx0dmFyIHVucXVvdGVkT3JpZ1VybCA9IG9yaWdVcmxcblx0XHRcdC50cmltKClcblx0XHRcdC5yZXBsYWNlKC9eXCIoLiopXCIkLywgZnVuY3Rpb24obywgJDEpeyByZXR1cm4gJDE7IH0pXG5cdFx0XHQucmVwbGFjZSgvXicoLiopJyQvLCBmdW5jdGlvbihvLCAkMSl7IHJldHVybiAkMTsgfSk7XG5cblx0XHQvLyBhbHJlYWR5IGEgZnVsbCB1cmw/IG5vIGNoYW5nZVxuXHRcdGlmICgvXigjfGRhdGE6fGh0dHA6XFwvXFwvfGh0dHBzOlxcL1xcL3xmaWxlOlxcL1xcL1xcLykvaS50ZXN0KHVucXVvdGVkT3JpZ1VybCkpIHtcblx0XHQgIHJldHVybiBmdWxsTWF0Y2g7XG5cdFx0fVxuXG5cdFx0Ly8gY29udmVydCB0aGUgdXJsIHRvIGEgZnVsbCB1cmxcblx0XHR2YXIgbmV3VXJsO1xuXG5cdFx0aWYgKHVucXVvdGVkT3JpZ1VybC5pbmRleE9mKFwiLy9cIikgPT09IDApIHtcblx0XHQgIFx0Ly9UT0RPOiBzaG91bGQgd2UgYWRkIHByb3RvY29sP1xuXHRcdFx0bmV3VXJsID0gdW5xdW90ZWRPcmlnVXJsO1xuXHRcdH0gZWxzZSBpZiAodW5xdW90ZWRPcmlnVXJsLmluZGV4T2YoXCIvXCIpID09PSAwKSB7XG5cdFx0XHQvLyBwYXRoIHNob3VsZCBiZSByZWxhdGl2ZSB0byB0aGUgYmFzZSB1cmxcblx0XHRcdG5ld1VybCA9IGJhc2VVcmwgKyB1bnF1b3RlZE9yaWdVcmw7IC8vIGFscmVhZHkgc3RhcnRzIHdpdGggJy8nXG5cdFx0fSBlbHNlIHtcblx0XHRcdC8vIHBhdGggc2hvdWxkIGJlIHJlbGF0aXZlIHRvIGN1cnJlbnQgZGlyZWN0b3J5XG5cdFx0XHRuZXdVcmwgPSBjdXJyZW50RGlyICsgdW5xdW90ZWRPcmlnVXJsLnJlcGxhY2UoL15cXC5cXC8vLCBcIlwiKTsgLy8gU3RyaXAgbGVhZGluZyAnLi8nXG5cdFx0fVxuXG5cdFx0Ly8gc2VuZCBiYWNrIHRoZSBmaXhlZCB1cmwoLi4uKVxuXHRcdHJldHVybiBcInVybChcIiArIEpTT04uc3RyaW5naWZ5KG5ld1VybCkgKyBcIilcIjtcblx0fSk7XG5cblx0Ly8gc2VuZCBiYWNrIHRoZSBmaXhlZCBjc3Ncblx0cmV0dXJuIGZpeGVkQ3NzO1xufTtcblxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vbm9kZV9tb2R1bGVzL3N0eWxlLWxvYWRlci9saWIvdXJscy5qc1xuLy8gbW9kdWxlIGlkID0gMTVcbi8vIG1vZHVsZSBjaHVua3MgPSAwIl0sInNvdXJjZVJvb3QiOiIifQ==