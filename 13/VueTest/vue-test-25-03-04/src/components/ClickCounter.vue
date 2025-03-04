<script setup>
import { ref } from 'vue';

const clicker = ref(0)

const handleClickerClick = (() => {
    clicker.value++
})
</script>

<template>
  <section>
    <button class="btn" @click="handleClickerClick">Click me!</button>
    <p class="clicker">{{ clicker }}</p>
    <div>
        <img src="../assets/vue.svg" alt="Logo">
    </div>
  </section>
</template>

<style scoped>
.btn {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 4px;
}

.clicker {
    font-size: 20px;
    color: white;
    margin-top: 10px;
}
</style>