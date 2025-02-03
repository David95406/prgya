<script setup>
import { Book } from '../classes/Book';
import { useBooksState } from '../state/state';
import { ref, watchEffect } from 'vue';

const booksState = useBooksState()
const books = ref([])

watchEffect(() => {
    books.value = booksState.getBooks()
    console.log("valtozas tortent")
})

const emit = defineEmits(['clear'])
const clearState = (() => emit('clear'))

const edit = ((index) => {
    const selectedBook = booksState.getBooks()[index]

    let newTitle = prompt("Adja meg az uj cimet!", selectedBook.getTitle())
    let newAuthor = prompt("Adja meg az uj irot!", selectedBook.getAuthor())
    let newDesc = prompt("Adja meg az uj leirast!", selectedBook.getDesc())

    booksState.editBook(index, new Book(newTitle, newAuthor, newDesc))
})
</script>

<template>
  <h2>Lista</h2>
  <div v-for="(book, i) in books">
    <p><b>Cím:</b> {{ book.getTitle() }}</p>
    <p><b>Író:</b> {{ book.getAuthor() }}</p>
    <p><b>Leírás:</b> {{ book.getDesc() }}</p>
    <button @click="edit(i)">Modositas</button>
  </div>

  <button @click="clearState">Clear State</button>
</template>

<style scoped>
  
</style>