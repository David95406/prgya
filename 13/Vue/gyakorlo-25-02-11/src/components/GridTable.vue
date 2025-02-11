<script setup>
import { ref, computed } from 'vue';
import gridData from '../data/gridData';
import Grid from '../classes/Grid';

let props = defineProps({
    filter: String
})
console.log(props.filter)

const grids = ref([])
gridData.forEach((grid) => {
    grids.value.push(new Grid(grid.name, grid.power))
})

const isSortByName = ref(false)
const sortByName = (() => isSortByName.value = true)
const sortByPower = (() => isSortByName.value = false)

const sortedGrids = computed(() => {
    let sorted = grids.value.sort((a, b) => {
        if (isSortByName.value) {
            return a.getName().localeCompare(b.getName());
        } else {
            return b.getPower() - a.getPower()
        }
    })
    if (props.filter.length == 0) {
        return sorted
    } else {
        return sorted.filter((value) => {
            return value.getName().toLowerCase().includes(props.filter.toLowerCase())
        })
    }
})

</script>

<template>
    <table>
        <thead>
            <tr>
                <th @click="sortByName">Name</th>
                <th @click="sortByPower">Power</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="grid in sortedGrids">
                <td>{{ grid.getName() }}</td>
                <td>{{ grid.getPower() }}</td>
            </tr>
        </tbody>
    </table>
</template>

<style scoped>
table {
    border-collapse: collapse;
    border: 2px solid rgb(140 140 140);
    font-family: sans-serif;
    font-size: 0.8rem;
    letter-spacing: 1px;
}

caption {
    caption-side: bottom;
    padding: 10px;
    font-weight: bold;
}

thead,
tfoot {
    background-color: rgb(228 240 245);
}

th,
td {
    border: 1px solid rgb(160 160 160);
    padding: 8px 10px;
}

td:last-of-type {
    text-align: center;
}

tbody>tr:nth-of-type(even) {
    background-color: rgb(237 238 242);
}

tfoot th {
    text-align: right;
}

tfoot td {
    font-weight: bold;
}
</style>