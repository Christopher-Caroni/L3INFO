import React from 'react';

import EtudiantList from '../components/etudiantList.js';

export default class etudiantListWithFilter extends React.Component {
    constructor(props) {
        super(props);
        this.state = {etudiants: [], filterText: ''}
    }

    componentWillMount() {
        this.setState({etudiants: this.props.alletudiants});
    }


    changeFilter() {
        this.setState({filterText: this.filterInput.value});
    }

    filterList() {
        let list = this.state.etudiants;
        let filterText = this.state.filterText;


        if (filterText === "") {
            return list;
        }


        return list.filter(etudiant => {
            return etudiant.nom.toLowerCase().includes(filterText.toLowerCase()) || etudiant.prenom.toLowerCase().includes(filterText.toLowerCase()) || etudiant.groupe == filterText;
        });
    }

    render() {

        return (
            <div className="container">
            <div className="row">
            <div className="center-block">

                <h1>Liste des étudiants</h1>

                <h3>Filtre :</h3>
                 <input
                 placeholder="nom, prénom ou groupe"
                  value={this.state.filterText}
                  onChange={this.changeFilter.bind(this)}
                  ref={input => this.filterInput = input}
                  />
                <EtudiantList
                    alletudiants={this.filterList()}
                />
            </div>
            </div>
        </div>
        );
    }
}
