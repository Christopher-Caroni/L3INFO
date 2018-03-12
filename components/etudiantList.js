import React from 'react';

import Etudiant from '../components/etudiant.js';

export default class EtudiantList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {etudiants : this.props.etudiants};
  }

    modifyEtu(id) {
      console.log("received modify req for id :" + id);
    }

    deleteEtu(id) {
      console.log("received del req for id :" + id);

      /* send del req to server */
      let newList = this.state.etudiants;
      newList = newlist.filter(etu => etu._id != id);

      this.setState(etudiants : newList);
    }

  render() {
    let allEtudiant = this.props.etudiants.map(
      etudiant =>
        <Etudiant
          {...etudiant}
          modifyEtu = {(id) => this.modifyEtu(id)}
          deleteEtu = {(id) => this.deleteEtu(id)}
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
