<script setup>
import ShowTodo from './components/ShowTodo.vue';
import NewTodo from './components/NewTodo.vue';
import { ref } from 'vue';
import { useTodoState } from './state/state';

const todoState = useTodoState()
const todos = todoState.getTodos()

const viewState = ref({
  "showTodos": true,
  "addTodo": false,
  "search": true,
})

const addTodo = (() => {
  console.log('addTodo')
  viewState.value.showTodos = false
  viewState.value.addTodo = true
})

const hideNew = (() => { // rename this
  viewState.value.showTodos = true
  viewState.value.addTodo = false
})

</script>

<template>
  <header>
    <h1>Todo List</h1>
    <p v-if="!viewState.addTodo" @click="addTodo">+</p>
  </header>
  <main>
    <section v-if="viewState.search">
      <div id="search">
        <i class="bi bi-search"></i>
        <input type="text" placeholder="Search" />
      </div>
    </section>
    <section v-if="viewState.addTodo">
      <NewTodo @onsuccess="hideNew"/>
    </section>
    <section v-if="viewState.showTodos">
      <ShowTodo />
    </section>
  </main>
</template>


<style scoped>
#search {
  position: relative;
  width: 85%;
}

#search i {
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);
  color: gray;
}

#search input {
  width: 100%;
  padding-left: 30px;
  box-sizing: border-box;
  height: 40px;
  font-size: 16px;
  height: 35px;
  border: 1px solid #ccc;
  background-color: #eee;
  border-radius: 10px;
}

#search {
  margin: 0 30px 30px 30px;
}
</style>
