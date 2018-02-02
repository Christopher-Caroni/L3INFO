import Mobile from './Mobile.js';
import shoot from '../images/shoot.png';

export default class Shoot extends Mobile {
    constructor(aCanvas, x, y, dx, dy, game) {
        super(aCanvas, shoot, x, y, dx, dy);
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
}
