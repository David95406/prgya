<script setup>
const emit = defineEmits(['onClick'])

const handleClick = (() => {
    emit("onClick")
})
</script>

<template>
    <button @click="handleClick">
        Click me!
    </button>
</template>

<style scoped></style>