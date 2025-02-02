<script setup>
import { ref, watchEffect } from 'vue';
import NavBar from './components/NavBar.vue';
import FavoriteData from './classes/FavoriteData';
import Favorite from './classes/Favorite';
import { favoritesData } from './data/favorites';
import { favorites } from './state/state';
import ShowFavorite from './components/ShowFavorite.vue';

const favoritesState = favorites()

favoritesData.forEach((oneType) => {
  let type = oneType["type"]
  let datas = []
  oneType.data.forEach((oneData) => {
    datas.push(new FavoriteData(
      oneData["title"],
      oneData["author"],
      oneData["image"]
    ))
  })
  let newFavorite = new Favorite(type, datas)
  favoritesState.addFavorites(newFavorite)
})

const currentType = ref(0)
const selectType = ((index) => {
  currentType.value = index
})

</script>

<template>
  <header>
    <NavBar @selected="selectType" />
  </header>
  <main>
    <ShowFavorite :currentType="currentType" />
  </main>
  <footer>
    <p>Copyright&copy; - All right reserved!</p>
  </footer>
</template>

<style scoped>
header {
  background-color: #f8f9fa;
  padding: 1rem;
  border-bottom: 1px solid #dee2e6;
}

main {
  padding: 2rem;
  min-height: 80vh;
}

footer {
  background-color: #f8f9fa;
  padding: 1rem;
  border-top: 1px solid #dee2e6;
  text-align: center;
}
</style>