<script setup>
import Favorite from '../classes/Favorite';
import FavoriteData from '../classes/FavoriteData';
import { favorites } from '../state/state';
import { ref } from 'vue';

const favoritesState = favorites()

const typeSelect = ref(-1)
const typeInput = ref("")
const titleInput = ref("")
const authorInpout = ref("")
const imageInput = ref("")

const addNewFavorite = (() => {
    let newData = new FavoriteData(titleInput.value, authorInpout.value, imageInput.value)
    if (typeSelect.value == -1) {
        favoritesState.addFavorites(new Favorite(typeInput.value, [newData]))
    } else {
        favoritesState.addDataToFavorites(typeSelect.value, newData)
    }
})

</script>

<template>
    <form @submit.prevent="addNewFavorite">
        <select v-model="typeSelect">
            <option v-for="(type, index) in favoritesState.getTypes()" :value="index">{{ type }}</option>
            <option :value="-1">new...</option>
        </select>
        <input v-if="typeSelect == -1" v-model="typeInput" type="text" placeholder="type...">
        <input v-model="titleInput" type="text" placeholder="title...">
        <input v-model="authorInpout" type="text" placeholder="author...">
        <input v-model="imageInput" type="text" placeholder="image url...">
        <button type="submit">Save</button>
    </form>
</template>

<style scoped>
</style>