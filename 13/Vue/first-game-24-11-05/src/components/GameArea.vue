<script setup>
import Fruit from '../classes/Fruit';
import { ref, watch, defineProps, defineEmits } from 'vue';

const props = defineProps({
    isGame: Boolean
})

const emits = defineEmits(['updateScore'])

var fruitInterval = null
watch(() => props.isGame, (newValue, oldValue) => {
    if (newValue && fruitInterval == null) {
        var gameArea = document.querySelector(".game-area")
        fruitInterval = setInterval(() => {
            const x = Math.random() * (gameArea.offsetWidth - 30)
            const fruit = new Fruit(x, 0, 1 + Math.random() * 2, ".game-area", collectFruit)
            fruit.fall()
        }, 800)
    }

    if (!newValue) {
        stopGame()
    }
})

const stopGame = (() => {
    clearInterval(fruitInterval)
    fruitInterval = null
    document.querySelectorAll("apple").forEach((apple) => {apple.remove()})
    document.querySelectorAll("banana").forEach((banana) => {banana.remove()})
})

const collectFruit = ((pont) => {
    emits('updateScore', pont)
})
</script>

<template>
    <section class="game-area">

    </section>
</template>

<style scoped>
.game-area {
    background-color: #add8e6;
    border: 2px solid #D6322F;
    width: 400px;
    height: 500px;
    margin: 30px auto;
    position: relative;
    overflow: hidden;
}
</style>