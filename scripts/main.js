import React from 'react';
import ReactDOM from 'react-dom';

import EtudiantList from '../components/etudiantList.js';


var Etudiants = require('../models/etudiants').model;

var etudiants = Etudiants.find();

var bootstrapReact =
  () =>
    {
      console.log("guigui suce des bites a decathlon");
      ReactDOM.render(
        <EtudiantList etudiants = {etudiants}/>,
        document.getElementById('insertReactHere')
      );
    }
//
window.addEventListener('DOMContentLoaded', bootstrapReact );
