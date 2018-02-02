import Starship from "./Starship";

export default class SmallStarship extends Starship {
    constructor(aCanvas, initX, initY) {
        super(aCanvas, initX, initY);
    }


    draw() {
        if (this.imgLoaded === true) {
            this.context.drawImage(this.imgMobile, this.x, this.y, 24, 20);
        }
    }
}