
const delta = 10;
const LINE_COLOR = 'rgba(0,0,0,0.6)';
const LINE_WIDTH = 10;

var setup = function() {
    let theCanvas = document.getElementById("theCanvas1");
    let slider = new ImageSlider(theCanvas);
    slider.initImages("images/tsunami-avant.png","images/tsunami-apres.png");

    let theCanvas2 = document.getElementById("theCanvas2");
    let slider2 = new ImageSlider(theCanvas2);
    slider2.initImages("images/region-avant.jpg","images/region-apres.jpg");
}

window.addEventListener("DOMContentLoaded",setup);
