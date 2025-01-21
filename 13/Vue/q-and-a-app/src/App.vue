<script setup>
import { ref } from 'vue';
import AddQuestion from './components/AddQuestion.vue';
import Quiz from './components/Quiz.vue';
import Summa from './components/Summa.vue';


const isQuiz = ref(false)
const isSumma = ref(false)

const startQuiz = (() => {
  isQuiz.value = true
})

const startSumma = (() => {
  isSumma.value = true
})

const reset = (() => {
  isQuiz.value = false
  isSumma.value = false
})
</script> 

<template>
  <header>
    <h1>Q&A App</h1>
  </header>
  <main>
    <div v-if="!isSumma">
      <AddQuestion v-if="!isQuiz" @startQuiz="startQuiz" />
      <Quiz v-else @startSum="startSumma" />
    </div>
    <div v-else>
      <Summa @reset="reset"/>
    </div>
  </main>
  <footer>
    <p>
      Copyright &copy; all rights reserved!
    </p>
  </footer>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}

.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
