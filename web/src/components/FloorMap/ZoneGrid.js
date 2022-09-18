import {useState} from "react";
import {Box, CardContent, Card, Paper, CardHeader, Typography, Grid, Fade} from "@mui/material";
import "../../style/Seats.css";


const floor = [
    {
        floorName:"Floor 1",
        count:200,
        isAvailable:false,
        zone:[
            {
                zoneName: "A",
                numberOfSeats:50,
                rangeFrom:19,
                rangeTo:50,
                availableSeats:20
            },
            {
                zoneName: "B",
                numberOfSeats:50,
                rangeFrom:51,
                rangeTo:100,
                availableSeats:25
            },{
                zoneName: "C",
                numberOfSeats:50,
                rangeFrom:101,
                rangeTo:150,
                availableSeats:0
            },
            {
                zoneName: "D",
                numberOfSeats:50,
                rangeFrom:151,
                rangeTo:200,
                availableSeats:20
            }
        ]
    },{
        floorName:"Floor 2",
        count:200,
        zone:[
            {
                zoneName: "A",
                numberOfSeats:50,
                rangeFrom:1,
                rangeTo:50,
                availableSeats:20
            },
            {
                zoneName: "B",
                numberOfSeats:50,
                rangeFrom:51,
                rangeTo:100,
                availableSeats:20
            },{
                zoneName: "C",
                numberOfSeats:50,
                rangeFrom:101,
                rangeTo:150,
                availableSeats:20
            },
            {
                zoneName: "D",
                numberOfSeats:50,
                rangeFrom:151,
                rangeTo:200,
                availableSeats:20
            }
        ]
    },{
        floorName:"Floor 3",
        count:200,
        zone:[
            {
                zoneName: "A",
                numberOfSeats:50,
                rangeFrom:1,
                rangeTo:50,
                availableSeats:20
            },
            {
                zoneName: "B",
                numberOfSeats:50,
                rangeFrom:51,
                rangeTo:100,
                availableSeats:20
            },{
                zoneName: "C",
                numberOfSeats:50,
                rangeFrom:101,
                rangeTo:150,
                availableSeats:20
            },
            {
                zoneName: "D",
                numberOfSeats:50,
                rangeFrom:151,
                rangeTo:200,
                availableSeats:20
            }
        ]
    }
]


const zone = [
    "Z1",
    "Z2",
    "Z3",
    "Z4",
    "Z5",
    "Z6",
    "Z7",
    "Z8"];
const availableZone = ["Z3",
    "Z4",
    "Z5",
    "Z6",
    "Z7,",
    "Z8"];
const seatsReserved =["Z1", "Z2"];
const initialZoneSelected= [];

export default function ZoneGrid(){

    const [floorSelected, setFloorSelected] = useState(false);

    const [zones, setZone] = useState(zone);
    const [zonesAvailable, setZonesAvailable] = useState(availableZone);
    const [zoneReserved, setZoneReserved] = useState(seatsReserved);
    const [zonesSelected, setZonesSelected] = useState(initialZoneSelected);
    const onClickData = (zone) => {
        if (zonesSelected.indexOf(zone) <= -1) {
            setZonesSelected([zone, ...zonesSelected]);
        }else{
            setZonesSelected(zonesSelected.filter(item=>item!=zone));
        }
    }



    const getClass = (selected,reservedSeat, site)=>{
        if(selected.indexOf(site) > -1){
            return "selected";
        }
        if(reservedSeat.indexOf(site) > -1){
            return "reserved";
        }
        return "available";
    }

    return (
        <Grid>
            <Grid xs={10} md={10} lg={12}>
                <Fade in={true} {...({ timeout: 2000 })}>
            <Card>
                <CardHeader title={"Floor Selector"} />
                <CardContent>
                    <Box sx={{
                        display: 'grid',
                        gap: 5,
                        gridTemplateColumns: 'repeat(10, 1fr)',
                    }}>
                        {floor.map((floor) => (
                            <Paper elevation={4} className={getClass(zonesSelected, zoneReserved, floor)} key={floor.floorName} variant="outlined"
                                   sx={{ py: 5, textAlign: 'center' }} onClick={()=>onClickData(floor.floorName)}>
                                <Typography variant="body2" sx={{ color: 'text.secondary' }}>
                                    {floor.floorName}
                                </Typography>
                            </Paper>
                        ))}
                    </Box>
                </CardContent>
            </Card>
                </Fade>
        </Grid>
        <Grid xs={10} md={10} lg={12} hidden={!floorSelected}>
            <Fade in={true} {...({ timeout: 2000 })}>
            <Card>
                <CardHeader title={"Zone Selector"} />
                <CardContent>
                    <Box sx={{
                        display: 'grid',
                        gap: 5,
                        gridTemplateColumns: 'repeat(10, 1fr)',
                    }}>
                        {zones.map((site) => (
                            <Paper elevation={10} className={getClass(zonesSelected, zoneReserved, site)} key={site} variant="outlined"
                                   sx={{ py: 5, textAlign: 'center' }} onClick={()=>onClickData(site)}>
                                <Typography variant="body2" sx={{ color: 'text.secondary' }}>
                                    {site}
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