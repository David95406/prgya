<script setup>
import { ref } from 'vue';
import { favorites } from '../state/state';
import AddFavorite from './AddFavorite.vue';

const favoritesState = favorites()
const emit = defineEmits(['selected'])


const select = ((index) => {
    emit('selected', index)
})

const isShow = ref(false)
const addNewType = (() => {
    isShow.value = !isShow.value
})
</script>

<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Favorites App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item" v-for="(oneType, index) in favoritesState.getTypes()">
                    <a class="nav-link" @click="select(index)">{{ oneType }}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" @click="addNewType">Add new</a>
                    <div class="nav-link" v-if="isShow">
                        <AddFavorite />
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</template>

<style scoped></style>