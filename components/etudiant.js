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
            <tr className="etudiant" id={this.props._id}>
                <td className="nom"><input id={this.props._id + "_nom"} defaultValue={this.props.nom}/></td>
                <td className="prenom"><input id={this.props._id + "_prenom"} defaultValue={this.props.prenom}/></td>
                <td className="groupe"><input id={this.props._id + "_groupe"} defaultValue={this.props.groupe}/></td>
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
