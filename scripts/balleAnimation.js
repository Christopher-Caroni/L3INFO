
var setup = function() {
    let theCanvas = document.getElementById("terrain");
    let animation = new Animation(theCanvas);

    let stopStartBall = document.getElementById("stopStartBall");
    stopStartBall.addEventListener("click", animation.startOrStopBall.bind(this));
}

window.addEventListener("DOMContentLoaded",setup);
