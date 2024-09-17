<script setup>
import { ref } from 'vue'

const showFirst = ref(true)

</script>

<template>
    <p v-if="showFirst">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris euismod eu sapien ac varius.</p>
    <p v-if="!showFirst">Maecenas euismod nec est eu luctus. Phasellus tempor justo in nunc vestibulum tempor.</p>
</template>

<style scoped></style>