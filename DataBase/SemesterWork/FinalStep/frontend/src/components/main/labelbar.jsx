import * as React from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import ListSubheader from '@mui/material/ListSubheader';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import HouseIcon from '@mui/icons-material/House';
import ReportIcon from '@mui/icons-material/Report';
import BarChartIcon from '@mui/icons-material/BarChart';
import Diversity1Icon from '@mui/icons-material/Diversity1';
import AssignmentIcon from '@mui/icons-material/Assignment';
import {AccountCircle} from "@mui/icons-material";

export const mainListItems = (
    <React.Fragment>
        <ListItemButton>
            <ListItemIcon>
                <AccountCircleIcon />
            </ListItemIcon>
            <ListItemText primary="My Profile" />
        </ListItemButton>
        <ListItemButton>
            <ListItemIcon>
                <Diversity1Icon />
            </ListItemIcon>
            <ListItemText primary="My Family" />
        </ListItemButton>
        <ListItemButton>
            <ListItemIcon>
                <HouseIcon />
            </ListItemIcon>
            <ListItemText primary="My Houses" />
        </ListItemButton>
        <ListItemButton>
            <ListItemIcon>
                <ReportIcon />
            </ListItemIcon>
            <ListItemText primary="My Issues" />
        </ListItemButton>
    </React.Fragment>
);

export const secondaryListItems = (
    <React.Fragment>
        <ListSubheader component="div" inset>

        </ListSubheader>
        <ListItemButton href="/">
            <ListItemIcon>
                <AssignmentIcon />
            </ListItemIcon>
            <ListItemText primary="Sign out" />
        </ListItemButton>
    </React.Fragment>
);