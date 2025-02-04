<script setup>

import { defineProps, defineEmits, ref, watchEffect, } from 'vue';
import Todo from "../classes/Todo"
import { useTodoState } from '../state/state.js';

const props = defineProps({
    visible: Boolean,
    isEdit: Boolean
});

const todoState = useTodoState()

const nameInput = ref("")
const dateInput = ref("")

watchEffect(() => {
    if (todoState.getEdited()) {
        const editedTodo = todoState.getEdited()
        nameInput.value = editedTodo.getName()
        dateInput.value = editedTodo.getDate()
    }
})

const emits = defineEmits(['close']);
const close = () => {
    nameInput.value = ""
    dateInput.value = ""
    emits('close');
}
const add = () => {
    if (todoState.getTodos().find((todo) => {
        return todo.getName() == nameInput.value
    })) {
        alert("ez a todo mar letezik!")
    } else {
        todoState.addTodo(new Todo(nameInput.value, dateInput.value, false))
        close();
    }
}

const edit = (() => {
    todoState.saveEdited(new Todo(nameInput.value, dateInput.value, false))
    close()
})



</script>
<template>
    <div class="modal" v-if="visible">
        <h2 v-if="isEdit">Edit todo</h2>
        <h2 v-else>Add todo</h2>
        <p>
            <label>Name:</label>
            <input type="text" v-model="nameInput">
        </p>
        <p>
            <input type="date" v-model="dateInput">
        </p>
        <p class="buttons">
            <button @click="close">Cancel</button>
            <button v-if="isEdit" @click="edit">Edit</button>
            <button v-else @click="add">Add</button>
        </p>
    </div>
</template>

<style scoped>
h2 {
    margin: 0;
    padding: 0;
    border-bottom: 1px solid #aaa;
    padding-bottom: 10px;
    text-align: center;
}

.modal {
    width: 300px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #efefef;
    padding: 20px 30px;
    margin: 0px auto;
    color: #000;
}

label {
    font-weight: 700;
    display: block;
}

select {
    width: 100% !important;
}

input,
select {
    width: calc(100% - 20px);
    padding: 7px 10px;
    display: block;
    border: none;
}

.buttons {
    text-align: center;
}

.buttons button {
    border: none;
    padding: 10px 20px;
    font-weight: 700;
    color: #fff;
    border-radius: 10px;
    margin: 0px 10px;
}

.buttons button:hover {
    background-color: aqua;
}

.buttons button:first-of-type {
    background-color: red;
}

.buttons button:last-of-type {
    background-color: green;
}
</style>