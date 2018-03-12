import React from 'react';
import PropTypes from 'prop-types';


export default class Etudiant extends React.Component {
  constructor(props) {
    super(props);
  }



  render() {
      return(
        <tr className="etudiant">
          <td className="nom">{this.props.nom}</td>
          <td className="prenom">{this.props.prenom}</td>
          <td className="groupe">{this.props.groupe}</td>
        </tr>
      );
  }
}

Etudiant.propTypes = {
  nom : PropTypes.string,
  prenom : PropTypes.string,
  groupe : PropTypes.number
}
