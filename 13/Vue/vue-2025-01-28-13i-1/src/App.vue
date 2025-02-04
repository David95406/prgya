<script setup>
import {screenings} from "./state/state.js";
import {screeningsData} from "./data/screenings.js";
import {roomsData} from "./data/rooms.js";
import Screening from "./classes/Screening.js";

const movieState = screenings();
if(movieState.getScreeningsLength() == 0){
  for (let i = 0; i < screeningsData.length; i++) {
    const roomSeats = roomsData.find(room => room.id === screeningsData[i].roomId);
    //Tömb másolás
    const copyRoomSeats = roomSeats.seats.map(row => [...row]);
    var s = new Screening(screeningsData[i].movieId, screeningsData[i].roomId, screeningsData[i].time, copyRoomSeats);
    movieState.addMovie(s);
  }
}

</script>

<template>
  <header class="center">
    <p><router-link to="/"><img src="./assets/logo.jpg" alt="Cinema"></router-link></p>
  </header>
  <main>
    <router-view />
  </main>
  <footer class="center">
    <p>Copyright - All rights reserved!</p>
  </footer>
</template>

<style scoped>

</style>
