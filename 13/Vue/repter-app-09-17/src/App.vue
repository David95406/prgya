<script setup>
import Repter from './components/Repter.vue'
</script>

<template>
  <main>
    <h1>Airport App!</h1>
    <img src="./assets/airport-logo.avif" alt="">
    <Repter />
  </main>
</template>

<style scoped>
main {
  text-align: center;
}

img {
  width: 25%;
  height: 25%;
}

h1 {
  color: lime;
}
</style>
