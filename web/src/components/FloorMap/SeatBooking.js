import React from "react";
import "../../style/Seats.css";
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import {experimentalStyled as styled} from "@mui/material/styles";
import {Button, TextField} from "@mui/material";
import {AppTrafficBySite} from "../../sections/@dashboard/app";
import DateFnsUtils from '@date-io/date-fns';
import {DateTimePicker} from "@mui/lab";

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
            <Grid>
                <DrawGrid
                    seat={this.state.seat}
                    available={this.state.seatAvailable}
                    reserved={this.state.seatReserved}
                    selected={this.state.seatSelected}
                    onClickData={this.onClickData.bind(this)}
                    checktrue={this.checktrue.bind(this)}
                    handleSubmited={this.handleSubmited.bind(this)}
                />
            </Grid>
        );
    }
}

class DrawGrid extends React.Component {
    handleChange(){
        console.log("Date Pciker")
    }
    render() {
        return (
            <Grid>
                <Grid>
                <AppTrafficBySite
                    title="Select Your Seat"
                    list={this.props.seat}
                    checktrue={this.props.checktrue}
                    onClickData={this.props.onClickData}
                    selected={this.props.selected}
                    reservedSeat={this.props.reserved}
                />
                </Grid>
                <Grid  >
                    <Button size="large" variant="contained" onClick={() => this.props.handleSubmited()}>Confirm Booking</Button>
                </Grid>
            </Grid>


        );
    }
}
export default SeatBooking;
