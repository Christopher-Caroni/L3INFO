var setup = function () {
    var username = window.prompt("Please enter a username:");
    if (username == null) {
        username = "anon";
    }

    var socket = io();
    socket.emit("userConnected", username);


    var messages = document.getElementById('messages');
    var input = document.getElementById('chatInput');

    socket.on('chat message', function (msg) {
        var msgEntry = document.createElement('li');
        msgEntry.appendChild(document.createTextNode(msg));
        messages.appendChild(msgEntry);
    });

    document.getElementById('chatForm').addEventListener("submit", function (ev) {
            socket.emit('chat message', username + ": " + input.value);
            input.value = "";

            ev.preventDefault();
            return true;
        }
    );
};

window.addEventListener("DOMContentLoaded", setup);
