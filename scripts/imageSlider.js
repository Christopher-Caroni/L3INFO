
/*
 * define here type ImageSlider
 */
var ImageSlider = function(aCanvas){
  this.myCanvas = aCanvas;
  this.position;

  this.context = aCanvas.getContext("2d");

}

ImageSlider.prototype.init = function(){
  this.myCanvas.width = this.img1.width;
  this.myCanvas.height = this.img1.height;


  this.position = this.myCanvas.width/2;
  this.dessine();

  this.context.fillStyle = "rgb(255,0,0)";


  this.context.fillRect(this.position,0,5,this.myCanvas.height);
  this.myCanvas.addEventListener("keydown",keyAction);
}

ImageSlider.prototype.dessine = function(){

    //void ctx.drawImage(image, sx, sy, sLargeur, sHauteur, dx, dy, dLargeur, dHauteur);

    this.context.drawImage(this.img1, 0, 0, this.img1.width, this.img1.height);
    this.context.drawImage(this.img2, this.position, 0, this.img2.width, this.img2.height);
}

ImageSlider.prototype.initImages = function(imgAvant, imgApres){

  this.img1 = new Image();
  this.img1.src = imgAvant;

  this.img2 = new Image();
  this.img2.addEventListener("load", this.init.bind(this));

  this.img2.src = imgApres;
}

// la fonction d'écoute, comme toute fonction d'écoute elle dispose d'un paramètre 'event'
var keyAction = function(event) {
   // on peut placer ici du code qui est exécuté dans tous les cas avant le traitement des touches
   switch (event.key) {
      case "ArrowLeft":
      case "Left":
         //  écrire ici le code exécuté si la touche flèche gauche est appuyée
      break;
      case "ArrowRight":
      case "Right":
         // écrire ici le code exécuté si la touche flèche droite est appuyée
      break;
      case "X":       
      case "x":       
         // écrire ici le code exécuté si la touche "x" est appuyée
      break;
      default: return;
   }
   // on peut aussi écrire ici du code exécuté dans tous les cas après le traitement des touches
   event.preventDefault();   // pour désactiver l'action éventuelle par défaut liée à la touche pressée
}
