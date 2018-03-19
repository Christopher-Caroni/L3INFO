import React from 'react';

import Etudiant from '../components/etudiant.js';
import EtudiantCreate from '../components/etudiantCreate.js';


export default class EtudiantList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {etudiants: []};
    }

    componentWillMount() {
        this.setState({etudiants: this.props.alletudiants});
    }

    getEtu(etudiantId) {
        let newNom = document.getElementById(etudiantId + "_nom").value;
        let newPrenom = document.getElementById(etudiantId + "_prenom").value;
        let newGroupe = document.getElementById(etudiantId + "_groupe").value;

        return {_id: etudiantId, nom: newNom, prenom: newPrenom, groupe: newGroupe};
    }


    createEtu(newEtu) {

        let body = JSON.stringify(newEtu);
        let requestOptions = {method: 'POST', headers: {"Content-Type": "application/json"}, body: body};
        fetch(`http://127.0.0.1:3000/etudiantsrest/`, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`create failed  : ${response.json.message}`);
                }
                let newList = this.state.etudiants;
                newList.push(newEtu);
                this.setState({etudiants: newList});
            })
            .catch(error => window.alert(error.message));
    }

    modifyEtu(etudiantId) {
        console.log("received modify req for id :" + etudiantId);

        let newEtu = this.getEtu(etudiantId);

        let body = JSON.stringify(newEtu);
        let requestOptions = {method: 'PUT', headers: {"Content-Type": "application/json"}, body: body};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etudiantId}`, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`update failed  : ${response.json.message}`);
                }
            })
            .catch(error => window.alert("update failed"));
    }

    deleteEtu(etudiantId) {
        console.log("received del req for id :" + etudiantId);

        let requestOptions = {method: 'DELETE'};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etudiantId}`, requestOptions)
            .then(response => {
                if (response.ok) {
                    let newList = this.state.etudiants;
                    newList = newList.filter(etudiant => etudiant._id !== etudiantId);
                    this.setState({etudiants: newList});
                } else {
                    throw new Error(` delete failed  : ${response.json.message}`);
                }createEtu
            })
            .catch(error => window.alert("delete failed"));
    }

    componentWillReceiveProps(nextProps) {
        this.setState({etudiants: nextProps.alletudiants});
    }

    render() {
        console.dir(this.state.etudiants);
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
                    <EtudiantCreate
                      nom=""
                      prenom=""
                      groupe=""
                      createEtu={(etudiant)=> this.createEtu(etudiant)}
                    />
                    </tbody>
                </table>
            </div>
        );
    }
}
