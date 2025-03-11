<script setup>
import { computed, ref } from 'vue';
import ChildComponent from './ChildComponent.vue';

const name = ref("")
const response = ref("")

const handleGreet = (message) => {
    response.value = message
}
</script>

<template>
    <h2>Parent</h2>
    <input type="text" v-model="name">
    <ChildComponent :name="name" @greet="handleGreet" />
    <p>{{ response }}</p>
</template>

<style scoped></style>