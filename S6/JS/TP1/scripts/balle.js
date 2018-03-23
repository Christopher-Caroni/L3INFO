var MoveState = { LEFT : 0, RIGHT : 1, NONE : 2};

var alea = function(n){
  let signe = Math.round(Math.random());
  return signe ? Math.floor(Math.random()*Math.floor(n))+1 : Math.floor(Math.random()*Math.floor(n))-1;
}
class Balle{
  constructor(aCanvas){
    this.myCanvas = aCanvas;
    this.init();
  }

  init(){
    this.context = this.myCanvas.getContext("2d");
    this.imgBalle = new Image();
    this.imgBalle.src = "images/balle.png";
    this.x = this.myCanvas.width/2;
    this.y = this.myCanvas.height/2;
    this.deltaX = alea(5);
    this.delatY = alea(5);

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
    this.start = false;

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
    if(this.start){
      this.cancelAnimation();
      this.start = false;
    }else {
      this.startAnimation();
      this.start = true;
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

    this.obstacle.move(this.myCanvas);

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

  keyDownActionHandler(event) {
  switch (event.key) {
        case "ArrowLeft":
        case "Left":
          console.log("received left key");
            this.obstacle.moveLeft();
            break;
        case "ArrowRight":
        case "Right":
            this.obstacle.moveRight();
            break;
        default: return;
    }
    event.preventDefault();
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

  moveLeft() {
    this.shiftX = -10;
    this.moving = MoveState.LEFT;
  }

  moveRight() {
    this.shiftX = +10;
    this.moving = MoveState.RIGHT;
  }

  move(canvas) {

    if (this.moving === MoveState.LEFT) {
        this.x = Math.max(0, this.x + this.shiftX);
    }

    if (this.moving === MoveState.RIGHT) {
      this.x = Math.min(canvas.width - this.width, this.x + this.shiftX);
    }
  }

}
