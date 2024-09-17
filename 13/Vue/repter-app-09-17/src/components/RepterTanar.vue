<script setup>
import { ref } from "vue"
import { airports } from "../data/airports.js";

var selectedAP = ref("")

var country = ref("")
var city = ref("")
var phone = ref("")

const searchAirport = (name) => {
    for (var i = 0; i < airports.length; i++) {
        if (airports[i]["name"] == name) {
            country.value = airports[i]["country"]["name"]["en"]
            city.value = airports[i]["city"]["name"]["en"]
            phone.value = airports[i]["contacts"]["phone"]
        }
    }
}

watch(selectedAP, () => {
    searchAirport(selectedAP)
})
</script>

<template>
    <section>
        <form>
            <p>Choose an airport!</p>
            <div>
                <select v-model="selectedAP">
                    <option value="">Choose one...</option>
                    <option v-for="(airport, index) in airports" v-bind:value="airport">
                        {{ airport.name }}
                    </option>
                </select>
                <br>
            </div>
        </form>
        <div v-if="selectedAP.length != 0" class="card">
            <h2>Airport: {{ selectedAP["name"] }}</h2>
            <p>Country: {{ selectedAP["country"]["name"]["en"] }}</p>
            <p>City: {{ selectedAP["city"]["name"]["en"] }}</p>
            <p>Phone: {{ selectedAP["contacts"]["phone"] }}</p>
        </div>
    </section>
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
</style>