<script setup>
import { p as productsData } from '../data/productData';
import { ref, computed, defineEmits, watchEffect } from 'vue';
import Product from '../classes/Product';
import { state } from '../state/state';

const emit = defineEmits(['productsSize']);

const search = ref("");
const result = computed(() => {
    var returnValue = productsData.filter((product) =>
    (product.name.toLowerCase().includes(search.value.toLowerCase()) ||
        product.desc.toLowerCase().includes(search.value.toLowerCase()) ||
        product.price == search.value)
    )

    emit('productsSize', returnValue.length)
    return returnValue
})

const newProduct = ref()
const addToCart = ((product) => {
    newProduct.value = {...(new Product(product.name, product.price, 1))}
})

watchEffect(() => {
    state.product = newProduct.value
})



</script>

<template>
    <section>
        <h2>Products</h2>
        <div class="mb-3">
            <input v-model="search" type="search" class="form-control" placeholder="Filter...">
        </div>
        <div v-for="(product, index) in result" class="products">
            <div class="product d-flex">
                <h3>{{ product.name }}</h3>
                <p>{{ product.desc }}</p>
                <p class="price">$ {{ product.price }}</p>
                <button @click="addToCart(product)" type="button" class="btn">Add to Cart</button>
            </div>
        </div>
    </section>
</template>

<style scoped>
section {
    background-color: #fff;
    padding: 20px;
    border-radius: 15px;
}

.form-control {
    border: 10px solid #ccc;
    margin-top: 10px;
}

h3 {
    font-size: 20px;
}

.product {
    border-bottom: 1px solid #ccc;
    padding-top: 15px;
    align-items: center;
}

.product:last-child {
    border-bottom: none;
}

.btn {
    width: 200px;
    margin-left: 144px;
}
</style>