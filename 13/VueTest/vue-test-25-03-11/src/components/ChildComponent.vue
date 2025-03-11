<script setup>

const emit = defineEmits(['greet'])

const props = defineProps({
    name: String
})

const sendGreeting = (() => {
    if (props.name != "") {
        const greeting = "Hello, " + props.name + " in VueWorld!"
        emit('greet', greeting)
    }
})
</script>

<template>
  <h2>Child</h2>
  <button @click="sendGreeting">Send message</button>
</template>

<style scoped>
  
</style>