<script setup>
import { movieDatas } from '../data/movies';
import { screenings } from '../state/state';

const movieState = screenings()

const getImageUrl = ((img) => {
    return new URL("../" + img, import.meta.url).href;
})

const setFilmId = ((id) => {
    movieState.setFilmId(id)
})

</script>

<template>
    <section>
        <h2>Our films</h2>
        <div class="films df">
            <div class="film center" v-for="movie in movieDatas" :key="movie.id">
                <img :src="getImageUrl(movie.image)" :alt="movie.title">
                <h3>{{ movie.title }}</h3>
                <p>{{ movie.description }}</p>
                <p>
                    <router-link to="/film" @click="setFilmId(movie.id)">Tikets &raquo;</router-link>
                </p>
            </div>
        </div>
    </section>
</template>

<style scoped>
.film {
    width: calc(48% - 40px);
    padding: 20px;
    border: 1px solid #fff;
}

.film img {
    width: 100%;
    height: auto;
}
</style>