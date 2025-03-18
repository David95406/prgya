<script setup>
import { ref } from 'vue';
import axios from 'axios';
import Pokemon from './classes/Pokemon';
import { usePokeState } from './state/state';
import Navigation from './components/Navigation.vue';

const pokeState = usePokeState()

const getPokemons = async () => {
    await axios.get("https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0")
        .then((response) => {
            const results = response.data.results
            results.forEach((data) => {
                pokeState.addPokemon(new Pokemon(data.name, data.url))
            })
        })
        .catch((error) => {
            console.error("hiba a pokemonok lekerdezeseben: " + error)
        })
        .finally(() => {
            console.log("sikeres lekérés")
        })
}
getPokemons()
</script>

<template>
    <Navigation />
    <RouterView />
</template>

<style scoped></style>