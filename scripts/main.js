import React from 'react';
import ReactDOM from 'react-dom';

import EtudiantList from '../components/etudiantList.js';
import EtudiantListWithFilter from '../components/etudiantListWithFilter.js';

var renderTable =
    () => {
        let requestOptions = {method: 'GET'};
        fetch(`http://127.0.0.1:3000/etudiantsrest/`, requestOptions)
            .then(response => response.json())
            .then(etu => {
                ReactDOM.render(
                    <EtudiantListWithFilter alletudiants={etu}/>,
                    document.getElementById('insertReactHere')
                );
            })
    }

window.addEventListener('DOMContentLoaded', () => renderTable());
