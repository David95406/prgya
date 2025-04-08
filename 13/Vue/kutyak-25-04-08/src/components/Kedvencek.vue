<script setup>
import DogDetails from './DogDetails.vue';
import axios from 'axios';
import { ref } from 'vue';
import Dog from '../classes/Dog';
import { CRUD_KUTYAK_URL } from '../secret/secret';

const favDawgs = ref([])
const getFavorites = async () => {
    favDawgs.value = []
    await axios.get(CRUD_KUTYAK_URL)
        .then((response) => {
            const rawDawgs = response.data
            rawDawgs.forEach((dowg) => {
                let newDawg = new Dog(dowg['url'], dowg['isFavorite'], dowg['likes'])
                newDawg.setCrudID(dowg['id'])
                favDawgs.value.push(newDawg)
            })
        })
        .catch((error) => {
            console.error(error)
        })
    favDawgs.value = favDawgs.value.sort((a, b) => b.getLikes() - a.getLikes())
}
getFavorites()

const removeFavorite = async (dog) => {
    await axios.delete(CRUD_KUTYAK_URL + "/" + dog.getCrudID())
        .then((response) => {
            console.log(response.data)
        })
        .catch((error) => {
            console.error(error)
        })
        .finally(() => getFavorites())
}

const likeDog = async (dawg) => {
    await axios.put(CRUD_KUTYAK_URL + "/" + dawg.getCrudID(), {
        likes: dawg.getLikes() + 1
    })
        .then((response) => {
            console.log(response.data)
        })
        .catch((error) => {
            console.error(error)
        })
        .finally(() => getFavorites())
}

</script>

<template>
    <DogDetails :dogs="favDawgs" :isFavorite="true" @removeFavorite="removeFavorite" @likeDog="likeDog" />
</template>

<style scoped>
  
</style>
