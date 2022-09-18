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
import ZoneGrid from "../components/FloorMap/ZoneGrid";

// ----------------------------------------------------------------------

export default function AllocateSpace() {
    const theme = useTheme();

    return (
        <Page title="Allocate Space">
            <Container maxWidth="xl">
                <Typography variant="h4" sx={{ mb: 5 }}>
                   Allocate Space
                </Typography>
                <Grid container spacing={4}>
                    <Grid item xs={10} md={10} lg={12}>
                        <ZoneGrid />
                    </Grid>
                </Grid>
            </Container>
        </Page>
    );
}
