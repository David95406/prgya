<script setup>
import { reactive, watch } from 'vue';
import Planet from '../classes/Planet';
import axios from 'axios';
import { CRUD_API_PLANETS } from '../secret/secret';
import PlanetCard from './PlanetCard.vue';

const props = defineProps({
    showModal: Boolean
})

const emit = defineEmits(['close', 'save'])

const closeModal = () => {
    emit('close')
}

const currentPlanet = reactive({
    planet: null,
    progress: 0
})

const getPlanet = async (index) => {
    axios.get('https://swapi.py4e.com/api/planets/' + index)
        .then((response) => {
            const name = response.data.name
            const population = response.data.population
            const climate = response.data.climate

            currentPlanet.planet = new Planet(name, population, climate)
        })
        .catch((error) => {
            console.error(error)
        })
}
getPlanet(1)

watch(() => currentPlanet.progress, (newValue) => {
    getPlanet(newValue);
})


const addPlanet = async () => {
    await axios.post(CRUD_API_PLANETS, {
        planet: currentPlanet.planet.getJSON(),
        //is_uppercase: false
    })
        .then(() => {
            emit('save')
        })
        .catch((error) => {
            console.error(error)
        })
}

</script>

<template>
    <div v-if="showModal" class="modal show d-block" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Planet</h5>
                    <button type="button" class="btn-close" @click="closeModal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <PlanetCard :planet="currentPlanet.planet"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" @click="closeModal">Close</button>
                    <button type="button" class="btn btn-secondary" @click="currentPlanet.progress++">Next</button>
                    <button type="button" class="btn btn-primary" @click="addPlanet">Add Planet</button>
                </div>
            </div>
        </div>
        <div class="modal-backdrop show" @click="closeModal"></div>
    </div>
</template>

<style scoped>
.modal {
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-backdrop {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: -1;
}
</style>