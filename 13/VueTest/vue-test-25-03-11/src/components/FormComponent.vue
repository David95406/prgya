<script setup>
import { ref } from 'vue';

const emit = defineEmits(['submitForm', 'reset'])

const inputValue = ref("")
const submitForm = () => {
    emit('submitForm', inputValue.value)
}

const resetForm = () => {
    inputValue.value = ""
    emit('reset')
}
</script>

<template>
  <form @submit.prevent="submitForm">
    <input v-model="inputValue" type="text">

    <button type="button" id="resetButton" @click="resetForm">Reset</button>
    <button type="submit" id="submitButton">Submit</button>
  </form>
</template>

<style scoped>
  
</style>