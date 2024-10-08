<script setup>
import { ref, watch, watchEffect } from 'vue';
import { its } from '../assets/items';

const itemName = ref("")
const itemPrice = ref(0)
const items = ref(its)
const sortType = ref("ASC")
const finalPrice = ref(0)

const sortList = (() => {
    if (sortType.value == "ASC") {
        items.value = items.value.sort((a, b) => a["price"] - b["price"])
    } else {
        items.value = items.value.sort((a, b) => b["price"] - a["price"])
    }
})

const addToList = (() => {
    items.value.push({
        "name": itemName.value,
        "price": itemPrice.value
    })

    itemName.value = ""
    itemPrice.value = ""
})

const removeItem = ((index) => {
    if (confirm("Are you sure you want to delete this item?")) {
        items.value.splice(index, 1)
    }
})

const editItem = ((index) => {
    if (confirm("Are u sure?")) {
        items.value[index]["name"] = prompt("New name:", items.value[index]["name"])
        items.value[index]["price"] = prompt("New price:", items.value[index]["price"])
    }
})

watchEffect(() => {
    finalPrice.value = 0
    items.value.forEach((item) => {
        finalPrice.value += parseInt(item["price"])
    })
    sortList()
})
</script>

<template>
    <h2>Add item to list</h2>
    <div>
        <form @submit.prevent="addToList">
            <label for="itemName">Item name: </label>
            <input name="itemName" type="text" v-model="itemName">

            <br>
            <label for="itemPrice">Item price: </label>
            <input name="itemPrice" type="number" v-model="itemPrice"><br>
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
        <ul v-for="(item, index) in items">
            <li>
                {{ item["name"] }}, {{ item["price"] }} Ft
                <button class="deleteBtn" v-if="item.name.toLocaleLowerCase() != 'kenyér'"
                    @click="removeItem(index)">Törlés</button>
                <button @click="editItem(index)">Edit</button>
            </li>
        </ul>
        <p>Final price: {{ finalPrice }} Ft</p>
    </div>
    <div v-else>
        <h3>Lista üres</h3>
    </div>
</template>

<style scoped>
.deleteBtn {
    color: red;
}

select {
    margin: 5px;
    width: 50%;
}

button {
    margin: 10px;
}
</style>