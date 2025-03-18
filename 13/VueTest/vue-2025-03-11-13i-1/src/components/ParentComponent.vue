<script setup>
import { ref } from 'vue';
import ChildComponenet from './ChildComponenet.vue';

const name = ref("");
const response = ref("");

const handleGreet = (message) =>{
    response.value = message;
}
</script>

<template>
   <h2>Parent</h2>
   <input type="text" v-model="name">
   <ChildComponenet :name="name" @greet="handleGreet"/>
   <p>{{ response }}</p>
</template>