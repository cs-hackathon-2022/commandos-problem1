import * as React from 'react';

import "../../style/Seats.css";
import { experimentalStyled as styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import {useState} from "react";


const Item = styled(Paper)(({ theme }) => ({
    ...theme.typography.body2,
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
}));

const zone = [
    "A1",
    "A2",
    "A3",
    "A4",
    "A5",
    "A6",
    "A7," ,
    "A8"];
const availableZone = ["A3",
    "A4",
    "A5",
    "A6",
    "A7,",
    "A8"];
const initialZoneSelected= ["A1", "A2"];


export default function ZoneGrid(props) {
    const {zoneSelected, setZoneSelected} = useState(initialZoneSelected);
    const {zonesAvailable, setZonesAvailable} = useState(availableZone);
    const {zones, setZones} = useState(zone);
    const onClickData = (zone) => {
        if (initialZoneSelected.indexOf(zone) > -1) {
            return null;
        } else {
            setZoneSelected([zone,...initialZoneSelected]);
        }
    }

    const onClickSeat = (row) => {
        if (initialZoneSelected.indexOf(row) > -1) {
            return false;
        } else {
            return true;
        }
    }

    const checkTrue =(row) =>{
        if (initialZoneSelected.indexOf(row) > -1) {
            return false;
        } else {
            return true;
        }
    }
    return (
        <Box sx={{ flexGrow: 1 }}>
            <Grid container spacing={{ xs: 2, md: 3 }} columns={{ xs: 4, sm: 8, md: 12 }}>
                {zone.map(row => (
                    <Grid item xs={2} sm={4} md={4} key={row}
                          className={ initialZoneSelected.indexOf(row) > -1
                            ? "reserved"
                            : initialZoneSelected.indexOf(row) > -1
                                ? "selected"
                                : "available"
                    }  onClick={
                        checkTrue(row)
                            ? e => onClickSeat(row)
                            : null
                    }>
                        <Item>{row}</Item>
                    </Grid>
                ))}
            </Grid>
        </Box>
    );
}
