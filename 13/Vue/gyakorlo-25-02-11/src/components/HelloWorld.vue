<script setup>
import { ref } from 'vue';

const text = ref("Hello World")

const reverse = (() => {
    let slitted = text.value.split("")
    let newSl = []
    slitted.forEach((char) => {
        newSl.unshift(char)
    })
    let returnValue = ""
    newSl.forEach((a) => returnValue += a)
    text.value = returnValue
})

const append = (() => {
    text.value += "!"
})
</script>

<template>
    <div>
        <h2>{{ text }}</h2>
        <button @click="reverse">Reverse text</button>
        <button @click="append">Append "!"</button>
    </div>
</template>

<style scoped>
  
</style>