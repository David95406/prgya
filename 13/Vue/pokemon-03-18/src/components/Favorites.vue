<script setup>
import { computed, ref, watch } from 'vue';
import { usePokeState } from '../state/state';
import Pokemon from './Pokemon.vue';

defineOptions({
  name: 'Favorites'
})

const pokeState = usePokeState()
const favorites = computed(() => {
  return pokeState.getFavoirites()
})

const removePokemon = (index) => {
  if (confirm('biztos?')) {
    pokeState.removePokemonByIndex(index)
  }
}
</script>

<template>
  <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4">
    <div v-for="(favorite, index) in favorites" class="col mb-3">
      <Pokemon :name="favorite.getName()" :url="favorite.getUrl()" :isFavorite="true" @remove="removePokemon(index)"/>
    </div>
  </div>
  
</template>
