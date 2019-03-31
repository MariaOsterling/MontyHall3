import React, {Component} from "react";
import './PerformGame.css';

class PresentResult extends Component {

    constructor(props) {
        super(props);
        this.state = {
            noOfCarsWon : props.noOfCarsWon,
        };


    }

    render() {
        return(
            <div>
                <p>Result: {this.state.noOfCarsWon}</p>
            </div>
        );
    }
}
export default PresentResult