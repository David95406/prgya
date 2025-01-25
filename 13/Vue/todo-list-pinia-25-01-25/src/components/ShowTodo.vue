<script setup>
import { computed, watch, watchEffect, ref } from 'vue';
import { useTodoState } from '../state/state';

const todoState = useTodoState()
const todos = todoState.getTodos()
const keepFresh = ref(true)
const refresh = (() => { // csak igy valtozik a view
    keepFresh.value = !keepFresh.value
})


const getStatus = ((status) => {
    return (status ? "Completed" : "Pending")
})

const changeStatus = ((index) => {
    todoState.changeStatus(index)
    refresh()
})

const isEditing = ref(false) // ez kell 
const edit = ref({
    name: "",
    desc: "",
    date: "",
    set(name, desc, date) {
        this.name = name
        this.desc = desc
        this.date = date
    },
    reset() {
        this.name = ""
        this.desc = ""
        this.date = ""
    }
})
const expand = ((index) => {
    console.log('expand')
    edit.value.set(todos[index].getName(), todos[index].getDesc(), todos[index].getRawDate())
    document.getElementById(index).style.display = "flex"
})

const remove = ((index) => {
    if (confirm("biztos torolni akarja?")) {
        todoState.removeTodo(index)
        console.log('removed')
        refresh()
    }
})

const exitEdit = ((id) => {
    todos[id].setName(edit.value.name)
    todos[id].setDesc(edit.value.desc)
    todos[id].setDate(edit.value.date)
    edit.value.reset()
    refresh()
    console.log('saved')
    document.getElementById(id).style.display = "none"
})

</script>
<template v-if="todos.length != 0">
    <p class="refresh">refresh: {{ keepFresh }}</p>
    <section v-for="(todo, index) in todos" :key="index">
        <div>
            <p id="title">{{ todo.getName() }}</p>
            <p id="date">{{ todo.getDate() }}</p>
        </div>
        <div>
            <p id="status" @click="changeStatus(index)" :class="{ completed: todo.getStatus() }">
                {{ getStatus(todo.getStatus()) }}
            </p>
            <p id="button" @click="expand(index)"> > </p>
            <div :id="index" class="edit-todo" style="display: none;">
                <input type="text" :placeholder="todo.getName()" v-model="edit.name" />
                <input type="text" :placeholder="todo.getDesc()" v-model="edit.desc" />
                <input type="datetime-local" :placeholder="todo.getRawDate()" v-model="edit.date" />
                <button @click="exitEdit(index)">Save</button>
                <button @click="remove(index)">Delete</button>
            </div>
        </div>

    </section>
</template>
<style scoped>
section:first-of-type {
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin: 0 30px 0 30px;
    display: flex;
    justify-content: space-between;
}

section {
    border-bottom: 1px solid #ccc;
    margin: 0 30px 0 30px;
    display: flex;
    justify-content: space-between;
}

#title {
    margin: 10px 0px 0px 0px;
    font-weight: 600;
}

#date,
#status {
    margin: 0;
    font-weight: 200;
}

#status {
    background-color: orange;
    border-radius: 20px;
    padding: 5px;
    color: white;
}

#button {
    padding: 5px;
    color: #ccc;
    cursor: pointer;
}

section div:last-of-type {
    display: flex;
    align-items: center;
    margin: 5px;
}

.edit-todo {
    display: none;
    flex-direction: column;
    margin: 0 30px 0 30px;
}

.refresh {
    display: none;
}

.completed {
    background-color: green !important;
    text-decoration: line-through;
}

</style>