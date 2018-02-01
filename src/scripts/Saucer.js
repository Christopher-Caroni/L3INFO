import Mobile from './Mobile.js';

import saucerSrc from '../images/flyingSaucer-petit.png';
import Shoot from "./Shoot";

export default class Saucer extends Mobile {
    constructor(aCanvas, x, y, game) {
        super(aCanvas, saucerSrc, x, y, -3, 0);
        this.game = game;
    }

    move() {
        super.move();

        if (this.x <= 0) {
            this.game.removeSaucer(this);
        }
    }
    collisionWith(x, y, game) {
        let shoot = new Shoot(this.myCanvas, x, y, game);
        return shoot.isInside(shoot.x, shoot.y);
    }
}
