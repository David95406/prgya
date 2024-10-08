<script setup>
import { ref, watchEffect } from 'vue';

const telkek = ref([])
const asd = ref("")

const sortTelkek = (() => {
    telkek = telkek.value.sort((a, b) => a.price - b.price)
})
watchEffect(() => {
    sortTelkek()
})

const addTelek = (() => {
    telkek.value.push({
        id: 1, name: 'Telek1', price:
            1000
    })
})
</script>

<template>
    <form @submit.prevent="addTelek">
        <input type="text" v-model="asd">
    </form>
</template>
<style lang="">

</style>