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
/******/ 	return __webpack_require__(__webpack_require__.s = 3);
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

        _this.width = _shoot2.default.width;
        _this.height = _shoot2.default.height;
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
    }, {
        key: 'isInside',
        value: function isInside(otherX, otherY) {
            return otherX >= this.x && otherX <= this.x + this.width && otherY >= this.y && otherY <= this.y + this.height;
        }
    }]);

    return Shoot;
}(_Mobile3.default);

exports.default = Shoot;

/***/ }),
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _Game = __webpack_require__(4);

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
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _Starship = __webpack_require__(5);

var _Starship2 = _interopRequireDefault(_Starship);

var _Saucer = __webpack_require__(7);

var _Saucer2 = _interopRequireDefault(_Saucer);

var _Shoot = __webpack_require__(2);

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
        this.infiniteSaucer = false;
        this.intervalSaucer = undefined;
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
            var _this = this;

            this.infiniteSaucer = !this.infiniteSaucer;

            if (this.infiniteSaucer) {
                this.intervalSaucer = window.setInterval(function () {
                    return _this.addSaucer();
                }, 750);
                console.log("infinite saucer on");
            } else {
                console.log("infinite saucer off");
                clearInterval(this.intervalSaucer);
            }
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
        key: 'updateScoreOnLostSaucer',
        value: function updateScoreOnLostSaucer() {
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
        key: 'setHTMLScore',
        value: function setHTMLScore(scoreSpan) {
            this.scoreSpan = scoreSpan;
        }
    }, {
        key: 'updateScoreSpan',
        value: function updateScoreSpan() {
            this.scoreSpan.innerHTML = this.score;
        }
    }, {
        key: 'animate',
        value: function animate() {
            var _this2 = this;

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

            var x = void 0;
            var y = void 0;
            this.shoots.forEach(function (shoot) {
                x = shoot.x;
                y = shoot.y;
                _this2.saucers = _this2.saucers.filter(function (saucer) {
                    return !saucer.collisionWith(x, y, _this2);
                });
            });

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
    }]);

    return Game;
}();

exports.default = Game;

/***/ }),
/* 5 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", {
    value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _get = function get(object, property, receiver) { if (object === null) object = Function.prototype; var desc = Object.getOwnPropertyDescriptor(object, property); if (desc === undefined) { var parent = Object.getPrototypeOf(object); if (parent === null) { return undefined; } else { return get(parent, property, receiver); } } else if ("value" in desc) { return desc.value; } else { var getter = desc.get; if (getter === undefined) { return undefined; } return getter.call(receiver); } };

var _Mobile2 = __webpack_require__(0);

var _Mobile3 = _interopRequireDefault(_Mobile2);

var _vaisseauBallonPetit = __webpack_require__(6);

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
/* 6 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "images/imge1bf45cee89f1ffc97d7cab6c41bd7c8.png";

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

var _flyingSaucerPetit = __webpack_require__(1);

var _flyingSaucerPetit2 = _interopRequireDefault(_flyingSaucerPetit);

var _Shoot = __webpack_require__(2);

var _Shoot2 = _interopRequireDefault(_Shoot);

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
    }, {
        key: 'collisionWith',
        value: function collisionWith(x, y, game) {
            var shoot = new _Shoot2.default(this.myCanvas, x, y, game);
            return shoot.isInside(shoot.x, shoot.y);
        }
    }]);

    return Saucer;
}(_Mobile3.default);

exports.default = Saucer;

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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8vd2VicGFjay9ib290c3RyYXAgZGNkN2E1ZjYwOTQxMzA0YzNkMjkiLCJ3ZWJwYWNrOi8vLy4vc3JjL3NjcmlwdHMvTW9iaWxlLmpzIiwid2VicGFjazovLy8uL3NyYy9pbWFnZXMvZmx5aW5nU2F1Y2VyLXBldGl0LnBuZyIsIndlYnBhY2s6Ly8vLi9zcmMvc2NyaXB0cy9TaG9vdC5qcyIsIndlYnBhY2s6Ly8vLi9zcmMvc2NyaXB0cy9tYWluLmpzIiwid2VicGFjazovLy8uL3NyYy9zY3JpcHRzL0dhbWUuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL3NjcmlwdHMvU3RhcnNoaXAuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL2ltYWdlcy92YWlzc2VhdS1iYWxsb24tcGV0aXQucG5nIiwid2VicGFjazovLy8uL3NyYy9zY3JpcHRzL1NhdWNlci5qcyIsIndlYnBhY2s6Ly8vLi9zcmMvaW1hZ2VzL3Nob290LnBuZyIsIndlYnBhY2s6Ly8vLi9zcmMvc3R5bGUvc3R5bGUuY3NzPzc4OTAiLCJ3ZWJwYWNrOi8vLy4vc3JjL3N0eWxlL3N0eWxlLmNzcyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qcyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvY3NzLWJhc2UuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL2ltYWdlcy9jaWVsLW5vY3R1cm5lLnBuZyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvc3R5bGUtbG9hZGVyL2xpYi9hZGRTdHlsZXMuanMiLCJ3ZWJwYWNrOi8vLy4vbm9kZV9tb2R1bGVzL3N0eWxlLWxvYWRlci9saWIvdXJscy5qcyJdLCJuYW1lcyI6WyJNb2JpbGUiLCJhQ2FudmFzIiwic3JjSW1hZ2UiLCJ4IiwieSIsInZ4IiwidnkiLCJteUNhbnZhcyIsImNvbnRleHQiLCJnZXRDb250ZXh0IiwiaW1nTW9iaWxlIiwiSW1hZ2UiLCJpbWdMb2FkZWQiLCJhZGRFdmVudExpc3RlbmVyIiwiaW1nTG9hZExpc3RlbmVyIiwiYmluZCIsInNyYyIsImRyYXdJbWFnZSIsIlNob290IiwiZ2FtZSIsIndpZHRoIiwiaGVpZ2h0IiwicmVtb3ZlU2hvb3QiLCJvdGhlclgiLCJvdGhlclkiLCJzZXR1cEdhbWUiLCJ0aGVDYW52YXMiLCJjb25zdHJ1Y3RvciIsInVuZGVmaW5lZCIsIk9iamVjdCIsImdldFByb3RvdHlwZU9mIiwid2luZG93Iiwia2V5RG93bkFjdGlvbkhhbmRsZXIiLCJrZXlVcEFjdGlvbkhhbmRsZXIiLCJzY29yZVNwYW4iLCJkb2N1bWVudCIsImdldEVsZW1lbnRCeUlkIiwic2V0SFRNTFNjb3JlIiwic2V0dXBCdXR0b25zIiwibmV3U2F1Y2VyQnV0dG9uIiwiYWRkU2F1Y2VyIiwiaW5maW5pdGVTYXVjZXJzIiwic2V0dXAiLCJhbmltYXRlIiwiR2FtZSIsInJhZiIsInN0YXJzaGlwIiwic2F1Y2VycyIsInNob290cyIsInNjb3JlIiwiZmlyc3REcmF3IiwiaW5maW5pdGVTYXVjZXIiLCJpbnRlcnZhbFNhdWNlciIsIk1hdGgiLCJmbG9vciIsInJhbmRvbSIsInB1c2giLCJzZXRJbnRlcnZhbCIsImNvbnNvbGUiLCJsb2ciLCJjbGVhckludGVydmFsIiwic2F1Y2VyIiwiZmlsdGVyIiwiZSIsInVwZGF0ZVNjb3JlT25Mb3N0U2F1Y2VyIiwic2hvb3QiLCJ1cGRhdGVkU2NvcmUiLCJ1cGRhdGVTY29yZVNwYW4iLCJpbm5lckhUTUwiLCJjbGVhclJlY3QiLCJpc01vdmluZyIsIm1vdmUiLCJkcmF3Iiwic2luZ2xlU2F1Y2VyIiwic2luZ2xlU2hvb3QiLCJmb3JFYWNoIiwiY29sbGlzaW9uV2l0aCIsInJlcXVlc3RBbmltYXRpb25GcmFtZSIsImV2ZW50Iiwia2V5Q29kZSIsImFkZFNob290Iiwia2V5IiwibW92ZVVwIiwibW92ZURvd24iLCJwcmV2ZW50RGVmYXVsdCIsInN0b3BNb3ZlIiwiTW92ZVN0YXRlIiwiVVAiLCJET1dOIiwiTk9ORSIsIlN0YXJzaGlwIiwiaW5pdFgiLCJpbml0WSIsIm1vdmluZyIsIm9nVlkiLCJvZ1ZYIiwiY2FsY1kiLCJ2YWxpZE1vdmUiLCJjYWxjWCIsIlNhdWNlciIsInJlbW92ZVNhdWNlciIsImlzSW5zaWRlIl0sIm1hcHBpbmdzIjoiO0FBQUE7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7OztBQUdBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBLGFBQUs7QUFDTDtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBLG1DQUEyQiwwQkFBMEIsRUFBRTtBQUN2RCx5Q0FBaUMsZUFBZTtBQUNoRDtBQUNBO0FBQ0E7O0FBRUE7QUFDQSw4REFBc0QsK0RBQStEOztBQUVySDtBQUNBOztBQUVBO0FBQ0E7Ozs7Ozs7Ozs7Ozs7Ozs7OztJQzdEcUJBLE07QUFDakIsb0JBQVlDLE9BQVosRUFBcUJDLFFBQXJCLEVBQStCQyxDQUEvQixFQUFrQ0MsQ0FBbEMsRUFBcUNDLEVBQXJDLEVBQXlDQyxFQUF6QyxFQUE2QztBQUFBOztBQUN6QyxhQUFLQyxRQUFMLEdBQWdCTixPQUFoQjtBQUNBLGFBQUtPLE9BQUwsR0FBZSxLQUFLRCxRQUFMLENBQWNFLFVBQWQsQ0FBeUIsSUFBekIsQ0FBZjs7QUFFQSxhQUFLQyxTQUFMLEdBQWlCLElBQUlDLEtBQUosRUFBakI7QUFDQSxhQUFLQyxTQUFMLEdBQWlCLEtBQWpCO0FBQ0EsYUFBS0YsU0FBTCxDQUFlRyxnQkFBZixDQUFnQyxNQUFoQyxFQUF3QyxLQUFLQyxlQUFMLENBQXFCQyxJQUFyQixDQUEwQixJQUExQixDQUF4QztBQUNBLGFBQUtMLFNBQUwsQ0FBZU0sR0FBZixHQUFxQmQsUUFBckI7O0FBRUEsYUFBS0MsQ0FBTCxHQUFTQSxDQUFUO0FBQ0EsYUFBS0MsQ0FBTCxHQUFTQSxDQUFUO0FBQ0Es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SDtBQUNBO0FBQ0E7QUFDQSxFQUFFO0FBQ0Y7QUFDQSxFQUFFO0FBQ0Y7QUFDQTtBQUNBLEVBQUU7QUFDRjtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQSxFQUFFO0FBQ0Y7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQSxNQUFNO0FBQ047QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTs7QUFFQTtBQUNBOztBQUVBLEVBQUU7QUFDRjtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQSxFQUFFO0FBQ0Y7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBLEdBQUc7QUFDSDtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBLENBQUM7O0FBRUQ7QUFDQTs7QUFFQTtBQUNBO0FBQ0EsRUFBRTtBQUNGO0FBQ0E7O0FBRUE7O0FBRUE7QUFDQTtBQUNBLEdBQUc7QUFDSDtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQSxFQUFFO0FBQ0Y7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQSx1REFBdUQ7QUFDdkQ7O0FBRUEsNkJBQTZCLG1CQUFtQjs7QUFFaEQ7O0FBRUE7O0FBRUE7QUFDQTs7Ozs7Ozs7QUM1V0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7O0FBRUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0Esd0NBQXdDLFdBQVcsRUFBRTtBQUNyRCx3Q0FBd0MsV0FBVyxFQUFFOztBQUVyRDtBQUNBO0FBQ0E7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBLEdBQUc7QUFDSDtBQUNBLHNDQUFzQztBQUN0QyxHQUFHO0FBQ0g7QUFDQSw4REFBOEQ7QUFDOUQ7O0FBRUE7QUFDQTtBQUNBLEVBQUU7O0FBRUY7QUFDQTtBQUNBIiwiZmlsZSI6InNjcmlwdHMvYnVuZGxlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiIFx0Ly8gVGhlIG1vZHVsZSBjYWNoZVxuIFx0dmFyIGluc3RhbGxlZE1vZHVsZXMgPSB7fTtcblxuIFx0Ly8gVGhlIHJlcXVpcmUgZnVuY3Rpb25cbiBcdGZ1bmN0aW9uIF9fd2VicGFja19yZXF1aXJlX18obW9kdWxlSWQpIHtcblxuIFx0XHQvLyBDaGVjayBpZiBtb2R1bGUgaXMgaW4gY2FjaGVcbiBcdFx0aWYoaW5zdGFsbGVkTW9kdWxlc1ttb2R1bGVJZF0pIHtcbiBcdFx0XHRyZXR1cm4gaW5zdGFsbGVkTW9kdWxlc1ttb2R1bGVJZF0uZXhwb3J0cztcbiBcdFx0fVxuIFx0XHQvLyBDcmVhdGUgYSBuZXcgbW9kdWxlIChhbmQgcHV0IGl0IGludG8gdGhlIGNhY2hlKVxuIFx0XHR2YXIgbW9kdWxlID0gaW5zdGFsbGVkTW9kdWxlc1ttb2R1bGVJZF0gPSB7XG4gXHRcdFx0aTogbW9kdWxlSWQsXG4gXHRcdFx0bDogZmFsc2UsXG4gXHRcdFx0ZXhwb3J0czoge31cbiBcdFx0fTtcblxuIFx0XHQvLyBFeGVjdXRlIHRoZSBtb2R1bGUgZnVuY3Rpb25cbiBcdFx0bW9kdWxlc1ttb2R1bGVJZF0uY2FsbChtb2R1bGUuZXhwb3J0cywgbW9kdWxlLCBtb2R1bGUuZXhwb3J0cywgX193ZWJwYWNrX3JlcXVpcmVfXyk7XG5cbiBcdFx0Ly8gRmxhZyB0aGUgbW9kdWxlIGFzIGxvYWRlZFxuIFx0XHRtb2R1bGUubCA9IHRydWU7XG5cbiBcdFx0Ly8gUmV0dXJuIHRoZSBleHBvcnRzIG9mIHRoZSBtb2R1bGVcbiBcdFx0cmV0dXJuIG1vZHVsZS5leHBvcnRzO1xuIFx0fVxuXG5cbiBcdC8vIGV4cG9zZSB0aGUgbW9kdWxlcyBvYmplY3QgKF9fd2VicGFja19tb2R1bGVzX18pXG4gXHRfX3dlYnBhY2tfcmVxdWlyZV9fLm0gPSBtb2R1bGVzO1xuXG4gXHQvLyBleHBvc2UgdGhlIG1vZHVsZSBjYWNoZVxuIFx0X193ZWJwYWNrX3JlcXVpcmVfXy5jID0gaW5zdGFsbGVkTW9kdWxlcztcblxuIFx0Ly8gZGVmaW5lIGdldHRlciBmdW5jdGlvbiBmb3IgaGFybW9ueSBleHBvcnRzXG4gXHRfX3dlYnBhY2tfcmVxdWlyZV9fLmQgPSBmdW5jdGlvbihleHBvcnRzLCBuYW1lLCBnZXR0ZXIpIHtcbiBcdFx0aWYoIV9fd2VicGFja19yZXF1aXJlX18ubyhleHBvcnRzLCBuYW1lKSkge1xuIFx0XHRcdE9iamVjdC5kZWZpbmVQcm9wZXJ0eShleHBvcnRzLCBuYW1lLCB7XG4gXHRcdFx0XHRjb25maWd1cmFibGU6IGZhbHNlLFxuIFx0XHRcdFx0ZW51bWVyYWJsZTogdHJ1ZSxcbiBcdFx0XHRcdGdldDogZ2V0dGVyXG4gXHRcdFx0fSk7XG4gXHRcdH1cbiBcdH07XG5cbiBcdC8vIGdldERlZmF1bHRFeHBvcnQgZnVuY3Rpb24gZm9yIGNvbXBhdGliaWxpdHkgd2l0aCBub24taGFybW9ueSBtb2R1bGVzXG4gXHRfX3dlYnBhY2tfcmVxdWlyZV9fLm4gPSBmdW5jdGlvbihtb2R1bGUpIHtcbiBcdFx0dmFyIGdldHRlciA9IG1vZHVsZSAmJiBtb2R1bGUuX19lc01vZHVsZSA/XG4gXHRcdFx0ZnVuY3Rpb24gZ2V0RGVmYXVsdCgpIHsgcmV0dXJuIG1vZHVsZVsnZGVmYXVsdCddOyB9IDpcbiBcdFx0XHRmdW5jdGlvbiBnZXRNb2R1bGVFeHBvcnRzKCkgeyByZXR1cm4gbW9kdWxlOyB9O1xuIFx0XHRfX3dlYnBhY2tfcmVxdWlyZV9fLmQoZ2V0dGVyLCAnYScsIGdldHRlcik7XG4gXHRcdHJldHVybiBnZXR0ZXI7XG4gXHR9O1xuXG4gXHQvLyBPYmplY3QucHJvdG90eXBlLmhhc093blByb3BlcnR5LmNhbGxcbiBcdF9fd2VicGFja19yZXF1aXJlX18ubyA9IGZ1bmN0aW9uKG9iamVjdCwgcHJvcGVydHkpIHsgcmV0dXJuIE9iamVjdC5wcm90b3R5cGUuaGFzT3duUHJvcGVydHkuY2FsbChvYmplY3QsIHByb3BlcnR5KTsgfTtcblxuIFx0Ly8gX193ZWJwYWNrX3B1YmxpY19wYXRoX19cbiBcdF9fd2VicGFja19yZXF1aXJlX18ucCA9IFwiXCI7XG5cbiBcdC8vIExvYWQgZW50cnkgbW9kdWxlIGFuZCByZXR1cm4gZXhwb3J0c1xuIFx0cmV0dXJuIF9fd2VicGFja19yZXF1aXJlX18oX193ZWJwYWNrX3JlcXVpcmVfXy5zID0gMyk7XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gd2VicGFjay9ib290c3RyYXAgZGNkN2E1ZjYwOTQxMzA0YzNkMjkiLCJleHBvcnQgZGVmYXVsdCBjbGFzcyBNb2JpbGUge1xuICAgIGNvbnN0cnVjdG9yKGFDYW52YXMsIHNyY0ltYWdlLCB4LCB5LCB2eCwgdnkpIHtcbiAgICAgICAgdGhpcy5teUNhbnZhcyA9IGFDYW52YXM7XG4gICAgICAgIHRoaXMuY29udGV4dCA9IHRoaXMubXlDYW52YXMuZ2V0Q29udGV4dChcIjJkXCIpO1xuXG4gICAgICAgIHRoaXMuaW1nTW9iaWxlID0gbmV3IEltYWdlKCk7XG4gICAgICAgIHRoaXMuaW1nTG9hZGVkID0gZmFsc2U7XG4gICAgICAgIHRoaXMuaW1nTW9iaWxlLmFkZEV2ZW50TGlzdGVuZXIoXCJsb2FkXCIsIHRoaXMuaW1nTG9hZExpc3RlbmVyLmJpbmQodGhpcykpO1xuICAgICAgICB0aGlzLmltZ01vYmlsZS5zcmMgPSBzcmNJbWFnZTtcblxuICAgICAgICB0aGlzLnggPSB4O1xuICAgICAgICB0aGlzLnkgPSB5O1xuICAgICAgICB0aGlzLnZ4ID0gdng7XG4gICAgICAgIHRoaXMudnkgPSB2eTtcbiAgICB9XG5cbiAgICBkcmF3KCkge1xuICAgICAgICBpZiAodGhpcy5pbWdMb2FkZWQgPT09IHRydWUpIHtcbiAgICAgICAgICAgIHRoaXMuY29udGV4dC5kcmF3SW1hZ2UodGhpcy5pbWdNb2JpbGUsIHRoaXMueCwgdGhpcy55KTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIG1vdmUoKSB7XG4gICAgICAgIHRoaXMueCArPSB0aGlzLnZ4O1xuICAgICAgICB0aGlzLnkgKz0gdGhpcy52eTtcbiAgICB9XG5cbiAgICBpbWdMb2FkTGlzdGVuZXIoKSB7XG4gICAgICAgIHRoaXMuaW1nTG9hZGVkID0gdHJ1ZTtcbiAgICB9XG59XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gLi9zcmMvc2NyaXB0cy9Nb2JpbGUuanMiLCJtb2R1bGUuZXhwb3J0cyA9IF9fd2VicGFja19wdWJsaWNfcGF0aF9fICsgXCJpbWFnZXMvaW1nYjNlZDUwMGJhYjk2ZWNkODIwNTJhMmFlZGY5YjJlMDQucG5nXCI7XG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvaW1hZ2VzL2ZseWluZ1NhdWNlci1wZXRpdC5wbmdcbi8vIG1vZHVsZSBpZCA9IDFcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiaW1wb3J0IE1vYmlsZSBmcm9tICcuL01vYmlsZS5qcyc7XG5pbXBvcnQgc2hvb3QgZnJvbSAnLi4vaW1hZ2VzL3Nob290LnBuZyc7XG5cbmV4cG9ydCBkZWZhdWx0IGNsYXNzIFNob290IGV4dGVuZHMgTW9iaWxlIHtcbiAgICBjb25zdHJ1Y3RvcihhQ2FudmFzLCB4LCB5LCBnYW1lKSB7XG4gICAgICAgIHN1cGVyKGFDYW52YXMsIHNob290LCB4LCB5LCA4LCAwKTtcbiAgICAgICAgdGhpcy53aWR0aCA9IHNob290LndpZHRoO1xuICAgICAgICB0aGlzLmhlaWdodCA9IHNob290LmhlaWdodDtcbiAgICAgICAgdGhpcy5nYW1lID0gZ2FtZTtcbiAgICB9XG5cbiAgICBtb3ZlKCl7XG4gICAgICAgIHN1cGVyLm1vdmUoKTtcblxuICAgICAgICBpZiAodGhpcy54ID49IHRoaXMubXlDYW52YXMud2lkdGgpIHtcbiAgICAgICAgICAgIHRoaXMuZ2FtZS5yZW1vdmVTaG9vdCh0aGlzKTtcbiAgICAgICAgfVxuICAgIH1cbiAgICBpc0luc2lkZShvdGhlclgsIG90aGVyWSkge1xuICAgICAgICByZXR1cm4gKG90aGVyWCA+PSB0aGlzLnggJiYgb3RoZXJYIDw9ICh0aGlzLnggKyB0aGlzLndpZHRoKSAmJiBvdGhlclkgPj0gdGhpcy55ICYmIG90aGVyWSA8PSAodGhpcy55ICsgdGhpcy5oZWlnaHQpKTtcbiAgICB9XG59XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gLi9zcmMvc2NyaXB0cy9TaG9vdC5qcyIsImltcG9ydCBHYW1lIGZyb20gJy4vR2FtZS5qcyc7XG5cbmltcG9ydCAnLi4vc3R5bGUvc3R5bGUuY3NzJztcbmltcG9ydCBzYXVjZXJTcmMgZnJvbSAnLi4vaW1hZ2VzL2ZseWluZ1NhdWNlci1wZXRpdC5wbmcnO1xuXG5cbmZ1bmN0aW9uIHNldHVwR2FtZSh0aGVDYW52YXMpIHtcbiAgICBsZXQgZ2FtZSA9IG5ldyBHYW1lKHRoZUNhbnZhcyk7XG4gICAgZ2FtZS5jb25zdHJ1Y3RvciA9IHVuZGVmaW5lZDtcbiAgICBPYmplY3QuZ2V0UHJvdG90eXBlT2YoZ2FtZSkuY29uc3RydWN0b3IgPSB1bmRlZmluZWQ7XG5cbiAgICB3aW5kb3cuYWRkRXZlbnRMaXN0ZW5lcigna2V5ZG93bicsIGdhbWUua2V5RG93bkFjdGlvbkhhbmRsZXIuYmluZChnYW1lKSk7XG4gICAgd2luZG93LmFkZEV2ZW50TGlzdGVuZXIoJ2tleXVwJywgZ2FtZS5rZXlVcEFjdGlvbkhhbmRsZXIuYmluZChnYW1lKSk7XG5cbiAgICBsZXQgc2NvcmVTcGFuID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJzY29yZVwiKTtcbiAgICBnYW1lLnNldEhUTUxTY29yZShzY29yZVNwYW4pO1xuXG4gICAgcmV0dXJuIGdhbWU7XG59XG5cbmZ1bmN0aW9uIHNldHVwQnV0dG9ucyhnYW1lKSB7XG4gICAgbGV0IG5ld1NhdWNlckJ1dHRvbiA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwibm91dmVsbGVTb3Vjb3VwZVwiKTtcbiAgICBuZXdTYXVjZXJCdXR0b24uYWRkRXZlbnRMaXN0ZW5lcihcImNsaWNrXCIsIGdhbWUuYWRkU2F1Y2VyLmJpbmQoZ2FtZSkpO1xuICAgIGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwibmV3U2F1Y2VyQnV0dG9uSW1nXCIpLnNyYyA9IHNhdWNlclNyYztcblxuICAgIGxldCBpbmZpbml0ZVNhdWNlcnMgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcImZsb3R0ZVNvdWNvdXBlc1wiKTtcbiAgICBpbmZpbml0ZVNhdWNlcnMuYWRkRXZlbnRMaXN0ZW5lcihcImNsaWNrXCIsIGdhbWUuaW5maW5pdGVTYXVjZXJzLmJpbmQoZ2FtZSkpO1xuICAgIGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwiaW5maW5pdGVTYXVjZXJzQnV0dG9uSW1nXCIpLnNyYyA9IHNhdWNlclNyYztcbn1cblxudmFyIHNldHVwID0gZnVuY3Rpb24gKCkge1xuICAgIGxldCB0aGVDYW52YXMgPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcInN0YXJzXCIpO1xuICAgIGxldCBnYW1lID0gc2V0dXBHYW1lKHRoZUNhbnZhcyk7XG5cbiAgICBzZXR1cEJ1dHRvbnMoZ2FtZSk7XG5cbiAgICBnYW1lLmFuaW1hdGUoKTtcblxufTtcblxud2luZG93LmFkZEV2ZW50TGlzdGVuZXIoXCJET01Db250ZW50TG9hZGVkXCIsIHNldHVwKTtcblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL21haW4uanMiLCJpbXBvcnQgU3RhcnNoaXAgZnJvbSAnLi9TdGFyc2hpcC5qcyc7XG5pbXBvcnQgU2F1Y2VyIGZyb20gJy4vU2F1Y2VyLmpzJztcbmltcG9ydCBTaG9vdCBmcm9tIFwiLi9TaG9vdFwiO1xuXG5cbmV4cG9ydCBkZWZhdWx0IGNsYXNzIEdhbWUge1xuICAgIGNvbnN0cnVjdG9yKGFDYW52YXMpIHtcbiAgICAgICAgdGhpcy5teUNhbnZhcyA9IGFDYW52YXM7XG4gICAgICAgIHRoaXMucmFmID0gdW5kZWZpbmVkO1xuICAgICAgICB0aGlzLmNvbnRleHQgPSB0aGlzLm15Q2FudmFzLmdldENvbnRleHQoJzJkJyk7XG5cbiAgICAgICAgdGhpcy5zdGFyc2hpcCA9IG5ldyBTdGFyc2hpcCh0aGlzLm15Q2FudmFzLCA0MCwgdGhpcy5teUNhbnZhcy5oZWlnaHQgLyAyKTtcblxuICAgICAgICB0aGlzLnNhdWNlcnMgPSBbXTtcbiAgICAgICAgdGhpcy5zaG9vdHMgPSBbXVxuICAgICAgICB0aGlzLnNjb3JlID0gMDtcblxuICAgICAgICB0aGlzLmZpcnN0RHJhdyA9IHRydWU7XG4gICAgICAgIHRoaXMuaW5maW5pdGVTYXVjZXIgPSBmYWxzZTtcbiAgICAgICAgdGhpcy5pbnRlcnZhbFNhdWNlciA9IHVuZGVmaW5lZDtcbiAgICAgICAgdGhpcy5zY29yZVNwYW4gPSB1bmRlZmluZWQ7XG4gICAgfVxuXG5cbiAgICBhZGRTYXVjZXIoKSB7XG4gICAgICAgIGxldCB4ID0gdGhpcy5teUNhbnZhcy53aWR0aDtcbiAgICAgICAgbGV0IHkgPSBNYXRoLmZsb29yKE1hdGgucmFuZG9tKCkgKiB0aGlzLm15Q2FudmFzLmhlaWdodCk7XG5cbiAgICAgICAgdGhpcy5zYXVjZXJzLnB1c2gobmV3IFNhdWNlcih0aGlzLm15Q2FudmFzLCB4LCB5LCB0aGlzKSk7XG4gICAgfVxuXG4gICAgaW5maW5pdGVTYXVjZXJzKCkge1xuICAgICAgICB0aGlzLmluZmluaXRlU2F1Y2VyID0gIXRoaXMuaW5maW5pdGVTYXVjZXI7XG5cbiAgICAgICAgaWYgKHRoaXMuaW5maW5pdGVTYXVjZXIpIHtcbiAgICAgICAgICAgIHRoaXMuaW50ZXJ2YWxTYXVjZXIgPSB3aW5kb3cuc2V0SW50ZXJ2YWwoKCkgPT4gdGhpcy5hZGRTYXVjZXIoKSwgNzUwKTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwiaW5maW5pdGUgc2F1Y2VyIG9uXCIpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coXCJpbmZpbml0ZSBzYXVjZXIgb2ZmXCIpO1xuICAgICAgICAgICAgY2xlYXJJbnRlcnZhbCh0aGlzLmludGVydmFsU2F1Y2VyKTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIHJlbW92ZVNhdWNlcihzYXVjZXIpIHtcbiAgICAgICAgdGhpcy5zYXVjZXJzID0gdGhpcy5zYXVjZXJzLmZpbHRlcihlID0+IGUgIT09IHNhdWNlcik7XG4gICAgICAgIHRoaXMudXBkYXRlU2NvcmVPbkxvc3RTYXVjZXIoKTtcbiAgICB9XG5cbiAgICBhZGRTaG9vdCgpIHtcbiAgICAgICAgbGV0IHggPSB0aGlzLnN0YXJzaGlwLng7XG4gICAgICAgIGxldCB5ID0gdGhpcy5zdGFyc2hpcC55O1xuXG4gICAgICAgIHRoaXMuc2hvb3RzLnB1c2gobmV3IFNob290KHRoaXMubXlDYW52YXMsIHgsIHksIHRoaXMpKTtcbiAgICB9XG5cbiAgICByZW1vdmVTaG9vdChzaG9vdCkge1xuICAgICAgICB0aGlzLnNob290cyA9IHRoaXMuc2hvb3RzLmZpbHRlcihlID0+IGUgIT09IHNob290KTtcbiAgICB9XG5cbiAgICBzZXRTY29yZSh1cGRhdGVkU2NvcmUpIHtcbiAgICAgICAgdGhpcy5zY29yZSA9IHVwZGF0ZWRTY29yZTtcbiAgICB9XG5cbiAgICB1cGRhdGVTY29yZU9uTG9zdFNhdWNlcigpIHtcbiAgICAgICAgdGhpcy5zY29yZSAtPSAxMDAwO1xuICAgICAgICB0aGlzLnVwZGF0ZVNjb3JlU3BhbigpO1xuICAgIH1cblxuICAgIHVwZGF0ZVNjb3JlT25TYXVjZXJTaG90RG93bigpIHtcbiAgICAgICAgdGhpcy5zY29yZSArPSAyMDA7XG4gICAgICAgIHRoaXMudXBkYXRlU2NvcmVTcGFuKCk7XG4gICAgfVxuXG4gICAgc2V0SFRNTFNjb3JlKHNjb3JlU3Bhbikge1xuICAgICAgICB0aGlzLnNjb3JlU3BhbiA9IHNjb3JlU3BhbjtcbiAgICB9XG5cbiAgICB1cGRhdGVTY29yZVNwYW4oKSB7XG4gICAgICAgIHRoaXMuc2NvcmVTcGFuLmlubmVySFRNTCA9IHRoaXMuc2NvcmU7XG4gICAgfVxuXG4gICAgYW5pbWF0ZSgpIHtcbiAgICAgICAgdGhpcy5jb250ZXh0LmNsZWFyUmVjdCgwLCAwLCB0aGlzLm15Q2FudmFzLndpZHRoLCB0aGlzLm15Q2FudmFzLmhlaWdodCk7XG5cbiAgICAgICAgaWYgKHRoaXMuZmlyc3REcmF3IHx8IHRoaXMuc3RhcnNoaXAuaXNNb3ZpbmcoKSkge1xuICAgICAgICAgICAgdGhpcy5zdGFyc2hpcC5tb3ZlKHRoaXMpO1xuICAgICAgICAgICAgdGhpcy5maXJzdERyYXcgPSBmYWxzZTtcbiAgICAgICAgfVxuICAgICAgICB0aGlzLnN0YXJzaGlwLmRyYXcoKTtcblxuICAgICAgICBmb3IgKGxldCBzaW5nbGVTYXVjZXIgb2YgdGhpcy5zYXVjZXJzKSB7XG4gICAgICAgICAgICBzaW5nbGVTYXVjZXIubW92ZSgpO1xuICAgICAgICAgICAgc2luZ2xlU2F1Y2VyLmRyYXcoKTtcbiAgICAgICAgfVxuXG4gICAgICAgIGZvciAobGV0IHNpbmdsZVNob290IG9mIHRoaXMuc2hvb3RzKSB7XG4gICAgICAgICAgICBzaW5nbGVTaG9vdC5tb3ZlKCk7XG4gICAgICAgICAgICBzaW5nbGVTaG9vdC5kcmF3KCk7XG4gICAgICAgIH1cbiAgICAgICAgbGV0IHg7XG4gICAgICAgIGxldCB5O1xuICAgICAgICB0aGlzLnNob290cy5mb3JFYWNoKHNob290ID0+IHtcbiAgICAgICAgICAgIHggPSBzaG9vdC54O1xuICAgICAgICAgICAgeSA9IHNob290Lnk7XG4gICAgICAgICAgICB0aGlzLnNhdWNlcnMgPSB0aGlzLnNhdWNlcnMuZmlsdGVyKHNhdWNlciA9PiAhc2F1Y2VyLmNvbGxpc2lvbldpdGgoeCwgeSwgdGhpcykpO1xuICAgICAgICB9KTtcblxuICAgICAgICB0aGlzLnJhZiA9IHdpbmRvdy5yZXF1ZXN0QW5pbWF0aW9uRnJhbWUodGhpcy5hbmltYXRlLmJpbmQodGhpcykpO1xuICAgIH1cblxuICAgIGtleURvd25BY3Rpb25IYW5kbGVyKGV2ZW50KSB7XG4gICAgICAgIGlmIChldmVudC5rZXlDb2RlID09PSAzMikge1xuICAgICAgICAgICAgdGhpcy5hZGRTaG9vdCgpO1xuICAgICAgICAgICAgY29uc29sZS5sb2coXCJzaG9vdFwiKTtcbiAgICAgICAgfVxuXG4gICAgICAgIHN3aXRjaCAoZXZlbnQua2V5KSB7XG4gICAgICAgICAgICBjYXNlIFwiQXJyb3dVcFwiOlxuICAgICAgICAgICAgY2FzZSBcIlVwXCI6XG4gICAgICAgICAgICAgICAgdGhpcy5zdGFyc2hpcC5tb3ZlVXAoKTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgXCJBcnJvd0Rvd25cIjpcbiAgICAgICAgICAgIGNhc2UgXCJEb3duXCI6XG4gICAgICAgICAgICAgICAgdGhpcy5zdGFyc2hpcC5tb3ZlRG93bigpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgIH1cblxuICAgICAgICBldmVudC5wcmV2ZW50RGVmYXVsdCgpO1xuICAgIH1cblxuXG4gICAga2V5VXBBY3Rpb25IYW5kbGVyKGV2ZW50KSB7XG5cbiAgICAgICAgc3dpdGNoIChldmVudC5rZXkpIHtcbiAgICAgICAgICAgIGNhc2UgXCJBcnJvd1VwXCI6XG4gICAgICAgICAgICBjYXNlIFwiVXBcIjpcbiAgICAgICAgICAgIGNhc2UgXCJBcnJvd0Rvd25cIjpcbiAgICAgICAgICAgIGNhc2UgXCJEb3duXCI6XG4gICAgICAgICAgICAgICAgdGhpcy5zdGFyc2hpcC5zdG9wTW92ZSgpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgIH1cbiAgICAgICAgZXZlbnQucHJldmVudERlZmF1bHQoKTtcbiAgICB9XG59XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gLi9zcmMvc2NyaXB0cy9HYW1lLmpzIiwiaW1wb3J0IE1vYmlsZSBmcm9tICcuL01vYmlsZS5qcydcbmltcG9ydCBzdGFyc2hpcFNyYyBmcm9tICcuLi9pbWFnZXMvdmFpc3NlYXUtYmFsbG9uLXBldGl0LnBuZyc7XG5cbnZhciBNb3ZlU3RhdGUgPSB7VVA6IDAsIERPV046IDEsIE5PTkU6IDJ9O1xuXG5leHBvcnQgZGVmYXVsdCBjbGFzcyBTdGFyc2hpcCBleHRlbmRzIE1vYmlsZSB7XG4gICAgY29uc3RydWN0b3IoYUNhbnZhcywgaW5pdFgsIGluaXRZKSB7XG4gICAgICAgIHN1cGVyKGFDYW52YXMsIHN0YXJzaGlwU3JjLCBpbml0WCwgaW5pdFksIDAsIDgpO1xuICAgICAgICB0aGlzLm1vdmluZyA9IE1vdmVTdGF0ZS5OT05FO1xuXG4gICAgICAgIHRoaXMub2dWWSA9IHRoaXMudnk7XG4gICAgICAgIHRoaXMub2dWWCA9IHRoaXMudng7XG4gICAgfVxuXG4gICAgZ2V0IHVwKCkge1xuICAgICAgICByZXR1cm4gdGhpcy5tb3ZpbmcgPT09IE1vdmVTdGF0ZS5VUDtcbiAgICB9XG5cbiAgICBnZXQgZG93bigpIHtcbiAgICAgICAgcmV0dXJuIHRoaXMubW92aW5nID09PSBNb3ZlU3RhdGUuRE9XTjtcbiAgICB9XG5cbiAgICBtb3ZlVXAoKSB7XG4gICAgICAgIHRoaXMubW92aW5nID0gTW92ZVN0YXRlLlVQO1xuICAgIH1cblxuICAgIG1vdmVEb3duKCkge1xuICAgICAgICB0aGlzLm1vdmluZyA9IE1vdmVTdGF0ZS5ET1dOO1xuICAgIH1cblxuICAgIG1vdmUoKSB7XG4gICAgICAgIGxldCBjYWxjWTtcbiAgICAgICAgaWYgKHRoaXMubW92aW5nID09PSBNb3ZlU3RhdGUuRE9XTikge1xuICAgICAgICAgICAgdGhpcy52eSA9IHRoaXMub2dWWTtcbiAgICAgICAgfSBlbHNlIGlmICh0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLlVQKSB7XG4gICAgICAgICAgICB0aGlzLnZ5ID0gLXRoaXMub2dWWTtcbiAgICAgICAgfVxuXG4gICAgICAgIGNhbGNZID0gdGhpcy55ICsgdGhpcy52eTtcbiAgICAgICAgaWYgKHRoaXMudmFsaWRNb3ZlKDEsIGNhbGNZKSkge1xuICAgICAgICAgICAgc3VwZXIubW92ZSgpO1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgc3RvcE1vdmUoKSB7XG4gICAgICAgIHRoaXMubW92aW5nID0gTW92ZVN0YXRlLk5PTkU7XG4gICAgfVxuXG4gICAgdmFsaWRNb3ZlKGNhbGNYLCBjYWxjWSkge1xuICAgICAgICByZXR1cm4gY2FsY1ggPiAwICYmIGNhbGNZID4gMCAmJiAoY2FsY1ggPCB0aGlzLm15Q2FudmFzLndpZHRoIC0gNDApICYmIChjYWxjWSA8IHRoaXMubXlDYW52YXMuaGVpZ2h0IC0gNDApO1xuICAgIH1cblxuXG4gICAgaXNNb3ZpbmcoKSB7XG4gICAgICAgIHJldHVybiB0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLlVQIHx8IHRoaXMubW92aW5nID09PSBNb3ZlU3RhdGUuRE9XTjtcbiAgICB9XG59XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gLi9zcmMvc2NyaXB0cy9TdGFyc2hpcC5qcyIsIm1vZHVsZS5leHBvcnRzID0gX193ZWJwYWNrX3B1YmxpY19wYXRoX18gKyBcImltYWdlcy9pbWdlMWJmNDVjZWU4OWYxZmZjOTdkN2NhYjZjNDFiZDdjOC5wbmdcIjtcblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9pbWFnZXMvdmFpc3NlYXUtYmFsbG9uLXBldGl0LnBuZ1xuLy8gbW9kdWxlIGlkID0gNlxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJpbXBvcnQgTW9iaWxlIGZyb20gJy4vTW9iaWxlLmpzJztcblxuaW1wb3J0IHNhdWNlclNyYyBmcm9tICcuLi9pbWFnZXMvZmx5aW5nU2F1Y2VyLXBldGl0LnBuZyc7XG5pbXBvcnQgU2hvb3QgZnJvbSBcIi4vU2hvb3RcIjtcblxuZXhwb3J0IGRlZmF1bHQgY2xhc3MgU2F1Y2VyIGV4dGVuZHMgTW9iaWxlIHtcbiAgICBjb25zdHJ1Y3RvcihhQ2FudmFzLCB4LCB5LCBnYW1lKSB7XG4gICAgICAgIHN1cGVyKGFDYW52YXMsIHNhdWNlclNyYywgeCwgeSwgLTMsIDApO1xuICAgICAgICB0aGlzLmdhbWUgPSBnYW1lO1xuICAgIH1cblxuICAgIG1vdmUoKSB7XG4gICAgICAgIHN1cGVyLm1vdmUoKTtcblxuICAgICAgICBpZiAodGhpcy54IDw9IDApIHtcbiAgICAgICAgICAgIHRoaXMuZ2FtZS5yZW1vdmVTYXVjZXIodGhpcyk7XG4gICAgICAgIH1cbiAgICB9XG4gICAgY29sbGlzaW9uV2l0aCh4LCB5LCBnYW1lKSB7XG4gICAgICAgIGxldCBzaG9vdCA9IG5ldyBTaG9vdCh0aGlzLm15Q2FudmFzLCB4LCB5LCBnYW1lKTtcbiAgICAgICAgcmV0dXJuIHNob290LmlzSW5zaWRlKHNob290LngsIHNob290LnkpO1xuICAgIH1cbn1cblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL1NhdWNlci5qcyIsIm1vZHVsZS5leHBvcnRzID0gX193ZWJwYWNrX3B1YmxpY19wYXRoX18gKyBcImltYWdlcy9pbWdjOGY5OTZjZjA4M2Y0ZWJmN2E2ZTM2M2Y1MGVhYjYwNi5wbmdcIjtcblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9pbWFnZXMvc2hvb3QucG5nXG4vLyBtb2R1bGUgaWQgPSA4XG4vLyBtb2R1bGUgY2h1bmtzID0gMCIsIi8vIHN0eWxlLWxvYWRlcjogQWRkcyBzb21lIGNzcyB0byB0aGUgRE9NIGJ5IGFkZGluZyBhIDxzdHlsZT4gdGFnXG5cbi8vIGxvYWQgdGhlIHN0eWxlc1xudmFyIGNvbnRlbnQgPSByZXF1aXJlKFwiISEuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9pbmRleC5qcyEuL3N0eWxlLmNzc1wiKTtcbmlmKHR5cGVvZiBjb250ZW50ID09PSAnc3RyaW5nJykgY29udGVudCA9IFtbbW9kdWxlLmlkLCBjb250ZW50LCAnJ11dO1xuLy8gUHJlcGFyZSBjc3NUcmFuc2Zvcm1hdGlvblxudmFyIHRyYW5zZm9ybTtcblxudmFyIG9wdGlvbnMgPSB7XCJobXJcIjp0cnVlfVxub3B0aW9ucy50cmFuc2Zvcm0gPSB0cmFuc2Zvcm1cbi8vIGFkZCB0aGUgc3R5bGVzIHRvIHRoZSBET01cbnZhciB1cGRhdGUgPSByZXF1aXJlKFwiIS4uLy4uL25vZGVfbW9kdWxlcy9zdHlsZS1sb2FkZXIvbGliL2FkZFN0eWxlcy5qc1wiKShjb250ZW50LCBvcHRpb25zKTtcbmlmKGNvbnRlbnQubG9jYWxzKSBtb2R1bGUuZXhwb3J0cyA9IGNvbnRlbnQubG9jYWxzO1xuLy8gSG90IE1vZHVsZSBSZXBsYWNlbWVudFxuaWYobW9kdWxlLmhvdCkge1xuXHQvLyBXaGVuIHRoZSBzdHlsZXMgY2hhbmdlLCB1cGRhdGUgdGhlIDxzdHlsZT4gdGFnc1xuXHRpZighY29udGVudC5sb2NhbHMpIHtcblx0XHRtb2R1bGUuaG90LmFjY2VwdChcIiEhLi4vLi4vbm9kZV9tb2R1bGVzL2Nzcy1sb2FkZXIvaW5kZXguanMhLi9zdHlsZS5jc3NcIiwgZnVuY3Rpb24oKSB7XG5cdFx0XHR2YXIgbmV3Q29udGVudCA9IHJlcXVpcmUoXCIhIS4uLy4uL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyL2luZGV4LmpzIS4vc3R5bGUuY3NzXCIpO1xuXHRcdFx0aWYodHlwZW9mIG5ld0NvbnRlbnQgPT09ICdzdHJpbmcnKSBuZXdDb250ZW50ID0gW1ttb2R1bGUuaWQsIG5ld0NvbnRlbnQsICcnXV07XG5cdFx0XHR1cGRhdGUobmV3Q29udGVudCk7XG5cdFx0fSk7XG5cdH1cblx0Ly8gV2hlbiB0aGUgbW9kdWxlIGlzIGRpc3Bvc2VkLCByZW1vdmUgdGhlIDxzdHlsZT4gdGFnc1xuXHRtb2R1bGUuaG90LmRpc3Bvc2UoZnVuY3Rpb24oKSB7IHVwZGF0ZSgpOyB9KTtcbn1cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9zdHlsZS9zdHlsZS5jc3Ncbi8vIG1vZHVsZSBpZCA9IDlcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwidmFyIGVzY2FwZSA9IHJlcXVpcmUoXCIuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qc1wiKTtcbmV4cG9ydHMgPSBtb2R1bGUuZXhwb3J0cyA9IHJlcXVpcmUoXCIuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvY3NzLWJhc2UuanNcIikoZmFsc2UpO1xuLy8gaW1wb3J0c1xuXG5cbi8vIG1vZHVsZVxuZXhwb3J0cy5wdXNoKFttb2R1bGUuaWQsIFwiaHRtbCB7XFxuICBiYWNrZ3JvdW5kLWNvbG9yIDogcmdiYSgwLDAsMCwwLjUpO1xcbn1cXG4jc3RhcnMgeyAgICBcXG4gICAgZGlzcGxheSA6IGJsb2NrO1xcbiAgICBtYXJnaW4gOiBhdXRvO1xcbiAgICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoXCIgKyBlc2NhcGUocmVxdWlyZShcIi4uL2ltYWdlcy9jaWVsLW5vY3R1cm5lLnBuZ1wiKSkgKyBcIik7XFxuICAgIGJhY2tncm91bmQtcmVwZWF0OiByZXBlYXQteDtcXG4gICAgYmFja2dyb3VuZC1zaXplOiBjb3ZlcjtcXG4gICAgYmFja2dyb3VuZC1wb3NpdGlvbiA6IDBweCAwcHg7XFxuICAgIGJvcmRlciA6IDJweCBzb2xpZCB3aGl0ZTtcXG4gICAgXFxufVxcblxcbiAgI3N0YXJzIHtcXG4gICAgYW5pbWF0aW9uLWR1cmF0aW9uOiAzMHM7XFxuICAgIGFuaW1hdGlvbi1uYW1lOiBzdGFyc1NsaWRlO1xcbiAgICBhbmltYXRpb24taXRlcmF0aW9uLWNvdW50OiBpbmZpbml0ZTtcXG4gICAgYW5pbWF0aW9uLXRpbWluZy1mdW5jdGlvbjogbGluZWFyO1xcbiAgfVxcbiBcXG5cXG5Aa2V5ZnJhbWVzIHN0YXJzU2xpZGUge1xcbiAgICBmcm9tIHtcXG4gICAgICBiYWNrZ3JvdW5kLXBvc2l0aW9uIDogMTIwMHB4IDBweDtcXG4gICAgfVxcbiAgICBcXG4gICAgdG8ge1xcbiAgICAgYmFja2dyb3VuZC1wb3NpdGlvbiA6IDBweCAwcHg7ICAgICBcXG4gICAgfVxcbiAgfVxcblxcblxcblxcbmRpdiNjb250cm9sIHtcXG4gIHRleHQtYWxpZ24gOiBjZW50ZXI7XFxuICBtYXJnaW4gOiAxMHB4O1xcbn1cXG5cXG5idXR0b24ge1xcbiAgZm9udC1zaXplIDogNDBweDsgXFxufVxcblxcbnNwYW4jc2NvcmV7XFxuICBkaXNwbGF5IDogaW5saW5lLWJsb2NrO1xcbiAgd2lkdGggOiAxMDBweDtcXG4gIGZvbnQtc2l6ZSA6IDMwcHg7XFxuICB0ZXh0LWFsaWduIDogcmlnaHQ7XFxuICBiYWNrZ3JvdW5kLWNvbG9yIDogd2hpdGU7XFxuICBwYWRkaW5nIDogNHB4O1xcbiAgbWFyZ2luIDogNHB4O1xcbn1cIiwgXCJcIl0pO1xuXG4vLyBleHBvcnRzXG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyIS4vc3JjL3N0eWxlL3N0eWxlLmNzc1xuLy8gbW9kdWxlIGlkID0gMTBcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwibW9kdWxlLmV4cG9ydHMgPSBmdW5jdGlvbiBlc2NhcGUodXJsKSB7XG4gICAgaWYgKHR5cGVvZiB1cmwgIT09ICdzdHJpbmcnKSB7XG4gICAgICAgIHJldHVybiB1cmxcbiAgICB9XG4gICAgLy8gSWYgdXJsIGlzIGFscmVhZHkgd3JhcHBlZCBpbiBxdW90ZXMsIHJlbW92ZSB0aGVtXG4gICAgaWYgKC9eWydcIl0uKlsnXCJdJC8udGVzdCh1cmwpKSB7XG4gICAgICAgIHVybCA9IHVybC5zbGljZSgxLCAtMSk7XG4gICAgfVxuICAgIC8vIFNob3VsZCB1cmwgYmUgd3JhcHBlZD9cbiAgICAvLyBTZWUgaHR0cHM6Ly9kcmFmdHMuY3Nzd2cub3JnL2Nzcy12YWx1ZXMtMy8jdXJsc1xuICAgIGlmICgvW1wiJygpIFxcdFxcbl0vLnRlc3QodXJsKSkge1xuICAgICAgICByZXR1cm4gJ1wiJyArIHVybC5yZXBsYWNlKC9cIi9nLCAnXFxcXFwiJykucmVwbGFjZSgvXFxuL2csICdcXFxcbicpICsgJ1wiJ1xuICAgIH1cblxuICAgIHJldHVybiB1cmxcbn1cblxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vbm9kZV9tb2R1bGVzL2Nzcy1sb2FkZXIvbGliL3VybC9lc2NhcGUuanNcbi8vIG1vZHVsZSBpZCA9IDExXG4vLyBtb2R1bGUgY2h1bmtzID0gMCIsIi8qXG5cdE1JVCBMaWNlbnNlIGh0dHA6Ly93d3cub3BlbnNvdXJjZS5vcmcvbGljZW5zZXMvbWl0LWxpY2Vuc2UucGhwXG5cdEF1dGhvciBUb2JpYXMgS29wcGVycyBAc29rcmFcbiovXG4vLyBjc3MgYmFzZSBjb2RlLCBpbmplY3RlZCBieSB0aGUgY3NzLWxvYWRlclxubW9kdWxlLmV4cG9ydHMgPSBmdW5jdGlvbih1c2VTb3VyY2VNYXApIHtcblx0dmFyIGxpc3QgPSBbXTtcblxuXHQvLyByZXR1cm4gdGhlIGxpc3Qgb2YgbW9kdWxlcyBhcyBjc3Mgc3RyaW5nXG5cdGxpc3QudG9TdHJpbmcgPSBmdW5jdGlvbiB0b1N0cmluZygpIHtcblx0XHRyZXR1cm4gdGhpcy5tYXAoZnVuY3Rpb24gKGl0ZW0pIHtcblx0XHRcdHZhciBjb250ZW50ID0gY3NzV2l0aE1hcHBpbmdUb1N0cmluZyhpdGVtLCB1c2VTb3VyY2VNYXApO1xuXHRcdFx0aWYoaXRlbVsyXSkge1xuXHRcdFx0XHRyZXR1cm4gXCJAbWVkaWEgXCIgKyBpdGVtWzJdICsgXCJ7XCIgKyBjb250ZW50ICsgXCJ9XCI7XG5cdFx0XHR9IGVsc2Uge1xuXHRcdFx0XHRyZXR1cm4gY29udGVudDtcblx0XHRcdH1cblx0XHR9KS5qb2luKFwiXCIpO1xuXHR9O1xuXG5cdC8vIGltcG9ydCBhIGxpc3Qgb2YgbW9kdWxlcyBpbnRvIHRoZSBsaXN0XG5cdGxpc3QuaSA9IGZ1bmN0aW9uKG1vZHVsZXMsIG1lZGlhUXVlcnkpIHtcblx0XHRpZih0eXBlb2YgbW9kdWxlcyA9PT0gXCJzdHJpbmdcIilcblx0XHRcdG1vZHVsZXMgPSBbW251bGwsIG1vZHVsZXMsIFwiXCJdXTtcblx0XHR2YXIgYWxyZWFkeUltcG9ydGVkTW9kdWxlcyA9IHt9O1xuXHRcdGZvcih2YXIgaSA9IDA7IGkgPCB0aGlzLmxlbmd0aDsgaSsrKSB7XG5cdFx0XHR2YXIgaWQgPSB0aGlzW2ldWzBdO1xuXHRcdFx0aWYodHlwZW9mIGlkID09PSBcIm51bWJlclwiKVxuXHRcdFx0XHRhbHJlYWR5SW1wb3J0ZWRNb2R1bGVzW2lkXSA9IHRydWU7XG5cdFx0fVxuXHRcdGZvcihpID0gMDsgaSA8IG1vZHVsZXMubGVuZ3RoOyBpKyspIHtcblx0XHRcdHZhciBpdGVtID0gbW9kdWxlc1tpXTtcblx0XHRcdC8vIHNraXAgYWxyZWFkeSBpbXBvcnRlZCBtb2R1bGVcblx0XHRcdC8vIHRoaXMgaW1wbGVtZW50YXRpb24gaXMgbm90IDEwMCUgcGVyZmVjdCBmb3Igd2VpcmQgbWVkaWEgcXVlcnkgY29tYmluYXRpb25zXG5cdFx0XHQvLyAgd2hlbiBhIG1vZHVsZSBpcyBpbXBvcnRlZCBtdWx0aXBsZSB0aW1lcyB3aXRoIGRpZmZlcmVudCBtZWRpYSBxdWVyaWVzLlxuXHRcdFx0Ly8gIEkgaG9wZSB0aGlzIHdpbGwgbmV2ZXIgb2NjdXIgKEhleSB0aGlzIHdheSB3ZSBoYXZlIHNtYWxsZXIgYnVuZGxlcylcblx0XHRcdGlmKHR5cGVvZiBpdGVtWzBdICE9PSBcIm51bWJlclwiIHx8ICFhbHJlYWR5SW1wb3J0ZWRNb2R1bGVzW2l0ZW1bMF1dKSB7XG5cdFx0XHRcdGlmKG1lZGlhUXVlcnkgJiYgIWl0ZW1bMl0pIHtcblx0XHRcdFx0XHRpdGVtWzJdID0gbWVkaWFRdWVyeTtcblx0XHRcdFx0fSBlbHNlIGlmKG1lZGlhUXVlcnkpIHtcblx0XHRcdFx0XHRpdGVtWzJdID0gXCIoXCIgKyBpdGVtWzJdICsgXCIpIGFuZCAoXCIgKyBtZWRpYVF1ZXJ5ICsgXCIpXCI7XG5cdFx0XHRcdH1cblx0XHRcdFx0bGlzdC5wdXNoKGl0ZW0pO1xuXHRcdFx0fVxuXHRcdH1cblx0fTtcblx0cmV0dXJuIGxpc3Q7XG59O1xuXG5mdW5jdGlvbiBjc3NXaXRoTWFwcGluZ1RvU3RyaW5nKGl0ZW0sIHVzZVNvdXJjZU1hcCkge1xuXHR2YXIgY29udGVudCA9IGl0ZW1bMV0gfHwgJyc7XG5cdHZhciBjc3NNYXBwaW5nID0gaXRlbVszXTtcblx0aWYgKCFjc3NNYXBwaW5nKSB7XG5cdFx0cmV0dXJuIGNvbnRlbnQ7XG5cdH1cblxuXHRpZiAodXNlU291cmNlTWFwICYmIHR5cGVvZiBidG9hID09PSAnZnVuY3Rpb24nKSB7XG5cdFx0dmFyIHNvdXJjZU1hcHBpbmcgPSB0b0NvbW1lbnQoY3NzTWFwcGluZyk7XG5cdFx0dmFyIHNvdXJjZVVSTHMgPSBjc3NNYXBwaW5nLnNvdXJjZXMubWFwKGZ1bmN0aW9uIChzb3VyY2UpIHtcblx0XHRcdHJldHVybiAnLyojIHNvdXJjZVVSTD0nICsgY3NzTWFwcGluZy5zb3VyY2VSb290ICsgc291cmNlICsgJyAqLydcblx0XHR9KTtcblxuXHRcdHJldHVybiBbY29udGVudF0uY29uY2F0KHNvdXJjZVVSTHMpLmNvbmNhdChbc291cmNlTWFwcGluZ10pLmpvaW4oJ1xcbicpO1xuXHR9XG5cblx0cmV0dXJuIFtjb250ZW50XS5qb2luKCdcXG4nKTtcbn1cblxuLy8gQWRhcHRlZCBmcm9tIGNvbnZlcnQtc291cmNlLW1hcCAoTUlUKVxuZnVuY3Rpb24gdG9Db21tZW50KHNvdXJjZU1hcCkge1xuXHQvLyBlc2xpbnQtZGlzYWJsZS1uZXh0LWxpbmUgbm8tdW5kZWZcblx0dmFyIGJhc2U2NCA9IGJ0b2EodW5lc2NhcGUoZW5jb2RlVVJJQ29tcG9uZW50KEpTT04uc3RyaW5naWZ5KHNvdXJjZU1hcCkpKSk7XG5cdHZhciBkYXRhID0gJ3NvdXJjZU1hcHBpbmdVUkw9ZGF0YTphcHBsaWNhdGlvbi9qc29uO2NoYXJzZXQ9dXRmLTg7YmFzZTY0LCcgKyBiYXNlNjQ7XG5cblx0cmV0dXJuICcvKiMgJyArIGRhdGEgKyAnICovJztcbn1cblxuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vbm9kZV9tb2R1bGVzL2Nzcy1sb2FkZXIvbGliL2Nzcy1iYXNlLmpzXG4vLyBtb2R1bGUgaWQgPSAxMlxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJtb2R1bGUuZXhwb3J0cyA9IF9fd2VicGFja19wdWJsaWNfcGF0aF9fICsgXCJpbWFnZXMvaW1nZTI5YTIwNDE4ZWU2M2FjZWIxYmM3M2QxNzJiNzM2N2UucG5nXCI7XG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvaW1hZ2VzL2NpZWwtbm9jdHVybmUucG5nXG4vLyBtb2R1bGUgaWQgPSAxM1xuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCIvKlxuXHRNSVQgTGljZW5zZSBodHRwOi8vd3d3Lm9wZW5zb3VyY2Uub3JnL2xpY2Vuc2VzL21pdC1saWNlbnNlLnBocFxuXHRBdXRob3IgVG9iaWFzIEtvcHBlcnMgQHNva3JhXG4qL1xuXG52YXIgc3R5bGVzSW5Eb20gPSB7fTtcblxudmFyXHRtZW1vaXplID0gZnVuY3Rpb24gKGZuKSB7XG5cdHZhciBtZW1vO1xuXG5cdHJldHVybiBmdW5jdGlvbiAoKSB7XG5cdFx0aWYgKHR5cGVvZiBtZW1vID09PSBcInVuZGVmaW5lZFwiKSBtZW1vID0gZm4uYXBwbHkodGhpcywgYXJndW1lbnRzKTtcblx0XHRyZXR1cm4gbWVtbztcblx0fTtcbn07XG5cbnZhciBpc09sZElFID0gbWVtb2l6ZShmdW5jdGlvbiAoKSB7XG5cdC8vIFRlc3QgZm9yIElFIDw9IDkgYXMgcHJvcG9zZWQgYnkgQnJvd3NlcmhhY2tzXG5cdC8vIEBzZWUgaHR0cDovL2Jyb3dzZXJoYWNrcy5jb20vI2hhY2stZTcxZDg2OTJmNjUzMzQxNzNmZWU3MTVjMjIyY2I4MDVcblx0Ly8gVGVzdHMgZm9yIGV4aXN0ZW5jZSBvZiBzdGFuZGFyZCBnbG9iYWxzIGlzIHRvIGFsbG93IHN0eWxlLWxvYWRlclxuXHQvLyB0byBvcGVyYXRlIGNvcnJlY3RseSBpbnRvIG5vbi1zdGFuZGFyZCBlbnZpcm9ubWVudHNcblx0Ly8gQHNlZSBodHRwczovL2dpdGh1Yi5jb20vd2VicGFjay1jb250cmliL3N0eWxlLWxvYWRlci9pc3N1ZXMvMTc3XG5cdHJldHVybiB3aW5kb3cgJiYgZG9jdW1lbnQgJiYgZG9jdW1lbnQuYWxsICYmICF3aW5kb3cuYXRvYjtcbn0pO1xuXG52YXIgZ2V0RWxlbWVudCA9IChmdW5jdGlvbiAoZm4pIHtcblx0dmFyIG1lbW8gPSB7fTtcblxuXHRyZXR1cm4gZnVuY3Rpb24oc2VsZWN0b3IpIHtcblx0XHRpZiAodHlwZW9mIG1lbW9bc2VsZWN0b3JdID09PSBcInVuZGVmaW5lZFwiKSB7XG5cdFx0XHR2YXIgc3R5bGVUYXJnZXQgPSBmbi5jYWxsKHRoaXMsIHNlbGVjdG9yKTtcblx0XHRcdC8vIFNwZWNpYWwgY2FzZSB0byByZXR1cm4gaGVhZCBvZiBpZnJhbWUgaW5zdGVhZCBvZiBpZnJhbWUgaXRzZWxmXG5cdFx0XHRpZiAoc3R5bGVUYXJnZXQgaW5zdGFuY2VvZiB3aW5kb3cuSFRNTElGcmFtZUVsZW1lbnQpIHtcblx0XHRcdFx0dHJ5IHtcblx0XHRcdFx0XHQvLyBUaGlzIHdpbGwgdGhyb3cgYW4gZXhjZXB0aW9uIGlmIGFjY2VzcyB0byBpZnJhbWUgaXMgYmxvY2tlZFxuXHRcdFx0XHRcdC8vIGR1ZSB0byBjcm9zcy1vcmlnaW4gcmVzdHJpY3Rpb25zXG5cdFx0XHRcdFx0c3R5bGVUYXJnZXQgPSBzdHlsZVRhcmdldC5jb250ZW50RG9jdW1lbnQuaGVhZDtcblx0XHRcdFx0fSBjYXRjaChlKSB7XG5cdFx0XHRcdFx0c3R5bGVUYXJnZXQgPSBudWxsO1xuXHRcdFx0XHR9XG5cdFx0XHR9XG5cdFx0XHRtZW1vW3NlbGVjdG9yXSA9IHN0eWxlVGFyZ2V0O1xuXHRcdH1cblx0XHRyZXR1cm4gbWVtb1tzZWxlY3Rvcl1cblx0fTtcbn0pKGZ1bmN0aW9uICh0YXJnZXQpIHtcblx0cmV0dXJuIGRvY3VtZW50LnF1ZXJ5U2VsZWN0b3IodGFyZ2V0KVxufSk7XG5cbnZhciBzaW5nbGV0b24gPSBudWxsO1xudmFyXHRzaW5nbGV0b25Db3VudGVyID0gMDtcbnZhclx0c3R5bGVzSW5zZXJ0ZWRBdFRvcCA9IFtdO1xuXG52YXJcdGZpeFVybHMgPSByZXF1aXJlKFwiLi91cmxzXCIpO1xuXG5tb2R1bGUuZXhwb3J0cyA9IGZ1bmN0aW9uKGxpc3QsIG9wdGlvbnMpIHtcblx0aWYgKHR5cGVvZiBERUJVRyAhPT0gXCJ1bmRlZmluZWRcIiAmJiBERUJVRykge1xuXHRcdGlmICh0eXBlb2YgZG9jdW1lbnQgIT09IFwib2JqZWN0XCIpIHRocm93IG5ldyBFcnJvcihcIlRoZSBzdHlsZS1sb2FkZXIgY2Fubm90IGJlIHVzZWQgaW4gYSBub24tYnJvd3NlciBlbnZpcm9ubWVudFwiKTtcblx0fVxuXG5cdG9wdGlvbnMgPSBvcHRpb25zIHx8IHt9O1xuXG5cdG9wdGlvbnMuYXR0cnMgPSB0eXBlb2Ygb3B0aW9ucy5hdHRycyA9PT0gXCJvYmplY3RcIiA/IG9wdGlvbnMuYXR0cnMgOiB7fTtcblxuXHQvLyBGb3JjZSBzaW5nbGUtdGFnIHNvbHV0aW9uIG9uIElFNi05LCB3aGljaCBoYXMgYSBoYXJkIGxpbWl0IG9uIHRoZSAjIG9mIDxzdHlsZT5cblx0Ly8gdGFncyBpdCB3aWxsIGFsbG93IG9uIGEgcGFnZVxuXHRpZiAoIW9wdGlvbnMuc2luZ2xldG9uICYmIHR5cGVvZiBvcHRpb25zLnNpbmdsZXRvbiAhPT0gXCJib29sZWFuXCIpIG9wdGlvbnMuc2luZ2xldG9uID0gaXNPbGRJRSgpO1xuXG5cdC8vIEJ5IGRlZmF1bHQsIGFkZCA8c3R5bGU+IHRhZ3MgdG8gdGhlIDxoZWFkPiBlbGVtZW50XG5cdGlmICghb3B0aW9ucy5pbnNlcnRJbnRvKSBvcHRpb25zLmluc2VydEludG8gPSBcImhlYWRcIjtcblxuXHQvLyBCeSBkZWZhdWx0LCBhZGQgPHN0eWxlPiB0YWdzIHRvIHRoZSBib3R0b20gb2YgdGhlIHRhcmdldFxuXHRpZiAoIW9wdGlvbnMuaW5zZXJ0QXQpIG9wdGlvbnMuaW5zZXJ0QXQgPSBcImJvdHRvbVwiO1xuXG5cdHZhciBzdHlsZXMgPSBsaXN0VG9TdHlsZXMobGlzdCwgb3B0aW9ucyk7XG5cblx0YWRkU3R5bGVzVG9Eb20oc3R5bGVzLCBvcHRpb25zKTtcblxuXHRyZXR1cm4gZnVuY3Rpb24gdXBkYXRlIChuZXdMaXN0KSB7XG5cdFx0dmFyIG1heVJlbW92ZSA9IFtdO1xuXG5cdFx0Zm9yICh2YXIgaSA9IDA7IGkgPCBzdHlsZXMubGVuZ3RoOyBpKyspIHtcblx0XHRcdHZhciBpdGVtID0gc3R5bGVzW2ldO1xuXHRcdFx0dmFyIGRvbVN0eWxlID0gc3R5bGVzSW5Eb21baXRlbS5pZF07XG5cblx0XHRcdGRvbVN0eWxlLnJlZnMtLTtcblx0XHRcdG1heVJlbW92ZS5wdXNoKGRvbVN0eWxlKTtcblx0XHR9XG5cblx0XHRpZihuZXdMaXN0KSB7XG5cdFx0XHR2YXIgbmV3U3R5bGVzID0gbGlzdFRvU3R5bGVzKG5ld0xpc3QsIG9wdGlvbnMpO1xuXHRcdFx0YWRkU3R5bGVzVG9Eb20obmV3U3R5bGVzLCBvcHRpb25zKTtcblx0XHR9XG5cblx0XHRmb3IgKHZhciBpID0gMDsgaSA8IG1heVJlbW92ZS5sZW5ndGg7IGkrKykge1xuXHRcdFx0dmFyIGRvbVN0eWxlID0gbWF5UmVtb3ZlW2ldO1xuXG5cdFx0XHRpZihkb21TdHlsZS5yZWZzID09PSAwKSB7XG5cdFx0XHRcdGZvciAodmFyIGogPSAwOyBqIDwgZG9tU3R5bGUucGFydHMubGVuZ3RoOyBqKyspIGRvbVN0eWxlLnBhcnRzW2pdKCk7XG5cblx0XHRcdFx0ZGVsZXRlIHN0eWxlc0luRG9tW2RvbVN0eWxlLmlkXTtcblx0XHRcdH1cblx0XHR9XG5cdH07XG59O1xuXG5mdW5jdGlvbiBhZGRTdHlsZXNUb0RvbSAoc3R5bGVzLCBvcHRpb25zKSB7XG5cdGZvciAodmFyIGkgPSAwOyBpIDwgc3R5bGVzLmxlbmd0aDsgaSsrKSB7XG5cdFx0dmFyIGl0ZW0gPSBzdHlsZXNbaV07XG5cdFx0dmFyIGRvbVN0eWxlID0gc3R5bGVzSW5Eb21baXRlbS5pZF07XG5cblx0XHRpZihkb21TdHlsZSkge1xuXHRcdFx0ZG9tU3R5bGUucmVmcysrO1xuXG5cdFx0XHRmb3IodmFyIGogPSAwOyBqIDwgZG9tU3R5bGUucGFydHMubGVuZ3RoOyBqKyspIHtcblx0XHRcdFx0ZG9tU3R5bGUucGFydHNbal0oaXRlbS5wYXJ0c1tqXSk7XG5cdFx0XHR9XG5cblx0XHRcdGZvcig7IGogPCBpdGVtLnBhcnRzLmxlbmd0aDsgaisrKSB7XG5cdFx0XHRcdGRvbVN0eWxlLnBhcnRzLnB1c2goYWRkU3R5bGUoaXRlbS5wYXJ0c1tqXSwgb3B0aW9ucykpO1xuXHRcdFx0fVxuXHRcdH0gZWxzZSB7XG5cdFx0XHR2YXIgcGFydHMgPSBbXTtcblxuXHRcdFx0Zm9yKHZhciBqID0gMDsgaiA8IGl0ZW0ucGFydHMubGVuZ3RoOyBqKyspIHtcblx0XHRcdFx0cGFydHMucHVzaChhZGRTdHlsZShpdGVtLnBhcnRzW2pdLCBvcHRpb25zKSk7XG5cdFx0XHR9XG5cblx0XHRcdHN0eWxlc0luRG9tW2l0ZW0uaWRdID0ge2lkOiBpdGVtLmlkLCByZWZzOiAxLCBwYXJ0czogcGFydHN9O1xuXHRcdH1cblx0fVxufVxuXG5mdW5jdGlvbiBsaXN0VG9TdHlsZXMgKGxpc3QsIG9wdGlvbnMpIHtcblx0dmFyIHN0eWxlcyA9IFtdO1xuXHR2YXIgbmV3U3R5bGVzID0ge307XG5cblx0Zm9yICh2YXIgaSA9IDA7IGkgPCBsaXN0Lmxlbmd0aDsgaSsrKSB7XG5cdFx0dmFyIGl0ZW0gPSBsaXN0W2ldO1xuXHRcdHZhciBpZCA9IG9wdGlvbnMuYmFzZSA/IGl0ZW1bMF0gKyBvcHRpb25zLmJhc2UgOiBpdGVtWzBdO1xuXHRcdHZhciBjc3MgPSBpdGVtWzFdO1xuXHRcdHZhciBtZWRpYSA9IGl0ZW1bMl07XG5cdFx0dmFyIHNvdXJjZU1hcCA9IGl0ZW1bM107XG5cdFx0dmFyIHBhcnQgPSB7Y3NzOiBjc3MsIG1lZGlhOiBtZWRpYSwgc291cmNlTWFwOiBzb3VyY2VNYXB9O1xuXG5cdFx0aWYoIW5ld1N0eWxlc1tpZF0pIHN0eWxlcy5wdXNoKG5ld1N0eWxlc1tpZF0gPSB7aWQ6IGlkLCBwYXJ0czogW3BhcnRdfSk7XG5cdFx0ZWxzZSBuZXdTdHlsZXNbaWRdLnBhcnRzLnB1c2gocGFydCk7XG5cdH1cblxuXHRyZXR1cm4gc3R5bGVzO1xufVxuXG5mdW5jdGlvbiBpbnNlcnRTdHlsZUVsZW1lbnQgKG9wdGlvbnMsIHN0eWxlKSB7XG5cdHZhciB0YXJnZXQgPSBnZXRFbGVtZW50KG9wdGlvbnMuaW5zZXJ0SW50bylcblxuXHRpZiAoIXRhcmdldCkge1xuXHRcdHRocm93IG5ldyBFcnJvcihcIkNvdWxkbid0IGZpbmQgYSBzdHlsZSB0YXJnZXQuIFRoaXMgcHJvYmFibHkgbWVhbnMgdGhhdCB0aGUgdmFsdWUgZm9yIHRoZSAnaW5zZXJ0SW50bycgcGFyYW1ldGVyIGlzIGludmFsaWQuXCIpO1xuXHR9XG5cblx0dmFyIGxhc3RTdHlsZUVsZW1lbnRJbnNlcnRlZEF0VG9wID0gc3R5bGVzSW5zZXJ0ZWRBdFRvcFtzdHlsZXNJbnNlcnRlZEF0VG9wLmxlbmd0aCAtIDFdO1xuXG5cdGlmIChvcHRpb25zLmluc2VydEF0ID09PSBcInRvcFwiKSB7XG5cdFx0aWYgKCFsYXN0U3R5bGVFbGVtZW50SW5zZXJ0ZWRBdFRvcCkge1xuXHRcdFx0dGFyZ2V0Lmluc2VydEJlZm9yZShzdHlsZSwgdGFyZ2V0LmZpcnN0Q2hpbGQpO1xuXHRcdH0gZWxzZSBpZiAobGFzdFN0eWxlRWxlbWVudEluc2VydGVkQXRUb3AubmV4dFNpYmxpbmcpIHtcblx0XHRcdHRhcmdldC5pbnNlcnRCZWZvcmUoc3R5bGUsIGxhc3RTdHlsZUVsZW1lbnRJbnNlcnRlZEF0VG9wLm5leHRTaWJsaW5nKTtcblx0XHR9IGVsc2Uge1xuXHRcdFx0dGFyZ2V0LmFwcGVuZENoaWxkKHN0eWxlKTtcblx0XHR9XG5cdFx0c3R5bGVzSW5zZXJ0ZWRBdFRvcC5wdXNoKHN0eWxlKTtcblx0fSBlbHNlIGlmIChvcHRpb25zLmluc2VydEF0ID09PSBcImJvdHRvbVwiKSB7XG5cdFx0dGFyZ2V0LmFwcGVuZENoaWxkKHN0eWxlKTtcblx0fSBlbHNlIGlmICh0eXBlb2Ygb3B0aW9ucy5pbnNlcnRBdCA9PT0gXCJvYmplY3RcIiAmJiBvcHRpb25zLmluc2VydEF0LmJlZm9yZSkge1xuXHRcdHZhciBuZXh0U2libGluZyA9IGdldEVsZW1lbnQob3B0aW9ucy5pbnNlcnRJbnRvICsgXCIgXCIgKyBvcHRpb25zLmluc2VydEF0LmJlZm9yZSk7XG5cdFx0dGFyZ2V0Lmluc2VydEJlZm9yZShzdHlsZSwgbmV4dFNpYmxpbmcpO1xuXHR9IGVsc2Uge1xuXHRcdHRocm93IG5ldyBFcnJvcihcIltTdHlsZSBMb2FkZXJdXFxuXFxuIEludmFsaWQgdmFsdWUgZm9yIHBhcmFtZXRlciAnaW5zZXJ0QXQnICgnb3B0aW9ucy5pbnNlcnRBdCcpIGZvdW5kLlxcbiBNdXN0IGJlICd0b3AnLCAnYm90dG9tJywgb3IgT2JqZWN0LlxcbiAoaHR0cHM6Ly9naXRodWIuY29tL3dlYnBhY2stY29udHJpYi9zdHlsZS1sb2FkZXIjaW5zZXJ0YXQpXFxuXCIpO1xuXHR9XG59XG5cbmZ1bmN0aW9uIHJlbW92ZVN0eWxlRWxlbWVudCAoc3R5bGUpIHtcblx0aWYgKHN0eWxlLnBhcmVudE5vZGUgPT09IG51bGwpIHJldHVybiBmYWxzZTtcblx0c3R5bGUucGFyZW50Tm9kZS5yZW1vdmVDaGlsZChzdHlsZSk7XG5cblx0dmFyIGlkeCA9IHN0eWxlc0luc2VydGVkQXRUb3AuaW5kZXhPZihzdHlsZSk7XG5cdGlmKGlkeCA+PSAwKSB7XG5cdFx0c3R5bGVzSW5zZXJ0ZWRBdFRvcC5zcGxpY2UoaWR4LCAxKTtcblx0fVxufVxuXG5mdW5jdGlvbiBjcmVhdGVTdHlsZUVsZW1lbnQgKG9wdGlvbnMpIHtcblx0dmFyIHN0eWxlID0gZG9jdW1lbnQuY3JlYXRlRWxlbWVudChcInN0eWxlXCIpO1xuXG5cdG9wdGlvbnMuYXR0cnMudHlwZSA9IFwidGV4dC9jc3NcIjtcblxuXHRhZGRBdHRycyhzdHlsZSwgb3B0aW9ucy5hdHRycyk7XG5cdGluc2VydFN0eWxlRWxlbWVudChvcHRpb25zLCBzdHlsZSk7XG5cblx0cmV0dXJuIHN0eWxlO1xufVxuXG5mdW5jdGlvbiBjcmVhdGVMaW5rRWxlbWVudCAob3B0aW9ucykge1xuXHR2YXIgbGluayA9IGRvY3VtZW50LmNyZWF0ZUVsZW1lbnQoXCJsaW5rXCIpO1xuXG5cdG9wdGlvbnMuYXR0cnMudHlwZSA9IFwidGV4dC9jc3NcIjtcblx0b3B0aW9ucy5hdHRycy5yZWwgPSBcInN0eWxlc2hlZXRcIjtcblxuXHRhZGRBdHRycyhsaW5rLCBvcHRpb25zLmF0dHJzKTtcblx0aW5zZXJ0U3R5bGVFbGVtZW50KG9wdGlvbnMsIGxpbmspO1xuXG5cdHJldHVybiBsaW5rO1xufVxuXG5mdW5jdGlvbiBhZGRBdHRycyAoZWwsIGF0dHJzKSB7XG5cdE9iamVjdC5rZXlzKGF0dHJzKS5mb3JFYWNoKGZ1bmN0aW9uIChrZXkpIHtcblx0XHRlbC5zZXRBdHRyaWJ1dGUoa2V5LCBhdHRyc1trZXldKTtcblx0fSk7XG59XG5cbmZ1bmN0aW9uIGFkZFN0eWxlIChvYmosIG9wdGlvbnMpIHtcblx0dmFyIHN0eWxlLCB1cGRhdGUsIHJlbW92ZSwgcmVzdWx0O1xuXG5cdC8vIElmIGEgdHJhbnNmb3JtIGZ1bmN0aW9uIHdhcyBkZWZpbmVkLCBydW4gaXQgb24gdGhlIGNzc1xuXHRpZiAob3B0aW9ucy50cmFuc2Zvcm0gJiYgb2JqLmNzcykge1xuXHQgICAgcmVzdWx0ID0gb3B0aW9ucy50cmFuc2Zvcm0ob2JqLmNzcyk7XG5cblx0ICAgIGlmIChyZXN1bHQpIHtcblx0ICAgIFx0Ly8gSWYgdHJhbnNmb3JtIHJldHVybnMgYSB2YWx1ZSwgdXNlIHRoYXQgaW5zdGVhZCBvZiB0aGUgb3JpZ2luYWwgY3NzLlxuXHQgICAgXHQvLyBUaGlzIGFsbG93cyBydW5uaW5nIHJ1bnRpbWUgdHJhbnNmb3JtYXRpb25zIG9uIHRoZSBjc3MuXG5cdCAgICBcdG9iai5jc3MgPSByZXN1bHQ7XG5cdCAgICB9IGVsc2Uge1xuXHQgICAgXHQvLyBJZiB0aGUgdHJhbnNmb3JtIGZ1bmN0aW9uIHJldHVybnMgYSBmYWxzeSB2YWx1ZSwgZG9uJ3QgYWRkIHRoaXMgY3NzLlxuXHQgICAgXHQvLyBUaGlzIGFsbG93cyBjb25kaXRpb25hbCBsb2FkaW5nIG9mIGNzc1xuXHQgICAgXHRyZXR1cm4gZnVuY3Rpb24oKSB7XG5cdCAgICBcdFx0Ly8gbm9vcFxuXHQgICAgXHR9O1xuXHQgICAgfVxuXHR9XG5cblx0aWYgKG9wdGlvbnMuc2luZ2xldG9uKSB7XG5cdFx0dmFyIHN0eWxlSW5kZXggPSBzaW5nbGV0b25Db3VudGVyKys7XG5cblx0XHRzdHlsZSA9IHNpbmdsZXRvbiB8fCAoc2luZ2xldG9uID0gY3JlYXRlU3R5bGVFbGVtZW50KG9wdGlvbnMpKTtcblxuXHRcdHVwZGF0ZSA9IGFwcGx5VG9TaW5nbGV0b25UYWcuYmluZChudWxsLCBzdHlsZSwgc3R5bGVJbmRleCwgZmFsc2UpO1xuXHRcdHJlbW92ZSA9IGFwcGx5VG9TaW5nbGV0b25UYWcuYmluZChudWxsLCBzdHlsZSwgc3R5bGVJbmRleCwgdHJ1ZSk7XG5cblx0fSBlbHNlIGlmIChcblx0XHRvYmouc291cmNlTWFwICYmXG5cdFx0dHlwZW9mIFVSTCA9PT0gXCJmdW5jdGlvblwiICYmXG5cdFx0dHlwZW9mIFVSTC5jcmVhdGVPYmplY3RVUkwgPT09IFwiZnVuY3Rpb25cIiAmJlxuXHRcdHR5cGVvZiBVUkwucmV2b2tlT2JqZWN0VVJMID09PSBcImZ1bmN0aW9uXCIgJiZcblx0XHR0eXBlb2YgQmxvYiA9PT0gXCJmdW5jdGlvblwiICYmXG5cdFx0dHlwZW9mIGJ0b2EgPT09IFwiZnVuY3Rpb25cIlxuXHQpIHtcblx0XHRzdHlsZSA9IGNyZWF0ZUxpbmtFbGVtZW50KG9wdGlvbnMpO1xuXHRcdHVwZGF0ZSA9IHVwZGF0ZUxpbmsuYmluZChudWxsLCBzdHlsZSwgb3B0aW9ucyk7XG5cdFx0cmVtb3ZlID0gZnVuY3Rpb24gKCkge1xuXHRcdFx0cmVtb3ZlU3R5bGVFbGVtZW50KHN0eWxlKTtcblxuXHRcdFx0aWYoc3R5bGUuaHJlZikgVVJMLnJldm9rZU9iamVjdFVSTChzdHlsZS5ocmVmKTtcblx0XHR9O1xuXHR9IGVsc2Uge1xuXHRcdHN0eWxlID0gY3JlYXRlU3R5bGVFbGVtZW50KG9wdGlvbnMpO1xuXHRcdHVwZGF0ZSA9IGFwcGx5VG9UYWcuYmluZChudWxsLCBzdHlsZSk7XG5cdFx0cmVtb3ZlID0gZnVuY3Rpb24gKCkge1xuXHRcdFx0cmVtb3ZlU3R5bGVFbGVtZW50KHN0eWxlKTtcblx0XHR9O1xuXHR9XG5cblx0dXBkYXRlKG9iaik7XG5cblx0cmV0dXJuIGZ1bmN0aW9uIHVwZGF0ZVN0eWxlIChuZXdPYmopIHtcblx0XHRpZiAobmV3T2JqKSB7XG5cdFx0XHRpZiAoXG5cdFx0XHRcdG5ld09iai5jc3MgPT09IG9iai5jc3MgJiZcblx0XHRcdFx0bmV3T2JqLm1lZGlhID09PSBvYmoubWVkaWEgJiZcblx0XHRcdFx0bmV3T2JqLnNvdXJjZU1hcCA9PT0gb2JqLnNvdXJjZU1hcFxuXHRcdFx0KSB7XG5cdFx0XHRcdHJldHVybjtcblx0XHRcdH1cblxuXHRcdFx0dXBkYXRlKG9iaiA9IG5ld09iaik7XG5cdFx0fSBlbHNlIHtcblx0XHRcdHJlbW92ZSgpO1xuXHRcdH1cblx0fTtcbn1cblxudmFyIHJlcGxhY2VUZXh0ID0gKGZ1bmN0aW9uICgpIHtcblx0dmFyIHRleHRTdG9yZSA9IFtdO1xuXG5cdHJldHVybiBmdW5jdGlvbiAoaW5kZXgsIHJlcGxhY2VtZW50KSB7XG5cdFx0dGV4dFN0b3JlW2luZGV4XSA9IHJlcGxhY2VtZW50O1xuXG5cdFx0cmV0dXJuIHRleHRTdG9yZS5maWx0ZXIoQm9vbGVhbikuam9pbignXFxuJyk7XG5cdH07XG59KSgpO1xuXG5mdW5jdGlvbiBhcHBseVRvU2luZ2xldG9uVGFnIChzdHlsZSwgaW5kZXgsIHJlbW92ZSwgb2JqKSB7XG5cdHZhciBjc3MgPSByZW1vdmUgPyBcIlwiIDogb2JqLmNzcztcblxuXHRpZiAoc3R5bGUuc3R5bGVTaGVldCkge1xuXHRcdHN0eWxlLnN0eWxlU2hlZXQuY3NzVGV4dCA9IHJlcGxhY2VUZXh0KGluZGV4LCBjc3MpO1xuXHR9IGVsc2Uge1xuXHRcdHZhciBjc3NOb2RlID0gZG9jdW1lbnQuY3JlYXRlVGV4dE5vZGUoY3NzKTtcblx0XHR2YXIgY2hpbGROb2RlcyA9IHN0eWxlLmNoaWxkTm9kZXM7XG5cblx0XHRpZiAoY2hpbGROb2Rlc1tpbmRleF0pIHN0eWxlLnJlbW92ZUNoaWxkKGNoaWxkTm9kZXNbaW5kZXhdKTtcblxuXHRcdGlmIChjaGlsZE5vZGVzLmxlbmd0aCkge1xuXHRcdFx0c3R5bGUuaW5zZXJ0QmVmb3JlKGNzc05vZGUsIGNoaWxkTm9kZXNbaW5kZXhdKTtcblx0XHR9IGVsc2Uge1xuXHRcdFx0c3R5bGUuYXBwZW5kQ2hpbGQoY3NzTm9kZSk7XG5cdFx0fVxuXHR9XG59XG5cbmZ1bmN0aW9uIGFwcGx5VG9UYWcgKHN0eWxlLCBvYmopIHtcblx0dmFyIGNzcyA9IG9iai5jc3M7XG5cdHZhciBtZWRpYSA9IG9iai5tZWRpYTtcblxuXHRpZihtZWRpYSkge1xuXHRcdHN0eWxlLnNldEF0dHJpYnV0ZShcIm1lZGlhXCIsIG1lZGlhKVxuXHR9XG5cblx0aWYoc3R5bGUuc3R5bGVTaGVldCkge1xuXHRcdHN0eWxlLnN0eWxlU2hlZXQuY3NzVGV4dCA9IGNzcztcblx0fSBlbHNlIHtcblx0XHR3aGlsZShzdHlsZS5maXJzdENoaWxkKSB7XG5cdFx0XHRzdHlsZS5yZW1vdmVDaGlsZChzdHlsZS5maXJzdENoaWxkKTtcblx0XHR9XG5cblx0XHRzdHlsZS5hcHBlbmRDaGlsZChkb2N1bWVudC5jcmVhdGVUZXh0Tm9kZShjc3MpKTtcblx0fVxufVxuXG5mdW5jdGlvbiB1cGRhdGVMaW5rIChsaW5rLCBvcHRpb25zLCBvYmopIHtcblx0dmFyIGNzcyA9IG9iai5jc3M7XG5cdHZhciBzb3VyY2VNYXAgPSBvYmouc291cmNlTWFwO1xuXG5cdC8qXG5cdFx0SWYgY29udmVydFRvQWJzb2x1dGVVcmxzIGlzbid0IGRlZmluZWQsIGJ1dCBzb3VyY2VtYXBzIGFyZSBlbmFibGVkXG5cdFx0YW5kIHRoZXJlIGlzIG5vIHB1YmxpY1BhdGggZGVmaW5lZCB0aGVuIGxldHMgdHVybiBjb252ZXJ0VG9BYnNvbHV0ZVVybHNcblx0XHRvbiBieSBkZWZhdWx0LiAgT3RoZXJ3aXNlIGRlZmF1bHQgdG8gdGhlIGNvbnZlcnRUb0Fic29sdXRlVXJscyBvcHRpb25cblx0XHRkaXJlY3RseVxuXHQqL1xuXHR2YXIgYXV0b0ZpeFVybHMgPSBvcHRpb25zLmNvbnZlcnRUb0Fic29sdXRlVXJscyA9PT0gdW5kZWZpbmVkICYmIHNvdXJjZU1hcDtcblxuXHRpZiAob3B0aW9ucy5jb252ZXJ0VG9BYnNvbHV0ZVVybHMgfHwgYXV0b0ZpeFVybHMpIHtcblx0XHRjc3MgPSBmaXhVcmxzKGNzcyk7XG5cdH1cblxuXHRpZiAoc291cmNlTWFwKSB7XG5cdFx0Ly8gaHR0cDovL3N0YWNrb3ZlcmZsb3cuY29tL2EvMjY2MDM4NzVcblx0XHRjc3MgKz0gXCJcXG4vKiMgc291cmNlTWFwcGluZ1VSTD1kYXRhOmFwcGxpY2F0aW9uL2pzb247YmFzZTY0LFwiICsgYnRvYSh1bmVzY2FwZShlbmNvZGVVUklDb21wb25lbnQoSlNPTi5zdHJpbmdpZnkoc291cmNlTWFwKSkpKSArIFwiICovXCI7XG5cdH1cblxuXHR2YXIgYmxvYiA9IG5ldyBCbG9iKFtjc3NdLCB7IHR5cGU6IFwidGV4dC9jc3NcIiB9KTtcblxuXHR2YXIgb2xkU3JjID0gbGluay5ocmVmO1xuXG5cdGxpbmsuaHJlZiA9IFVSTC5jcmVhdGVPYmplY3RVUkwoYmxvYik7XG5cblx0aWYob2xkU3JjKSBVUkwucmV2b2tlT2JqZWN0VVJMKG9sZFNyYyk7XG59XG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL25vZGVfbW9kdWxlcy9zdHlsZS1sb2FkZXIvbGliL2FkZFN0eWxlcy5qc1xuLy8gbW9kdWxlIGlkID0gMTRcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiXG4vKipcbiAqIFdoZW4gc291cmNlIG1hcHMgYXJlIGVuYWJsZWQsIGBzdHlsZS1sb2FkZXJgIHVzZXMgYSBsaW5rIGVsZW1lbnQgd2l0aCBhIGRhdGEtdXJpIHRvXG4gKiBlbWJlZCB0aGUgY3NzIG9uIHRoZSBwYWdlLiBUaGlzIGJyZWFrcyBhbGwgcmVsYXRpdmUgdXJscyBiZWNhdXNlIG5vdyB0aGV5IGFyZSByZWxhdGl2ZSB0byBhXG4gKiBidW5kbGUgaW5zdGVhZCBvZiB0aGUgY3VycmVudCBwYWdlLlxuICpcbiAqIE9uZSBzb2x1dGlvbiBpcyB0byBvbmx5IHVzZSBmdWxsIHVybHMsIGJ1dCB0aGF0IG1heSBiZSBpbXBvc3NpYmxlLlxuICpcbiAqIEluc3RlYWQsIHRoaXMgZnVuY3Rpb24gXCJmaXhlc1wiIHRoZSByZWxhdGl2ZSB1cmxzIHRvIGJlIGFic29sdXRlIGFjY29yZGluZyB0byB0aGUgY3VycmVudCBwYWdlIGxvY2F0aW9uLlxuICpcbiAqIEEgcnVkaW1lbnRhcnkgdGVzdCBzdWl0ZSBpcyBsb2NhdGVkIGF0IGB0ZXN0L2ZpeFVybHMuanNgIGFuZCBjYW4gYmUgcnVuIHZpYSB0aGUgYG5wbSB0ZXN0YCBjb21tYW5kLlxuICpcbiAqL1xuXG5tb2R1bGUuZXhwb3J0cyA9IGZ1bmN0aW9uIChjc3MpIHtcbiAgLy8gZ2V0IGN1cnJlbnQgbG9jYXRpb25cbiAgdmFyIGxvY2F0aW9uID0gdHlwZW9mIHdpbmRvdyAhPT0gXCJ1bmRlZmluZWRcIiAmJiB3aW5kb3cubG9jYXRpb247XG5cbiAgaWYgKCFsb2NhdGlvbikge1xuICAgIHRocm93IG5ldyBFcnJvcihcImZpeFVybHMgcmVxdWlyZXMgd2luZG93LmxvY2F0aW9uXCIpO1xuICB9XG5cblx0Ly8gYmxhbmsgb3IgbnVsbD9cblx0aWYgKCFjc3MgfHwgdHlwZW9mIGNzcyAhPT0gXCJzdHJpbmdcIikge1xuXHQgIHJldHVybiBjc3M7XG4gIH1cblxuICB2YXIgYmFzZVVybCA9IGxvY2F0aW9uLnByb3RvY29sICsgXCIvL1wiICsgbG9jYXRpb24uaG9zdDtcbiAgdmFyIGN1cnJlbnREaXIgPSBiYXNlVXJsICsgbG9jYXRpb24ucGF0aG5hbWUucmVwbGFjZSgvXFwvW15cXC9dKiQvLCBcIi9cIik7XG5cblx0Ly8gY29udmVydCBlYWNoIHVybCguLi4pXG5cdC8qXG5cdFRoaXMgcmVndWxhciBleHByZXNzaW9uIGlzIGp1c3QgYSB3YXkgdG8gcmVjdXJzaXZlbHkgbWF0Y2ggYnJhY2tldHMgd2l0aGluXG5cdGEgc3RyaW5nLlxuXG5cdCAvdXJsXFxzKlxcKCAgPSBNYXRjaCBvbiB0aGUgd29yZCBcInVybFwiIHdpdGggYW55IHdoaXRlc3BhY2UgYWZ0ZXIgaXQgYW5kIHRoZW4gYSBwYXJlbnNcblx0ICAgKCAgPSBTdGFydCBhIGNhcHR1cmluZyBncm91cFxuXHQgICAgICg/OiAgPSBTdGFydCBhIG5vbi1jYXB0dXJpbmcgZ3JvdXBcblx0ICAgICAgICAgW14pKF0gID0gTWF0Y2ggYW55dGhpbmcgdGhhdCBpc24ndCBhIHBhcmVudGhlc2VzXG5cdCAgICAgICAgIHwgID0gT1Jcblx0ICAgICAgICAgXFwoICA9IE1hdGNoIGEgc3RhcnQgcGFyZW50aGVzZXNcblx0ICAgICAgICAgICAgICg/OiAgPSBTdGFydCBhbm90aGVyIG5vbi1jYXB0dXJpbmcgZ3JvdXBzXG5cdCAgICAgICAgICAgICAgICAgW14pKF0rICA9IE1hdGNoIGFueXRoaW5nIHRoYXQgaXNuJ3QgYSBwYXJlbnRoZXNlc1xuXHQgICAgICAgICAgICAgICAgIHwgID0gT1Jcblx0ICAgICAgICAgICAgICAgICBcXCggID0gTWF0Y2ggYSBzdGFydCBwYXJlbnRoZXNlc1xuXHQgICAgICAgICAgICAgICAgICAgICBbXikoXSogID0gTWF0Y2ggYW55dGhpbmcgdGhhdCBpc24ndCBhIHBhcmVudGhlc2VzXG5cdCAgICAgICAgICAgICAgICAgXFwpICA9IE1hdGNoIGEgZW5kIHBhcmVudGhlc2VzXG5cdCAgICAgICAgICAgICApICA9IEVuZCBHcm91cFxuICAgICAgICAgICAgICAqXFwpID0gTWF0Y2ggYW55dGhpbmcgYW5kIHRoZW4gYSBjbG9zZSBwYXJlbnNcbiAgICAgICAgICApICA9IENsb3NlIG5vbi1jYXB0dXJpbmcgZ3JvdXBcbiAgICAgICAgICAqICA9IE1hdGNoIGFueXRoaW5nXG4gICAgICAgKSAgPSBDbG9zZSBjYXB0dXJpbmcgZ3JvdXBcblx0IFxcKSAgPSBNYXRjaCBhIGNsb3NlIHBhcmVuc1xuXG5cdCAvZ2kgID0gR2V0IGFsbCBtYXRjaGVzLCBub3QgdGhlIGZpcnN0LiAgQmUgY2FzZSBpbnNlbnNpdGl2ZS5cblx0ICovXG5cdHZhciBmaXhlZENzcyA9IGNzcy5yZXBsYWNlKC91cmxcXHMqXFwoKCg/OlteKShdfFxcKCg/OlteKShdK3xcXChbXikoXSpcXCkpKlxcKSkqKVxcKS9naSwgZnVuY3Rpb24oZnVsbE1hdGNoLCBvcmlnVXJsKSB7XG5cdFx0Ly8gc3RyaXAgcXVvdGVzIChpZiB0aGV5IGV4aXN0KVxuXHRcdHZhciB1bnF1b3RlZE9yaWdVcmwgPSBvcmlnVXJsXG5cdFx0XHQudHJpbSgpXG5cdFx0XHQucmVwbGFjZSgvXlwiKC4qKVwiJC8sIGZ1bmN0aW9uKG8sICQxKXsgcmV0dXJuICQxOyB9KVxuXHRcdFx0LnJlcGxhY2UoL14nKC4qKSckLywgZnVuY3Rpb24obywgJDEpeyByZXR1cm4gJDE7IH0pO1xuXG5cdFx0Ly8gYWxyZWFkeSBhIGZ1bGwgdXJsPyBubyBjaGFuZ2Vcblx0XHRpZiAoL14oI3xkYXRhOnxodHRwOlxcL1xcL3xodHRwczpcXC9cXC98ZmlsZTpcXC9cXC9cXC8pL2kudGVzdCh1bnF1b3RlZE9yaWdVcmwpKSB7XG5cdFx0ICByZXR1cm4gZnVsbE1hdGNoO1xuXHRcdH1cblxuXHRcdC8vIGNvbnZlcnQgdGhlIHVybCB0byBhIGZ1bGwgdXJsXG5cdFx0dmFyIG5ld1VybDtcblxuXHRcdGlmICh1bnF1b3RlZE9yaWdVcmwuaW5kZXhPZihcIi8vXCIpID09PSAwKSB7XG5cdFx0ICBcdC8vVE9ETzogc2hvdWxkIHdlIGFkZCBwcm90b2NvbD9cblx0XHRcdG5ld1VybCA9IHVucXVvdGVkT3JpZ1VybDtcblx0XHR9IGVsc2UgaWYgKHVucXVvdGVkT3JpZ1VybC5pbmRleE9mKFwiL1wiKSA9PT0gMCkge1xuXHRcdFx0Ly8gcGF0aCBzaG91bGQgYmUgcmVsYXRpdmUgdG8gdGhlIGJhc2UgdXJsXG5cdFx0XHRuZXdVcmwgPSBiYXNlVXJsICsgdW5xdW90ZWRPcmlnVXJsOyAvLyBhbHJlYWR5IHN0YXJ0cyB3aXRoICcvJ1xuXHRcdH0gZWxzZSB7XG5cdFx0XHQvLyBwYXRoIHNob3VsZCBiZSByZWxhdGl2ZSB0byBjdXJyZW50IGRpcmVjdG9yeVxuXHRcdFx0bmV3VXJsID0gY3VycmVudERpciArIHVucXVvdGVkT3JpZ1VybC5yZXBsYWNlKC9eXFwuXFwvLywgXCJcIik7IC8vIFN0cmlwIGxlYWRpbmcgJy4vJ1xuXHRcdH1cblxuXHRcdC8vIHNlbmQgYmFjayB0aGUgZml4ZWQgdXJsKC4uLilcblx0XHRyZXR1cm4gXCJ1cmwoXCIgKyBKU09OLnN0cmluZ2lmeShuZXdVcmwpICsgXCIpXCI7XG5cdH0pO1xuXG5cdC8vIHNlbmQgYmFjayB0aGUgZml4ZWQgY3NzXG5cdHJldHVybiBmaXhlZENzcztcbn07XG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL25vZGVfbW9kdWxlcy9zdHlsZS1sb2FkZXIvbGliL3VybHMuanNcbi8vIG1vZHVsZSBpZCA9IDE1XG4vLyBtb2R1bGUgY2h1bmtzID0gMCJdLCJzb3VyY2VSb290IjoiIn0=