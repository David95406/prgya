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
  var ids = []
  kosar.value.forEach((products) => ids.push(products.getId()))
  var isUres = true
  ids.forEach((id) => {
    if (id === product.getId()) {
      const i = kosar.value.indexOf(product)
      kosar.value[i].increaseDarabszam()
      isUres = false
    }
  })
  if (isUres) {
    kosar.value.push(product)
    console.log("siker")
    console.log(kosar.value.length)
    kosarSize.value++
  }

})

const kosarSize = ref(0)

const isKosar = ref(false)
const isFizetes = ref(false)
const setIsKosar = ((value) => {
  isKosar.value = value
})

const setIsFizetes = ((value) => {
  isFizetes.value = value
})

const goToKosar = (() => {
  setIsFizetes(false)
  setIsKosar(true)
})



const back = (() => {
  setIsKosar(false)
  setIsFizetes(false)
})

const vegsoKosar = ref(null)
const goToFizetes = ((vKosar) => {
  setIsKosar(false)
  setIsFizetes(true)
  vegsoKosar.value = vKosar
})

const vegsoFizetes = (() => {
  back()
  kosar.value = []
  location.reload()
})
</script>

<template>
  <header>
    <button @click="goToKosar" .disabled="kosarSize == 0">
      <p>Kosár {{ kosarSize }}</p>
    </button>
  </header>
  <main>
    <section v-if="!isKosar && !isFizetes">
      <div v-for="product in products">
        <div class="card" style="width: 18rem;">
          <img class="card-img-top" :src="product.getImg()" .alt="product.getName()">
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
        <Kosar :kosar="kosar" @back="back()" @fizetes="goToFizetes" />
      </div>
    </section>
    <section>
      <div v-if="isFizetes">
        <Fizetes :kosar="vegsoKosar" @vegso_fizetes="vegsoFizetes"/>
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
