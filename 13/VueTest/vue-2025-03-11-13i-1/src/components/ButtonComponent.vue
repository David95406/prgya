<script setup>
import { defineEmits } from "vue";

const emit = defineEmits(["click"]);
const handleClick = () => {
    emit("click");
}
</script>

<template>
    <p><button @click="handleClick">Click me!</button></p>
</template>
