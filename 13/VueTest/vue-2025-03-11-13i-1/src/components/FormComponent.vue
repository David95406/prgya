<script setup>
import { ref,defineEmits } from 'vue';

const inputValue = ref("");
const emit = defineEmits(["submit", "reset"]);

const handleSubmit = () =>{
    emit("submit", inputValue.value);
}

const handleReset = () =>{
    inputValue.value = "";
    emit("reset");
}
</script>

<template>
    <form>
        <input type="text" v-model="inputValue">
        <button type="submit" @click.prevent="handleSubmit">Submit</button>
        <button type="reset" @click="handleReset">Reset</button>
    </form>
</template>