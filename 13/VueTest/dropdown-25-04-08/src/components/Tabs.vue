<!--
Alapértelmezett fül a főoldal
Fülváltásra a megfelelő tartalom jelenik meg
-->
<template>
    <div>
      <button @click="active = 'home'">Főoldal</button>
      <button @click="active = 'about'">Rólunk</button>
      <div v-if="active === 'home'">Üdv a főoldalon!</div>
      <div v-else-if="active === 'about'">Rólunk oldal tartalma</div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  
  const active = ref('home')
  </script>
  