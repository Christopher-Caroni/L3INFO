
var setup = function() {
    let theCanvas = document.getElementById("terrain");
    let animation = new Animation(theCanvas);

    let stopStartBall = document.getElementById("stopStartBall");
    stopStartBall.addEventListener("click", animation.startOrStopBall.bind(animation));

    let addBall = document.getElementById("addBall");
    stopStartBall.addEventListener("click", animation.addBall.bind(animation));
}

window.addEventListener("DOMContentLoaded",setup);
