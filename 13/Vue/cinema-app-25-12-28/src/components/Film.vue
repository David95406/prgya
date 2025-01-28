<script setup>
import { ref } from 'vue';
import { movieDatas } from '../data/movies';
import { screeningsData } from '../data/screenings';
import { screenings } from '../state/state';
import Screening from '../classes/Screening';

const getImageUrl = ((img) => {
    return new URL("../" + img, import.meta.url).href;
})

const movieState = screenings()

const movie = movieDatas.find(movie => movie.id === movieState.getFilmId())
const movieScreenings = screeningsData.filter(screening => screening.movieId === movieState.getFilmId())

const currentScreeningData = ref(null)
const showSeats = ref(false)
const setSeats = (time) => {
    showSeats.value = true; // a state-el van a baj
    currentScreeningData.value = movieState.getScreenings().find(ms => (ms.getTime() === time && ms.getMovieId() === movieState.getFilmId()));
    console.log(currentScreeningData.value.getSeets())
}

const prefix = "seat-";
const setColor = ((i, j) => {
    document.querySelector(prefix + i + j).style.backgroundColor = "red";

    if (currentScreeningData.value.isFree(i, j)) {
        currentScreeningData.value.setSeat(i, j);
    } 
})

</script>

<template>
    <section>
        <h2>{{ movie.title }}</h2>
        <p class="center">
            <img :src="getImageUrl(movie.image)">
        </p>
        <p>{{ movie.description }}</p>
        <hr>
    </section>
    <section>
        <h2>Screenings</h2>
        <div class="df">
            <div class="time" v-for="ms in movieScreenings" @click="setSeats(ms.time)">
                {{ ms.time }}
            </div>
        </div>
    </section>
    <section v-if="showSeats">
        <h2>Seats - </h2>
        <div class="df" v-for="(row, rId) in currentScreeningData.getSeets()" :key="rId">
            <div v-for="(col, cId) in row.length" :key="cId">
                <span :id="prefix + rId + cId" @click="setColor(rId, cId)">A</span>
            </div>
        </div>
        <button @click="reserve">Reserve</button>
    </section>
    <section>
        <p>
            <router-link to="/">
                <p>&laquo; Back to home</p>
            </router-link>
        </p>
    </section>
</template>

<style scoped>
.df {
    justify-content: center;
}

.time,
button,
.seat span {
    background-color: #FDCD00;
    padding: 10px 20px;
    margin: 10px;
    color: #000;
    font-weight: 700;
    border-radius: 10px;
}

.seat span {
    margin-bottom: 20px;
    display: inline-block;
    padding: 20px;
    background-color: green;
}

button {
    margin: 20px auto;
    display: block;
}


</style>