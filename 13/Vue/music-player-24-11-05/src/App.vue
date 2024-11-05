<script setup>
import Player from './components/Player.vue';
import Playlist from './components/Playlist.vue';
import { ref } from 'vue';

const currentTrack = ref(null)
const changeTrack = ((track) => {
  currentTrack.value = track
})

</script>

<template>
  <header>
    <h1>Zenelejátszó</h1>
  </header>
  <main>
    <Playlist @changeTrack="changeTrack"/>
    <Player :track="currentTrack"/>
  </main>
  <footer>
    <hr>
    <p>&copy;Copyright</p>
  </footer>
</template>

<style scoped>

</style>
