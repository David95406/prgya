<script setup>
import { ref } from 'vue';
import Cart from './components/Cart.vue';
import Products from './components/Products.vue';
import Snowflake from './classes/Snowflake';

const productsSize = ref(-1);
const updateProductsSize = ((newSize) => productsSize.value = newSize);

var snowinterval = setInterval(() => {
  var area = document.querySelector('.snowcontainer');
  const x = Math.random() * area.offsetWidth;
  const newSnowflake = new Snowflake(x, 0, Math.random() * 2 + 1, '.snowcontainer');
  newSnowflake.fall()
}, 800);
</script>

<template>
  <div class="snowcontainer">

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
  </div>
</template>

<style scoped></style>