<script setup>
import { ref, watch } from 'vue';
import { products as productsFile } from './data/products';
import Product from './classes/Product';
import Kosar from './components/Kosar.vue'
import Fizetes from './components/Fizetes.vue'

const products = ref([])
productsFile.forEach((egyProduct) => {
  products.value.push(new Product(
    egyProduct["id"],
    egyProduct["name"],
    egyProduct["price"],
    egyProduct["img"]
  ))
})
const kosar = ref([])
const addToKosar = ((product) => {
  kosar.value.push(product)
  console.log("siker")
  console.log(kosar.value)
})

const kosarSize = ref(0)
watch(kosar.value, (() => {
  var ids = []
  kosar.value.forEach((product) => {
    console.log(product.getId())
    if (!ids.includes(product.getId())) {
      ids.push(product.getId())
    }
  })
  console.log(ids)
  kosarSize.value = ids.length
}))

const isKosar = ref(false)
const goToKosar = (() => {
  isKosar.value = true
  return true
})
</script>

<template>
  <header>
    <button @click="goToKosar" .disabled="kosarSize == 0">
      <p>Kosár {{ kosarSize }}</p>
    </button>
  </header>
  <main>
    <section v-if="!isKosar">
      <div v-for="product in products">
        <div class="card" style="width: 18rem;">
          <img class="card-img-top" .src="product.getImg()" .alt="product.getName()">
          <div class="card-body">
            <h5 class="card-title">{{ product.getName() }}</h5>
            <p class="card-text">{{ product.getPrice() }} Ft</p>
            <a class="btn btn-primary" @click="addToKosar(product)">Kosárba</a>
          </div>
        </div>
      </div>
    </section>

    <section>
      <div v-if="isKosar">
        <Kosar :kosar=kosar/>
      </div>
    </section>
  </main>
  <footer>
    <p>&copy;Copyright</p>
  </footer>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}

.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}

footer header {
  text-align: center;
}
</style>
