import { createPinia, defineStore } from "pinia";
import { ref } from "vue";

export const usePokeState = defineStore(('pokemon state'), () => {
    const pokemons = ref([])
    const favorites = ref([])

    function getPokemons() {
        return pokemons.value
    }

    function addPokemon(pokemon) {
        pokemons.value.push(pokemon)
    }

    function getFavoirites() {
        return favorites.value
    }

    function getFavoiritesByIndex(index) {
        return favorites.value[index]
    }

    function addFavorite(favorite) {
        favorite.value.push(favorite)
    }

    return {
        getPokemons,
        addPokemon,
        getFavoirites,
        getFavoiritesByIndex,
        addFavorite
    }

})