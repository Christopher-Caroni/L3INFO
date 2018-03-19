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

        let counts = [0,0,0,0,0,0];
        this.state.etudiants.forEach( etu => {
          counts[etu.groupe-1]++;
        })

        let groupeCount = counts.map(
            (count, idx) =>
              <td key={idx} >{counts[idx]}</td>

        )


        return (

            <div>

            <div  id="groupeCount">
            <h3> Nombre d étudiants par groupe :</h3>
            <table className="table table-striped table-bordered table-condensed">
              <tbody>
                <tr><th>Groupe 1</th><th>Groupe 2</th><th>Groupe 3</th><th>Groupe 4</th><th>Groupe 5</th><th>Groupe 6</th></tr>
                <tr>
                  {groupeCount}
                </tr>
              </tbody>
            </table>

            </div>

              <div className="etudiants">
                <h3>Voici la liste des étudiants : </h3>
                <table className="table table-striped table-bordered table-condensed table-hover">
                    <tbody>
                    <tr className="active" >
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Groupe</th>
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
            </div>
        );
    }
}
