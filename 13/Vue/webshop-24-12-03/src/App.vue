<script setup>
import { ref } from 'vue';
import Cart from './components/Cart.vue';
import Products from './components/Products.vue';

const productsSize = ref(-1);
const updateProductsSize = ((newSize) => productsSize.value = newSize);
</script>

<template>
  <header>
    <h1>Cart App</h1>
  </header>
  <main>
    <div class="container">
      <div class="row">
        <div class="col-lg-3">
          <Cart />
        </div>
        <div class="col-lg-9">
          <Products @productsSize="updateProductsSize" />
        </div>
      </div>
    </div>
  </main>
  <footer>
    <div class="container">
      <p class="text-end fw-bold mt-2"># of products {{ productsSize }}</p>
    </div>
  </footer>
</template>

<style scoped></style>