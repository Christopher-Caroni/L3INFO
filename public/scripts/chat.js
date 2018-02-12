var setup = function () {
    var username = window.prompt("Please enter a username:");
    if (username == null) {
        username = "anon";
    }

    var socket = io();
    socket.emit("userConnected", username);


    var messages = document.getElementById('messages');
    var input = document.getElementById('chatInput');

    var appendChatMessage = function (msg) {
        var msgEntry = document.createElement('li');
        msgEntry.appendChild(document.createTextNode(msg));
        messages.appendChild(msgEntry);
    };

    socket.on('chat message', msg => appendChatMessage(msg));

    document.getElementById('chatForm').addEventListener("submit", function (ev) {
        appendChatMessage(username + ": " + input.value);
            socket.emit('chat message', username + ": " + input.value);

            input.value = "";
            ev.preventDefault();
            return true;
        }
    );
};

window.addEventListener("DOMContentLoaded", setup);
