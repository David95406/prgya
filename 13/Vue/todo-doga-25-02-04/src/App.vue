<script setup>
import { computed, ref, watch } from "vue"
import Modal from "./components/Modal.vue"
import { useTodoState } from "./state/state"
import Todo from "./classes/Todo"

const todos = useTodoState()

const sortBy = ref("")
const isSort = ref(false)
const sorting = (() => {
  isSort.value = true
})
watch((sortBy), () => {
  if (sortBy.value.length == 0) {
    isSort.value = false
  }
})
const sortedTodos = computed(() => {
  if (sortBy.value && isSort.value) {
    return todos.getTodos().filter((a) => { //gomb!
      return a.getName().includes(sortBy.value) 
    })
  } else {
    return todos.getTodos()
  }
})

const isAddVisible = ref(false)
const openAddTodo = (() => {
  isAddVisible.value = true
})
const closeAddTodo = (() => {
  isAddVisible.value = false
  isEdit.value = false
})

const changeStatus = ((i) => {
  let currentTodo = todos.getTodos()[i]
  currentTodo.setStatus(!currentTodo.getStatus())
  todos.updateTodo(i, new Todo(currentTodo.getName(), currentTodo.getDate(), currentTodo.getStatus()))
})

const deleteTodo = ((i) => {
  if (confirm("biztosan torolni akarja?")) {
    todos.removeTodo(i)
  }
})

const isEdit = ref(false)
const editTodo = ((index) => {
  todos.setEdited(index)
  isEdit.value = true
  openAddTodo()
})
</script>

<template>
  <header>
    <h1>ToDo List</h1>
  </header>
  <main>
    <section>
      <form @submit.prevent="sort">
        <input v-model="sortBy" type="text">
        <button @click="sorting" type="submit">Szures</button>
      </form>
    </section>
    <section>
      <button @click="openAddTodo">+</button>
      <Modal :visible="isAddVisible" @close="closeAddTodo" :isEdit="isEdit" />
    </section>
    <section>
      <div v-if="todos.getTodos().length != 0">
        <div v-for="(todo, i) in sortedTodos">
          <p>{{ todo.getName() }}</p>
          <p>{{ todo.getDate() }}</p>
          <button :class="[todo.getStatus() ? 'done' : 'pending']" @click="changeStatus(i)">{{ todo.getStatusText()
            }}</button>
          <button @click="editTodo(i)">Edit</button>
          <button @click="deleteTodo(i)">Delete</button>

          <br><br>
        </div>
      </div>
      <div v-else>
        <p>List is empty.</p>
      </div>
    </section>
  </main>
  <footer>
    <p>
      All rights reserved!
    </p>
  </footer>
</template>

<style scoped>
.done {
  background-color: green;
}

.pending {
  background-color: red;
}

.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}

.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
