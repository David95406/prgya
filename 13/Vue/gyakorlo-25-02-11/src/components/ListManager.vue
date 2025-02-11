<script setup>
import { ref } from 'vue';

const numbers = ref([])

for (let i = 1; i < 11; i++) {
    numbers.value.push(i)
}
</script>

<template>
  <div>
    <button>Toggle list</button>
    <button>Push number</button>
    <button>Pop number</button>
    <button>Reverse list</button>
  </div>
  <ul>
    <li v-for="number in numbers">{{ number }}</li>
  </ul>
</template>

<style scoped>
  
</style>