import React, {Component} from "react";


class PresentResult extends Component {

    constructor(props) {
        super(props);
        this.state = {
            noOfCarsWon : 1,
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
export function updateNoOfCarsWon() {
    console.log("In updateNoOfCarsWon!!");
    this.state.noOfCarsWon = 10;
}
export default PresentResult