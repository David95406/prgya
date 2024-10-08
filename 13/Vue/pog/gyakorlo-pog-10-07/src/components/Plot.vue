<script setup>
import { ref, watch } from 'vue';
import { plots } from '../assets/plot';

const plotWidth = ref(0)
const plotLength = ref(0)
const plotPrice = ref(0)
const plotsList = ref(plots)
const maxPlot = 5

const addToList = (() => {
    if (plotsList.value.length < maxPlot) {
        plotsList.value.push({
            "width": plotWidth.value,
            "length": plotLength.value,
            "price": plotPrice.value
        })

        plotWidth.value = 0
        plotLength.value = 0
        plotPrice.value = 0
        alert("Sikeresen hozzáadta a listához")
    }
})

const sortList = (() => {
    plotsList.value = plotsList.value.sort((a, b) => a["price"] - b["price"])
})

const priceIncrease = (() => {

})
sortList()
</script>

<template>
    <div>
        <div v-if="plotsList.length != maxPlot">
            <form @submit.prevent="addToList">
                <h2>Add Plot</h2><br>
                <label for="plotWidth">Width (meter): </label>
                <input type="number" name="plotWidth" v-model="plotWidth"><br>
                <label for="plotLength">Length (meter): </label>
                <input type="number" name="plotLength" v-model="plotLength"><br>
                <label for="plotPrice">Price (million HUF): </label>
                <input type="number" name="plotPrice" v-model="plotPrice"><br>
                <button type="submit">Add to list</button>
            </form>
        </div>
        <div v-else>
            <h2>Plots for Sale</h2>
            <table>
                <thead>
                    <tr>
                        <th>Width</th>
                        <th>Length</th>
                        <th>Price</th>
                        <th>Price Inc.</th>
                    </tr>
                </thead>
                <tbody v-for="(item, index) in plotsList">
                    <tr>
                        <td>{{ item["width"] }}</td>
                        <td>{{ item["length"] }}</td>
                        <td>{{ item["price"] }}</td>
                        <td @click="priceIncrease(index)" v-if="item['price'] < 3">Increase</td>
                    </tr>
                </tbody>
            </table>
            <button>Clear</button>
        </div>
    </div>
</template>

<style scoped></style>