import { defineStore } from "pinia";
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
        if (!favorites.value.some(fav => fav.getName() == favorite.getName())) {
            favorites.value.push(favorite);
        }
    }

    function removePokemonByIndex(index) {
        favorites.value.splice(index, 1)
    }

    return {
        getPokemons,
        addPokemon,
        getFavoirites,
        getFavoiritesByIndex,
        addFavorite,
        removePokemonByIndex
    }

})