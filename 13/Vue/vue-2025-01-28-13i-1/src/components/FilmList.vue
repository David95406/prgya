<script setup>
import { movieDatas } from "../data/movies.js";
import { screenings } from "../state/state.js";

const movieState = screenings();

function getImageUrl(image) {
    return new URL("../" + image, import.meta.url).href;
}

const setFilmId = (id) => {
    movieState.setFilmId(id);
}
</script>

<template>
    <section>
        <h2>Our films</h2>
        <div class="films df">
            <div class="film center" v-for="movie in movieDatas">
                <p><img :src="getImageUrl(movie.image)" :alt="movie.title"></p>
                <h3>{{ movie.title }}</h3>
                <p><router-link to="/film" @click="setFilmId(movie.id)">Tikets &raquo;</router-link></p>
            </div>
        </div>

    </section>
</template>

<style scoped>
.film{
    width: calc(48% - 40px);
    padding: 20px;
    border: 1px solid #fff;
}
.film img{
    max-width: 100%;
}
</style>
