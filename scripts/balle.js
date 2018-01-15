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
    this.context.drawImage(this.imgBalle, this.x, this.y);
  }

  moveIt(){
    this.x += this.deltaX;
    this.y += this.delatY;

    if((this.y<0) ||(this.y>this.myCanvas.height-this.imgBalle.height)){
      this.delatY *= -1;
    }
    if((this.x<0)||(this.x>this.myCanvas.width-this.imgBalle.width)){
      this.deltaX *= -1;
    }
  }
}

class Animation{
  constructor(aCanvas){
    this.myCanvas = aCanvas;
    this.context = aCanvas.getContext("2d");
    this.start = 0;

    this.balles = Array();
    this.raf = undefined;
    }


  moveAndDraw(){

    this.context.clearRect(0,0, this.myCanvas.width, this.myCanvas.height);
    this.balles.forEach(
      balle => {
        balle.moveIt();
        balle.draw();
      }
    );
    this.raf = window.requestAnimationFrame(this.moveAndDraw.bind(this));

  }

  startAnimation(){
    this.raf = window.requestAnimationFrame(this.moveAndDraw.bind(this));
  }

  cancelAnimation(){
     window.cancelAnimationFrame(this.raf);
  }

  startOrStopBall(){
    if(this.start===1){
      this.cancelAnimation();
      this.start = 0;
    }else {
      this.startAnimation();
      this.start = 1;
    }
  }

  addBall(){
    this.balles.push(new Balle(this.myCanvas));
  }
}
