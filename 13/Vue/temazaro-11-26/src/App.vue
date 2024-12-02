<script setup>
import Kolcsonzes from './components/Kolcsonzes.vue'
import Konyvtar from './components/Konyvtar.vue'
import { computed, ref } from 'vue';
import Book from './classes/Book';
import { books as booksFile } from './data/books';

const books = ref([])
const kolcsonzott = ref([])
const listAll = ref(false)
const search = ref("")
const finalSearch = ref("")

booksFile.forEach((book) => {
  books.value.push(new Book(
    book.azon,
    book.name,
    book.authors,
    book.img,
  ))
})

const listAllBook = (() => {
  listAll.value = !(listAll.value)
  search.value = ""
})

const searchResult = computed(() => {
  if (listAll.value) {
    return books.value
  } else {
    if (finalSearch.value.length > 0) {
      return books.value.filter((book) =>
        book.getName().toLowerCase().includes(finalSearch.value.toLowerCase()) ||
        book.getAzon().toLowerCase().includes(finalSearch.value.toLowerCase())
      )
    }
  }
})

const getImageURL = ((imageURL) => {
  imageURL = "/src/" + imageURL
  return new URL(imageURL, import.meta.url).href
})


const kolcsonzes = ((ujKonyv, index) => {
  const check = kolcsonzott.value.filter((book) => book.getAzon() == ujKonyv.getAzon())
  if (check.length == 0) {
    kolcsonzott.value.push(books.value.at(index))
    alert("Sikeres kölcsönzés!")
  } else {
    alert("Nem lehet ketszer ugyanazt a konyvet kikolcsonozni!")
  }

})

const searchBooks = (() => {
  if (listAll.value) {
    alert("Kereseshez kapcsolja ki a 'Minden könyv mutatása'-t!")
  } else {
    finalSearch.value = search.value
  }
})

const isKolcsonzes = ref(false)
const goToKolcsonzes = (() => {
  if (kolcsonzott.value.length == 0) {
    alert("Üres!")
  } else {
    isKolcsonzes.value = true
  }
})

const back = ((newBooks) => {
  isKolcsonzes.value = false
  kolcsonzott.value = newBooks
})
</script>

<template>
  <header>
    <h1>Könvtár App</h1>
    <form @submit.prevent="searchBooks" v-if="!isKolcsonzes">
      <h2>Keresés a könvek között</h2>
      <div class="input-group mb-3">
        <input v-model="search" type="text" class="form-control" placeholder="Könyv címe vagy azonositoja"
          aria-describedby="basic-addon1" :disabled="listAll">
        <button type="submit" class="btn btn-warning">Tovább</button>
      </div>
    </form>
  </header>
  <main>
    <section v-if="!isKolcsonzes">
      <div>
        <span @click="goToKolcsonzes" class="kolcsonzott">Kölcsönzött {{ kolcsonzott.length }}</span>
        <div class="form-check form-switch">
          <label for="flexSwitchCheckDefault">Minden könyv mutatása</label>
          <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault"
            @click="listAllBook">
        </div>
      </div>
    </section>
    <section v-if="!isKolcsonzes">
      <!--
      <Konyvtar :books="searchResult" @kolcsonzes="kolcsonzes"/>
      -->
      <div v-for="(book, index) in searchResult" class="card" style="width: 18rem;">
        <img :src="getImageURL(book.getImg())" class="card-img-top" :title="book.getTitle()">
        <div class="card-body">
          <h5 class="card-title">{{ book.getName() }}</h5>
          <p class="card-text">{{ book.getAzon() }}</p>
          <a class="btn btn-primary" @click="kolcsonzes(book, index)">Kölcsönzés</a>
        </div>
      </div>
    </section>
    <section v-else>
      <Kolcsonzes :books="kolcsonzott" @back="back" />
    </section>
  </main>
  <footer></footer>
</template>

<style scoped>
.kolcsonzott {
  cursor: pointer;
  font-weight: 700;
}
</style>
