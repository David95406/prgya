import { defineStore } from "pinia";
import { ref } from "vue";

export const useTodoState = defineStore('useTodoState', (() => {
    const todos = ref([])

    function addTodo(newTodo) {
        todos.value.push(newTodo)
        console.log("siker: " + newTodo.toString())
    }

    function getTodos() {
        return todos.value //.value
    }

    function changeStatus(index) {
        todos.value[index].changeStatus()
    }

    function removeTodo(index) {
        todos.value.splice(index, 1)
    }

    return {
        addTodo,
        getTodos,
        changeStatus,
        removeTodo
    }
}))
