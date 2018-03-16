import React from 'react';
import PropTypes from 'prop-types';


export default class Etudiant extends React.Component {
    constructor(props) {
        super(props);
    }


    onClickModify(event) {
        this.props.modifyEtu(this.props._id);
    }

    onClickDelete(event) {
        this.props.deleteEtu(this.props._id);
    }

    render() {
        return (
            <tr className="etudiant">
                <td className="nom">{this.props.nom}</td>
                <td className="prenom">{this.props.prenom}</td>
                <td className="groupe">{this.props.groupe}</td>
                <td>
                    <button type="button" onClick={this.onClickModify.bind(this)}>Modifier</button>
                </td>
                <td>
                    <button type="button" onClick={this.onClickDelete.bind(this)}>Supprimer</button>
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
