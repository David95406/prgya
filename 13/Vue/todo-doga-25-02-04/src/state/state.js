import { ref } from "vue";
import { defineStore } from "pinia";

export const useTodoState = defineStore("todo-state", (() => {
    const todos = ref([])
    const editedTodo = ref(null)
    const editedIndex = ref(-1)

    function setEdited(index) {
        editedTodo.value = todos.value[index]
        editedIndex.value = index
    }

    function saveEdited(newTodo) {
        todos.value.splice(editedIndex.value, 1, newTodo)
        editedTodo.value = null
        editedIndex.value = -1
    }

    function getEdited() {
        return editedTodo.value
    }


    function addTodo(newTodo) {
        todos.value.push(newTodo)
    }

    function getTodos() {
        return todos.value
    }

    function updateTodo(index, newTodo) {
        todos.value.splice(index, 1, newTodo)
    }

    function removeTodo(index) {
        todos.value.splice(index, 1)
    }

    return {
        addTodo,
        getTodos,
        updateTodo,
        removeTodo,
        setEdited,
        getEdited,
        saveEdited
    }
}))