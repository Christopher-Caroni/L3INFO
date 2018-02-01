import Mobile from './Mobile.js';
import shoot from '../images/shoot.png';

export default class Shoot extends Mobile {
    constructor(aCanvas, x, y, game) {
        super(aCanvas, shoot, x, y, 8, 0);
        this.width = shoot.width;
        this.height = shoot.height;
        this.game = game;
    }

    move(){
        super.move();

        if (this.x >= this.myCanvas.width) {
            this.game.removeShoot(this);
        }
    }
    isInside(otherX, otherY) {
        return (otherX >= this.x && otherX <= (this.x + this.width) && otherY >= this.y && otherY <= (this.y + this.height));
    }
}
