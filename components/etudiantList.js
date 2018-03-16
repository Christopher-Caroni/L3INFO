import React from 'react';

import Etudiant from '../components/etudiant.js';

export default class EtudiantList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {etudiants: []};
    }

    componentWillMount() {
        this.setState({etudiants: this.props.alletudiants});
    }


    modifyEtu(id) {
        console.log("received modify req for id :" + id);
    }

    deleteEtu(etudiantId) {
        console.log("received del req for id :" + etudiantId);

        let requestOptions = {method: 'DELETE'};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etudiantId}`, requestOptions)
            .then(response => {
                console.log(response);
                if (response.ok) {
                    let newList = this.state.etudiants;
                    newList = newList.filter(etudiant => etudiant._id !== etudiantId);
                    this.setState({etudiants: newList});
                } else {
                    throw new Error(` delete failed  : ${response.json.message}`);
                }
            })
            .catch(error => window.alert("delete failed"));
    }

    render() {
        let allEtudiant = this.state.etudiants.map(
            etudiant =>
                <Etudiant
                    {...etudiant}
                    modifyEtu={(id) => this.modifyEtu(id)}
                    deleteEtu={(id) => this.deleteEtu(id)}
                    key={etudiant._id}
                />
        )


        return (
            <div className="etudiants">
                <p>Voici la liste des étudiants : </p>
                <table>
                    <tbody>
                    <tr>
                        <td>Nom</td>
                        <td>Prenom</td>
                        <td>Groupe</td>
                    </tr>
                    {allEtudiant}
                    </tbody>
                </table>
            </div>
        );
    }
}
