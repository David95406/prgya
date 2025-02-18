<script setup>
import { computed, ref } from 'vue';

const numbers = ref([])

for (let i = 1; i < 11; i++) {
    numbers.value.push(i)
}

const numbersToShow = ref(3)
const showList = ref(true)

const sortedNumbers = computed(() => {
  return numbers.value.slice(0, numbersToShow.value)
})

const handleToggleList = () => {
  showList.value = !showList.value
}

const handlePushNumber = () => {
  if (numbersToShow.value < numbers.value.length) {
    numbersToShow.value++
  }
}

const handlePopNumber = () => {
  if (numbersToShow.value > 0) {
    numbersToShow.value--
  }
}

const handleReverseList = () => {
  numbers.value.reverse()
}
</script>

<template>
  <div>
    <button @click="handleToggleList">Toggle list</button>
    <button @click="handlePushNumber">Push number</button>
    <button @click="handlePopNumber">Pop number</button>
    <button @click="handleReverseList">Reverse list</button>
  </div>
  <ul v-if="showList">
    <li v-for="number in sortedNumbers" :key="number">{{ number }}</li>
  </ul>
</template>

<style scoped>
  
</style>