var setupListeners =
    () => {
        let gets = document.getElementsByClassName("get");
        Array.from(gets).forEach( button => button.addEventListener('click', () => getEtudiant(button.dataset.etudiantid)));
        let updates = document.getElementsByClassName("put");
        Array.from(updates).forEach( button => button.addEventListener('click', () => updateEtudiant(JSON.parse(button.dataset.etudiant))));
        let deletes = document.getElementsByClassName("delete");
        Array.from(deletes).forEach( button => button.addEventListener('click', () => deleteEtudiant(button.dataset.etudiantid, button)));

        post.addEventListener('click', createEtudiant );
    };


window.addEventListener('DOMContentLoaded', setupListeners);

var getEtudiant =
    etudiantId => {
        let requestOptions = { method :'GET' };
        fetch(`http://127.0.0.1:3000/etudiantrest/${etudiantId}`, requestOptions)
            .then( response => response.json())
            .then( etudiant => details2.textContent = JSON.stringify(etudiant) );
    }

var updateEtudiant =
    etudiant => {
        let newEtudiant = { ...etudiant,  title : etudiant.title+'*' };
        let body = JSON.stringify(newEtudiant);
        let requestOptions = { method :'PUT',  headers : { "Content-Type": "application/json" }, body : body  };
        fetch(`http://127.0.0.1:3000/etudiantrest/${etudiant._id}`, requestOptions)
            .then( response => response.json())
            .then( etudiant => details2.textContent = JSON.stringify(etudiant) )
            .then( () => window.setTimeout( () => window.location.reload(), 3000));
    }

var deleteEtudiant =
    (etudiantId, button) => {
        let requestOptions = { method :'DELETE' };
        fetch(`http://127.0.0.1:3000/etudiantrest/${etudiantId}`, requestOptions)
            .then( response => details2.textContent = JSON.stringify(response) )
            .then ( () => {
                let span = document.createElement('span');
                span.className = 'deleted';
                span.textContent = 'deleted';
                button.parentNode.replaceChild( span , button);
            } )
            .then( () => window.setTimeout( () => window.location.reload(), 3000));
    }


var createEtudiant =
    () => {
        let newEtudiant = { title : 'New Title', author : 'New author', year : 2018, cover : ''  };
        let body = JSON.stringify(newEtudiant);
        let requestOptions = { method :'POST',  headers : { "Content-Type": "application/json" }, body : body  };
        fetch(`http://127.0.0.1:3000/etudiantrest/`, requestOptions)
            .then( response => response.json() )
            .then( etudiant => details2.textContent = JSON.stringify(etudiant) )
            .then( () => window.setTimeout( () => window.location.reload(), 3000));
    }
