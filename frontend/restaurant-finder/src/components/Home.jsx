import React, { useState } from "react";
import {
  Container,
  Grid,
  TextField,
  Card,
  CardContent,
  CardMedia,
  Typography,
  Box,
} from "@mui/material";

const Home = () => {
  const [searchQuery, setSearchQuery] = useState("");

  const handleSearchChange = (event) => {
    setSearchQuery(event.target.value);
  };

  const restaurants = [
    {
      name: "Restaurant 1",
      image: "https://source.unsplash.com/1600x900/?restaurant,restaurant",
      description: "This is a description of Restaurant 1.",
    },
    {
      name: "Restaurant 2",
      image: "https://source.unsplash.com/1600x900/?restaurant,restaurant",
      description: "This is a description of Restaurant 2.",
    },
    {
      name: "Restaurant 2",
      image: "https://source.unsplash.com/1600x900/?restaurant,restaurant",
      description: "This is a description of Restaurant 2.",
    },
    {
      name: "Restaurant 2",
      image: "https://source.unsplash.com/1600x900/?restaurant,restaurant",
      description: "This is a description of Restaurant 2.",
    },
    {
      name: "Restaurant 2",
      image: "https://via.placeholder.com/150",
      description: "This is a description of Restaurant 2.",
    },
    // Add more restaurant objects as needed
  ];

  return (
    <Container>
      <Box my>
        <TextField
          fullWidth
          variant="outlined"
          placeholder="Search..."
          value={searchQuery}
          onChange={handleSearchChange}
        />
      </Box>
      <Grid container spacing={2}>
        <Grid item xs={12} sm={4} md={3}>
          <Box p={2} border={1} borderColor="grey.300">
            {/* Add your filter components here */}
            <Typography variant="h6">Filters</Typography>
            {/* Example filter components */}
            <TextField fullWidth variant="outlined" label="Filter 1" />
            <TextField fullWidth variant="outlined" label="Filter 2" />
          </Box>
        </Grid>
        <Grid item xs={12} sm={8} md={9}>
          <Grid container spacing={2}>
            {restaurants
              .filter((restaurant) =>
                restaurant.name
                  .toLowerCase()
                  .includes(searchQuery.toLowerCase())
              )
              .map((restaurant, index) => (
                <Grid item xs={12} sm={6} md={4} key={index}>
                  <Card>
                    <CardMedia
                      component="img"
                      height="140"
                      image={restaurant.image}
                      alt={restaurant.name}
                    />
                    <CardContent>
                      <Typography gutterBottom variant="h5" component="div">
                        {restaurant.name}
                      </Typography>
                      <Typography variant="body2" color="text.secondary">
                        {restaurant.description}
                      </Typography>
                    </CardContent>
                  </Card>
                </Grid>
              ))}
          </Grid>
        </Grid>
      </Grid>
    </Container>
  );
};

export default Home;
