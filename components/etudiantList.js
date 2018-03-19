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


    createEtu(newEtu) {

        let body = JSON.stringify(newEtu);
        let requestOptions = {method: 'POST', headers: {"Content-Type": "application/json"}, body: body};
        fetch(`http://127.0.0.1:3000/etudiantsrest/`, requestOptions)
            .then(response => {
                this.etuCreate.clearValues();
                if (!response.ok) {
                    throw new Error(`create failed  : ${response.json.message}`);
                } else {
                  response.json()
                    .then(json => {
                      let newList = this.state.etudiants;
                      newList.push(json);
                      this.setState({etudiants: newList});
                    })
                }
            })
            .catch(error => window.alert(error.message));
    }

    modifyEtu(etu) {
        console.log("received modify req for id :" + etu._id);

        let body = JSON.stringify(etu);
        let requestOptions = {method: 'PUT', headers: {"Content-Type": "application/json"}, body: body};
        fetch(`http://127.0.0.1:3000/etudiantsrest/${etu._id}`, requestOptions)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`update failed  : ${response.json.message}`);
                }
            })
            .catch(error => window.alert(error.message));
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
                }
            })
            .catch(error => window.alert(error.message));
    }

    componentWillReceiveProps(nextProps) {
        this.setState({etudiants: nextProps.alletudiants});
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
                    <EtudiantCreate
                      ref={etuCreate => this.etuCreate = etuCreate}
                      nom=""
                      prenom=""
                      groupe={0}
                      createEtu={(etudiant)=> this.createEtu(etudiant)}
                    />
                    </tbody>
                </table>
            </div>
        );
    }
}
