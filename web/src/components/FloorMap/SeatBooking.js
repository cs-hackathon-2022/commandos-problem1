import React from "react";
import "../../style/Seats.css";
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import {experimentalStyled as styled} from "@mui/material/styles";
import ZoneGrid from "./SeatGrid";


const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
}));
const zone = 6;
class SeatBooking extends React.Component {
    constructor() {
        super();
        this.state = {
            seat: [
                "A1",
                "A2",
                "A3",
                "A4",
                "A5",
                "A6",
                "A7",
                "A8",
                "A9",
                "A10",
                "A11",
                "A12",
                "A13",
                "A14",
                "A15",
                "A16",
                "A17",

                "B1",
                "B2",
                "B3",
                "B4",
                "B5",
                "B6",
                "B7",
                "C1",
                "C2",
                "C3",
                "C4",
                "C5",
                "C6",
                "C7"
            ],
            seatAvailable: [
                "A1",
                "A2",
                "A3",
                "A4",
                "A5",
                "A6",
                "A7",
                "A8",
                "A9",
                "A10",
                "A11",
                "A12",
                "A13",
                "A14",
                "A15",
                "A16",
                "A17",

                "B1",
                "B2",
                "B3",
                "B4",
                "B5",
                "B6",
                "B7",
                "C1",
                "C2",
                "C3",
                "C4",
                "C5",
                "C6",
                "C7"
            ],
            seatReserved: [],
            seatSelected: ["A1", "B2"]
        };
    }

    onClickData(seat) {
        if (this.state.seatReserved.indexOf(seat) > -1) {
            this.setState({
                seatAvailable: this.state.seatAvailable.concat(seat),
                seatReserved: this.state.seatReserved.filter(res => res !== seat)
                //seatSelected: this.state.seatSelected.filter(res => res != seat)
            });
        } else {
            this.setState({
                seatReserved: this.state.seatReserved.concat(seat),
                //seatSelected: this.state.seatSelected.concat(seat),
                seatAvailable: this.state.seatAvailable.filter(res => res !== seat)
            });
        }
    }
    checktrue(row) {
        if (this.state.seatSelected.indexOf(row) > -1) {
            return false;
        } else {
            return true;
        }
    }

    handleSubmited() {
        this.setState({
            seatSelected: this.state.seatSelected.concat(this.state.seatReserved)
        });
        this.setState({
            seatReserved: []
        });
    }

    render() {
        return (
            <div>
                <h1>Floor Map</h1>
                <ZoneGrid />
                <DrawGrid
                    seat={this.state.seat}
                    available={this.state.seatAvailable}
                    reserved={this.state.seatReserved}
                    selected={this.state.seatSelected}
                    onClickData={this.onClickData.bind(this)}
                    checktrue={this.checktrue.bind(this)}
                    handleSubmited={this.handleSubmited.bind(this)}
                />
            </div>
        );
    }
}

class DrawGrid extends React.Component {
    render() {
        return (
            <Grid container >
                <Grid item >
                    <h2 />
                        <table className="grid" >
                            <tbody>
                            <tr>
                                {this.props.seat.map(row => (
                                    <td
                                        className={
                                            this.props.selected.indexOf(row) > -1
                                                ? "reserved"
                                                : this.props.reserved.indexOf(row) > -1
                                                    ? "selected"
                                                    : "available"
                                        }
                                        key={row}
                                        onClick={
                                            this.props.checktrue(row)
                                                ? e => this.onClickSeat(row)
                                                : null
                                        }
                                    >
                                        {row}{" "}
                                    </td>
                                ))}
                            </tr>
                            </tbody>
                        </table>
                        <button
                            type="button"
                            className="btn-success btnmargin"
                            onClick={() => this.props.handleSubmited()}
                        >
                            Confirm Booking
                        </button>
                </Grid>
            </Grid>


        );
    }

    onClickSeat(seat) {
        this.props.onClickData(seat);
    }
}
export default SeatBooking;
