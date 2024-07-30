import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import $ from 'jquery';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {useState} from "react";

function Copyright(props) {
    return (
        <Typography variant="body2" color="text.secondary" align="center" {...props}>
            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/">
                My Smart Home
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

export default function SignUp() {


    const [state, setState] = useState({
        age: 0,
        gender: '?',
        firstName: '?',
        lastName: '?',
        country: 'RUSSIA',
        city: 'Moscow',
        street: '?',
        phone:'?',
        email:'?',
        password:'',
    })

    const handleChange = (event) => {
        const name = event.target.name;
        setState({
            ...state,
            [name]: event.target.value,
        });
    };

    function sendAccount(firstName, lastName, password, age, phone, email, gender) {
        $.ajax({
            url: "api/signUp",
            method:"POST",
            data:{
                password: password,
                firstName: firstName,
                lastName: lastName,
                gender: gender,
                age: age,
                phone: phone,
                email: email,
            },
            async:false,
            success:function (res){
                if(res.success){
                    alert('Account add success')
                }else {
                    //dispatch(clearAccount());
                    alert(res.message);
                }
            }
        });
    }

    return (
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <Box
                sx={{
                    marginTop: 8,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                }}
            >
                <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
                    <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                    Sign up
                </Typography>
                <Box component="form" noValidate sx={{ mt: 3 }}>
                    <Grid container spacing={2}>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                autoComplete="fname"
                                name="firstName"
                                required
                                fullWidth
                                id="firstName"
                                label="First Name"
                                autoFocus
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={12} sm={6}>
                            <TextField
                                required
                                fullWidth
                                id="lastName"
                                label="Last Name"
                                name="lastName"
                                autoComplete="lname"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                required
                                fullWidth
                                id="email"
                                label="Email Address"
                                name="email"
                                autoComplete="email"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                required
                                fullWidth
                                id="phone"
                                label="Phone Number"
                                name="phone"
                                autoComplete="phone"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                autoComplete="new-password"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                required
                                fullWidth
                                name="age"
                                label="Age"
                                id="age"
                                autoComplete="age"
                                onChange={handleChange}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <FormControl fullWidth>
                                <InputLabel id="genderLabel">Gender</InputLabel>
                                <Select
                                    native
                                    value={state.gender}
                                    inputProps={{
                                        name: 'gender',
                                        id: 'gender-native-simple',
                                    }}
                                    labelId="genderLabel"
                                    id="gedner"
                                    label="Gender"
                                    onChange={handleChange}
                                >
                                    <option value="MALE">Male</option>
                                    <option value="FEMALE">Female</option>
                                </Select>
                            </FormControl>
                        </Grid>

                    </Grid>
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        sx={{ mt: 3, mb: 2 }}
                        onClick={() => {
                            alert(state.firstName + " " + state.lastName + "\n" + state.password + "\n" + state.age + "\n" + state.email + "\n" + state.phone + "\n" + state.gender)
                            sendAccount(state.firstName,state.lastName,state.password,state.age,state.phone,state.email,state.gender)}
                        }
                    >
                        Sign Up
                    </Button>
                    <Button
                        type="submit"
                        href="/"
                        fullWidth
                        variant="outlined"
                        sx={{ mt: 0, mb: 2 }}
                    >
                        Back
                    </Button>
                </Box>
            </Box>
            <Copyright sx={{ mt: 5 }} />
        </Container>
    );
}