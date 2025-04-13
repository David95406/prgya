<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { CRUD_API, CRUD_API_PLANETS, UPPERCASE_ID } from './secret/secret';
import PlanetCard from './components/PlanetCard.vue';
import { reactive } from 'vue';
import AddPlanetModal from './components/AddPlanetModal.vue';
import { usePlanetStore } from './state/store';
import Planet from './classes/Planet';

const viewState = reactive({
  showAddPlanetModal: false
})

const planetStore = usePlanetStore()
const planets = ref([])

const fetchData = async () => {
  planets.value = []
  axios.get(CRUD_API_PLANETS)
    .then((response) => {
      const data = response.data
      console.log(data)

      data.forEach((rawPlanet) => {
        if (rawPlanet.id != UPPERCASE_ID) {
          const name = rawPlanet.planet.name
          const population = rawPlanet.planet.population
          const climate = rawPlanet.planet.climate

          planetStore.addPlanet(new Planet(name, population, climate))
          planets.value.push(new Planet(name, population, climate))
        } else {
          planetStore.setIsUppercase(rawPlanet.is_uppercase)
        }
      })
    })
    .catch((error) => {
      console.error(error)
    })
}
fetchData()

const handleAddNew = () => {
  viewState.showAddPlanetModal = !viewState.showAddPlanetModal
}

const deleteData = async (id) => {
  await axios.delete(CRUD_API_PLANETS + "/" + id)
    .then((response) => {
      console.log(response.data)
    })
    .catch((error) => {
      console.error(error)
    })
}

const deleteAll = async () => {
  if (confirm("are u sure?")) {
    axios.get(CRUD_API_PLANETS)
    .then((response) => {
      const data = response.data

      data.forEach(async (rawPlanet) => {
        if (rawPlanet.id != UPPERCASE_ID) {
          const id = rawPlanet.id
          await deleteData(id)
        }
      })
    })
    .catch((error) => {
      console.error(error)
    })
  }
}

const uppercaseAll = async () => {
  await axios.put(CRUD_API_PLANETS + "/" + UPPERCASE_ID, {
    "is_uppercase": !planetStore.getUppercase()
  })
    .then((response) => {
      console.log(response.data)
    }) 
    .catch((error) => {
      console.error(error)
    })

}
</script>

<template>
  <header>
    <img class="img-fluid mx-auto d-block" src="./assets/logo.png" alt="star-wars-logo" style="max-width: 20%;">
  </header>
  <main>
    <h1 class="mx-auto ml-3">Planets</h1>
    <div class="container text-center">
      <div class="row">
        <div class="col-8">
            <div class="row" v-if="planets" v-for="planet in planets">
              <PlanetCard :planet="planet" class="col" />
            </div>
        </div>
        <div class="col-4">
          <div>
            <div class="d-flex flex-column">
              <button class="btn btn-success pb-10 mb-2" @click="handleAddNew">Add new</button>
              <button class="btn btn-warning pb-10 mb-2" @click="uppercaseAll">Uppercase All</button>
              <button class="btn btn-danger pb-10" @click="deleteAll">Delete All</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div>
      <AddPlanetModal :showModal="viewState.showAddPlanetModal" @close="handleAddNew" @save="fetchData" />
    </div>
  </main>
  <footer class="text-center fixed-bottom">
    <p>&copy; All rights reserved.</p>
  </footer>
</template>

<style scoped>
  
</style>