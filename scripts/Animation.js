var Animation = function(aCanvas){
  this.myCanvas = aCanvas;
  this.context = aCanvas.getContext("2d");
  this.start = 0;

  this.balle = new Balle(this.myCanvas);
}

Animation.prototype.moveAndDraw = function(){
  this.balle.move();
  this.balle.draw();
}

Animation.prototype.simpleAnimationFunction = function() {
  this.moveAndDraw();
  this.raf = window.requestAnimationFrame(simpleAnimationFunction);
}

Animation.prototype.startAnimation = function(){
   this.raf = window.requestAnimationFrame(simpleAnimationFunction);
}

Animation.prototype.cancelAnimation = function(){
   this.raf = window.cancelAnimationFrame(simpleAnimationFunction);
}

Animation.prototype.startOrStopBall = function(){
  if(this.start){
    this.cancelAnimation();
    this.start = 0;
  }else {
    this.startAnimation();
    this.start = 1;
  }
}
