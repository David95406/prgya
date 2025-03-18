<script setup>
import axios from 'axios'
import { nextTick, ref } from 'vue'
import PokemonDetails from './PokemonDetails.vue'
import { usePokeState } from '../state/state'

const props = defineProps({
  name: String,
  imageUrl: String // raw url
})

const pokeState = usePokeState()

const url = ref("")
const getUrl = async () => {
  await axios.get(props.imageUrl)
    .then((response) => {
      url.value = response.data["sprites"]["other"]["official-artwork"]["front_default"]
      console.log("pik")
      console.log(url.value)
    })
    .catch((error) => {
      console.error(error)
    })
}
getUrl()

const addToFavorites = () => {
  pokeState.addFavorite(props.name)
}

</script>

<template>
  <div class="pokemon-box">
    <div class="pokemon-image">
      <img :src="url" :alt="name">
    </div>
    <div class="pokemon-name">
      <strong>{{ name }}</strong>
    </div>
    <button @click="addToFavorites" class="favorite-button">Add to favorites</button>
    <PokemonDetails :url="imageUrl" />
  </div>

</template>

<style scoped>
.pokemon-box {
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 10px;
  width: 200px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.pokemon-image {
  display: flex;
  justify-content: center;
  margin-bottom: 10px;
}

.pokemon-image img {
  max-width: 120px;
  height: auto;
}

.pokemon-name {
  text-align: center;
  font-size: 1.2em;
}

.favorite-button,
.details-button {
  display: block;
  width: 100%;
  margin-top: 10px;
  padding: 5px;
  border: none;
  border-radius: 4px;
  background-color: black;
  cursor: pointer;
  text-align: center;
}

.favorite-button:hover,
.details-button:hover {
  background-color: cyan;
  color: black;
}
</style>