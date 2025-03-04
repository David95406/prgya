<script setup>
import { ref } from 'vue';

const items = ref(['apple', 'banana', 'orange'])

</script>

<template>
  <section>
    <ul class="items">
        <li v-for="item in items">
            {{ item }}
        </li>
    </ul>
  </section>
</template>

<style scoped>
  
</style>