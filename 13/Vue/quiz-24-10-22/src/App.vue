<script setup>
import Quiz from './components/Quiz.vue';
import { ref } from 'vue';
import { quizData } from "./data/quizData"

const progress = ref(0)
const correctAnswer = ref(0)
const max = quizData.length


const handleAnswer = ((answer) => {
  if (answer == quizData[progress.value]["correctAnswer"]) {
    correctAnswer.value++
  }
  progress.value++
})

const resetQuiz = (() => {
  progress.value = 0
  correctAnswer.value = 0
})

</script>

<template>
  <header>
    <h1>Quiz</h1>
  </header>
  <main>
    <section v-if="progress < max">
      <h2>Kérdés {{ progress + 1 }}/{{ max }}</h2>
      <Quiz :quiz="quizData[progress]" @answer="handleAnswer" />
    </section>

    <section v-else class="quiz-end">
      <h2>Quiz vége!</h2>
      <h2>Helyes válaszok: {{ correctAnswer }}/{{ max }}</h2>
      <button @click="resetQuiz">Újraindítás</button>
    </section>
  </main>
  <footer>
    <span>&#169; Quiz App</span>
  </footer>
</template>

<style scoped>
header,
footer,
.quiz-end {
  text-align: center;
}

footer {
  position: absolute;
  bottom: 0;
  height: 2.5rem;
}

</style>
