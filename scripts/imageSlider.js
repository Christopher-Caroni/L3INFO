
/*
 * define here type ImageSlider
 */
var ImageSlider = function(aCanvas){
  this.myCanvas = aCanvas;
  this.position = aCanvas.width/2;

  this.context = aCanvas.getContext("2d");

}

ImageSlider.prototype.init = function(){
  this.myCanvas.width = this.img1.width;
  this.myCanvas.height = this.img1.height;

  this.dessine();
}

ImageSlider.prototype.dessine = function(){
    this.context.drawImage(this.img1,0,0);
    this.context.drawImage(this.img2,0,0);
}

ImageSlider.prototype.initImages = function(imgAvant, imgApres){

  this.img1 = new Image();
  this.img1.src = imgAvant;

  this.img2 = new Image();
  this.img2.addEventListener("load", this.init.bind(this), true);

  this.img2.src = imgApres;
}
