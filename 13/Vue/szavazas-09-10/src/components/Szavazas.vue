<script setup>
import { films } from "../data/films.js"
import { ref } from "vue"

const filmlist = ref(films)

function getImageUrl(film) {
    return new URL(film["image"], import.meta.url).href
}

const vote = (film) => {
    film["vote"]++
}

const vote2 = (i) => {
    filmlist.value[i]["vote"]++
    updateFilms()
}

const updateFilms = () => {
    filmlist.value.sort((a, b) => b.vote - a.vote)
}

</script>


<template>
    <section v-for="(film, i) in filmlist" class="df" v-bind:class="{ 'green-border': film.vote >= 10 }">
        <div><img :src="getImageUrl(film)" alt="film1" title="Film 1"></div>
        <div>
            <div class="df">
                <h2>{{ film["name"] }}</h2> <!--    @click.prevent="film.vote++"    -->
                <div><strong class="vote" @click.prevent="vote2(i)">Vote</strong> | {{ film["vote"] }}</div>
            </div>
            <p>{{ film["description"] }}</p>
        </div>
    </section>
</template>


<style scoped>
.df {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

section {
    background-color: lightgray;
    padding: 10px;
    width: 60%;
    margin: 0px auto;
    margin-bottom: 20px;
}

strong {
    color: green;
}

img {
    margin-right: 20px;
}

h2 {
    margin: 0;
    padding: 0;
}

.vote {
    cursor: pointer;
}

.green-border {
    border: 3px solid green;
}
</style>