<script setup>
import { ref } from "vue"

const password = ref("")
const showPassword = ref(false)


</script>

<template>
    <input v-model="password" :type="[showPassword? 'text': 'password' ]">
    <input v-model="showPassword" type="checkbox" id="showPassword">
</template>

<style>

</style>