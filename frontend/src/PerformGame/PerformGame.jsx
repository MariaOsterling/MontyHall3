import React, {Component} from "react";
import axios from 'axios';


import './PerformGame.css';

class PerformGame extends Component {
    constructor(props) {
        super(props);
        this.state = {
            noOfCarsWon : 0,
            changeDoor: "yes",
            numberOfTries: 1,
        };

        this.handleNumberChange = this.handleNumberChange.bind(this);
        this.handleNumberSubmit = this.handleNumberSubmit.bind(this);

        this.handleDoorChange = this.handleDoorChange.bind(this);
        this.handleDoorSubmit = this.handleDoorSubmit.bind(this);
    }

    handleClick() {
        console.log('In handle click with ChangeDoor ' + this.state.changeDoor + ' and number of tries: ' + this.state.numberOfTries);

        axios.get('checkresult/?number=' + this.state.numberOfTries + '&changeDoor='+this.state.changeDoor)
            .then( res => {
                if (res.status === 200) {
                    this.setState({noOfCarsWon: res.data});
                    console.log('Number of cars won: ' + this.state.noOfCarsWon);

                } else{
                    console.log('Error');
                }
            })
            .catch(res => {
                console.log(res);
            })

    }

    handleNumberChange(event) {
        console.log('Handle change called with ' + event.target.value);
        this.setState({numberOfTries: event.target.value});

    }

    handleNumberSubmit(event) {
        console.log('Handle submit called');
        event.preventDefault();
    }

    handleDoorChange(event) {
        this.setState({changeDoor: event.target.value});
        console.log('Handle change 1 called');
    }

    handleDoorSubmit(event) {
        console.log('Handle submit 1 called');
        event.preventDefault();
    }

    render() {
        return (
            <div className="PerformGame">
                <form className="gameComponents" onSubmit={this.handleDoorSubmit}>
                    <label>
                        Byta dörr?
                        <select value={this.state.changeDoor} onChange={this.handleDoorChange}>
                            <option value="yes">Ja</option>
                            <option value="no">Nej</option>
                        </select>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>

                <form className="gameComponents" onSubmit={this.handleNumberSubmit}>
                    <label>
                        Antal försök:
                        <input type="text" value={this.state.numberOfTries} onChange={this.handleNumberChange}/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>

                <button className="button" onClick={() => this.handleClick()}>
                    Start
                </button>

                <h1>Resultat</h1>
                <h2>Antal vunna bilar</h2>
                <h3>{this.state.noOfCarsWon}</h3>
            </div>
        );
    }
}

export default PerformGame