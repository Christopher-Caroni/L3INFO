
var setup = function() {
    let theCanvas = document.getElementById("terrain");
    let animation = new AnimationWithObstacle(theCanvas, new Obstacle(200,175,75,75));

    let stopStartBall = document.getElementById("stopStartBall");
    stopStartBall.addEventListener("click", animation.startOrStopBall.bind(animation));

    let addBall = document.getElementById("addBall");
    stopStartBall.addEventListener("click", animation.addBall.bind(animation));
}

window.addEventListener("DOMContentLoaded",setup);
