<script setup>
import { movieDatas } from './data/movies';
import { roomsData } from './data/rooms';
import { screeningsData } from './data/screenings';
import { screenings } from './state/state';
import Screening from './classes/Screening';
import { ref } from 'vue';

const movieState = screenings()
if (movieState.getScreeningsLength() == 0) {
  screeningsData.forEach((sd) => {
    const roomSeats = roomsData.find((room) => room.id === sd.roomId);
    const copyOfRoomSeats = roomSeats.seats.map((seat) => [...seat]); // tomb masolas
    
    const s = new Screening(sd.id, sd.movieId, sd.time, copyOfRoomSeats)
    movieState.addMovie(s)
  })
  console.log(screeningsData)
}

</script>

<template>
  <header class="center">
    <p>
      <router-link to="/">
        <img src="./assets/logo.jpg">
      </router-link>
    </p>
  </header>
  <main>
    <router-view />
  </main>
  <footer class="center">
    <p>Copyright &copy; - All rights reserved!</p>
  </footer>
</template>

<style scoped>
body,
header,
p {
  margin: 0;
  padding: 0;
}

header,
footer {
  background-color: #FDCD00;

}

section {
  margin: 0px auto;
  width: 90%;
}

h2 {
  text-transform: uppercase;
  letter-spacing: 1px;
}

footer {
  padding: 10px 0px;
  margin-top: 30px;
  color: #000;
  font-weight: 700;
}

.center {
  text-align: center;
}
</style>
