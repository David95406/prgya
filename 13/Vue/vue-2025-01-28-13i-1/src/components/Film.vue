<script setup>
import { screenings } from "../state/state.js"
import { movieDatas } from "../data/movies.js"
import { screeningsData } from "../data/screenings.js"
import { useRouter } from 'vue-router';
import { ref } from "vue"

const router = useRouter();
const prefix = "seat";
const movieState = screenings();
const showSeats = ref(false)
const movie = movieDatas.find(movie => movie.id === movieState.getFilmId());
const movieScreenings = screeningsData.filter(screening => screening.movieId === movieState.getFilmId());

const currentScreeningData = ref();

console.log(movieState.getScreenings());

function getImageUrl(name) {
    return new URL("../" + name, import.meta.url).href
}

const setSeats = (time) => {
    showSeats.value = true;
    currentScreeningData.value = movieState.getScreenings().find(ms => (ms.getTime() == time && ms.getMovieId() === movieState.getFilmId()))
}

const setColor = (i, j) => {
    document.querySelector("#seat" + i + j).style.backgroundColor = "red";
    if (!currentScreeningData.value.isFree(i, j)) {
        currentScreeningData.value.setSeet(i, j);
    }
}

const reserve = (time) => {
    var screens = movieState.getScreenings();
    var movie = screens.find(movie => (movie.getMovieId() === movieState.getFilmId() && movie.getTime() === currentScreeningData.value.getTime()));
    movie.setSeets(currentScreeningData.value.getSeets());
    router.push("/success-reserved");
}

</script>
<template>
    <section>
        <h2>{{ movie.title }}</h2>
        <p class="center"><img :src="getImageUrl(movie.image)"></p>
        <p>{{ movie.description }}</p>
        <hr>
    </section>
    <section class="screenings">
        <h2>Screenings</h2>
        <div class="df">
            <div class="time" v-for="ms in movieScreenings" @click="setSeats(ms.time)">{{ ms.time }}</div>
        </div>
    </section>
    <section v-if="showSeats">
        <h2>Seats - {{ currentScreeningData.getRoomId() }} - {{ currentScreeningData.getTime() }}</h2>
        <div class="df" v-for="(sor, i) in currentScreeningData.getSeets()">
            <div v-for="(oszlop, j) in sor.length" class="seats">
                <span :id="prefix + i + j" :class="{ 'notfree': currentScreeningData.isFree(i, j) }"
                    @click="setColor(i, j)"></span>
            </div>
        </div>
        <button @click="reserve">Reserve</button>
    </section>
    <section>
        <p><router-link to="/">&laquo; Back</router-link></p>
    </section>
</template>

<style scoped>
.screenings {
    padding-bottom: 10px;
}

.time,
.free,
button,
.seats span {
    background-color: #FDCD00;
    padding: 10px 20px;
    margin: 10px;
    color: #000;
    font-weight: 700;
    border-radius: 10px;
}

.seats span {
    margin-bottom: 20px;
    display: inline-block;
    padding: 20px;
}

.notfree {
    background-color: red !important;
}

.time:hover {
    cursor: pointer;
    background-color: aqua;
}

.df {
    justify-content: center;
}

.seats span {
    background-color: green;
}

button {
    display: block;
    border: none;
    margin: 0px auto;
}
</style>
