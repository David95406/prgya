<script setup>
import { ref } from 'vue';

const searchQuery = ref("")

const resetField = () => {
    searchQuery.value = ''
}

</script>

<template>
    <input type="text" v-model="searchQuery">
    <button @click="resetField">Reset</button>
</template>

<style>
    
</style>