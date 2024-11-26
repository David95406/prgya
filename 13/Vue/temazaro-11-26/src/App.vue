<script setup>
import Kolcsonzes from './components/Kolcsonzes.vue'
import Konyvtar from './components/Konyvtar.vue'
import { ref } from 'vue';
import Book from './classes/Book';
import { books as booksFile } from './data/books';

const books = ref([])
const searchResult = ref([])
const kolcsonzott = ref([])
const listAll = ref(false)
const search = ref("")

booksFile.forEach((book) => {
  books.value.push(new Book(
    book.azon,
    book.name,
    book.authors,
    book.img,
  ))
})

const listAllBook = (() => {
  listAll.value = !(listAll.value) //claer
  alert(listAll.value)
  if (listAll) {
    searchResult.value = books.value
    search.value = ""
  } else {
    searchResult.value = []
  }
})

const getImageURL = ((imageURL) => {
  console.log(new URL(imageURL, import.meta.url).origin + "/src/" + imageURL)
  console.log(new URL(imageURL, import.meta.url).href)
  return new URL(imageURL, import.meta.url).origin + "/src/" + imageURL
  //return (new URL(imageURL, import.meta.url).origin + "/src/" + imageURL).href
})


const kolcsonzes = ((index) => {
  return
})

const searchBooks = (() => {
  alert(search.value)
})
</script>

<template>
  <header>
    <h1>Könvtár App</h1>
    <form @submit.prevent="searchBooks">
      <h2>Keresés a könvek között</h2>
      <div class="input-group mb-3">
        <input v-model="search" type="text" class="form-control" placeholder="Könyv címe vagy azonositoja"
          aria-describedby="basic-addon1">
        <button type="submit" class="btn btn-warning">Tovább</button>
      </div>
    </form>
  </header>
  <main>
    <section>
      <div>
        <span>Kölcsönzött {{ kolcsonzott.length }}</span>
        <div class="form-check form-switch">
          <label for="flexSwitchCheckDefault">Minden könyv mutatása</label>
          <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault"
            @click="listAllBook">
        </div>

      </div>
    </section>
    <section>
      <div v-for="(book, index) in searchResult" class="card" style="width: 18rem;">
        <img :src="getImageURL(book.getImg())" class="card-img-top" :title="book.getAuthors()">
        <div class="card-body">
          <h5 class="card-title">{{ book.getName() }}</h5>
          <p class="card-text">{{ book.getAzon() }}</p>
          <a class="btn btn-primary" @click="kolcsonzes(index)">Kölcsönzés</a>
        </div>
      </div>
    </section>
    <section>

    </section>
  </main>
  <footer></footer>
</template>

<style scoped></style>
