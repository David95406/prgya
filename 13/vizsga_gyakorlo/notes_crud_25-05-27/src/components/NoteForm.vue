<script setup>
import { reactive } from 'vue';

const emit = defineEmits(['create', 'close'])

const form = reactive({
    content: ""
})

const createNote = () => {
    emit('create', form.content)
}

const close = () => emit('close')
</script>

<template>
  <form @submit.prevent="createNote">
    <input v-model="form.content" type="text" required>
    <button type="submit">Create</button>
    <button @click="close">Close</button>
  </form>
</template>

<style scoped>

</style>