<!--
Teszteled le:
Gomb új idézetet generál (nem mindig változik, de változhat)
A szöveg szerepel a megadott tömbben
-->
<template>
    <div>
      <p>{{ quote }}</p>
      <button @click="newQuote">Új idézet</button>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  
  const quotes = [
    "Az élet szép.",
    "Tanulni jó.",
    "A Vue fantasztikus!"
  ]
  
  const quote = ref(quotes[0])
  
  function newQuote() {
    quote.value = quotes[Math.floor(Math.random() * quotes.length)]
  }
  </script>
  
  