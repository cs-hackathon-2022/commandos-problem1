import React from "react";
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

// ----------------------------------------------------------------------
const seats = {
    seatsReserved:[{id:1,name:"Seat A"}, {id:2,name:"Seat B"}, {id:3,name:"Seat C"}],
    seatsAvailable:[{id:4,name:"Seat D"}, {id:5,name:"Seat E"}, {id:6,name:"Seat F"}]
}

export default function BookSeat() {
  const theme = useTheme();

  return (
      <Page title="Book Seat">
        <Container maxWidth="xl">
          <Typography variant="h4" sx={{ mb: 5 }}>
           Request Space
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
