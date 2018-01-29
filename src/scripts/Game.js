import Starship from './Starship.js';
import Saucer from './Saucer.js';


export default class Game {
    constructor(aCanvas) {
        this.myCanvas = aCanvas;
        this.raf = undefined;
        this.context = this.myCanvas.getContext('2d');

        this.starship = new Starship(this.myCanvas, 40, this.myCanvas.height / 2);

        this.saucers = [];
        this.shoots = []
        this.score = 0;

        this.init();
        this.firstDraw = true;

        this.scoreSpan = undefined;
    }


    addSaucer() {
        let x = this.myCanvas.width;
        let y = Math.floor(Math.random() * this.myCanvas.height);

        this.saucers.push(new Saucer(this.myCanvas, x, y, this));
        console.log("added saucer");
    }

    infiniteSaucers() {
        // TODO
    }

    removeSaucer(saucer) {
        this.saucers = this.saucers.filter(e => e !== saucer);
        this.updateScoreOnLostSaucer();
    }

    removeShoot(shoot) {
        this.shoots = this.shoots.filter(e => e !== shoot);
    }

    setScore(updatedScore) {
        this.score = updatedScore;
    }

    loseSaucer() {
        this.score -= 1000;
        this.updateScoreSpan();
    }

    updateScoreOnSaucerShotDown() {
        this.score += 200;
        this.updateScoreSpan();
    }

    animate() {
        this.context.clearRect(0, 0, this.myCanvas.width, this.myCanvas.height);

        if (this.firstDraw || this.starship.isMoving()) {
            this.starship.move(this);
            this.firstDraw = false;
        }
        this.starship.draw();

        for (let singleSaucer of this.saucers) {
            singleSaucer.move();
            singleSaucer.draw();
        }

        this.raf = window.requestAnimationFrame(this.animate.bind(this));
    }

    keyDownActionHandler(event) {
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


    keyUpActionHandler(event) {
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


    setHTMLScore(scoreSpan) {
        this.scoreSpan = scoreSpan;
    }

    updateScoreSpan() {
        this.scoreSpan.innerHTML = this.score;
    }
}
