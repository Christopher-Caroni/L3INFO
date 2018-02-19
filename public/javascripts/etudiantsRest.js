var setupListeners =
    () => {
        let gets = document.getElementsByClassName("get");
        Array.from(gets).forEach(button => button.addEventListener('click', () => getEtudiant(button.dataset.etudiantid)));
        let updates = document.getElementsByClassName("put");
        Array.from(updates).forEach(button => button.addEventListener('click', () => updateEtudiant(JSON.parse(button.dataset.etudiant))));
        let deletes = document.getElementsByClassName("delete");

        Array.from(deletes).forEach(button => button.addEventListener('click', () => {
            console.log(button.dataset);
            deleteEtudiant(button.dataset.etudiantid, button);
        }));

        let post = document.getElementById("createbutton");
        let inputNom = document.getElementById("nom");
        let inputPrenom = document.getElementById("prenom");
        let inputGroupe = document.getElementById("groupe");

        post.addEventListener('click', function () {
            createEtudiant(inputNom, inputPrenom, inputGroupe);
        });

        changeTd();

    };

var changeTd =
    () => {
        let tds = document.getElementsByTagName('td');

        for(var i=0; i<tds.length; i++) {
            tds[i].addEventListener('click', change.bind(td[i]), false);
        }
    }


var change =
    () => {
        if (this.firstChild.nodeType !== 3) {
            return;
        }

        var docFrag = document.createDocumentFragment();
        var input = document.createElement('input');
        input.value = this.textContent;
        this.removeChild(this.firstChild);
        docFrag.appendChild(input);
        this.appendChild(docFrag);
    }


window.addEventListener('DOMContentLoaded', setupListeners);

var getEtudiant =
    etudiantId => {
        let requestOptions = {method: 'GET'};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etudiantId}`, requestOptions)
            .then(response => response.json())
    }

var updateEtudiant =
    etudiant => {
        let newEtudiant = {...etudiant, title: etudiant.title + '*'};
        let body = JSON.stringify(newEtudiant);
        let requestOptions = {method: 'PUT', headers: {"Content-Type": "application/json"}, body: body};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etudiant._id}`, requestOptions)
            .then(response => response.json());
    }

var deleteEtudiant =
    (etudiantId, button) => {
        let requestOptions = {method: 'DELETE'};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etudiantId}`, requestOptions)
            .then(() => window.setTimeout(() => window.location.reload(), 200));
    }


var createEtudiant =
    (inputNom, inputPrenom, inputGroupe) => {
        let newEtudiant = {nom: inputNom.value, prenom: inputPrenom.value, groupe: inputGroupe.value};
        let body = JSON.stringify(newEtudiant);
        let requestOptions = {method: 'POST', headers: {"Content-Type": "application/json"}, body: body};
        fetch(`http://127.0.0.1:3000/etudiantsrest/`, requestOptions)
            .then(response => response.json())
            .then(() => window.setTimeout(() => window.location.reload(), 200));
    }
