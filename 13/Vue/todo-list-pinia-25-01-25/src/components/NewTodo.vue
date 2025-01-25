<script setup>
import {ref} from 'vue'
import Todo from '../classes/Todo'
import { useTodoState } from '../state/state'

const emit = defineEmits(['onsuccess'])
const todoState = useTodoState()

const name = ref("")
const description = ref("")
const date = ref("")
const status = ref(false)
const addNewTodo = () => {
    const newTodo = new Todo(name.value, description.value, date.value, status.value)
    todoState.addTodo(newTodo)
    emit('onsuccess')
}
</script>
<template>
    <section>
        <form>
            <input v-model="name" type="text" placeholder="Name: " />
            <input v-model="description" type="text" placeholder="Description: " />
            <input v-model="date" type="datetime-local" placeholder="Date: " />
            <select v-model="status">
                <option value="false">Pending</option>
                <option value="true">Completed</option>
            </select>
            <button type="submit" @click.prevent="addNewTodo">Add</button>
        </form>
    </section>
</template>

<style scoped>
section {
    margin: 30px 0 0 30px;
    padding: 0;
    display: flex;
    justify-content: space-between;
}

header p {
    font-size: 24px;
    color: #ccc;
    margin: 0 30px 0 0;
    padding: 0;
    cursor: pointer;
}

h1 {
    margin: 0;
}
</style>