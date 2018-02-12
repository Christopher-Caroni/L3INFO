var setup = function () {
    var socket = io();
    var messages = document.getElementById('messages');
    console.log(messages);

    socket.on('chat message', function(msg){
        var msgEntry = document.createElement('li');
        msgEntry.appendChild(document.createTextNode(msg));
        messages.appendChild(msgEntry);
    });


    var input = document.getElementById('chatInput');

    var funcSubmit = function (ev) {
        socket.emit('chat message', input.value);
        input.value = "";

        ev.preventDefault();
        return true;
    };

    document.getElementById('chatForm').addEventListener("submit", funcSubmit);
};

window.addEventListener("DOMContentLoaded", setup);
