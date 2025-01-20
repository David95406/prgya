<script setup>
import { ref } from 'vue';
import ShoppingList from './components/ShoppingList.vue';


</script>

<template>
  <header>
    <h1>Shopping list</h1>
  </header>
  <main>
    <ShoppingList />
  </main>
  <footer></footer>
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
