<script setup>
import { defineProps, defineEmits } from 'vue';

const props = defineProps({
    books: Array
})
</script>

<template>
    <div>
        <div v-for="(book, index) in searchResult" class="card" style="width: 18rem;">
            <img :src="getImageURL(book.getImg())" class="card-img-top" :title="book.getAuthors()">
            <div class="card-body">
                <h5 class="card-title">{{ book.getName() }}</h5>
                <p class="card-text">{{ book.getAzon() }}</p>
                <a class="btn btn-primary" @click="kolcsonzes(book, index)">Kölcsönzés</a>
            </div>
        </div>
    </div>
</template>

<style scoped></style>