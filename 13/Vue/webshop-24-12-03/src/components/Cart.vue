<script setup>
import { state } from '../state/state';
import Product from '../classes/Product';
import { ref, watch, watchEffect } from 'vue';

const cartProduct = ref([])
const summa = ref(0)
const pieces = ref(0)
watchEffect(() => {
    if (state.product) {
        let index = cartProduct.value.findIndex((product) => {
            return product.getName() == state.product.getName()
        })

        if (index == -1) {
            cartProduct.value.push(state.product)
        } else {
            cartProduct.value[index].addPiece()
        }
        cartProduct.value = [...cartProduct.value]

        summa.value = pieces.value = 0
        cartProduct.value.forEach((product) => {
            summa.value += product.getPrice() * product.getPiece()
            pieces.value += product.getPiece()
        })
    }
})

const checkout = (() => {
    if (confirm("Biztosan?")) {
        cartProduct.value = []
        state.product = null
        summa.value = 0
        pieces.value = 0
    }
})

</script>

<template>
    <aside>
        <h2>Cart</h2>
        <div v-for="product in cartProduct" class="cartProduct">
            <h3>{{ product.getName() }}</h3>
            <div class="d-flex">
                <div class="price">$ {{ product.getPrice() }}</div>
                <div class="quantity">Quantity: {{ product.getPiece() }}</div>
            </div>
        </div>
        <div v-if="cartProduct.length > 0">
            <div class="total">Total quantity: {{ pieces }}</div>
            <div class="mb-3">
                <button @click="checkout" class="btn w-100">Checkout $ {{ summa }}</button>
            </div>
        </div>
        <div v-else>
            <p>A kosár üres!</p>
        </div>
    </aside>
</template>

<style scoped>
aside {
    margin-top: 30px;
}

h3 {
    font-size: 18px;
}

.d-flex {
    justify-content: space-between;
    margin-bottom: 10px;
    padding-bottom: 15px;
    border-bottom: 1px solid #ccc;
}

.price {
    color: #3AB982;
    font-weight: 700;
}

.btn {
    margin-top: 15px;
}
</style>