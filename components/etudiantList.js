import React from 'react';

import Etudiant from '../components/etudiant.js';

export default class EtudiantList extends React.Component {
  constructor(props) {
    super(props);
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
