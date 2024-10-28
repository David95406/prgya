<script setup>
import { ref, defineProps, defineEmits } from 'vue';

const userAnswer = ref("")

const changeUserAnswer = ((option) => {
    userAnswer.value = option
})

const props = defineProps({
    quiz: Object
})

const emit = defineEmits(
    ['answer']
)

const emitAnswer = (() => {
    emit('answer', userAnswer.value)
    userAnswer.value = ""
})
</script>

<template>
    <section>
        <h3>{{ props.quiz["question"] }}</h3>
        <div class="wrapper">
            <div v-for="option in props.quiz['options']" class="answers">
                <button @click="changeUserAnswer(option)" :class="userAnswer == option ? 'selected' : ''">{{ option}}</button>
            </div>
        </div>
        <button v-if="userAnswer" @click="emitAnswer" class="next-button">Tovább</button>
    </section>
</template>

<style scoped>
h3 {
    text-align: center;
}

.wrapper {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 15px;
    margin: 0 auto;
    max-width: 700px;
}

.answers {
    flex: 0 0 50%;
    max-width: 200px;
}

button {
    margin: 10px;
    padding: 10px;
    width: 100%;
}

.next-button {
    display: flex;
    justify-content: center;
    margin: 20px 0;
    font-weight: bold;
}

.selected {
    color: black;
    background-color: white;
}
</style>