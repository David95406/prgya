<script setup>
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
    <header class="container-fluid bg-light py-3">
        <div class="text-center">
            <img src="./assets/pokeapi_256.png" class="img-fluid" style="max-height: 80px;">
        </div>
        <Navigation />
        <RouterView />
    </header>
    <main class="container mt-4"></main>
    <footer class="container-fluid bg-dark text-white py-3 mt-4 text-center footer">
        <p class="mb-0">Pokemon App &copy; 2025</p>
    </footer>
</template>
