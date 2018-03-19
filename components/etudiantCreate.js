import React from 'react';
import PropTypes from 'prop-types';


export default class EtudiantCreate extends React.Component {
    constructor(props) {
        super(props);
    }


    getEtu() {
        let newNom = this.inputNom.value;
        let newPrenom = this.inputPrenom.value;
        let newGroupe = this.inputGroupe.value;

        return {nom: newNom, prenom: newPrenom, groupe: newGroupe};
    }

    onClickCreate(event) {
        this.props.createEtu(this.getEtu());
    }

    clearValues() {
      this.inputNom.value = "";
      this.inputPrenom.value = "";
      this.inputGroupe.value = "";
    }



    render() {
        return (
            <tr className="etudiant active" id={this.props._id}>
                <td className="nom"><input placeholder="nom" ref={ input => this.inputNom = input}/></td>
                <td className="prenom"><input placeholder="prénom" ref={ input => this.inputPrenom = input}/></td>
                <td className="groupe"><input placeholder="groupe" ref={ input => this.inputGroupe = input}/></td>
                <td>
                    <button type="button"  className="btn btn-success center-block"  onClick={this.onClickCreate.bind(this)}>Create</button>
                </td>

            </tr>
        );
    }
}

EtudiantCreate.propTypes = {
    nom: PropTypes.string,
    prenom: PropTypes.string,
    groupe: PropTypes.number
}
