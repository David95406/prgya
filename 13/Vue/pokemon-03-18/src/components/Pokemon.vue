<script setup>
import axios from 'axios'
import { ref, watch } from 'vue'
import PokemonDetails from './PokemonDetails.vue'
import { usePokeState } from '../state/state'
import Pokemon from '../classes/Pokemon'

const emit = defineEmits(['add', 'remove'])

const props = defineProps({
  name: String,
  url: String,
  isFavorite: Boolean
})

const imageUrl = ref("")
const getImageUrl = async () => {
  await axios.get(props.url)
    .then((response) => {
      imageUrl.value = response.data["sprites"]["other"]["official-artwork"]["front_default"]
    })
    .catch((error) => {
      console.error(error)
    })
}
getImageUrl()

watch(props, () => {
  getImageUrl()
}, { deep: true })

const addToFavorites = () => {
  emit('add', new Pokemon(props.name, props.url))
}

const removePokemon = () => {
  emit('remove')
}
</script>

<template>
  <div class="card h-100 shadow-sm">
    <div class="text-center p-3">
      <img :src="imageUrl" :alt="name" class="card-img-top" style="max-height: 150px; width: auto;">
    </div>
    <div class="card-body d-flex flex-column">
      <h5 class="card-title text-center text-capitalize mb-3">{{ name }}</h5>
      <div class="mt-auto">
        <button v-if="!isFavorite" @click="addToFavorites" class="btn btn-primary w-100 mb-2">Add to favorites</button>
        <button v-else @click="removePokemon" class="btn btn-primary w-100 mb-2 bg-danger">Remove</button>
        <PokemonDetails :url="url" />
      </div>
    </div>
  </div>
</template>
