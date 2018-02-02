import Starship from './Starship.js';
import Saucer from './Saucer.js';
import Shoot from "./Shoot";


export default class Game {
    constructor(aCanvas) {
        this.myCanvas = aCanvas;
        this.raf = undefined;
        this.context = this.myCanvas.getContext('2d');

        this.starship = new Starship(this.myCanvas, 40, this.myCanvas.height / 2);

        this.saucers = [];
        this.bullets = [];
        this.score = 0;

        this.firstDraw = true;
        this.infiniteSaucer = false;
        this.intervalSaucer = undefined;
        this.scoreSpan = undefined;
    }


    addSaucer() {
        let x = this.myCanvas.width;
        let y = Math.floor(Math.random() * (this.myCanvas.height - 40));

        this.saucers.push(new Saucer(this.myCanvas, x, y, this));
    }

    infiniteSaucers() {
        this.infiniteSaucer = !this.infiniteSaucer;

        if (this.infiniteSaucer) {
            this.intervalSaucer = window.setInterval(() => this.addSaucer(), 750);
        } else {
            clearInterval(this.intervalSaucer);
        }
    }

    removeSaucer(saucer) {
        this.saucers = this.saucers.filter(e => e !== saucer);
        this.updateScoreOnLostSaucer();
    }

    addBullet() {
        let x = this.starship.x + this.starship.imgMobile.width - 10;
        let y = this.starship.y + (this.starship.imgMobile.height / 3);

        this.bullets.push(new Shoot(this.myCanvas, x, y, this));
    }

    removeShoot(shoot) {
        this.bullets = this.bullets.filter(e => e !== shoot);
    }

    updateScoreOnLostSaucer() {
        this.score -= 1000;
        this.updateScoreSpan();
    }

    updateScoreOnSaucerShotDown() {
        this.score += 200;
        this.updateScoreSpan();
    }

    setHTMLScore(scoreSpan) {
        this.scoreSpan = scoreSpan;
    }

    updateScoreSpan() {
        this.scoreSpan.innerHTML = this.score;
    }

    animate() {
        this.context.clearRect(0, 0, this.myCanvas.width, this.myCanvas.height);

        if (this.firstDraw || this.starship.isMoving()) {
            this.starship.move(this);
            this.firstDraw = false;
        }
        this.starship.draw();

        this.saucers.forEach(singleSaucer => {
            singleSaucer.move();
            singleSaucer.draw();
        });

        this.bullets.forEach(singleBullet => {
            singleBullet.move();
            singleBullet.draw();
        });

        this.bullets.forEach(shoot => {
            this.saucers = this.saucers.filter(saucer => !saucer.collisionWith(shoot, this));
        });

        this.raf = window.requestAnimationFrame(this.animate.bind(this));
    }

    keyDownActionHandler(event) {
        if (event.keyCode === 32) {
            this.addBullet();
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
}
