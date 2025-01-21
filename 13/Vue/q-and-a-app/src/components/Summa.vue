<script setup>
import { ref } from 'vue';
import { questionState } from '../state/state';
import Question from '../classes/Question';

const emit = defineEmits(['reset'])
const qaState = questionState()

const questions = ref(qaState.getQuestions())
const userAnswers = ref(qaState.getUserAnswers())
const indexes = ref(qaState.getQuestionsIndexes())
const ok = ref(0)

const check = ((id, isGood) => {
    //document.getElementById(id).style.display = "none"
    //document.querySelector("#"+prefeix+index).remove()
    document.getElementById(id).remove()

    if (isGood) ok.value++

})

const reset = (() => {
    qaState.clearState() //ez nem jo
    emit("reset")
})

</script>

<template>
    <section>
        <h2>Summa</h2>
        <p v-for="(index, i) in indexes" class="df">
            <span>
                <label>Kérdés: {{ questions[index].getQuestion() }}</label>
                <label class="answer">Helyes válasz: {{ questions[index].getAnswer() }}</label>
                <label class="userAnswer">Adott válasz: {{ userAnswers[index] }}</label>
            </span>
            <span class="buttons" :id="i">
                <button @click="check(i, true)">Jó</button>
                <button @click="check(i, false)">Nem jó</button>
            </span>
        </p>
        <h3>
            <p>{{ ok }}/{{ qaState.getQuestionsLength() }}</p>
        </h3>
        <button @click="reset">Reset</button>
    </section>
</template>

<style scoped>
h3 {
    font-size: 40px;
    padding: 0;
    margin: 0;
    text-align: center;
}

.buttons {
    width: calc(100% - 190px);
}

.df {
    display: flex;
}

p {
    text-align: center;
    padding-bottom: 10px;
    border-bottom: 1px solid white;
}

p:last-of-type {
    border: none;
}

.answer,
.userAnswer {
    text-transform: none;
}

.answer {
    color: greenyellow;
}

.userAnswer {
    color: cyan;
}
</style>