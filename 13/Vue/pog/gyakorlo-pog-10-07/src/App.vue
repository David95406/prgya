<script setup>
import Todo from './components/Todo.vue';
import Plot from './components/Plot.vue';

</script>

<template>
  <header>
    <h1>Todo List</h1>
  </header>
  <main>
    <Todo />
    <Plot/>
  </main>
  <footer>
    <p>&copy; 2024</p>
  </footer>
</template>

<style scoped>
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
