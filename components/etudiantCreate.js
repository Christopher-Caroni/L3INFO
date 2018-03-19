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
            <tr className="etudiant" id={this.props._id}>
                <td className="nom"><input ref={ input => this.inputNom = input} id={this.props._id + "_nom"} defaultValue={this.props.nom}/></td>
                <td className="prenom"><input ref={ input => this.inputPrenom = input} id={this.props._id + "_prenom"} defaultValue={this.props.prenom}/></td>
                <td className="groupe"><input ref={ input => this.inputGroupe = input} id={this.props._id + "_groupe"} defaultValue={this.props.groupe}/></td>
                <td>
                    <button type="button" onClick={this.onClickCreate.bind(this)}>Create</button>
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
