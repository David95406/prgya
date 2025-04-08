<script setup>
import DogDetails from './DogDetails.vue';
import axios from 'axios';
import { ref } from 'vue';
import Dog from '../classes/Dog';
import { CRUD_KUTYAK_URL } from '../secret/secret';

const dawgs = ref([])
const getDawgs = async () => {
    for (let i = 0; i < 10; i++) {
        await axios.get('https://dog.ceo/api/breeds/image/random')
            .then((response) => {
                let d = new Dog(response.data.message, false, 0)
                dawgs.value.push(d)
            })
            .catch((error) => {
                console.error(error)
            })
    }
}
getDawgs()

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
}
getFavorites()

const isDawgFavorite = (dawg) => {
    console.log(dawg.getUrl())
    for (let i = 0; i < favDawgs.value.length; i++) {
        if (dawg.getUrl() === favDawgs.value[i].getUrl()) { // foreach nem returnol!
            return true
        }
    }
    return false
}

const addToFavorites = async (dawg) => {
    if (!isDawgFavorite(dawg)) {
        await axios.post(CRUD_KUTYAK_URL, {
        url: dawg.getUrl(),
        isFavorite: true,
        likes: dawg.getLikes()
    })
        .then(() => {
            console.log("siker")
        })
        .catch((error) => {
            console.error(error)
        })
    } else {
        alert('mar van')
    }
    getFavorites()
}

</script>

<template>
 <DogDetails :dogs="dawgs" @addFavorite="addToFavorites"/>
</template>

<style scoped>
  
</style>