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
    this.deltaX = 5;
    this.delatY = 8;

  }

  draw(){

    this.context.clearRect(0,0, this.myCanvas.width, this.myCanvas.height);
    this.context.drawImage(this.imgBalle, this.x, this.y);
  }

  moveIt(){
    this.x += this.deltaX;
    this.y += this.delatY;

    if((this.y<0) ||(this.y>this.myCanvas.height-this.imgBalle.height)){
      this.delatY = -this.delatY;
    }
    if((this.x<0)||(this.x>this.myCanvas.width-this.imgBalle.width)){
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
  }


  moveAndDraw(){
    this.balle.moveIt();
    this.balle.draw();
    var raf = window.requestAnimationFrame(this.moveAndDraw.bind(this));
  }

  startAnimation(){
    var raf = window.requestAnimationFrame(this.moveAndDraw.bind(this));
  }

  cancelAnimation(){
     window.cancelAnimationFrame(this.raf);
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
