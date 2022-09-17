import React from 'react';
import Head from 'next/head';
import { Box, Container, Grid, Button } from '@mui/material';
import  {SeatView} from './seat-view';
import {Request} from './request';
import {Team} from './team';
import { DashboardLayout } from './dashboard-layout';
import {TrafficByDevice} from "./trraffic-by-device";
import { Link, Route, Switch } from "react-router-dom";
import ArrowRightIcon from "@mui/icons-material/ArrowRight";
import FormDialog from '../modal/modal';

const Dashboard = () => {
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    return (
        <>
            {open ? <FormDialog handleClose={handleClose}/>: null }
            <Head>
                <title>
                    Dashboard | Material Kit
                </title>
            </Head>
            <Box
                component="main"
                sx={{
                    flexGrow: 1,
                    py: 8
                }}

            >
                <div style={{marginLeft: 800}}>
                    <Button color="primary"
                            endIcon={<ArrowRightIcon fontSize="small"/>}
                            size="small">
                        <Link to="/signin">Sign In</Link>
                    </Button>
                    <Button color="primary"
                            endIcon={<ArrowRightIcon fontSize="small"/>}
                            size="small">
                        <Link to="/signup">Sign Up</Link>
                    </Button>
                </div>
                <Container maxWidth={false}>
                    <Grid
                        container
                        spacing={3}
                    >
                        <Grid
                            item
                            xl={3}
                            lg={3}
                            sm={6}
                            xs={12}
                        >

                            <Request handleClickOpen={handleClickOpen}/>
                        </Grid>
                        <Grid
                            item
                            xl={3}
                            lg={3}
                            sm={6}
                            xs={12}
                        >
                            <Team />
                        </Grid>
                        <Grid
                            item
                            xl={3}
                            lg={3}
                            sm={6}
                            xs={12}
                        >
                            <Team/>

                        </Grid>
                    </Grid>
                    <div style={{marginTop: 20}}>
                        <Grid
                            container
                            spacing={2}
                        >
                            <Grid
                                item
                                lg={6}
                                sm={6}
                                xl={3}
                                xs={12}
                            >
                                <SeatView/>

                            </Grid>
                            <Grid
                                item
                                lg={3}
                                sm={6}
                                xl={3}
                                xs={12}
                            >
                                <TrafficByDevice/>

                            </Grid>
                        </Grid>
                    </div>
                </Container>
            </Box>
        </>
    )
}
 const DashBoardPage = () => (
    <DashboardLayout>
        <Dashboard/>
    </DashboardLayout>
);

//export default  Dashboard;
 export default DashBoardPage;