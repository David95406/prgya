import { defineStore } from "pinia";
import { ref } from "vue";
import Planet from "../classes/Planet";

export const usePlanetStore = defineStore(("planet store"), () => {
    const planets = ref([])
    const isUppercase = ref(null)

    function addPlanet(planet) {
        planets.value.push(planet)
    }

    function getPlanets() {
        return planets.value
    } 

    function setIsUppercase(value) {
        isUppercase.value = value
    }

    function getUppercase() {
        return isUppercase.value
    }

    return {
        addPlanet,
        getPlanets,
        setIsUppercase,
        getUppercase
    }
})