<script setup>
import { ref, watch, watchEffect } from "vue"
import { tasks } from "../assets/tasks";

const todoList = ref(tasks)
const todoInput = ref("")
const sortType = ref("all")

const addTask = (() => {
    todoList.value.push({
        "text": todoInput.value,
        "completed": false
    })

    todoInput.value = ""
})

const deleteItem = ((index) => {
    if (confirm("Bizti?")) {
        todoList.value.splice(index, 1)
    }
})

const getStatus = ((task) => {
    if (sortType.value == "all") {
        return true
    } else if (sortType.value == "completed" && task["completed"]) {
        return true
    } else if (sortType.value == "notcompleted" && !task["completed"]) {
        return true
    } else {
        return false
    }
})

</script>

<template>
    <form @submit.prevent="addTask">
        <label for="todoInput">Teendo neve:</label><br>
        <input type="text" name="todoInput" v-model="todoInput"><br>
        <button type="submit">Hozzáadás</button>
    </form>

    <div>
        <h3>Megjelenites:</h3>
        <select v-model="sortType">
            <option v-bind:value="'all'" selected>Minden teendo</option>
            <option v-bind:value="'notcompleted'">Nem kesz teendo</option>
            <option v-bind:value="'completed'">Kesz teendo</option>
        </select>
    </div>

    <div v-if="todoList.length != 0">
        <ul v-for="(task, index) in todoList">
            <li v-if="getStatus(task)">
                <div :class="(task['completed'] ? 'completed' : 'not-completed')">
                    {{ task["text"] }}
                    <input type="checkbox" v-model="task['completed']"> <!--:checked="task['completed']" v-bind:value="task['completed']" @click="task['completed'] = !task['completed']"-->
                    <button style="color:red;" @click="deleteItem(index)" v-if="!task['text'].toLocaleLowerCase().includes('fontos')">Törlés</button>
                </div>
            </li>
        </ul>
    </div>
    <div v-else>
        <p>xd</p>
    </div>
</template>

<style scoped>
.completed {
    text-decoration: line-through;
}

.not-completed {
    text-decoration: none;
}
</style>