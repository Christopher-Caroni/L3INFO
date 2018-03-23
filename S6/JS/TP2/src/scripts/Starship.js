import Mobile from './Mobile.js'
import starshipSrc from '../images/vaisseau-ballon-petit.png';

var MoveState = {UP: 0, DOWN: 1, NONE: 2};

export default class Starship extends Mobile {
    constructor(aCanvas, initX, initY) {
        super(aCanvas, starshipSrc, initX, initY, 0, 8);
        this.moving = MoveState.NONE;

        this.ogVY = this.vy;
        this.ogVX = this.vx;
    }

    get up() {
        return this.moving === MoveState.UP;
    }

    get down() {
        return this.moving === MoveState.DOWN;
    }

    moveUp() {
        this.moving = MoveState.UP;
    }

    moveDown() {
        this.moving = MoveState.DOWN;
    }

    move() {
        if (this.moving === MoveState.NONE) {
            return;
        }

        let calcY;
        if (this.moving === MoveState.DOWN) {
            this.vy = this.ogVY;
        } else if (this.moving === MoveState.UP) {
            this.vy = -this.ogVY;
        }

        calcY = this.y + this.vy;
        if (this.validMove(1, calcY)) {
            super.move();
        }
    }

    stopMove() {
        this.moving = MoveState.NONE;
    }

    validMove(calcX, calcY) {
        return calcX > 0 && calcY > 0 && (calcX < this.myCanvas.width - 40) && (calcY < this.myCanvas.height - 40);
    }


    isMoving() {
        return this.moving === MoveState.UP || this.moving === MoveState.DOWN;
    }
}
