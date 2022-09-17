import { Avatar, Box, Card, CardContent, Grid, Typography } from '@mui/material';
import ArrowUpwardIcon from '@mui/icons-material/ArrowUpward';
import PeopleIcon from '@mui/icons-material/PeopleOutlined';
import Button from "@mui/material/Button";
import * as React from "react";

export const Team = (props) => (
    <Card {...props}>
        <CardContent>
            <Grid
                container
                spacing={3}
                sx={{ justifyContent: 'space-between' }}
            >
                <Grid item>
                    <Typography
                        color="textSecondary"
                        gutterBottom
                        variant="overline"
                    >
                        TOTAL SEATS BOOKED
                    </Typography>
                    <Typography
                        color="textPrimary"
                        variant="h4"
                    >
                        100
                    </Typography>
                </Grid>
                <Button
                    color="textPrimary"
                    variant="h4"
                    onClick={()=>{console.log("on button click")}}>
                    Create Team
                </Button>
                <Grid item>
                    <Avatar
                        sx={{
                            backgroundColor: 'success.main',
                            height: 56,
                            width: 56
                        }}
                    >
                        <PeopleIcon />
                    </Avatar>
                </Grid>
            </Grid>
            <Box
                sx={{
                    alignItems: 'center',
                    display: 'flex',
                    pt: 2
                }}
            >
                <ArrowUpwardIcon color="success" />
                <Typography
                    variant="body2"
                    sx={{
                        mr: 1
                    }}
                >
                    16%
                </Typography>
                <Typography
                    color="textSecondary"
                    variant="caption"
                >
                    Since last month
                </Typography>
            </Box>
        </CardContent>
    </Card>
);