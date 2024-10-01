<script setup>
import { ref, watch } from 'vue';
import { its } from '../assets/items';

const itemName = ref("")
const itemPrice = ref(0)
const items = ref(its)
const sortType = ref("ASC")

const sortList = (() => {
    if (sortType.value == "ASC") {
        items.value = items.value.sort((a, b) => a["price"] - b["price"])
    } else {
        items.value = items.value.sort((a, b) => b["price"] - a["price"])
    }
})
sortList()
watch(sortType, () => sortList())

const addToList = (() => {
    items.value.push({
        "name": itemName.value,
        "price": itemPrice.value
    })

    itemName.value = ""
    itemPrice.value = ""

    sortList()
})

const removeItem = ((index) => {
    if (confirm("Are you sure you want to delete this item?")) {
        items.value.splice(index, 1)
    }
})
</script>

<template>
    <h2>Add item to list</h2>
    <div>
        <form @submit.prevent="addToList">
            <div class="df">
                <label for="itemName">Item name: </label>
                <input name="itemName" type="text" v-model="itemName">

                <label for="itemPrice">Item price: </label>
                <input name="itemPrice" type="number" v-model="itemPrice">
            </div>

            <button type="submit">ADD TO LIST</button>
        </form>
    </div>

    <div>
        <p>Sort:</p>
        <select v-model="sortType">
            <option v-bind:value="'ASC'" selected>By price ASC</option>
            <option v-bind:value="'DSC'">By price DSC</option>
        </select>
    </div>

    <div v-if="items.length != 0">
        <h3>Shopping list</h3>
        <ul>
            <li v-for="(item, index) in items">
                {{ item["name"] }}, {{ item["price"] }} Ft
                <button class="deleteBtn" v-if="item.name.toLocaleLowerCase() != 'kenyér'" @click="removeItem(index)">Törlés</button>
            </li>
        </ul>
    </div>
    <div v-else>
        <h3>Lista üres</h3>
    </div>
</template>

<style scoped>
.deleteBtn {
    background-color: red;
    font-weight: 700;
}

.df {
    display: flex;
    justify-content: space-between;
}

label {
    display: block;
    color: #3AB982;
    font-weight: 700;
}

select,
input {
    padding: 5px;
}

select {
    width: 100%;
}

form {
    border-bottom: 2px solid #34495F;
    color: #3AB982;

}

button {
    background-color: #3AB982;
    padding: 10px 20px;
    border: none;
    text-transform: uppercase;
    margin-top: 20px;
}
</style>