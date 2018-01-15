class Balle{
  constructor(aCanvas){
    this.myCanvas = aCanvas;
    this.context = aCanvas.getContext("2d");
    initBalle();
  }

  initBalle(){

    this.imgBalle = new Image();
    this.imgBalle.src = "images/balle.png";

    this.imgBalle.addEventListener("load", this.init.bind(this));

  }

  init(){
    this.x = this.myCanvas.width/2;
    this.y = this.myCanvas.height/2;
    this.deltaX = 1;
    this.delatY = 1.25;

  }

  draw(){

    this.context.clearRect(0,0, this.myCanvas.width, this.myCanvas.height);
    this.context.drawImage(this.imgBalle, this.x, this.y);
  }

  move(){
    this.x += this.deltaX;
    this.y += this.delatY;

    if((y<0) ||(y>this.myCanvas.height)){
      this.delatY = -this.delatY;
    }
    if((x<0)||(this.x>this.myCanvas.width)){
      this.deltaX = -this.deltaX;
    }
  }
}
