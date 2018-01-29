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

__webpack_require__(7);

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

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var Game = function () {
    function Game(aCanvas) {
        _classCallCheck(this, Game);

        this.myCanvas = aCanvas;
        this.raf = undefined;
        this.context = this.myCanvas.getContext('2d');

        this.starship = undefined;
        this.saucers = [];
        this.score = 0;

        this.init();
        this.firstDraw = true;

        this.scoreSpan = undefined;
    }

    _createClass(Game, [{
        key: 'init',
        value: function init() {
            this.starship = new _Starship2.default(this.myCanvas, 40, this.myCanvas.height / 2);
            this.saucers = [];
            this.score = 0;
        }
    }, {
        key: 'addSaucer',
        value: function addSaucer() {
            var x = this.myCanvas.width;
            var y = Math.floor(Math.random() * this.myCanvas.height);

            this.saucers.push(new _Saucer2.default(this.myCanvas, x, y, this));
            console.log("added saucer");
        }
    }, {
        key: 'infiniteSaucers',
        value: function infiniteSaucers() {
            // nothing
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

            this.raf = window.requestAnimationFrame(this.animate.bind(this));
        }
    }, {
        key: 'keyDownActionHandler',
        value: function keyDownActionHandler(event) {
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

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(8);
if(typeof content === 'string') content = [[module.i, content, '']];
// Prepare cssTransformation
var transform;

var options = {"hmr":true}
options.transform = transform
// add the styles to the DOM
var update = __webpack_require__(12)(content, options);
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
/* 8 */
/***/ (function(module, exports, __webpack_require__) {

var escape = __webpack_require__(9);
exports = module.exports = __webpack_require__(10)(false);
// imports


// module
exports.push([module.i, "html {\n  background-color : rgba(0,0,0,0.5);\n}\n#stars {    \n    display : block;\n    margin : auto;\n    background-image: url(" + escape(__webpack_require__(11)) + ");\n    background-repeat: repeat-x;\n    background-size: cover;\n    background-position : 0px 0px;\n    border : 2px solid white;\n    \n}\n\n  #stars {\n    animation-duration: 30s;\n    animation-name: starsSlide;\n    animation-iteration-count: infinite;\n    animation-timing-function: linear;\n  }\n \n\n@keyframes starsSlide {\n    from {\n      background-position : 1200px 0px;\n    }\n    \n    to {\n     background-position : 0px 0px;     \n    }\n  }\n\n\n\ndiv#control {\n  text-align : center;\n  margin : 10px;\n}\n\nbutton {\n  font-size : 40px; \n}\n\nspan#score{\n  display : inline-block;\n  width : 100px;\n  font-size : 30px;\n  text-align : right;\n  background-color : white;\n  padding : 4px;\n  margin : 4px;\n}", ""]);

// exports


/***/ }),
/* 9 */
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
/* 10 */
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
/* 11 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "images/imge29a20418ee63aceb1bc73d172b7367e.png";

/***/ }),
/* 12 */
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

var	fixUrls = __webpack_require__(13);

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
/* 13 */
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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly8vd2VicGFjay9ib290c3RyYXAgZWIzNmI2ODRiYmQ0YzdkYjE2NTUiLCJ3ZWJwYWNrOi8vLy4vc3JjL3NjcmlwdHMvTW9iaWxlLmpzIiwid2VicGFjazovLy8uL3NyYy9pbWFnZXMvZmx5aW5nU2F1Y2VyLXBldGl0LnBuZyIsIndlYnBhY2s6Ly8vLi9zcmMvc2NyaXB0cy9tYWluLmpzIiwid2VicGFjazovLy8uL3NyYy9zY3JpcHRzL0dhbWUuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL3NjcmlwdHMvU3RhcnNoaXAuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL2ltYWdlcy92YWlzc2VhdS1iYWxsb24tcGV0aXQucG5nIiwid2VicGFjazovLy8uL3NyYy9zY3JpcHRzL1NhdWNlci5qcyIsIndlYnBhY2s6Ly8vLi9zcmMvc3R5bGUvc3R5bGUuY3NzPzc4OTAiLCJ3ZWJwYWNrOi8vLy4vc3JjL3N0eWxlL3N0eWxlLmNzcyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qcyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvY3NzLWJhc2UuanMiLCJ3ZWJwYWNrOi8vLy4vc3JjL2ltYWdlcy9jaWVsLW5vY3R1cm5lLnBuZyIsIndlYnBhY2s6Ly8vLi9ub2RlX21vZHVsZXMvc3R5bGUtbG9hZGVyL2xpYi9hZGRTdHlsZXMuanMiLCJ3ZWJwYWNrOi8vLy4vbm9kZV9tb2R1bGVzL3N0eWxlLWxvYWRlci9saWIvdXJscy5qcyJdLCJuYW1lcyI6WyJNb2JpbGUiLCJhQ2FudmFzIiwic3JjSW1hZ2UiLCJ4IiwieSIsInZ4IiwidnkiLCJteUNhbnZhcyIsImNvbnRleHQiLCJnZXRDb250ZXh0IiwiaW1nTW9iaWxlIiwiSW1hZ2UiLCJpbWdMb2FkZWQiLCJhZGRFdmVudExpc3RlbmVyIiwiaW1nTG9hZExpc3RlbmVyIiwiYmluZCIsInNyYyIsImRyYXdJbWFnZSIsInNldHVwR2FtZSIsInRoZUNhbnZhcyIsImdhbWUiLCJjb25zdHJ1Y3RvciIsInVuZGVmaW5lZCIsIk9iamVjdCIsImdldFByb3RvdHlwZU9mIiwid2luZG93Iiwia2V5RG93bkFjdGlvbkhhbmRsZXIiLCJrZXlVcEFjdGlvbkhhbmRsZXIiLCJzY29yZVNwYW4iLCJkb2N1bWVudCIsImdldEVsZW1lbnRCeUlkIiwic2V0SFRNTFNjb3JlIiwic2V0dXBCdXR0b25zIiwibmV3U2F1Y2VyQnV0dG9uIiwiYWRkU2F1Y2VyIiwiaW5maW5pdGVTYXVjZXJzIiwic2V0dXAiLCJhbmltYXRlIiwiR2FtZSIsInJhZiIsInN0YXJzaGlwIiwic2F1Y2VycyIsInNjb3JlIiwiaW5pdCIsImZpcnN0RHJhdyIsImhlaWdodCIsIndpZHRoIiwiTWF0aCIsImZsb29yIiwicmFuZG9tIiwicHVzaCIsImNvbnNvbGUiLCJsb2ciLCJzYXVjZXIiLCJmaWx0ZXIiLCJlIiwidXBkYXRlU2NvcmVPbkxvc3RTYXVjZXIiLCJ1cGRhdGVTY29yZVNwYW4iLCJjbGVhclJlY3QiLCJpc01vdmluZyIsIm1vdmUiLCJkcmF3Iiwic2luZ2xlU2F1Y2VyIiwicmVxdWVzdEFuaW1hdGlvbkZyYW1lIiwiZXZlbnQiLCJrZXkiLCJtb3ZlVXAiLCJtb3ZlRG93biIsInByZXZlbnREZWZhdWx0Iiwic3RvcE1vdmUiLCJpbm5lckhUTUwiLCJNb3ZlU3RhdGUiLCJVUCIsIkRPV04iLCJOT05FIiwiU3RhcnNoaXAiLCJpbml0WCIsImluaXRZIiwibW92aW5nIiwib2dWWSIsIm9nVlgiLCJjYWxjWSIsInZhbGlkTW92ZSIsImNhbGNYIiwiU2F1Y2VyIiwicmVtb3ZlU2F1Y2VyIl0sIm1hcHBpbmdzIjoiO0FBQUE7QUFDQTs7QUFFQTtBQUNBOztBQUVBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOztBQUVBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7OztBQUdBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBO0FBQ0E7QUFD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O0FBQ0EsRUFBRTs7QUFFRjtBQUNBO0FBQ0EiLCJmaWxlIjoic2NyaXB0cy9idW5kbGUuanMiLCJzb3VyY2VzQ29udGVudCI6WyIgXHQvLyBUaGUgbW9kdWxlIGNhY2hlXG4gXHR2YXIgaW5zdGFsbGVkTW9kdWxlcyA9IHt9O1xuXG4gXHQvLyBUaGUgcmVxdWlyZSBmdW5jdGlvblxuIFx0ZnVuY3Rpb24gX193ZWJwYWNrX3JlcXVpcmVfXyhtb2R1bGVJZCkge1xuXG4gXHRcdC8vIENoZWNrIGlmIG1vZHVsZSBpcyBpbiBjYWNoZVxuIFx0XHRpZihpbnN0YWxsZWRNb2R1bGVzW21vZHVsZUlkXSkge1xuIFx0XHRcdHJldHVybiBpbnN0YWxsZWRNb2R1bGVzW21vZHVsZUlkXS5leHBvcnRzO1xuIFx0XHR9XG4gXHRcdC8vIENyZWF0ZSBhIG5ldyBtb2R1bGUgKGFuZCBwdXQgaXQgaW50byB0aGUgY2FjaGUpXG4gXHRcdHZhciBtb2R1bGUgPSBpbnN0YWxsZWRNb2R1bGVzW21vZHVsZUlkXSA9IHtcbiBcdFx0XHRpOiBtb2R1bGVJZCxcbiBcdFx0XHRsOiBmYWxzZSxcbiBcdFx0XHRleHBvcnRzOiB7fVxuIFx0XHR9O1xuXG4gXHRcdC8vIEV4ZWN1dGUgdGhlIG1vZHVsZSBmdW5jdGlvblxuIFx0XHRtb2R1bGVzW21vZHVsZUlkXS5jYWxsKG1vZHVsZS5leHBvcnRzLCBtb2R1bGUsIG1vZHVsZS5leHBvcnRzLCBfX3dlYnBhY2tfcmVxdWlyZV9fKTtcblxuIFx0XHQvLyBGbGFnIHRoZSBtb2R1bGUgYXMgbG9hZGVkXG4gXHRcdG1vZHVsZS5sID0gdHJ1ZTtcblxuIFx0XHQvLyBSZXR1cm4gdGhlIGV4cG9ydHMgb2YgdGhlIG1vZHVsZVxuIFx0XHRyZXR1cm4gbW9kdWxlLmV4cG9ydHM7XG4gXHR9XG5cblxuIFx0Ly8gZXhwb3NlIHRoZSBtb2R1bGVzIG9iamVjdCAoX193ZWJwYWNrX21vZHVsZXNfXylcbiBcdF9fd2VicGFja19yZXF1aXJlX18ubSA9IG1vZHVsZXM7XG5cbiBcdC8vIGV4cG9zZSB0aGUgbW9kdWxlIGNhY2hlXG4gXHRfX3dlYnBhY2tfcmVxdWlyZV9fLmMgPSBpbnN0YWxsZWRNb2R1bGVzO1xuXG4gXHQvLyBkZWZpbmUgZ2V0dGVyIGZ1bmN0aW9uIGZvciBoYXJtb255IGV4cG9ydHNcbiBcdF9fd2VicGFja19yZXF1aXJlX18uZCA9IGZ1bmN0aW9uKGV4cG9ydHMsIG5hbWUsIGdldHRlcikge1xuIFx0XHRpZighX193ZWJwYWNrX3JlcXVpcmVfXy5vKGV4cG9ydHMsIG5hbWUpKSB7XG4gXHRcdFx0T2JqZWN0LmRlZmluZVByb3BlcnR5KGV4cG9ydHMsIG5hbWUsIHtcbiBcdFx0XHRcdGNvbmZpZ3VyYWJsZTogZmFsc2UsXG4gXHRcdFx0XHRlbnVtZXJhYmxlOiB0cnVlLFxuIFx0XHRcdFx0Z2V0OiBnZXR0ZXJcbiBcdFx0XHR9KTtcbiBcdFx0fVxuIFx0fTtcblxuIFx0Ly8gZ2V0RGVmYXVsdEV4cG9ydCBmdW5jdGlvbiBmb3IgY29tcGF0aWJpbGl0eSB3aXRoIG5vbi1oYXJtb255IG1vZHVsZXNcbiBcdF9fd2VicGFja19yZXF1aXJlX18ubiA9IGZ1bmN0aW9uKG1vZHVsZSkge1xuIFx0XHR2YXIgZ2V0dGVyID0gbW9kdWxlICYmIG1vZHVsZS5fX2VzTW9kdWxlID9cbiBcdFx0XHRmdW5jdGlvbiBnZXREZWZhdWx0KCkgeyByZXR1cm4gbW9kdWxlWydkZWZhdWx0J107IH0gOlxuIFx0XHRcdGZ1bmN0aW9uIGdldE1vZHVsZUV4cG9ydHMoKSB7IHJldHVybiBtb2R1bGU7IH07XG4gXHRcdF9fd2VicGFja19yZXF1aXJlX18uZChnZXR0ZXIsICdhJywgZ2V0dGVyKTtcbiBcdFx0cmV0dXJuIGdldHRlcjtcbiBcdH07XG5cbiBcdC8vIE9iamVjdC5wcm90b3R5cGUuaGFzT3duUHJvcGVydHkuY2FsbFxuIFx0X193ZWJwYWNrX3JlcXVpcmVfXy5vID0gZnVuY3Rpb24ob2JqZWN0LCBwcm9wZXJ0eSkgeyByZXR1cm4gT2JqZWN0LnByb3RvdHlwZS5oYXNPd25Qcm9wZXJ0eS5jYWxsKG9iamVjdCwgcHJvcGVydHkpOyB9O1xuXG4gXHQvLyBfX3dlYnBhY2tfcHVibGljX3BhdGhfX1xuIFx0X193ZWJwYWNrX3JlcXVpcmVfXy5wID0gXCJcIjtcblxuIFx0Ly8gTG9hZCBlbnRyeSBtb2R1bGUgYW5kIHJldHVybiBleHBvcnRzXG4gXHRyZXR1cm4gX193ZWJwYWNrX3JlcXVpcmVfXyhfX3dlYnBhY2tfcmVxdWlyZV9fLnMgPSAyKTtcblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyB3ZWJwYWNrL2Jvb3RzdHJhcCBlYjM2YjY4NGJiZDRjN2RiMTY1NSIsImV4cG9ydCBkZWZhdWx0IGNsYXNzIE1vYmlsZSB7XG4gICAgY29uc3RydWN0b3IoYUNhbnZhcywgc3JjSW1hZ2UsIHgsIHksIHZ4LCB2eSkge1xuICAgICAgICB0aGlzLm15Q2FudmFzID0gYUNhbnZhcztcbiAgICAgICAgdGhpcy5jb250ZXh0ID0gdGhpcy5teUNhbnZhcy5nZXRDb250ZXh0KFwiMmRcIik7XG5cbiAgICAgICAgdGhpcy5pbWdNb2JpbGUgPSBuZXcgSW1hZ2UoKTtcbiAgICAgICAgdGhpcy5pbWdMb2FkZWQgPSBmYWxzZTtcbiAgICAgICAgdGhpcy5pbWdNb2JpbGUuYWRkRXZlbnRMaXN0ZW5lcihcImxvYWRcIiwgdGhpcy5pbWdMb2FkTGlzdGVuZXIuYmluZCh0aGlzKSk7XG4gICAgICAgIHRoaXMuaW1nTW9iaWxlLnNyYyA9IHNyY0ltYWdlO1xuXG4gICAgICAgIHRoaXMueCA9IHg7XG4gICAgICAgIHRoaXMueSA9IHk7XG4gICAgICAgIHRoaXMudnggPSB2eDtcbiAgICAgICAgdGhpcy52eSA9IHZ5O1xuICAgIH1cblxuICAgIGRyYXcoKSB7XG4gICAgICAgIGlmICh0aGlzLmltZ0xvYWRlZCA9PT0gdHJ1ZSkge1xuICAgICAgICAgICAgdGhpcy5jb250ZXh0LmRyYXdJbWFnZSh0aGlzLmltZ01vYmlsZSwgdGhpcy54LCB0aGlzLnkpO1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgbW92ZSgpIHtcbiAgICAgICAgdGhpcy54ICs9IHRoaXMudng7XG4gICAgICAgIHRoaXMueSArPSB0aGlzLnZ5O1xuICAgIH1cblxuICAgIGltZ0xvYWRMaXN0ZW5lcigpIHtcbiAgICAgICAgdGhpcy5pbWdMb2FkZWQgPSB0cnVlO1xuICAgIH1cbn1cblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL01vYmlsZS5qcyIsIm1vZHVsZS5leHBvcnRzID0gX193ZWJwYWNrX3B1YmxpY19wYXRoX18gKyBcImltYWdlcy9pbWdiM2VkNTAwYmFiOTZlY2Q4MjA1MmEyYWVkZjliMmUwNC5wbmdcIjtcblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9pbWFnZXMvZmx5aW5nU2F1Y2VyLXBldGl0LnBuZ1xuLy8gbW9kdWxlIGlkID0gMVxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJpbXBvcnQgR2FtZSBmcm9tICcuL0dhbWUuanMnO1xuXG5pbXBvcnQgJy4uL3N0eWxlL3N0eWxlLmNzcyc7XG5pbXBvcnQgc2F1Y2VyU3JjIGZyb20gJy4uL2ltYWdlcy9mbHlpbmdTYXVjZXItcGV0aXQucG5nJztcblxuXG5mdW5jdGlvbiBzZXR1cEdhbWUodGhlQ2FudmFzKSB7XG4gICAgbGV0IGdhbWUgPSBuZXcgR2FtZSh0aGVDYW52YXMpO1xuICAgIGdhbWUuY29uc3RydWN0b3IgPSB1bmRlZmluZWQ7XG4gICAgT2JqZWN0LmdldFByb3RvdHlwZU9mKGdhbWUpLmNvbnN0cnVjdG9yID0gdW5kZWZpbmVkO1xuXG4gICAgd2luZG93LmFkZEV2ZW50TGlzdGVuZXIoJ2tleWRvd24nLCBnYW1lLmtleURvd25BY3Rpb25IYW5kbGVyLmJpbmQoZ2FtZSkpO1xuICAgIHdpbmRvdy5hZGRFdmVudExpc3RlbmVyKCdrZXl1cCcsIGdhbWUua2V5VXBBY3Rpb25IYW5kbGVyLmJpbmQoZ2FtZSkpO1xuXG4gICAgbGV0IHNjb3JlU3BhbiA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwic2NvcmVcIik7XG4gICAgZ2FtZS5zZXRIVE1MU2NvcmUoc2NvcmVTcGFuKTtcblxuICAgIHJldHVybiBnYW1lO1xufVxuXG5mdW5jdGlvbiBzZXR1cEJ1dHRvbnMoZ2FtZSkge1xuICAgIGxldCBuZXdTYXVjZXJCdXR0b24gPSBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcIm5vdXZlbGxlU291Y291cGVcIik7XG4gICAgbmV3U2F1Y2VyQnV0dG9uLmFkZEV2ZW50TGlzdGVuZXIoXCJjbGlja1wiLCBnYW1lLmFkZFNhdWNlci5iaW5kKGdhbWUpKTtcbiAgICBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcIm5ld1NhdWNlckJ1dHRvbkltZ1wiKS5zcmMgPSBzYXVjZXJTcmM7XG5cbiAgICBsZXQgaW5maW5pdGVTYXVjZXJzID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJmbG90dGVTb3Vjb3VwZXNcIik7XG4gICAgaW5maW5pdGVTYXVjZXJzLmFkZEV2ZW50TGlzdGVuZXIoXCJjbGlja1wiLCBnYW1lLmluZmluaXRlU2F1Y2Vycy5iaW5kKGdhbWUpKTtcbiAgICBkb2N1bWVudC5nZXRFbGVtZW50QnlJZChcImluZmluaXRlU2F1Y2Vyc0J1dHRvbkltZ1wiKS5zcmMgPSBzYXVjZXJTcmM7XG59XG5cbnZhciBzZXR1cCA9IGZ1bmN0aW9uICgpIHtcbiAgICBsZXQgdGhlQ2FudmFzID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJzdGFyc1wiKTtcbiAgICBsZXQgZ2FtZSA9IHNldHVwR2FtZSh0aGVDYW52YXMpO1xuXG4gICAgc2V0dXBCdXR0b25zKGdhbWUpO1xuXG4gICAgZ2FtZS5hbmltYXRlKCk7XG5cbn07XG5cbndpbmRvdy5hZGRFdmVudExpc3RlbmVyKFwiRE9NQ29udGVudExvYWRlZFwiLCBzZXR1cCk7XG5cblxuXG4vLyBXRUJQQUNLIEZPT1RFUiAvL1xuLy8gLi9zcmMvc2NyaXB0cy9tYWluLmpzIiwiaW1wb3J0IFN0YXJzaGlwIGZyb20gJy4vU3RhcnNoaXAuanMnO1xuaW1wb3J0IFNhdWNlciBmcm9tICcuL1NhdWNlci5qcyc7XG5cblxuZXhwb3J0IGRlZmF1bHQgY2xhc3MgR2FtZSB7XG4gICAgY29uc3RydWN0b3IoYUNhbnZhcykge1xuICAgICAgICB0aGlzLm15Q2FudmFzID0gYUNhbnZhcztcbiAgICAgICAgdGhpcy5yYWYgPSB1bmRlZmluZWQ7XG4gICAgICAgIHRoaXMuY29udGV4dCA9IHRoaXMubXlDYW52YXMuZ2V0Q29udGV4dCgnMmQnKTtcblxuICAgICAgICB0aGlzLnN0YXJzaGlwID0gdW5kZWZpbmVkO1xuICAgICAgICB0aGlzLnNhdWNlcnMgPSBbXTtcbiAgICAgICAgdGhpcy5zY29yZSA9IDA7XG5cbiAgICAgICAgdGhpcy5pbml0KCk7XG4gICAgICAgIHRoaXMuZmlyc3REcmF3ID0gdHJ1ZTtcblxuICAgICAgICB0aGlzLnNjb3JlU3BhbiA9IHVuZGVmaW5lZDtcbiAgICB9XG5cbiAgICBpbml0KCkge1xuICAgICAgICB0aGlzLnN0YXJzaGlwID0gbmV3IFN0YXJzaGlwKHRoaXMubXlDYW52YXMsIDQwLCB0aGlzLm15Q2FudmFzLmhlaWdodCAvIDIpO1xuICAgICAgICB0aGlzLnNhdWNlcnMgPSBbXTtcbiAgICAgICAgdGhpcy5zY29yZSA9IDA7XG4gICAgfVxuXG4gICAgYWRkU2F1Y2VyKCkge1xuICAgICAgICBsZXQgeCA9IHRoaXMubXlDYW52YXMud2lkdGg7XG4gICAgICAgIGxldCB5ID0gTWF0aC5mbG9vcihNYXRoLnJhbmRvbSgpICogdGhpcy5teUNhbnZhcy5oZWlnaHQpO1xuXG4gICAgICAgIHRoaXMuc2F1Y2Vycy5wdXNoKG5ldyBTYXVjZXIodGhpcy5teUNhbnZhcywgeCwgeSwgdGhpcykpO1xuICAgICAgICBjb25zb2xlLmxvZyhcImFkZGVkIHNhdWNlclwiKTtcbiAgICB9XG5cbiAgICBpbmZpbml0ZVNhdWNlcnMoKSB7XG4gICAgICAgIC8vIG5vdGhpbmdcbiAgICB9XG5cbiAgICByZW1vdmVTYXVjZXIoc2F1Y2VyKSB7XG4gICAgICAgIHRoaXMuc2F1Y2VycyA9IHRoaXMuc2F1Y2Vycy5maWx0ZXIoZSA9PiBlICE9PSBzYXVjZXIpO1xuICAgICAgICB0aGlzLnVwZGF0ZVNjb3JlT25Mb3N0U2F1Y2VyKCk7XG4gICAgfVxuXG4gICAgdXBkYXRlU2NvcmVPbkxvc3RTYXVjZXIoKSB7XG4gICAgICAgIHRoaXMuc2NvcmUgLT0gMTAwMDtcbiAgICAgICAgdGhpcy51cGRhdGVTY29yZVNwYW4oKTtcbiAgICB9XG5cbiAgICB1cGRhdGVTY29yZU9uU2F1Y2VyU2hvdERvd24oKSB7XG4gICAgICAgIHRoaXMuc2NvcmUgKz0gMjAwO1xuICAgICAgICB0aGlzLnVwZGF0ZVNjb3JlU3BhbigpO1xuICAgIH1cblxuICAgIGFuaW1hdGUoKSB7XG4gICAgICAgIHRoaXMuY29udGV4dC5jbGVhclJlY3QoMCwgMCwgdGhpcy5teUNhbnZhcy53aWR0aCwgdGhpcy5teUNhbnZhcy5oZWlnaHQpO1xuXG4gICAgICAgIGlmICh0aGlzLmZpcnN0RHJhdyB8fCB0aGlzLnN0YXJzaGlwLmlzTW92aW5nKCkpIHtcbiAgICAgICAgICAgIHRoaXMuc3RhcnNoaXAubW92ZSh0aGlzKTtcbiAgICAgICAgICAgIHRoaXMuZmlyc3REcmF3ID0gZmFsc2U7XG4gICAgICAgIH1cbiAgICAgICAgdGhpcy5zdGFyc2hpcC5kcmF3KCk7XG5cbiAgICAgICAgZm9yIChsZXQgc2luZ2xlU2F1Y2VyIG9mIHRoaXMuc2F1Y2Vycykge1xuICAgICAgICAgICAgc2luZ2xlU2F1Y2VyLm1vdmUoKTtcbiAgICAgICAgICAgIHNpbmdsZVNhdWNlci5kcmF3KCk7XG4gICAgICAgIH1cblxuICAgICAgICB0aGlzLnJhZiA9IHdpbmRvdy5yZXF1ZXN0QW5pbWF0aW9uRnJhbWUodGhpcy5hbmltYXRlLmJpbmQodGhpcykpO1xuICAgIH1cblxuICAgIGtleURvd25BY3Rpb25IYW5kbGVyKGV2ZW50KSB7XG4gICAgICAgIHN3aXRjaCAoZXZlbnQua2V5KSB7XG4gICAgICAgICAgICBjYXNlIFwiQXJyb3dVcFwiOlxuICAgICAgICAgICAgY2FzZSBcIlVwXCI6XG4gICAgICAgICAgICAgICAgdGhpcy5zdGFyc2hpcC5tb3ZlVXAoKTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgXCJBcnJvd0Rvd25cIjpcbiAgICAgICAgICAgIGNhc2UgXCJEb3duXCI6XG4gICAgICAgICAgICAgICAgdGhpcy5zdGFyc2hpcC5tb3ZlRG93bigpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgIH1cbiAgICAgICAgZXZlbnQucHJldmVudERlZmF1bHQoKTtcbiAgICB9XG5cblxuICAgIGtleVVwQWN0aW9uSGFuZGxlcihldmVudCkge1xuICAgICAgICBzd2l0Y2ggKGV2ZW50LmtleSkge1xuICAgICAgICAgICAgY2FzZSBcIkFycm93VXBcIjpcbiAgICAgICAgICAgIGNhc2UgXCJVcFwiOlxuICAgICAgICAgICAgY2FzZSBcIkFycm93RG93blwiOlxuICAgICAgICAgICAgY2FzZSBcIkRvd25cIjpcbiAgICAgICAgICAgICAgICB0aGlzLnN0YXJzaGlwLnN0b3BNb3ZlKCk7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBkZWZhdWx0OlxuICAgICAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgfVxuICAgICAgICBldmVudC5wcmV2ZW50RGVmYXVsdCgpO1xuICAgIH1cblxuXG4gICAgc2V0SFRNTFNjb3JlKHNjb3JlU3Bhbikge1xuICAgICAgICB0aGlzLnNjb3JlU3BhbiA9IHNjb3JlU3BhbjtcbiAgICB9XG5cbiAgICB1cGRhdGVTY29yZVNwYW4oKSB7XG4gICAgICAgIHRoaXMuc2NvcmVTcGFuLmlubmVySFRNTCA9IHRoaXMuc2NvcmU7XG4gICAgfVxufVxuXG5cblxuLy8gV0VCUEFDSyBGT09URVIgLy9cbi8vIC4vc3JjL3NjcmlwdHMvR2FtZS5qcyIsImltcG9ydCBNb2JpbGUgZnJvbSAnLi9Nb2JpbGUuanMnXG5pbXBvcnQgc3RhcnNoaXBTcmMgZnJvbSAnLi4vaW1hZ2VzL3ZhaXNzZWF1LWJhbGxvbi1wZXRpdC5wbmcnO1xuXG52YXIgTW92ZVN0YXRlID0ge1VQOiAwLCBET1dOOiAxLCBOT05FOiAyfTtcblxuZXhwb3J0IGRlZmF1bHQgY2xhc3MgU3RhcnNoaXAgZXh0ZW5kcyBNb2JpbGUge1xuICAgIGNvbnN0cnVjdG9yKGFDYW52YXMsIGluaXRYLCBpbml0WSkge1xuICAgICAgICBzdXBlcihhQ2FudmFzLCBzdGFyc2hpcFNyYywgaW5pdFgsIGluaXRZLCAwLCA4KTtcbiAgICAgICAgdGhpcy5tb3ZpbmcgPSBNb3ZlU3RhdGUuTk9ORTtcblxuICAgICAgICB0aGlzLm9nVlkgPSB0aGlzLnZ5O1xuICAgICAgICB0aGlzLm9nVlggPSB0aGlzLnZ4O1xuICAgIH1cblxuICAgIGdldCB1cCgpIHtcbiAgICAgICAgcmV0dXJuIHRoaXMubW92aW5nID09PSBNb3ZlU3RhdGUuVVA7XG4gICAgfVxuXG4gICAgZ2V0IGRvd24oKSB7XG4gICAgICAgIHJldHVybiB0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLkRPV047XG4gICAgfVxuXG4gICAgbW92ZVVwKCkge1xuICAgICAgICB0aGlzLm1vdmluZyA9IE1vdmVTdGF0ZS5VUDtcbiAgICB9XG5cbiAgICBtb3ZlRG93bigpIHtcbiAgICAgICAgdGhpcy5tb3ZpbmcgPSBNb3ZlU3RhdGUuRE9XTjtcbiAgICB9XG5cbiAgICBtb3ZlKCkge1xuICAgICAgICBsZXQgY2FsY1k7XG4gICAgICAgIGlmICh0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLkRPV04pIHtcbiAgICAgICAgICAgIHRoaXMudnkgPSB0aGlzLm9nVlk7XG4gICAgICAgIH0gZWxzZSBpZiAodGhpcy5tb3ZpbmcgPT09IE1vdmVTdGF0ZS5VUCkge1xuICAgICAgICAgICAgdGhpcy52eSA9IC10aGlzLm9nVlk7XG4gICAgICAgIH1cblxuICAgICAgICBjYWxjWSA9IHRoaXMueSArIHRoaXMudnk7XG4gICAgICAgIGlmICh0aGlzLnZhbGlkTW92ZSgxLCBjYWxjWSkpIHtcbiAgICAgICAgICAgIHN1cGVyLm1vdmUoKTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIHN0b3BNb3ZlKCkge1xuICAgICAgICB0aGlzLm1vdmluZyA9IE1vdmVTdGF0ZS5OT05FO1xuICAgIH1cblxuICAgIHZhbGlkTW92ZShjYWxjWCwgY2FsY1kpIHtcbiAgICAgICAgcmV0dXJuIGNhbGNYID4gMCAmJiBjYWxjWSA+IDAgJiYgKGNhbGNYIDwgdGhpcy5teUNhbnZhcy53aWR0aCAtIDQwKSAmJiAoY2FsY1kgPCB0aGlzLm15Q2FudmFzLmhlaWdodCAtIDQwKTtcbiAgICB9XG5cblxuICAgIGlzTW92aW5nKCkge1xuICAgICAgICByZXR1cm4gdGhpcy5tb3ZpbmcgPT09IE1vdmVTdGF0ZS5VUCB8fCB0aGlzLm1vdmluZyA9PT0gTW92ZVN0YXRlLkRPV047XG4gICAgfVxufVxuXG5cblxuLy8gV0VCUEFDSyBGT09URVIgLy9cbi8vIC4vc3JjL3NjcmlwdHMvU3RhcnNoaXAuanMiLCJtb2R1bGUuZXhwb3J0cyA9IF9fd2VicGFja19wdWJsaWNfcGF0aF9fICsgXCJpbWFnZXMvaW1nZTFiZjQ1Y2VlODlmMWZmYzk3ZDdjYWI2YzQxYmQ3YzgucG5nXCI7XG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvaW1hZ2VzL3ZhaXNzZWF1LWJhbGxvbi1wZXRpdC5wbmdcbi8vIG1vZHVsZSBpZCA9IDVcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiaW1wb3J0IE1vYmlsZSBmcm9tICcuL01vYmlsZS5qcyc7XG5cbmltcG9ydCBzYXVjZXJTcmMgZnJvbSAnLi4vaW1hZ2VzL2ZseWluZ1NhdWNlci1wZXRpdC5wbmcnO1xuXG5leHBvcnQgZGVmYXVsdCBjbGFzcyBTYXVjZXIgZXh0ZW5kcyBNb2JpbGUge1xuICAgIGNvbnN0cnVjdG9yKGFDYW52YXMsIHgsIHksIGdhbWUpIHtcbiAgICAgICAgc3VwZXIoYUNhbnZhcywgc2F1Y2VyU3JjLCB4LCB5LCAtMywgMCk7XG4gICAgICAgIHRoaXMuZ2FtZSA9IGdhbWU7XG4gICAgfVxuXG4gICAgbW92ZSgpIHtcbiAgICAgICAgc3VwZXIubW92ZSgpO1xuXG4gICAgICAgIGlmICh0aGlzLnggPD0gMCkge1xuICAgICAgICAgICAgdGhpcy5nYW1lLnJlbW92ZVNhdWNlcih0aGlzKTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuXG5cbi8vIFdFQlBBQ0sgRk9PVEVSIC8vXG4vLyAuL3NyYy9zY3JpcHRzL1NhdWNlci5qcyIsIi8vIHN0eWxlLWxvYWRlcjogQWRkcyBzb21lIGNzcyB0byB0aGUgRE9NIGJ5IGFkZGluZyBhIDxzdHlsZT4gdGFnXG5cbi8vIGxvYWQgdGhlIHN0eWxlc1xudmFyIGNvbnRlbnQgPSByZXF1aXJlKFwiISEuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9pbmRleC5qcyEuL3N0eWxlLmNzc1wiKTtcbmlmKHR5cGVvZiBjb250ZW50ID09PSAnc3RyaW5nJykgY29udGVudCA9IFtbbW9kdWxlLmlkLCBjb250ZW50LCAnJ11dO1xuLy8gUHJlcGFyZSBjc3NUcmFuc2Zvcm1hdGlvblxudmFyIHRyYW5zZm9ybTtcblxudmFyIG9wdGlvbnMgPSB7XCJobXJcIjp0cnVlfVxub3B0aW9ucy50cmFuc2Zvcm0gPSB0cmFuc2Zvcm1cbi8vIGFkZCB0aGUgc3R5bGVzIHRvIHRoZSBET01cbnZhciB1cGRhdGUgPSByZXF1aXJlKFwiIS4uLy4uL25vZGVfbW9kdWxlcy9zdHlsZS1sb2FkZXIvbGliL2FkZFN0eWxlcy5qc1wiKShjb250ZW50LCBvcHRpb25zKTtcbmlmKGNvbnRlbnQubG9jYWxzKSBtb2R1bGUuZXhwb3J0cyA9IGNvbnRlbnQubG9jYWxzO1xuLy8gSG90IE1vZHVsZSBSZXBsYWNlbWVudFxuaWYobW9kdWxlLmhvdCkge1xuXHQvLyBXaGVuIHRoZSBzdHlsZXMgY2hhbmdlLCB1cGRhdGUgdGhlIDxzdHlsZT4gdGFnc1xuXHRpZighY29udGVudC5sb2NhbHMpIHtcblx0XHRtb2R1bGUuaG90LmFjY2VwdChcIiEhLi4vLi4vbm9kZV9tb2R1bGVzL2Nzcy1sb2FkZXIvaW5kZXguanMhLi9zdHlsZS5jc3NcIiwgZnVuY3Rpb24oKSB7XG5cdFx0XHR2YXIgbmV3Q29udGVudCA9IHJlcXVpcmUoXCIhIS4uLy4uL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyL2luZGV4LmpzIS4vc3R5bGUuY3NzXCIpO1xuXHRcdFx0aWYodHlwZW9mIG5ld0NvbnRlbnQgPT09ICdzdHJpbmcnKSBuZXdDb250ZW50ID0gW1ttb2R1bGUuaWQsIG5ld0NvbnRlbnQsICcnXV07XG5cdFx0XHR1cGRhdGUobmV3Q29udGVudCk7XG5cdFx0fSk7XG5cdH1cblx0Ly8gV2hlbiB0aGUgbW9kdWxlIGlzIGRpc3Bvc2VkLCByZW1vdmUgdGhlIDxzdHlsZT4gdGFnc1xuXHRtb2R1bGUuaG90LmRpc3Bvc2UoZnVuY3Rpb24oKSB7IHVwZGF0ZSgpOyB9KTtcbn1cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9zdHlsZS9zdHlsZS5jc3Ncbi8vIG1vZHVsZSBpZCA9IDdcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwidmFyIGVzY2FwZSA9IHJlcXVpcmUoXCIuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qc1wiKTtcbmV4cG9ydHMgPSBtb2R1bGUuZXhwb3J0cyA9IHJlcXVpcmUoXCIuLi8uLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvY3NzLWJhc2UuanNcIikoZmFsc2UpO1xuLy8gaW1wb3J0c1xuXG5cbi8vIG1vZHVsZVxuZXhwb3J0cy5wdXNoKFttb2R1bGUuaWQsIFwiaHRtbCB7XFxuICBiYWNrZ3JvdW5kLWNvbG9yIDogcmdiYSgwLDAsMCwwLjUpO1xcbn1cXG4jc3RhcnMgeyAgICBcXG4gICAgZGlzcGxheSA6IGJsb2NrO1xcbiAgICBtYXJnaW4gOiBhdXRvO1xcbiAgICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoXCIgKyBlc2NhcGUocmVxdWlyZShcIi4uL2ltYWdlcy9jaWVsLW5vY3R1cm5lLnBuZ1wiKSkgKyBcIik7XFxuICAgIGJhY2tncm91bmQtcmVwZWF0OiByZXBlYXQteDtcXG4gICAgYmFja2dyb3VuZC1zaXplOiBjb3ZlcjtcXG4gICAgYmFja2dyb3VuZC1wb3NpdGlvbiA6IDBweCAwcHg7XFxuICAgIGJvcmRlciA6IDJweCBzb2xpZCB3aGl0ZTtcXG4gICAgXFxufVxcblxcbiAgI3N0YXJzIHtcXG4gICAgYW5pbWF0aW9uLWR1cmF0aW9uOiAzMHM7XFxuICAgIGFuaW1hdGlvbi1uYW1lOiBzdGFyc1NsaWRlO1xcbiAgICBhbmltYXRpb24taXRlcmF0aW9uLWNvdW50OiBpbmZpbml0ZTtcXG4gICAgYW5pbWF0aW9uLXRpbWluZy1mdW5jdGlvbjogbGluZWFyO1xcbiAgfVxcbiBcXG5cXG5Aa2V5ZnJhbWVzIHN0YXJzU2xpZGUge1xcbiAgICBmcm9tIHtcXG4gICAgICBiYWNrZ3JvdW5kLXBvc2l0aW9uIDogMTIwMHB4IDBweDtcXG4gICAgfVxcbiAgICBcXG4gICAgdG8ge1xcbiAgICAgYmFja2dyb3VuZC1wb3NpdGlvbiA6IDBweCAwcHg7ICAgICBcXG4gICAgfVxcbiAgfVxcblxcblxcblxcbmRpdiNjb250cm9sIHtcXG4gIHRleHQtYWxpZ24gOiBjZW50ZXI7XFxuICBtYXJnaW4gOiAxMHB4O1xcbn1cXG5cXG5idXR0b24ge1xcbiAgZm9udC1zaXplIDogNDBweDsgXFxufVxcblxcbnNwYW4jc2NvcmV7XFxuICBkaXNwbGF5IDogaW5saW5lLWJsb2NrO1xcbiAgd2lkdGggOiAxMDBweDtcXG4gIGZvbnQtc2l6ZSA6IDMwcHg7XFxuICB0ZXh0LWFsaWduIDogcmlnaHQ7XFxuICBiYWNrZ3JvdW5kLWNvbG9yIDogd2hpdGU7XFxuICBwYWRkaW5nIDogNHB4O1xcbiAgbWFyZ2luIDogNHB4O1xcbn1cIiwgXCJcIl0pO1xuXG4vLyBleHBvcnRzXG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyIS4vc3JjL3N0eWxlL3N0eWxlLmNzc1xuLy8gbW9kdWxlIGlkID0gOFxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCJtb2R1bGUuZXhwb3J0cyA9IGZ1bmN0aW9uIGVzY2FwZSh1cmwpIHtcbiAgICBpZiAodHlwZW9mIHVybCAhPT0gJ3N0cmluZycpIHtcbiAgICAgICAgcmV0dXJuIHVybFxuICAgIH1cbiAgICAvLyBJZiB1cmwgaXMgYWxyZWFkeSB3cmFwcGVkIGluIHF1b3RlcywgcmVtb3ZlIHRoZW1cbiAgICBpZiAoL15bJ1wiXS4qWydcIl0kLy50ZXN0KHVybCkpIHtcbiAgICAgICAgdXJsID0gdXJsLnNsaWNlKDEsIC0xKTtcbiAgICB9XG4gICAgLy8gU2hvdWxkIHVybCBiZSB3cmFwcGVkP1xuICAgIC8vIFNlZSBodHRwczovL2RyYWZ0cy5jc3N3Zy5vcmcvY3NzLXZhbHVlcy0zLyN1cmxzXG4gICAgaWYgKC9bXCInKCkgXFx0XFxuXS8udGVzdCh1cmwpKSB7XG4gICAgICAgIHJldHVybiAnXCInICsgdXJsLnJlcGxhY2UoL1wiL2csICdcXFxcXCInKS5yZXBsYWNlKC9cXG4vZywgJ1xcXFxuJykgKyAnXCInXG4gICAgfVxuXG4gICAgcmV0dXJuIHVybFxufVxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9ub2RlX21vZHVsZXMvY3NzLWxvYWRlci9saWIvdXJsL2VzY2FwZS5qc1xuLy8gbW9kdWxlIGlkID0gOVxuLy8gbW9kdWxlIGNodW5rcyA9IDAiLCIvKlxuXHRNSVQgTGljZW5zZSBodHRwOi8vd3d3Lm9wZW5zb3VyY2Uub3JnL2xpY2Vuc2VzL21pdC1saWNlbnNlLnBocFxuXHRBdXRob3IgVG9iaWFzIEtvcHBlcnMgQHNva3JhXG4qL1xuLy8gY3NzIGJhc2UgY29kZSwgaW5qZWN0ZWQgYnkgdGhlIGNzcy1sb2FkZXJcbm1vZHVsZS5leHBvcnRzID0gZnVuY3Rpb24odXNlU291cmNlTWFwKSB7XG5cdHZhciBsaXN0ID0gW107XG5cblx0Ly8gcmV0dXJuIHRoZSBsaXN0IG9mIG1vZHVsZXMgYXMgY3NzIHN0cmluZ1xuXHRsaXN0LnRvU3RyaW5nID0gZnVuY3Rpb24gdG9TdHJpbmcoKSB7XG5cdFx0cmV0dXJuIHRoaXMubWFwKGZ1bmN0aW9uIChpdGVtKSB7XG5cdFx0XHR2YXIgY29udGVudCA9IGNzc1dpdGhNYXBwaW5nVG9TdHJpbmcoaXRlbSwgdXNlU291cmNlTWFwKTtcblx0XHRcdGlmKGl0ZW1bMl0pIHtcblx0XHRcdFx0cmV0dXJuIFwiQG1lZGlhIFwiICsgaXRlbVsyXSArIFwie1wiICsgY29udGVudCArIFwifVwiO1xuXHRcdFx0fSBlbHNlIHtcblx0XHRcdFx0cmV0dXJuIGNvbnRlbnQ7XG5cdFx0XHR9XG5cdFx0fSkuam9pbihcIlwiKTtcblx0fTtcblxuXHQvLyBpbXBvcnQgYSBsaXN0IG9mIG1vZHVsZXMgaW50byB0aGUgbGlzdFxuXHRsaXN0LmkgPSBmdW5jdGlvbihtb2R1bGVzLCBtZWRpYVF1ZXJ5KSB7XG5cdFx0aWYodHlwZW9mIG1vZHVsZXMgPT09IFwic3RyaW5nXCIpXG5cdFx0XHRtb2R1bGVzID0gW1tudWxsLCBtb2R1bGVzLCBcIlwiXV07XG5cdFx0dmFyIGFscmVhZHlJbXBvcnRlZE1vZHVsZXMgPSB7fTtcblx0XHRmb3IodmFyIGkgPSAwOyBpIDwgdGhpcy5sZW5ndGg7IGkrKykge1xuXHRcdFx0dmFyIGlkID0gdGhpc1tpXVswXTtcblx0XHRcdGlmKHR5cGVvZiBpZCA9PT0gXCJudW1iZXJcIilcblx0XHRcdFx0YWxyZWFkeUltcG9ydGVkTW9kdWxlc1tpZF0gPSB0cnVlO1xuXHRcdH1cblx0XHRmb3IoaSA9IDA7IGkgPCBtb2R1bGVzLmxlbmd0aDsgaSsrKSB7XG5cdFx0XHR2YXIgaXRlbSA9IG1vZHVsZXNbaV07XG5cdFx0XHQvLyBza2lwIGFscmVhZHkgaW1wb3J0ZWQgbW9kdWxlXG5cdFx0XHQvLyB0aGlzIGltcGxlbWVudGF0aW9uIGlzIG5vdCAxMDAlIHBlcmZlY3QgZm9yIHdlaXJkIG1lZGlhIHF1ZXJ5IGNvbWJpbmF0aW9uc1xuXHRcdFx0Ly8gIHdoZW4gYSBtb2R1bGUgaXMgaW1wb3J0ZWQgbXVsdGlwbGUgdGltZXMgd2l0aCBkaWZmZXJlbnQgbWVkaWEgcXVlcmllcy5cblx0XHRcdC8vICBJIGhvcGUgdGhpcyB3aWxsIG5ldmVyIG9jY3VyIChIZXkgdGhpcyB3YXkgd2UgaGF2ZSBzbWFsbGVyIGJ1bmRsZXMpXG5cdFx0XHRpZih0eXBlb2YgaXRlbVswXSAhPT0gXCJudW1iZXJcIiB8fCAhYWxyZWFkeUltcG9ydGVkTW9kdWxlc1tpdGVtWzBdXSkge1xuXHRcdFx0XHRpZihtZWRpYVF1ZXJ5ICYmICFpdGVtWzJdKSB7XG5cdFx0XHRcdFx0aXRlbVsyXSA9IG1lZGlhUXVlcnk7XG5cdFx0XHRcdH0gZWxzZSBpZihtZWRpYVF1ZXJ5KSB7XG5cdFx0XHRcdFx0aXRlbVsyXSA9IFwiKFwiICsgaXRlbVsyXSArIFwiKSBhbmQgKFwiICsgbWVkaWFRdWVyeSArIFwiKVwiO1xuXHRcdFx0XHR9XG5cdFx0XHRcdGxpc3QucHVzaChpdGVtKTtcblx0XHRcdH1cblx0XHR9XG5cdH07XG5cdHJldHVybiBsaXN0O1xufTtcblxuZnVuY3Rpb24gY3NzV2l0aE1hcHBpbmdUb1N0cmluZyhpdGVtLCB1c2VTb3VyY2VNYXApIHtcblx0dmFyIGNvbnRlbnQgPSBpdGVtWzFdIHx8ICcnO1xuXHR2YXIgY3NzTWFwcGluZyA9IGl0ZW1bM107XG5cdGlmICghY3NzTWFwcGluZykge1xuXHRcdHJldHVybiBjb250ZW50O1xuXHR9XG5cblx0aWYgKHVzZVNvdXJjZU1hcCAmJiB0eXBlb2YgYnRvYSA9PT0gJ2Z1bmN0aW9uJykge1xuXHRcdHZhciBzb3VyY2VNYXBwaW5nID0gdG9Db21tZW50KGNzc01hcHBpbmcpO1xuXHRcdHZhciBzb3VyY2VVUkxzID0gY3NzTWFwcGluZy5zb3VyY2VzLm1hcChmdW5jdGlvbiAoc291cmNlKSB7XG5cdFx0XHRyZXR1cm4gJy8qIyBzb3VyY2VVUkw9JyArIGNzc01hcHBpbmcuc291cmNlUm9vdCArIHNvdXJjZSArICcgKi8nXG5cdFx0fSk7XG5cblx0XHRyZXR1cm4gW2NvbnRlbnRdLmNvbmNhdChzb3VyY2VVUkxzKS5jb25jYXQoW3NvdXJjZU1hcHBpbmddKS5qb2luKCdcXG4nKTtcblx0fVxuXG5cdHJldHVybiBbY29udGVudF0uam9pbignXFxuJyk7XG59XG5cbi8vIEFkYXB0ZWQgZnJvbSBjb252ZXJ0LXNvdXJjZS1tYXAgKE1JVClcbmZ1bmN0aW9uIHRvQ29tbWVudChzb3VyY2VNYXApIHtcblx0Ly8gZXNsaW50LWRpc2FibGUtbmV4dC1saW5lIG5vLXVuZGVmXG5cdHZhciBiYXNlNjQgPSBidG9hKHVuZXNjYXBlKGVuY29kZVVSSUNvbXBvbmVudChKU09OLnN0cmluZ2lmeShzb3VyY2VNYXApKSkpO1xuXHR2YXIgZGF0YSA9ICdzb3VyY2VNYXBwaW5nVVJMPWRhdGE6YXBwbGljYXRpb24vanNvbjtjaGFyc2V0PXV0Zi04O2Jhc2U2NCwnICsgYmFzZTY0O1xuXG5cdHJldHVybiAnLyojICcgKyBkYXRhICsgJyAqLyc7XG59XG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL25vZGVfbW9kdWxlcy9jc3MtbG9hZGVyL2xpYi9jc3MtYmFzZS5qc1xuLy8gbW9kdWxlIGlkID0gMTBcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwibW9kdWxlLmV4cG9ydHMgPSBfX3dlYnBhY2tfcHVibGljX3BhdGhfXyArIFwiaW1hZ2VzL2ltZ2UyOWEyMDQxOGVlNjNhY2ViMWJjNzNkMTcyYjczNjdlLnBuZ1wiO1xuXG5cbi8vLy8vLy8vLy8vLy8vLy8vL1xuLy8gV0VCUEFDSyBGT09URVJcbi8vIC4vc3JjL2ltYWdlcy9jaWVsLW5vY3R1cm5lLnBuZ1xuLy8gbW9kdWxlIGlkID0gMTFcbi8vIG1vZHVsZSBjaHVua3MgPSAwIiwiLypcblx0TUlUIExpY2Vuc2UgaHR0cDovL3d3dy5vcGVuc291cmNlLm9yZy9saWNlbnNlcy9taXQtbGljZW5zZS5waHBcblx0QXV0aG9yIFRvYmlhcyBLb3BwZXJzIEBzb2tyYVxuKi9cblxudmFyIHN0eWxlc0luRG9tID0ge307XG5cbnZhclx0bWVtb2l6ZSA9IGZ1bmN0aW9uIChmbikge1xuXHR2YXIgbWVtbztcblxuXHRyZXR1cm4gZnVuY3Rpb24gKCkge1xuXHRcdGlmICh0eXBlb2YgbWVtbyA9PT0gXCJ1bmRlZmluZWRcIikgbWVtbyA9IGZuLmFwcGx5KHRoaXMsIGFyZ3VtZW50cyk7XG5cdFx0cmV0dXJuIG1lbW87XG5cdH07XG59O1xuXG52YXIgaXNPbGRJRSA9IG1lbW9pemUoZnVuY3Rpb24gKCkge1xuXHQvLyBUZXN0IGZvciBJRSA8PSA5IGFzIHByb3Bvc2VkIGJ5IEJyb3dzZXJoYWNrc1xuXHQvLyBAc2VlIGh0dHA6Ly9icm93c2VyaGFja3MuY29tLyNoYWNrLWU3MWQ4NjkyZjY1MzM0MTczZmVlNzE1YzIyMmNiODA1XG5cdC8vIFRlc3RzIGZvciBleGlzdGVuY2Ugb2Ygc3RhbmRhcmQgZ2xvYmFscyBpcyB0byBhbGxvdyBzdHlsZS1sb2FkZXJcblx0Ly8gdG8gb3BlcmF0ZSBjb3JyZWN0bHkgaW50byBub24tc3RhbmRhcmQgZW52aXJvbm1lbnRzXG5cdC8vIEBzZWUgaHR0cHM6Ly9naXRodWIuY29tL3dlYnBhY2stY29udHJpYi9zdHlsZS1sb2FkZXIvaXNzdWVzLzE3N1xuXHRyZXR1cm4gd2luZG93ICYmIGRvY3VtZW50ICYmIGRvY3VtZW50LmFsbCAmJiAhd2luZG93LmF0b2I7XG59KTtcblxudmFyIGdldEVsZW1lbnQgPSAoZnVuY3Rpb24gKGZuKSB7XG5cdHZhciBtZW1vID0ge307XG5cblx0cmV0dXJuIGZ1bmN0aW9uKHNlbGVjdG9yKSB7XG5cdFx0aWYgKHR5cGVvZiBtZW1vW3NlbGVjdG9yXSA9PT0gXCJ1bmRlZmluZWRcIikge1xuXHRcdFx0dmFyIHN0eWxlVGFyZ2V0ID0gZm4uY2FsbCh0aGlzLCBzZWxlY3Rvcik7XG5cdFx0XHQvLyBTcGVjaWFsIGNhc2UgdG8gcmV0dXJuIGhlYWQgb2YgaWZyYW1lIGluc3RlYWQgb2YgaWZyYW1lIGl0c2VsZlxuXHRcdFx0aWYgKHN0eWxlVGFyZ2V0IGluc3RhbmNlb2Ygd2luZG93LkhUTUxJRnJhbWVFbGVtZW50KSB7XG5cdFx0XHRcdHRyeSB7XG5cdFx0XHRcdFx0Ly8gVGhpcyB3aWxsIHRocm93IGFuIGV4Y2VwdGlvbiBpZiBhY2Nlc3MgdG8gaWZyYW1lIGlzIGJsb2NrZWRcblx0XHRcdFx0XHQvLyBkdWUgdG8gY3Jvc3Mtb3JpZ2luIHJlc3RyaWN0aW9uc1xuXHRcdFx0XHRcdHN0eWxlVGFyZ2V0ID0gc3R5bGVUYXJnZXQuY29udGVudERvY3VtZW50LmhlYWQ7XG5cdFx0XHRcdH0gY2F0Y2goZSkge1xuXHRcdFx0XHRcdHN0eWxlVGFyZ2V0ID0gbnVsbDtcblx0XHRcdFx0fVxuXHRcdFx0fVxuXHRcdFx0bWVtb1tzZWxlY3Rvcl0gPSBzdHlsZVRhcmdldDtcblx0XHR9XG5cdFx0cmV0dXJuIG1lbW9bc2VsZWN0b3JdXG5cdH07XG59KShmdW5jdGlvbiAodGFyZ2V0KSB7XG5cdHJldHVybiBkb2N1bWVudC5xdWVyeVNlbGVjdG9yKHRhcmdldClcbn0pO1xuXG52YXIgc2luZ2xldG9uID0gbnVsbDtcbnZhclx0c2luZ2xldG9uQ291bnRlciA9IDA7XG52YXJcdHN0eWxlc0luc2VydGVkQXRUb3AgPSBbXTtcblxudmFyXHRmaXhVcmxzID0gcmVxdWlyZShcIi4vdXJsc1wiKTtcblxubW9kdWxlLmV4cG9ydHMgPSBmdW5jdGlvbihsaXN0LCBvcHRpb25zKSB7XG5cdGlmICh0eXBlb2YgREVCVUcgIT09IFwidW5kZWZpbmVkXCIgJiYgREVCVUcpIHtcblx0XHRpZiAodHlwZW9mIGRvY3VtZW50ICE9PSBcIm9iamVjdFwiKSB0aHJvdyBuZXcgRXJyb3IoXCJUaGUgc3R5bGUtbG9hZGVyIGNhbm5vdCBiZSB1c2VkIGluIGEgbm9uLWJyb3dzZXIgZW52aXJvbm1lbnRcIik7XG5cdH1cblxuXHRvcHRpb25zID0gb3B0aW9ucyB8fCB7fTtcblxuXHRvcHRpb25zLmF0dHJzID0gdHlwZW9mIG9wdGlvbnMuYXR0cnMgPT09IFwib2JqZWN0XCIgPyBvcHRpb25zLmF0dHJzIDoge307XG5cblx0Ly8gRm9yY2Ugc2luZ2xlLXRhZyBzb2x1dGlvbiBvbiBJRTYtOSwgd2hpY2ggaGFzIGEgaGFyZCBsaW1pdCBvbiB0aGUgIyBvZiA8c3R5bGU+XG5cdC8vIHRhZ3MgaXQgd2lsbCBhbGxvdyBvbiBhIHBhZ2Vcblx0aWYgKCFvcHRpb25zLnNpbmdsZXRvbiAmJiB0eXBlb2Ygb3B0aW9ucy5zaW5nbGV0b24gIT09IFwiYm9vbGVhblwiKSBvcHRpb25zLnNpbmdsZXRvbiA9IGlzT2xkSUUoKTtcblxuXHQvLyBCeSBkZWZhdWx0LCBhZGQgPHN0eWxlPiB0YWdzIHRvIHRoZSA8aGVhZD4gZWxlbWVudFxuXHRpZiAoIW9wdGlvbnMuaW5zZXJ0SW50bykgb3B0aW9ucy5pbnNlcnRJbnRvID0gXCJoZWFkXCI7XG5cblx0Ly8gQnkgZGVmYXVsdCwgYWRkIDxzdHlsZT4gdGFncyB0byB0aGUgYm90dG9tIG9mIHRoZSB0YXJnZXRcblx0aWYgKCFvcHRpb25zLmluc2VydEF0KSBvcHRpb25zLmluc2VydEF0ID0gXCJib3R0b21cIjtcblxuXHR2YXIgc3R5bGVzID0gbGlzdFRvU3R5bGVzKGxpc3QsIG9wdGlvbnMpO1xuXG5cdGFkZFN0eWxlc1RvRG9tKHN0eWxlcywgb3B0aW9ucyk7XG5cblx0cmV0dXJuIGZ1bmN0aW9uIHVwZGF0ZSAobmV3TGlzdCkge1xuXHRcdHZhciBtYXlSZW1vdmUgPSBbXTtcblxuXHRcdGZvciAodmFyIGkgPSAwOyBpIDwgc3R5bGVzLmxlbmd0aDsgaSsrKSB7XG5cdFx0XHR2YXIgaXRlbSA9IHN0eWxlc1tpXTtcblx0XHRcdHZhciBkb21TdHlsZSA9IHN0eWxlc0luRG9tW2l0ZW0uaWRdO1xuXG5cdFx0XHRkb21TdHlsZS5yZWZzLS07XG5cdFx0XHRtYXlSZW1vdmUucHVzaChkb21TdHlsZSk7XG5cdFx0fVxuXG5cdFx0aWYobmV3TGlzdCkge1xuXHRcdFx0dmFyIG5ld1N0eWxlcyA9IGxpc3RUb1N0eWxlcyhuZXdMaXN0LCBvcHRpb25zKTtcblx0XHRcdGFkZFN0eWxlc1RvRG9tKG5ld1N0eWxlcywgb3B0aW9ucyk7XG5cdFx0fVxuXG5cdFx0Zm9yICh2YXIgaSA9IDA7IGkgPCBtYXlSZW1vdmUubGVuZ3RoOyBpKyspIHtcblx0XHRcdHZhciBkb21TdHlsZSA9IG1heVJlbW92ZVtpXTtcblxuXHRcdFx0aWYoZG9tU3R5bGUucmVmcyA9PT0gMCkge1xuXHRcdFx0XHRmb3IgKHZhciBqID0gMDsgaiA8IGRvbVN0eWxlLnBhcnRzLmxlbmd0aDsgaisrKSBkb21TdHlsZS5wYXJ0c1tqXSgpO1xuXG5cdFx0XHRcdGRlbGV0ZSBzdHlsZXNJbkRvbVtkb21TdHlsZS5pZF07XG5cdFx0XHR9XG5cdFx0fVxuXHR9O1xufTtcblxuZnVuY3Rpb24gYWRkU3R5bGVzVG9Eb20gKHN0eWxlcywgb3B0aW9ucykge1xuXHRmb3IgKHZhciBpID0gMDsgaSA8IHN0eWxlcy5sZW5ndGg7IGkrKykge1xuXHRcdHZhciBpdGVtID0gc3R5bGVzW2ldO1xuXHRcdHZhciBkb21TdHlsZSA9IHN0eWxlc0luRG9tW2l0ZW0uaWRdO1xuXG5cdFx0aWYoZG9tU3R5bGUpIHtcblx0XHRcdGRvbVN0eWxlLnJlZnMrKztcblxuXHRcdFx0Zm9yKHZhciBqID0gMDsgaiA8IGRvbVN0eWxlLnBhcnRzLmxlbmd0aDsgaisrKSB7XG5cdFx0XHRcdGRvbVN0eWxlLnBhcnRzW2pdKGl0ZW0ucGFydHNbal0pO1xuXHRcdFx0fVxuXG5cdFx0XHRmb3IoOyBqIDwgaXRlbS5wYXJ0cy5sZW5ndGg7IGorKykge1xuXHRcdFx0XHRkb21TdHlsZS5wYXJ0cy5wdXNoKGFkZFN0eWxlKGl0ZW0ucGFydHNbal0sIG9wdGlvbnMpKTtcblx0XHRcdH1cblx0XHR9IGVsc2Uge1xuXHRcdFx0dmFyIHBhcnRzID0gW107XG5cblx0XHRcdGZvcih2YXIgaiA9IDA7IGogPCBpdGVtLnBhcnRzLmxlbmd0aDsgaisrKSB7XG5cdFx0XHRcdHBhcnRzLnB1c2goYWRkU3R5bGUoaXRlbS5wYXJ0c1tqXSwgb3B0aW9ucykpO1xuXHRcdFx0fVxuXG5cdFx0XHRzdHlsZXNJbkRvbVtpdGVtLmlkXSA9IHtpZDogaXRlbS5pZCwgcmVmczogMSwgcGFydHM6IHBhcnRzfTtcblx0XHR9XG5cdH1cbn1cblxuZnVuY3Rpb24gbGlzdFRvU3R5bGVzIChsaXN0LCBvcHRpb25zKSB7XG5cdHZhciBzdHlsZXMgPSBbXTtcblx0dmFyIG5ld1N0eWxlcyA9IHt9O1xuXG5cdGZvciAodmFyIGkgPSAwOyBpIDwgbGlzdC5sZW5ndGg7IGkrKykge1xuXHRcdHZhciBpdGVtID0gbGlzdFtpXTtcblx0XHR2YXIgaWQgPSBvcHRpb25zLmJhc2UgPyBpdGVtWzBdICsgb3B0aW9ucy5iYXNlIDogaXRlbVswXTtcblx0XHR2YXIgY3NzID0gaXRlbVsxXTtcblx0XHR2YXIgbWVkaWEgPSBpdGVtWzJdO1xuXHRcdHZhciBzb3VyY2VNYXAgPSBpdGVtWzNdO1xuXHRcdHZhciBwYXJ0ID0ge2NzczogY3NzLCBtZWRpYTogbWVkaWEsIHNvdXJjZU1hcDogc291cmNlTWFwfTtcblxuXHRcdGlmKCFuZXdTdHlsZXNbaWRdKSBzdHlsZXMucHVzaChuZXdTdHlsZXNbaWRdID0ge2lkOiBpZCwgcGFydHM6IFtwYXJ0XX0pO1xuXHRcdGVsc2UgbmV3U3R5bGVzW2lkXS5wYXJ0cy5wdXNoKHBhcnQpO1xuXHR9XG5cblx0cmV0dXJuIHN0eWxlcztcbn1cblxuZnVuY3Rpb24gaW5zZXJ0U3R5bGVFbGVtZW50IChvcHRpb25zLCBzdHlsZSkge1xuXHR2YXIgdGFyZ2V0ID0gZ2V0RWxlbWVudChvcHRpb25zLmluc2VydEludG8pXG5cblx0aWYgKCF0YXJnZXQpIHtcblx0XHR0aHJvdyBuZXcgRXJyb3IoXCJDb3VsZG4ndCBmaW5kIGEgc3R5bGUgdGFyZ2V0LiBUaGlzIHByb2JhYmx5IG1lYW5zIHRoYXQgdGhlIHZhbHVlIGZvciB0aGUgJ2luc2VydEludG8nIHBhcmFtZXRlciBpcyBpbnZhbGlkLlwiKTtcblx0fVxuXG5cdHZhciBsYXN0U3R5bGVFbGVtZW50SW5zZXJ0ZWRBdFRvcCA9IHN0eWxlc0luc2VydGVkQXRUb3Bbc3R5bGVzSW5zZXJ0ZWRBdFRvcC5sZW5ndGggLSAxXTtcblxuXHRpZiAob3B0aW9ucy5pbnNlcnRBdCA9PT0gXCJ0b3BcIikge1xuXHRcdGlmICghbGFzdFN0eWxlRWxlbWVudEluc2VydGVkQXRUb3ApIHtcblx0XHRcdHRhcmdldC5pbnNlcnRCZWZvcmUoc3R5bGUsIHRhcmdldC5maXJzdENoaWxkKTtcblx0XHR9IGVsc2UgaWYgKGxhc3RTdHlsZUVsZW1lbnRJbnNlcnRlZEF0VG9wLm5leHRTaWJsaW5nKSB7XG5cdFx0XHR0YXJnZXQuaW5zZXJ0QmVmb3JlKHN0eWxlLCBsYXN0U3R5bGVFbGVtZW50SW5zZXJ0ZWRBdFRvcC5uZXh0U2libGluZyk7XG5cdFx0fSBlbHNlIHtcblx0XHRcdHRhcmdldC5hcHBlbmRDaGlsZChzdHlsZSk7XG5cdFx0fVxuXHRcdHN0eWxlc0luc2VydGVkQXRUb3AucHVzaChzdHlsZSk7XG5cdH0gZWxzZSBpZiAob3B0aW9ucy5pbnNlcnRBdCA9PT0gXCJib3R0b21cIikge1xuXHRcdHRhcmdldC5hcHBlbmRDaGlsZChzdHlsZSk7XG5cdH0gZWxzZSBpZiAodHlwZW9mIG9wdGlvbnMuaW5zZXJ0QXQgPT09IFwib2JqZWN0XCIgJiYgb3B0aW9ucy5pbnNlcnRBdC5iZWZvcmUpIHtcblx0XHR2YXIgbmV4dFNpYmxpbmcgPSBnZXRFbGVtZW50KG9wdGlvbnMuaW5zZXJ0SW50byArIFwiIFwiICsgb3B0aW9ucy5pbnNlcnRBdC5iZWZvcmUpO1xuXHRcdHRhcmdldC5pbnNlcnRCZWZvcmUoc3R5bGUsIG5leHRTaWJsaW5nKTtcblx0fSBlbHNlIHtcblx0XHR0aHJvdyBuZXcgRXJyb3IoXCJbU3R5bGUgTG9hZGVyXVxcblxcbiBJbnZhbGlkIHZhbHVlIGZvciBwYXJhbWV0ZXIgJ2luc2VydEF0JyAoJ29wdGlvbnMuaW5zZXJ0QXQnKSBmb3VuZC5cXG4gTXVzdCBiZSAndG9wJywgJ2JvdHRvbScsIG9yIE9iamVjdC5cXG4gKGh0dHBzOi8vZ2l0aHViLmNvbS93ZWJwYWNrLWNvbnRyaWIvc3R5bGUtbG9hZGVyI2luc2VydGF0KVxcblwiKTtcblx0fVxufVxuXG5mdW5jdGlvbiByZW1vdmVTdHlsZUVsZW1lbnQgKHN0eWxlKSB7XG5cdGlmIChzdHlsZS5wYXJlbnROb2RlID09PSBudWxsKSByZXR1cm4gZmFsc2U7XG5cdHN0eWxlLnBhcmVudE5vZGUucmVtb3ZlQ2hpbGQoc3R5bGUpO1xuXG5cdHZhciBpZHggPSBzdHlsZXNJbnNlcnRlZEF0VG9wLmluZGV4T2Yoc3R5bGUpO1xuXHRpZihpZHggPj0gMCkge1xuXHRcdHN0eWxlc0luc2VydGVkQXRUb3Auc3BsaWNlKGlkeCwgMSk7XG5cdH1cbn1cblxuZnVuY3Rpb24gY3JlYXRlU3R5bGVFbGVtZW50IChvcHRpb25zKSB7XG5cdHZhciBzdHlsZSA9IGRvY3VtZW50LmNyZWF0ZUVsZW1lbnQoXCJzdHlsZVwiKTtcblxuXHRvcHRpb25zLmF0dHJzLnR5cGUgPSBcInRleHQvY3NzXCI7XG5cblx0YWRkQXR0cnMoc3R5bGUsIG9wdGlvbnMuYXR0cnMpO1xuXHRpbnNlcnRTdHlsZUVsZW1lbnQob3B0aW9ucywgc3R5bGUpO1xuXG5cdHJldHVybiBzdHlsZTtcbn1cblxuZnVuY3Rpb24gY3JlYXRlTGlua0VsZW1lbnQgKG9wdGlvbnMpIHtcblx0dmFyIGxpbmsgPSBkb2N1bWVudC5jcmVhdGVFbGVtZW50KFwibGlua1wiKTtcblxuXHRvcHRpb25zLmF0dHJzLnR5cGUgPSBcInRleHQvY3NzXCI7XG5cdG9wdGlvbnMuYXR0cnMucmVsID0gXCJzdHlsZXNoZWV0XCI7XG5cblx0YWRkQXR0cnMobGluaywgb3B0aW9ucy5hdHRycyk7XG5cdGluc2VydFN0eWxlRWxlbWVudChvcHRpb25zLCBsaW5rKTtcblxuXHRyZXR1cm4gbGluaztcbn1cblxuZnVuY3Rpb24gYWRkQXR0cnMgKGVsLCBhdHRycykge1xuXHRPYmplY3Qua2V5cyhhdHRycykuZm9yRWFjaChmdW5jdGlvbiAoa2V5KSB7XG5cdFx0ZWwuc2V0QXR0cmlidXRlKGtleSwgYXR0cnNba2V5XSk7XG5cdH0pO1xufVxuXG5mdW5jdGlvbiBhZGRTdHlsZSAob2JqLCBvcHRpb25zKSB7XG5cdHZhciBzdHlsZSwgdXBkYXRlLCByZW1vdmUsIHJlc3VsdDtcblxuXHQvLyBJZiBhIHRyYW5zZm9ybSBmdW5jdGlvbiB3YXMgZGVmaW5lZCwgcnVuIGl0IG9uIHRoZSBjc3Ncblx0aWYgKG9wdGlvbnMudHJhbnNmb3JtICYmIG9iai5jc3MpIHtcblx0ICAgIHJlc3VsdCA9IG9wdGlvbnMudHJhbnNmb3JtKG9iai5jc3MpO1xuXG5cdCAgICBpZiAocmVzdWx0KSB7XG5cdCAgICBcdC8vIElmIHRyYW5zZm9ybSByZXR1cm5zIGEgdmFsdWUsIHVzZSB0aGF0IGluc3RlYWQgb2YgdGhlIG9yaWdpbmFsIGNzcy5cblx0ICAgIFx0Ly8gVGhpcyBhbGxvd3MgcnVubmluZyBydW50aW1lIHRyYW5zZm9ybWF0aW9ucyBvbiB0aGUgY3NzLlxuXHQgICAgXHRvYmouY3NzID0gcmVzdWx0O1xuXHQgICAgfSBlbHNlIHtcblx0ICAgIFx0Ly8gSWYgdGhlIHRyYW5zZm9ybSBmdW5jdGlvbiByZXR1cm5zIGEgZmFsc3kgdmFsdWUsIGRvbid0IGFkZCB0aGlzIGNzcy5cblx0ICAgIFx0Ly8gVGhpcyBhbGxvd3MgY29uZGl0aW9uYWwgbG9hZGluZyBvZiBjc3Ncblx0ICAgIFx0cmV0dXJuIGZ1bmN0aW9uKCkge1xuXHQgICAgXHRcdC8vIG5vb3Bcblx0ICAgIFx0fTtcblx0ICAgIH1cblx0fVxuXG5cdGlmIChvcHRpb25zLnNpbmdsZXRvbikge1xuXHRcdHZhciBzdHlsZUluZGV4ID0gc2luZ2xldG9uQ291bnRlcisrO1xuXG5cdFx0c3R5bGUgPSBzaW5nbGV0b24gfHwgKHNpbmdsZXRvbiA9IGNyZWF0ZVN0eWxlRWxlbWVudChvcHRpb25zKSk7XG5cblx0XHR1cGRhdGUgPSBhcHBseVRvU2luZ2xldG9uVGFnLmJpbmQobnVsbCwgc3R5bGUsIHN0eWxlSW5kZXgsIGZhbHNlKTtcblx0XHRyZW1vdmUgPSBhcHBseVRvU2luZ2xldG9uVGFnLmJpbmQobnVsbCwgc3R5bGUsIHN0eWxlSW5kZXgsIHRydWUpO1xuXG5cdH0gZWxzZSBpZiAoXG5cdFx0b2JqLnNvdXJjZU1hcCAmJlxuXHRcdHR5cGVvZiBVUkwgPT09IFwiZnVuY3Rpb25cIiAmJlxuXHRcdHR5cGVvZiBVUkwuY3JlYXRlT2JqZWN0VVJMID09PSBcImZ1bmN0aW9uXCIgJiZcblx0XHR0eXBlb2YgVVJMLnJldm9rZU9iamVjdFVSTCA9PT0gXCJmdW5jdGlvblwiICYmXG5cdFx0dHlwZW9mIEJsb2IgPT09IFwiZnVuY3Rpb25cIiAmJlxuXHRcdHR5cGVvZiBidG9hID09PSBcImZ1bmN0aW9uXCJcblx0KSB7XG5cdFx0c3R5bGUgPSBjcmVhdGVMaW5rRWxlbWVudChvcHRpb25zKTtcblx0XHR1cGRhdGUgPSB1cGRhdGVMaW5rLmJpbmQobnVsbCwgc3R5bGUsIG9wdGlvbnMpO1xuXHRcdHJlbW92ZSA9IGZ1bmN0aW9uICgpIHtcblx0XHRcdHJlbW92ZVN0eWxlRWxlbWVudChzdHlsZSk7XG5cblx0XHRcdGlmKHN0eWxlLmhyZWYpIFVSTC5yZXZva2VPYmplY3RVUkwoc3R5bGUuaHJlZik7XG5cdFx0fTtcblx0fSBlbHNlIHtcblx0XHRzdHlsZSA9IGNyZWF0ZVN0eWxlRWxlbWVudChvcHRpb25zKTtcblx0XHR1cGRhdGUgPSBhcHBseVRvVGFnLmJpbmQobnVsbCwgc3R5bGUpO1xuXHRcdHJlbW92ZSA9IGZ1bmN0aW9uICgpIHtcblx0XHRcdHJlbW92ZVN0eWxlRWxlbWVudChzdHlsZSk7XG5cdFx0fTtcblx0fVxuXG5cdHVwZGF0ZShvYmopO1xuXG5cdHJldHVybiBmdW5jdGlvbiB1cGRhdGVTdHlsZSAobmV3T2JqKSB7XG5cdFx0aWYgKG5ld09iaikge1xuXHRcdFx0aWYgKFxuXHRcdFx0XHRuZXdPYmouY3NzID09PSBvYmouY3NzICYmXG5cdFx0XHRcdG5ld09iai5tZWRpYSA9PT0gb2JqLm1lZGlhICYmXG5cdFx0XHRcdG5ld09iai5zb3VyY2VNYXAgPT09IG9iai5zb3VyY2VNYXBcblx0XHRcdCkge1xuXHRcdFx0XHRyZXR1cm47XG5cdFx0XHR9XG5cblx0XHRcdHVwZGF0ZShvYmogPSBuZXdPYmopO1xuXHRcdH0gZWxzZSB7XG5cdFx0XHRyZW1vdmUoKTtcblx0XHR9XG5cdH07XG59XG5cbnZhciByZXBsYWNlVGV4dCA9IChmdW5jdGlvbiAoKSB7XG5cdHZhciB0ZXh0U3RvcmUgPSBbXTtcblxuXHRyZXR1cm4gZnVuY3Rpb24gKGluZGV4LCByZXBsYWNlbWVudCkge1xuXHRcdHRleHRTdG9yZVtpbmRleF0gPSByZXBsYWNlbWVudDtcblxuXHRcdHJldHVybiB0ZXh0U3RvcmUuZmlsdGVyKEJvb2xlYW4pLmpvaW4oJ1xcbicpO1xuXHR9O1xufSkoKTtcblxuZnVuY3Rpb24gYXBwbHlUb1NpbmdsZXRvblRhZyAoc3R5bGUsIGluZGV4LCByZW1vdmUsIG9iaikge1xuXHR2YXIgY3NzID0gcmVtb3ZlID8gXCJcIiA6IG9iai5jc3M7XG5cblx0aWYgKHN0eWxlLnN0eWxlU2hlZXQpIHtcblx0XHRzdHlsZS5zdHlsZVNoZWV0LmNzc1RleHQgPSByZXBsYWNlVGV4dChpbmRleCwgY3NzKTtcblx0fSBlbHNlIHtcblx0XHR2YXIgY3NzTm9kZSA9IGRvY3VtZW50LmNyZWF0ZVRleHROb2RlKGNzcyk7XG5cdFx0dmFyIGNoaWxkTm9kZXMgPSBzdHlsZS5jaGlsZE5vZGVzO1xuXG5cdFx0aWYgKGNoaWxkTm9kZXNbaW5kZXhdKSBzdHlsZS5yZW1vdmVDaGlsZChjaGlsZE5vZGVzW2luZGV4XSk7XG5cblx0XHRpZiAoY2hpbGROb2Rlcy5sZW5ndGgpIHtcblx0XHRcdHN0eWxlLmluc2VydEJlZm9yZShjc3NOb2RlLCBjaGlsZE5vZGVzW2luZGV4XSk7XG5cdFx0fSBlbHNlIHtcblx0XHRcdHN0eWxlLmFwcGVuZENoaWxkKGNzc05vZGUpO1xuXHRcdH1cblx0fVxufVxuXG5mdW5jdGlvbiBhcHBseVRvVGFnIChzdHlsZSwgb2JqKSB7XG5cdHZhciBjc3MgPSBvYmouY3NzO1xuXHR2YXIgbWVkaWEgPSBvYmoubWVkaWE7XG5cblx0aWYobWVkaWEpIHtcblx0XHRzdHlsZS5zZXRBdHRyaWJ1dGUoXCJtZWRpYVwiLCBtZWRpYSlcblx0fVxuXG5cdGlmKHN0eWxlLnN0eWxlU2hlZXQpIHtcblx0XHRzdHlsZS5zdHlsZVNoZWV0LmNzc1RleHQgPSBjc3M7XG5cdH0gZWxzZSB7XG5cdFx0d2hpbGUoc3R5bGUuZmlyc3RDaGlsZCkge1xuXHRcdFx0c3R5bGUucmVtb3ZlQ2hpbGQoc3R5bGUuZmlyc3RDaGlsZCk7XG5cdFx0fVxuXG5cdFx0c3R5bGUuYXBwZW5kQ2hpbGQoZG9jdW1lbnQuY3JlYXRlVGV4dE5vZGUoY3NzKSk7XG5cdH1cbn1cblxuZnVuY3Rpb24gdXBkYXRlTGluayAobGluaywgb3B0aW9ucywgb2JqKSB7XG5cdHZhciBjc3MgPSBvYmouY3NzO1xuXHR2YXIgc291cmNlTWFwID0gb2JqLnNvdXJjZU1hcDtcblxuXHQvKlxuXHRcdElmIGNvbnZlcnRUb0Fic29sdXRlVXJscyBpc24ndCBkZWZpbmVkLCBidXQgc291cmNlbWFwcyBhcmUgZW5hYmxlZFxuXHRcdGFuZCB0aGVyZSBpcyBubyBwdWJsaWNQYXRoIGRlZmluZWQgdGhlbiBsZXRzIHR1cm4gY29udmVydFRvQWJzb2x1dGVVcmxzXG5cdFx0b24gYnkgZGVmYXVsdC4gIE90aGVyd2lzZSBkZWZhdWx0IHRvIHRoZSBjb252ZXJ0VG9BYnNvbHV0ZVVybHMgb3B0aW9uXG5cdFx0ZGlyZWN0bHlcblx0Ki9cblx0dmFyIGF1dG9GaXhVcmxzID0gb3B0aW9ucy5jb252ZXJ0VG9BYnNvbHV0ZVVybHMgPT09IHVuZGVmaW5lZCAmJiBzb3VyY2VNYXA7XG5cblx0aWYgKG9wdGlvbnMuY29udmVydFRvQWJzb2x1dGVVcmxzIHx8IGF1dG9GaXhVcmxzKSB7XG5cdFx0Y3NzID0gZml4VXJscyhjc3MpO1xuXHR9XG5cblx0aWYgKHNvdXJjZU1hcCkge1xuXHRcdC8vIGh0dHA6Ly9zdGFja292ZXJmbG93LmNvbS9hLzI2NjAzODc1XG5cdFx0Y3NzICs9IFwiXFxuLyojIHNvdXJjZU1hcHBpbmdVUkw9ZGF0YTphcHBsaWNhdGlvbi9qc29uO2Jhc2U2NCxcIiArIGJ0b2EodW5lc2NhcGUoZW5jb2RlVVJJQ29tcG9uZW50KEpTT04uc3RyaW5naWZ5KHNvdXJjZU1hcCkpKSkgKyBcIiAqL1wiO1xuXHR9XG5cblx0dmFyIGJsb2IgPSBuZXcgQmxvYihbY3NzXSwgeyB0eXBlOiBcInRleHQvY3NzXCIgfSk7XG5cblx0dmFyIG9sZFNyYyA9IGxpbmsuaHJlZjtcblxuXHRsaW5rLmhyZWYgPSBVUkwuY3JlYXRlT2JqZWN0VVJMKGJsb2IpO1xuXG5cdGlmKG9sZFNyYykgVVJMLnJldm9rZU9iamVjdFVSTChvbGRTcmMpO1xufVxuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9ub2RlX21vZHVsZXMvc3R5bGUtbG9hZGVyL2xpYi9hZGRTdHlsZXMuanNcbi8vIG1vZHVsZSBpZCA9IDEyXG4vLyBtb2R1bGUgY2h1bmtzID0gMCIsIlxuLyoqXG4gKiBXaGVuIHNvdXJjZSBtYXBzIGFyZSBlbmFibGVkLCBgc3R5bGUtbG9hZGVyYCB1c2VzIGEgbGluayBlbGVtZW50IHdpdGggYSBkYXRhLXVyaSB0b1xuICogZW1iZWQgdGhlIGNzcyBvbiB0aGUgcGFnZS4gVGhpcyBicmVha3MgYWxsIHJlbGF0aXZlIHVybHMgYmVjYXVzZSBub3cgdGhleSBhcmUgcmVsYXRpdmUgdG8gYVxuICogYnVuZGxlIGluc3RlYWQgb2YgdGhlIGN1cnJlbnQgcGFnZS5cbiAqXG4gKiBPbmUgc29sdXRpb24gaXMgdG8gb25seSB1c2UgZnVsbCB1cmxzLCBidXQgdGhhdCBtYXkgYmUgaW1wb3NzaWJsZS5cbiAqXG4gKiBJbnN0ZWFkLCB0aGlzIGZ1bmN0aW9uIFwiZml4ZXNcIiB0aGUgcmVsYXRpdmUgdXJscyB0byBiZSBhYnNvbHV0ZSBhY2NvcmRpbmcgdG8gdGhlIGN1cnJlbnQgcGFnZSBsb2NhdGlvbi5cbiAqXG4gKiBBIHJ1ZGltZW50YXJ5IHRlc3Qgc3VpdGUgaXMgbG9jYXRlZCBhdCBgdGVzdC9maXhVcmxzLmpzYCBhbmQgY2FuIGJlIHJ1biB2aWEgdGhlIGBucG0gdGVzdGAgY29tbWFuZC5cbiAqXG4gKi9cblxubW9kdWxlLmV4cG9ydHMgPSBmdW5jdGlvbiAoY3NzKSB7XG4gIC8vIGdldCBjdXJyZW50IGxvY2F0aW9uXG4gIHZhciBsb2NhdGlvbiA9IHR5cGVvZiB3aW5kb3cgIT09IFwidW5kZWZpbmVkXCIgJiYgd2luZG93LmxvY2F0aW9uO1xuXG4gIGlmICghbG9jYXRpb24pIHtcbiAgICB0aHJvdyBuZXcgRXJyb3IoXCJmaXhVcmxzIHJlcXVpcmVzIHdpbmRvdy5sb2NhdGlvblwiKTtcbiAgfVxuXG5cdC8vIGJsYW5rIG9yIG51bGw/XG5cdGlmICghY3NzIHx8IHR5cGVvZiBjc3MgIT09IFwic3RyaW5nXCIpIHtcblx0ICByZXR1cm4gY3NzO1xuICB9XG5cbiAgdmFyIGJhc2VVcmwgPSBsb2NhdGlvbi5wcm90b2NvbCArIFwiLy9cIiArIGxvY2F0aW9uLmhvc3Q7XG4gIHZhciBjdXJyZW50RGlyID0gYmFzZVVybCArIGxvY2F0aW9uLnBhdGhuYW1lLnJlcGxhY2UoL1xcL1teXFwvXSokLywgXCIvXCIpO1xuXG5cdC8vIGNvbnZlcnQgZWFjaCB1cmwoLi4uKVxuXHQvKlxuXHRUaGlzIHJlZ3VsYXIgZXhwcmVzc2lvbiBpcyBqdXN0IGEgd2F5IHRvIHJlY3Vyc2l2ZWx5IG1hdGNoIGJyYWNrZXRzIHdpdGhpblxuXHRhIHN0cmluZy5cblxuXHQgL3VybFxccypcXCggID0gTWF0Y2ggb24gdGhlIHdvcmQgXCJ1cmxcIiB3aXRoIGFueSB3aGl0ZXNwYWNlIGFmdGVyIGl0IGFuZCB0aGVuIGEgcGFyZW5zXG5cdCAgICggID0gU3RhcnQgYSBjYXB0dXJpbmcgZ3JvdXBcblx0ICAgICAoPzogID0gU3RhcnQgYSBub24tY2FwdHVyaW5nIGdyb3VwXG5cdCAgICAgICAgIFteKShdICA9IE1hdGNoIGFueXRoaW5nIHRoYXQgaXNuJ3QgYSBwYXJlbnRoZXNlc1xuXHQgICAgICAgICB8ICA9IE9SXG5cdCAgICAgICAgIFxcKCAgPSBNYXRjaCBhIHN0YXJ0IHBhcmVudGhlc2VzXG5cdCAgICAgICAgICAgICAoPzogID0gU3RhcnQgYW5vdGhlciBub24tY2FwdHVyaW5nIGdyb3Vwc1xuXHQgICAgICAgICAgICAgICAgIFteKShdKyAgPSBNYXRjaCBhbnl0aGluZyB0aGF0IGlzbid0IGEgcGFyZW50aGVzZXNcblx0ICAgICAgICAgICAgICAgICB8ICA9IE9SXG5cdCAgICAgICAgICAgICAgICAgXFwoICA9IE1hdGNoIGEgc3RhcnQgcGFyZW50aGVzZXNcblx0ICAgICAgICAgICAgICAgICAgICAgW14pKF0qICA9IE1hdGNoIGFueXRoaW5nIHRoYXQgaXNuJ3QgYSBwYXJlbnRoZXNlc1xuXHQgICAgICAgICAgICAgICAgIFxcKSAgPSBNYXRjaCBhIGVuZCBwYXJlbnRoZXNlc1xuXHQgICAgICAgICAgICAgKSAgPSBFbmQgR3JvdXBcbiAgICAgICAgICAgICAgKlxcKSA9IE1hdGNoIGFueXRoaW5nIGFuZCB0aGVuIGEgY2xvc2UgcGFyZW5zXG4gICAgICAgICAgKSAgPSBDbG9zZSBub24tY2FwdHVyaW5nIGdyb3VwXG4gICAgICAgICAgKiAgPSBNYXRjaCBhbnl0aGluZ1xuICAgICAgICkgID0gQ2xvc2UgY2FwdHVyaW5nIGdyb3VwXG5cdCBcXCkgID0gTWF0Y2ggYSBjbG9zZSBwYXJlbnNcblxuXHQgL2dpICA9IEdldCBhbGwgbWF0Y2hlcywgbm90IHRoZSBmaXJzdC4gIEJlIGNhc2UgaW5zZW5zaXRpdmUuXG5cdCAqL1xuXHR2YXIgZml4ZWRDc3MgPSBjc3MucmVwbGFjZSgvdXJsXFxzKlxcKCgoPzpbXikoXXxcXCgoPzpbXikoXSt8XFwoW14pKF0qXFwpKSpcXCkpKilcXCkvZ2ksIGZ1bmN0aW9uKGZ1bGxNYXRjaCwgb3JpZ1VybCkge1xuXHRcdC8vIHN0cmlwIHF1b3RlcyAoaWYgdGhleSBleGlzdClcblx0XHR2YXIgdW5xdW90ZWRPcmlnVXJsID0gb3JpZ1VybFxuXHRcdFx0LnRyaW0oKVxuXHRcdFx0LnJlcGxhY2UoL15cIiguKilcIiQvLCBmdW5jdGlvbihvLCAkMSl7IHJldHVybiAkMTsgfSlcblx0XHRcdC5yZXBsYWNlKC9eJyguKiknJC8sIGZ1bmN0aW9uKG8sICQxKXsgcmV0dXJuICQxOyB9KTtcblxuXHRcdC8vIGFscmVhZHkgYSBmdWxsIHVybD8gbm8gY2hhbmdlXG5cdFx0aWYgKC9eKCN8ZGF0YTp8aHR0cDpcXC9cXC98aHR0cHM6XFwvXFwvfGZpbGU6XFwvXFwvXFwvKS9pLnRlc3QodW5xdW90ZWRPcmlnVXJsKSkge1xuXHRcdCAgcmV0dXJuIGZ1bGxNYXRjaDtcblx0XHR9XG5cblx0XHQvLyBjb252ZXJ0IHRoZSB1cmwgdG8gYSBmdWxsIHVybFxuXHRcdHZhciBuZXdVcmw7XG5cblx0XHRpZiAodW5xdW90ZWRPcmlnVXJsLmluZGV4T2YoXCIvL1wiKSA9PT0gMCkge1xuXHRcdCAgXHQvL1RPRE86IHNob3VsZCB3ZSBhZGQgcHJvdG9jb2w/XG5cdFx0XHRuZXdVcmwgPSB1bnF1b3RlZE9yaWdVcmw7XG5cdFx0fSBlbHNlIGlmICh1bnF1b3RlZE9yaWdVcmwuaW5kZXhPZihcIi9cIikgPT09IDApIHtcblx0XHRcdC8vIHBhdGggc2hvdWxkIGJlIHJlbGF0aXZlIHRvIHRoZSBiYXNlIHVybFxuXHRcdFx0bmV3VXJsID0gYmFzZVVybCArIHVucXVvdGVkT3JpZ1VybDsgLy8gYWxyZWFkeSBzdGFydHMgd2l0aCAnLydcblx0XHR9IGVsc2Uge1xuXHRcdFx0Ly8gcGF0aCBzaG91bGQgYmUgcmVsYXRpdmUgdG8gY3VycmVudCBkaXJlY3Rvcnlcblx0XHRcdG5ld1VybCA9IGN1cnJlbnREaXIgKyB1bnF1b3RlZE9yaWdVcmwucmVwbGFjZSgvXlxcLlxcLy8sIFwiXCIpOyAvLyBTdHJpcCBsZWFkaW5nICcuLydcblx0XHR9XG5cblx0XHQvLyBzZW5kIGJhY2sgdGhlIGZpeGVkIHVybCguLi4pXG5cdFx0cmV0dXJuIFwidXJsKFwiICsgSlNPTi5zdHJpbmdpZnkobmV3VXJsKSArIFwiKVwiO1xuXHR9KTtcblxuXHQvLyBzZW5kIGJhY2sgdGhlIGZpeGVkIGNzc1xuXHRyZXR1cm4gZml4ZWRDc3M7XG59O1xuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9ub2RlX21vZHVsZXMvc3R5bGUtbG9hZGVyL2xpYi91cmxzLmpzXG4vLyBtb2R1bGUgaWQgPSAxM1xuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwic291cmNlUm9vdCI6IiJ9