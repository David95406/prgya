<script setup>
import { ref } from 'vue';
import { data } from '../data/data';

const todos = ref(data)
</script>

<template>
    <section>
        <ul>
            <li class="todo" v-for="todo in todos" :key="todo.id">
                {{ todo.text }}
            </li>
        </ul>
    </section>
</template>

<style scoped></style>