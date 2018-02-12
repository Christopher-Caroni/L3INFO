var setup = function () {
    var socket = io();
    var messages = document.getElementById('messages');
    var input = document.getElementById('chatInput');

    socket.on('chat message', function (msg) {
        var msgEntry = document.createElement('li');
        msgEntry.appendChild(document.createTextNode(msg));
        messages.appendChild(msgEntry);
    });

    document.getElementById('chatForm').addEventListener("submit", function (ev) {
            socket.emit('chat message', input.value);
            input.value = "";

            ev.preventDefault();
            return true;
        }
    );
};

window.addEventListener("DOMContentLoaded", setup);
