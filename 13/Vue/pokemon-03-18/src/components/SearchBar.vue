<script setup>
import { computed, ref } from 'vue';
import { usePokeState } from '../state/state';
import Pokemon from './Pokemon.vue';

const pokeState = usePokeState()

const addPokemon = (pokemon) => {
  pokeState.addFavorite(pokemon)
}

const searchValue = ref("")
const searchResult = computed(() => {
    const results = pokeState.getPokemons().filter((pokemon) => pokemon.getName().includes(searchValue.value))
    return results.slice(0, 20)
})
</script>

<template>
    <form class="row justify-content-center mb-4">
        <div class="col-md-6">
            <input v-model="searchValue" type="text" class="form-control" placeholder="Search for pokemon by name">
        </div>
    </form>
    
    <div class="row row-cols-1 row-cols-md-3 row-cols-lg-4 g-4">
        <div class="col mb-3" v-for="pokemon in searchResult">
            <Pokemon @add="addPokemon" :name="pokemon.getName()" :url="pokemon.getUrl()" :isFavorite="false" />
        </div>
    </div>
</template>

<style scoped></style>