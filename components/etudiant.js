import React from 'react';
import PropTypes from 'prop-types';


export default class Etudiant extends React.Component {
    constructor(props) {
        super(props);
    }

    getEtu() {
        let newNom = this.inputNom.value;
        let newPrenom = this.inputPrenom.value;
        let newGroupe = this.inputGroupe.value;

        return {_id: this.props._id, nom: newNom, prenom: newPrenom, groupe: newGroupe};
    }

    onClickModify(event) {
        this.props.modifyEtu(this.getEtu());
    }

    onClickDelete(event) {
        this.props.deleteEtu(this.props._id);
    }

    render() {
        return (
            <tr className="etudiant" id={this.props._id}>
                <td className="nom"><input ref={ input => this.inputNom = input} defaultValue={this.props.nom}/></td>
                <td className="prenom"><input ref={ input => this.inputPrenom = input} defaultValue={this.props.prenom}/></td>
                <td className="groupe"><input ref={ input => this.inputGroupe = input} defaultValue={this.props.groupe}/></td>
                <td>
                    <button type="button" className="btn btn-primary center-block" onClick={this.onClickModify.bind(this)}>Modifier</button>
                </td>
                <td>
                    <button type="button"  className="btn btn-danger center-block" onClick={this.onClickDelete.bind(this)}>Supprimer</button>
                </td>
            </tr>
        );
    }
}

Etudiant.propTypes = {
    nom: PropTypes.string,
    prenom: PropTypes.string,
    groupe: PropTypes.number
}
