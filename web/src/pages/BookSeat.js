import React, {useEffect, useState} from "react";
import { faker } from '@faker-js/faker';
// @mui
import { useTheme } from '@mui/material/styles';
import { Grid, Container, Typography } from '@mui/material';
// components
import Page from '../components/Page';
import Iconify from '../components/Iconify';
// sections
import {
  AppTasks,
  AppNewsUpdate,
  AppOrderTimeline,
  AppCurrentVisits,
  AppWebsiteVisits,
  AppTrafficBySite,
  AppWidgetSummary,
  AppCurrentSubject,
  AppConversionRates,
} from '../sections/@dashboard/app';
import SeatGrid from "../components/FloorMap/SeatGrid";
import Api from "../api/Api";

// ----------------------------------------------------------------------

export default function BookSeat() {

    const [seats, setSeats] = useState({});
    useEffect(()=>{
        Api.axiosGetApi('/employee/10/availableSpaces')
            .then((response) => {
                console.log("response===",response)
                setSeats({...seats,...response.data})
            }).catch(() => {
        })
    },[]);

  return (
      <Page title="Book Seat">
        <Container maxWidth="xl">
          <Typography variant="h4" sx={{ mb: 5 }}>
              Book Seat
          </Typography>

          <Grid container spacing={3}>
            <Grid item xs={12} md={6} lg={12}>
                <SeatGrid seats={seats} />
            </Grid>
          </Grid>
        </Container>
      </Page>
  );
}
