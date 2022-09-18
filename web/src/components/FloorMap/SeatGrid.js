import {useState} from "react";
import {Box, CardContent, Card, Paper, CardHeader, Typography, Grid, Fade} from "@mui/material";
import "../../style/Seats.css";

export default function SeatGrid(props){

    const [seats, setSeats] = useState(Object.keys(props.seats).length>0?[...props.seats.seatsReserved,...props.seats.seatsAvailable]:[]);
    const [seatsAvailable, setSeatsAvailable] = useState(Object.keys(props.seats).length>0?props.seats.seatsAvailable:[]);
    const [seatsReserved, setSeatsReserved] = useState(Object.keys(props.seats).length>0?props.seats.seatsReserved:[]);
    const [seatsSelected, setSeatsSelected] = useState([]);


    const onSeatClickData = (seat) => {
        let isPresent = seatsSelected.some(se => se.name === seat.name)
        if (!isPresent) {
            setSeatsSelected([seat]);
        }else{
            setSeatsSelected([]);
        }
    }

    const getSeatClass = (selected,reservedSeat, seat)=>{
        let seatPresent = selected.some(set => set.name === seat.name);
        let seatRes = reservedSeat.some(set => set.name === seat.name)
        if(seatPresent){
            return "selected";
        }
        if(seatRes){
            return "reserved";
        }
        return "available";
    }

    return (
        <Grid>
            <Grid item xs={10} md={10} lg={12}>
                <Fade in={true} {...({ timeout: 2000 })}>
                    <Card>
                        <CardHeader title={"Seat Selector"} />
                        <CardContent>
                            <Box sx={{
                                display: 'grid',
                                gap: 5,
                                gridTemplateColumns: 'repeat(10, 1fr)',
                            }}>
                                {seats.map((seat) => (
                                    <Paper elevation={0} className={getSeatClass(seatsSelected, seatsReserved, seat)} key={seat.id} variant="outlined"
                                           sx={{ py: 5, textAlign: 'center' }} onClick={()=>onSeatClickData(seat)}>
                                        <Typography variant="body2" sx={{ color: 'text.secondary' }}>
                                            {seat.name}
                                        </Typography>
                                    </Paper>
                                ))}
                            </Box>
                        </CardContent>
                    </Card>
                </Fade>
            </Grid>
        </Grid>
    );

}