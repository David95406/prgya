<script setup>
import { computed, ref } from 'vue';
import { usePokeState } from '../state/state';
import Pokemon from './Pokemon.vue';

const pokeState = usePokeState()
const searchValue = ref("")
const searchResult = computed(() => {
    const results = pokeState.getPokemons().filter((pokemon) => pokemon.getName().includes(searchValue.value))
    return results.slice(0, 20)
})
</script>

<template>
    <input v-model="searchValue" type="text" placeholder="Search for pokemon by name">
    <div v-for="pokemon in searchResult">
        <Pokemon :name="pokemon.getName()" :imageUrl="pokemon.getUrl()" />
    </div>
</template>

<style scoped></style>