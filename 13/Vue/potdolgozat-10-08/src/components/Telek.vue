<script setup>
import { ref, watchEffect } from 'vue';
import { plots } from '../assets/plots';

const telkek = ref([])
const maxTelkek = 5
plots.forEach((plot) => {
    telkek.value.push(plot)
})

const telekSzelesseg = ref("")
const telekHosszusag = ref("")
const telekAra = ref("")

const sortTelkek = (() => {
    telkek.value = telkek.value.sort((a, b) => a['ar'] - b['ar'])
})
watchEffect(() => { sortTelkek() })

const addTelek = (() => {
    telkek.value.push({
        "szelesseg": telekSzelesseg.value,
        "hosszugas": telekHosszusag.value,
        "ar": telekAra.value * 1000000
    })

    telekSzelesseg.value = ""
    telekHosszusag.value = ""
    telekAra.value = ""
    alert("sikeres hozzaadas!")
})

const increasePrice = ((index) => {
    telkek.value[index]["ar"] *= 1.5//!2:(
})

const clearPlots = (() => {
    if (confirm("Biztos benne?")) {
        telkek.value = []
        plots.forEach((plot) => {
            telkek.value.push(plot)
        })
    }
})
</script>

<template>
    <div v-if="telkek.length < maxTelkek">
        <h2>Add plot {{ maxTelkek }} / {{ telkek.length }}</h2>
        <form @submit.prevent="addTelek">
            <label for="telekSzelesseg">Width (meter): </label>
            <input type="number" v-model="telekSzelesseg" name="telekSzelesseg"><br>

            <label for="telekHosszusag">Length (meter): </label>
            <input type="number" v-model="telekHosszusag" name="telekHosszusag"><br>

            <label for="telekAra">Price (million HUF)</label>
            <input type="number" v-model="telekAra" name="telekAra"><br>
            <button type="submit">Add To List</button>
        </form>
    </div>
    <div v-else class="plots">
        <table>
            <thead>
                <tr>
                    <th>Width</th>
                    <th>Length</th>
                    <th>Price</th>
                    <th>Price inc</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(plot, index) in telkek" :class="plot['ar'] >= 3000000 ? 'felsoar' : ''">
                    <td>{{ plot["szelesseg"] }}m</td>
                    <td>{{ plot["hosszugas"] }}m</td>
                    <td>{{ plot["ar"] }} Ft</td>
                    <td>
                        <span class="incBtn" @click="increasePrice(index)" v-if="plot['ar'] < 3000000">Increase</span>
                    </td>
                </tr>
            </tbody>
        </table>
        <button @click="clearPlots()">Clear</button>
    </div>
</template>
<style scoped>
.felsoar {
    background-color: rgb(228, 135, 135);
}

h2 {
    color: #34495F;
    border-bottom: 2px solid #34495F;
}

h2,
label {
    color: #34495F;
}

label,
button,
.incBtn {
    font-weight: 700;
}

.incBtn {
    color: #3AB982;
    text-align: center;
}

.incBtn,
button {
    text-transform: uppercase;
}

button {
    padding: 10px 0px;
    margin-top: 20px;
}

label,
input,
button {
    display: block;
    border-radius: 10px;
    border: none;
}

label,
input,
button,
table {
    width: 100%;
}

button,
thead {
    background-color: #34495F;
    color: white;
}

table {
    border-collapse: collapse;

}

td {
    border: 1px solid #000;
}

td,
th {
    padding: 5px;
}

input {
    padding: 10px 5px;
    width: calc(100% - 10px);
    margin-top: 10px;
}

.plots button {
    width: auto;
    margin: 20px auto 0px auto;
    padding: 10px 20px;
}
</style>