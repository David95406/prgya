<script setup>
import { ref } from 'vue'

const initialNumbers = [1, 2, 3, 4, 5]
const numbers = ref([...initialNumbers])

const handleDeleteNumber = (index) => {
  numbers.value.splice(index, 1)
}

const handleInsertRandom = () => {
  const nextNumber = numbers.value.length + 1
  const randomIndex = Math.floor(Math.random() * (numbers.value.length + 1))
  numbers.value.splice(randomIndex, 0, nextNumber)
}

const handleReset = () => {
  numbers.value = [...initialNumbers]
}

const handleShuffle = () => {
  for (let i = numbers.value.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1))
    ;[numbers.value[i], numbers.value[j]] = [numbers.value[j], numbers.value[i]]
  }
}
</script>

<template>
  <div>
    <button @click="handleInsertRandom">Insert at random index</button>
    <button @click="handleReset">Reset</button>
    <button @click="handleShuffle">Shuffle</button>
  </div>
  <ul>
    <li v-for="(number, index) in numbers" :key="number">
      {{ number }} <button @click="handleDeleteNumber(index)">Delete</button>
    </li>
  </ul>
</template>

<style scoped>
  
</style>