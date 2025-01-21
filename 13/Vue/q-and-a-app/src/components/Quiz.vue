<script setup>
import { ref } from 'vue';
import { questionState } from '../state/state';

const emit = defineEmits(['startSum'])
const qaState = questionState()

const answer = ref("")
const progress = ref(1)
const hasBeenShown = ref([])
const questions = ref([])
const index = ref(0)

questions.value = qaState.getQuestions()
const generateQuestions = (() => {
    if (hasBeenShown.value.length < qaState.getQuestionsLength()) {
        do {
            index.value = Math.floor(Math.random() * qaState.getQuestionsLength())
        } while (hasBeenShown.value.includes(index.value))
        hasBeenShown.value.push(index.value)
    } else {
        index.value = -1
        qaState.setQuestionsIndexes(hasBeenShown.value)
        emit("startSum")
    }

})

generateQuestions()
const next = (() => {
    qaState.addUserAnswer(answer.value)
    answer.value = ""
    progress.value++
    generateQuestions()
})
</script>

<template>
    <section>
        <h2>Question {{ progress }}/{{ qaState.getQuestionsLength() }}</h2>
        <p>
            <label>Question: {{ questions[index].getQuestion() }}</label>
        </p>
        <p>
            <label>Answer: </label>
            <input v-model="answer" type="text">
        </p>
        <p>
            <button @click="next">Next</button>
        </p>
    </section>
</template>

<style scoped></style>