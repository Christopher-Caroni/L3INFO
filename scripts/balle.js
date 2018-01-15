class Balle{
  constructor(aCanvas){
    this.myCanvas = aCanvas;
    this.context = aCanvas.getContext("2d");
    this.initBalle();
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

  moveIt(){
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

class Animation{
  constructor(aCanvas){
    this.myCanvas = aCanvas;
    this.context = aCanvas.getContext("2d");
    this.start = 0;

    this.balle = new Balle(this.myCanvas);
    this.raf = window.requestAnimationFrame(this.moveAndDraw);
  }


  moveAndDraw(){
    console.log(this);
    this.balle.moveIt();
    this.balle.draw();
    this.raf();
  }

  startAnimation(){
     this.moveAndDraw();
  }

  cancelAnimation(){
     window.cancelAnimationFrame(this.moveAndDraw);
  }

  startOrStopBall(){
    if(this.start){
      this.cancelAnimation();
      this.start = 0;
    }else {
      this.startAnimation();
      this.start = 1;
    }
  }
}
