<script setup>
import { defineEmits, defineProps } from 'vue'

const emit = defineEmits(
    ['add']
)

const add = ((grade) => {
    emit('add', grade)
})
</script>

<template>
    <div>
        <h1>Új jegy hozzáadása</h1>
        <button @click="add(1)">1</button>
        <button @click="add(2)">2</button>
        <button @click="add(3)">3</button>
        <button @click="add(4)">4</button>
        <button @click="add(5)">5</button>
    </div>
</template>

<style scoped>
    
</style>