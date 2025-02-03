<script setup>
import { ref } from 'vue';
import { booksData } from './data/books';
import { useBooksState } from './state/state';
import ShowBooks from './components/ShowBooks.vue'
import { Book } from './classes/Book';

const bookState = useBooksState()

booksData.forEach((data) => {
  let newBook = new Book(data.title, data.author, data.desc)

  bookState.addBook(newBook)
})

const titleInput = ref("")
const authorInput = ref("")
const descInput = ref("")
const addBook = (() => {
  bookState.addBook(new Book(
    titleInput.value,
    authorInput.value,
    descInput.value
  ))

  titleInput.value = authorInput.value = descInput.value = ""
})

const clearState = (() => {
    bookState.clearState()
})
</script>

<template>
  <header>
    <h1>Könyv nyilvántartó</h1>
  </header>
  <main>
    <section>
      <form @submit.prevent="addBook">
        <input v-model="titleInput" type="text" placeholder="title">
        <input v-model="authorInput" type="text" placeholder="author">
        <input v-model="descInput" type="text" placeholder="desc">
        <button type="submit">Add</button>
      </form>
    </section>
    <section>
      <ShowBooks @clear="clearState" />
    </section>
  </main>
  <footer>Copyright &copy;</footer>
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
