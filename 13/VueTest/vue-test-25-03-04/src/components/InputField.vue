<script setup>
import { ref } from 'vue';

const message = ref("")
const showMessage = ref("")


const sendMessage = (() => {
    showMessage.value = message.value
    message.value = ""

})
</script>

<template>
    <form @submit.prevent="sendMessage">
        <input id="messageInput" type="text" v-model="message">
        <button id="submitBtn" type="submit">Send</button>
        <p id="showMessage">{{ showMessage }}</p>
    </form>
</template>

<style scoped>
form {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 10px;
}

input {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 200px;
}

button {
    padding: 8px 16px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

p {
    margin-top: 10px;
    font-size: 16px;
    color: white;
}
</style>