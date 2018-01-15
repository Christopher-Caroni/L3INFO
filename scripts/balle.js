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

  collisionWith(otherObstacle) {
      return otherObstacle.isInside(this.x, this.y);
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

class AnimationWithObstacle extends Animation {
  constructor(aCanvas, anObstacle) {
    super(aCanvas);
    this.obstacle = anObstacle;
    this.drawObstacle();
  }

  drawObstacle() {
    this.context.fillStyle = "rgb(255,0,0)";
    this.context.fillRect(this.obstacle.x, this.obstacle.y, this.obstacle.width, this.obstacle.height);
  }

  moveAndDraw() {
    this.context.clearRect(0,0, this.myCanvas.width, this.myCanvas.height);

    this.drawObstacle();

    this.balles.forEach(
      balle => {
        balle.moveIt();
        balle.draw();
      }
    );

    this.balles = this.balles.filter(balle => !balle.collisionWith(this.obstacle));
    this.raf = window.requestAnimationFrame(this.moveAndDraw.bind(this));
  }
}

class Obstacle {

  constructor(x,y, w, h) {
      this.x = x;
      this.y = y;
      this.width = w;
      this.height = h;
  }

  isInside(otherX, otherY) {
    return (otherX >= this.x && otherX <= (this.x + this.width) && otherY >= this.y && otherY <= (this.y + this.height));
  }
}
