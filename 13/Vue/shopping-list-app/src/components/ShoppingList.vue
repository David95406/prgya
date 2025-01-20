<script setup>
import {useShoppingListStore} from '../store/store.js';

const shoppingListStore = useShoppingListStore();
</script>

<template>
    <section>
        <h2>Shopping list</h2>
        <input v-model="shoppingListStore.newItem" type="text" placeholder="Add item" />
        <input v-model="shoppingListStore.newQuantity" type="number" min="1" placeholder="Quantity" />
        <button @click="shoppingListStore.addItem">Add</button>
    </section>
    <section>
        <ul>
            <li v-for="(item, index) in shoppingListStore.items" :key="index">
                {{ item.name }} - Quantity {{ item.quantity }}
                <button @click="shoppingListStore.removeItem(index)">Delete</button>
            </li>
        </ul>
    </section>
</template>

<style scoped>
    
</style>