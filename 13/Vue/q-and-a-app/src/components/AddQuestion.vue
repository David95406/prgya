<script setup>
import { ref } from 'vue';
import Question from '../classes/Question';
import { questionState } from '../state/state';

//emits
const emit = defineEmits(['startQuiz'])

//state inicializalasa
const qaState = questionState()

const question = ref("")
const answer = ref("")

const add = (() => {
    const newQuestion = new Question(question.value, answer.value)

    qaState.addQuestion(newQuestion)
    alert("Sikeres hozzáadás")

    question.value = ""
    answer.value = ""
})

const start = () => {
    emit('startQuiz')
}
</script>

<template>
    <section>
        <h2>Add question</h2>
        <p>
            <label>Question:</label>
            <input v-model="question" type="text">
        </p>
        <p>
            <label>Answer: </label>
            <input v-model="answer" type="text">
        </p>
        <p>
            <button @click="add">Add</button>
            <button v-if="qaState.getQuestionsLength() > 0" @click="start">Start quiz</button>
        </p>
    </section>
</template>

<style scoped></style>