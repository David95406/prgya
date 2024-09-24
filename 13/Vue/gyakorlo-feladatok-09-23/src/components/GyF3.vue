<script setup>
/**
Készíts egy komponenst, amely egy listát jelenít meg egy tömb elemeiből! Adj
hozzá egy gombot, amely egy új elemet ad hozzá a listához!
 */

import { ref } from 'vue'

const userArray = ref([])
const newItem = ref("")

const addToArray = () => {
    userArray.value.push(newItem.value)
}

</script>

<template>
    <form>
        <input type="text" v-model="newItem" placeholder="Hozzáadás a listához...">
        <button v-if="newItem.length != 0" type="button" @click="addToArray">Mentés</button>
    </form>
    <div>
        <ul>
            <li v-for="userText in userArray">{{ userText }}</li>
        </ul>
    </div>
</template>

<style scoped>
form {
    padding: 20px;
}

input,
button,
li {
    padding: 10px;
    margin: 5px;
    border: 2px solid black;
    border-radius: 5px;
    font-size: 16px;
}

input {
    width: 200px;
}

button {
    color: white;
    cursor: pointer;
    background-color: black;
}

ul {
    list-style-type: none;
}

li {
    font-size: 20px;
    font-weight: bold;
    border: 2px, solid, white;
    border-radius: 5px;
}
</style>