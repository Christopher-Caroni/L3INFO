export default class Mobile {
    constructor(aCanvas, srcImage, x, y, vx, vy) {
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

    draw() {
        if (this.imgLoaded === true) {
            this.context.drawImage(this.imgMobile, this.x, this.y);
        }
    }

    move() {
        this.x += this.vx;
        this.y += this.vy;
    }

    imgLoadListener() {
        this.imgLoaded = true;
    }
}
