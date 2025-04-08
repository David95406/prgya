<!--
Teszteld le: 
Alapértelmezetten nincs kiválasztva semmi
Választás után a kiválasztott megjelenik
-->
<template>
    <select v-model="selected">
      <option disabled value="">Válassz egyet</option>
      <option>Alma</option>
      <option>Banán</option>
      <option>Cseresznye</option>
    </select>
    <p v-if="selected">Kiválasztott: {{ selected }}</p>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  
  const selected = ref('')
  </script>
