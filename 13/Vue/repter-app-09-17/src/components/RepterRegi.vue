<script setup>
import { ref, watch } from "vue"
import { airports } from "../data/airports.js";

var selectedAP = ref("")


//hazi
var searchText = ref("")
var searchResults = ref([])

/*
watch(searchText, () => {
    searchResults = ref([])
    for (var i = 0; i < airports.length; i++) {
        if (airports[i].name.includes(searchText.value)) {
            console.log(airports[i].name)
            searchResults.value.push(airports[i])
        }
    }
})
*/

//gomb
const onsubmit = () => {
    searchResults.value = []
    /*
    for (var i = 0; i < airports.length; i++) { //in
        if (airports[i].name.includes(searchText.value)) {
            searchResults.value.push(airports[i])
        }
    }
    */
    airports.forEach((airport) => {
        if (airport.name.includes(searchText.value)) {
            searchResults.value.push(airport)
        }
    })
}

//reset
/*
watch (searchText, () => {
    if (searchText.value.length == 0) {
        searchResults.value = []
    }
})
*/

</script>

<template>
    <section>
        <p>Choose an airport!</p>
        <div>
            <select v-model="selectedAP">
                <option value="">Choose one...</option>
                <option v-for="airport in airports" v-bind:value="airport">
                    {{ airport.name }}
                </option>
            </select>
            <br>
        </div>
        <div v-if="selectedAP.length != 0" class="card">
            <h2>Airport: {{ selectedAP["name"] }}</h2>
            <p>Country: {{ selectedAP["country"]["name"]["en"] }}</p>
            <p>City: {{ selectedAP["city"]["name"]["en"] }}</p>
            <p>Phone: {{ selectedAP["contacts"]["phone"] }}</p>
        </div>
    </section>

    <div>
        <input type="text" v-model="searchText" placeholder="Keresés...">
        <button @click="onsubmit">Go</button>

        <div class="card" v-for="searchedAirport in searchResults"
            v-if="searchText.length != 0 || searchResults.length != 0">
            <h2>Airport: {{ searchedAirport["name"] }}</h2>
            <p>Country: {{ searchedAirport["country"]["name"]["en"] }}</p>
            <p>City: {{ searchedAirport["city"]["name"]["en"] }}</p>
            <p>Phone: {{ searchedAirport["contacts"]["phone"] }}</p>
        </div>
    </div>

</template>

<style scoped>
form {
    text-align: center;
}

img {
    height: 150px;
    display: block;
    margin: 0px auto;
}

label {
    font-weight: bold;
    display: block;
}

form {
    padding: 20px;
    background-color: aliceblue;
}

select {
    padding: 10px;
    margin-top: 10px;
}

.card {
    background-color: rgb(34, 39, 30);
    color: white;
}

span {
    color: rgb(127, 253, 127);
}

form,
.card {
    padding: 20px;
}

input,
button {
    padding: 10px;
    margin: 5px;
    border: 2px solid black;
    border-radius: 5px;
    font-size: 16px;
}

input {
    width: 200px;
}

button {
    color: white;
    cursor: pointer;
    background-color: black;
}
</style>