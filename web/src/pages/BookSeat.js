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
import SeatBooking from "../components/FloorMap/SeatBooking";

// ----------------------------------------------------------------------

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
                <SeatBooking />
            </Grid>
          </Grid>
        </Container>
      </Page>
  );
}
