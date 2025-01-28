import {
    defineStore
} from "pinia";
import {
    ref
} from "vue";

export const screenings = defineStore("cinema", () => {
    const screenings = ref([]);
    const filmId = ref(0);

    function addMovie(movie) {
        screenings.value.push(movie);
    }

    function getScreenings() {
        return screenings.value;
    }

    function getScreeningsLength() {
        return screenings.value.length;
    }

    function setFilmId(id) {
        filmId.value = id;
    }

    function getFilmId() {
        return filmId.value;
    }

    function setScreeningsData(data) {
        screenings.value = data;
    }

    return {
        addMovie,
        getScreenings,
        getScreeningsLength,
        getFilmId,
        setFilmId,
        setScreeningsData
    }
});