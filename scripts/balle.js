var Balle = function(aCanvas){
  this.myCanvas = aCanvas;
  this.context = aCanvas.getContext("2d");

}
Balle.prototype.initBalle = function(){

  this.imgBalle = new Image();
  this.imgBalle.src = "images/balle.png";

  this.imgBalle.addEventListener("load", this.init.bind(this));

}

Balle.prototype.init = function(){

  this.x = this.myCanvas.width/2;
  this.y = this.myCanvas.height/2;
  this.deltaX = 1;
  this.delatY = 1.25;

}

Balle.prototype.draw = function(){

  this.context.clearRect(0,0, this.myCanvas.width, this.myCanvas.height);
  this.context.drawImage(this.imgBalle, this.x, this.y);
}

Balle.prototype.move = function(){
  this.x += this.deltaX;
  this.y += this.delatY;

  if((y<0) ||(y>this.myCanvas.height)){
    this.delatY = -this.delatY;
  }
  if((x<0)||(this.x>this.myCanvas.width)){
    this.deltaX = -this.deltaX;
  }
}
