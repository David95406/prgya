<script setup>
import Navbar from './components/Navbar.vue';
</script>

<template>
  <header>
    <h1 class="text-center">Random kutyképek</h1>
    <Navbar />
  </header>
  <main class="p-4">
    <router-view></router-view>
  </main>
  <footer class="pt-5">
    <p class="text-center">Minden jog fenntartva!</p>
  </footer>
</template>

<style scoped>
  
</style>