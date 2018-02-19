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


    var typers = [];
    var refreshTypingInfo = function () {
        if (typers.length === 0) {
            document.getElementById('typingInfo').innerText = "";
            return;
        }
        var names = "";
        typers.forEach(singleName => names += singleName + " ");
        document.getElementById('typingInfo').innerText = (names + " is/are typing");
        console.log(names + " is/are typing");
    };

    socket.on('stoppedTyping', function (username) {
        typers = typers.filter(name => name !== username);
        refreshTypingInfo();
    });

    socket.on('isTyping', function (username) {
        if (!typers.includes(username)) {
            typers.push(username);
            console.log("adding typer");
            refreshTypingInfo();
        }
    });

    var lastTypedTime = new Date(0); // it's 01/01/1970
    var typingDelayMillis = 5000; // how long user can "think about his spelling" before we show "No one is typing -blank space." message

    function refreshTypingStatus() {
        if (input.value === "" || new Date().getTime() - lastTypedTime.getTime() > typingDelayMillis) {
            socket.emit("stoppedTyping", username);
        } else {
            socket.emit("isTyping", username);
        }
    }

    setInterval(refreshTypingStatus, 1500);

    input.addEventListener('keydown', function (evt) {
        console.log("update time");
        lastTypedTime = new Date();
    });

};

window.addEventListener("DOMContentLoaded", setup);
