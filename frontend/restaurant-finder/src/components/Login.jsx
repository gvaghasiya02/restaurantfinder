import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import RestaurantIcon from "@mui/icons-material/Restaurant";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

const defaultTheme = createTheme();

const Login = () => {
  const navigate = useNavigate();

  // useEffect(() => {
  //   let authorization = localStorage.getItem("token");
  //   if (!authorization) {
  //     // navigate("/login");
  //   } else {
  //     navigate("/home");
  //   }
  // }, [navigate]);

  const handleSubmit = async (event) => {
    // event.preventDefault();
    // const formData = new FormData(event.currentTarget);
    // const email = formData.get("email");
    // const password = formData.get("password");
    // try {
    //   const response = await axios.post(
    //     "http://localhost:3000/api/users/login",
    //     { email, password }
    //   );
    //   const token = "JWT " + response.data.token;
    //   // Store the JWT token securely (e.g., in local storage)
    //   localStorage.setItem("token", token);
    //   navigate("/home");
    //   // Redirect or perform other actions as needed after successful login
    // } catch (error) {
    //   console.error("Login failed:", error);
    //   // Handle login error
    // }
  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <div
        style={{
          backgroundImage:
            'url("https://source.unsplash.com/1600x900/?restaurant,restaurant")',
          backgroundSize: "cover",
          backgroundPosition: "center",
          height: "100vh",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Container component="main" maxWidth="xs">
          <CssBaseline />
          <Box
            sx={{
              marginTop: 8,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              backgroundColor: "rgba(255, 255, 255, 0.8)",
              padding: 3,
              borderRadius: 2,
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
              <RestaurantIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Restaurant Finder
            </Typography>
            <Box
              component="form"
              onSubmit={handleSubmit}
              noValidate
              sx={{ mt: 1 }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                autoFocus
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Login
              </Button>
              <Grid container>
                <Grid item xs></Grid>
                <Grid item>
                  <Link href="/signup" variant="body2">
                    {"Don't have an account? Sign Up"}
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Container>
      </div>
    </ThemeProvider>
  );
};

export default Login;
