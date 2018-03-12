import React from 'react';

import Etudiant from '../components/etudiant.js';

export default class EtudiantList extends React.Component {
  constructor(props) {
    super(props);
  }

  guidGenerator() {
    var S4 = function() {
       return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    };
    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
  }

  render() {
    let allEtudiant = this.props.etudiants.map(
      etudiant =>
        <Etudiant
          {...etudiant}
          key = {etudiant._id}
        />
    )


    return(
        <div className="etudiants">
          <p>Voici la liste des étudiants : </p>
          <table>
            <tbody>
              <tr><td>Nom</td><td>Prenom</td><td>Groupe</td></tr>
              {allEtudiant}
            </tbody>
          </table>
        </div>
        );
    }
}
