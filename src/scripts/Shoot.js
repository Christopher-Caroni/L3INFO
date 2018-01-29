import Mobile from './Mobile.js';
import shoot from '../images/shoot.png';

export default class Shoot extends Mobile {
    constructor(aCanvas, x, y) {
        super(aCanvas, shoot,x, y, 8, 0);
    }

    move(){
        super.move();

        if (this.x >= this.myCanvas.width) {
            this.game.removeShoot(this);
        }
    }
}
