import React from 'react';
import ReactDOM from 'react-dom';

import EtudiantList from '../components/etudiantList.js';


var Etudiants = require('../models/etudiants').model;

var etudiants = Etudiants.find();

var bootstrapReact =
  () => ReactDOM.render(
      <EtudiantList etudiants = {etudiants}/>,
      document.getElementById('insertReactHere')
    );

//
window.addEventListener('DOMContentLoaded', bootstrapReact );
