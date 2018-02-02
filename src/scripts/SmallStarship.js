import Starship from "./Starship";

export default class SmallStarship extends Starship {
    constructor(aCanvas, initX, initY, yOffset) {
        super(aCanvas, initX, initY + yOffset);
        this.yOffset = yOffset;
    }


    draw() {
        if (this.imgLoaded === true) {
            this.context.drawImage(this.imgMobile, this.x, this.y, 24, 20);
        }
    }

    validMove(calcX, calcY) {
        return calcX > 0 && calcY > (0 + this.yOffset) && (calcX < this.myCanvas.width - 40) && calcY < (this.myCanvas.height + this.yOffset - 40);
    }

}