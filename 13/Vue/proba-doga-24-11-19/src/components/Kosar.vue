<script setup>
import { defineProps, ref, watch, defineEmits } from 'vue';
import Product from '../classes/Product';

const props = defineProps({
    kosar: Array
})
var osszar = 0
props.kosar.forEach((product) => {
    osszar += product.getPrice() * product.getDarabszam()
})
const vegsoKosar = ref(props.kosar)

const emit = defineEmits(
    ['back'],
    ['fizetes']
)

const back = (() => {
    emit('back')
})

const goToFizetes = (() => {
    emit('fizetes', vegsoKosar.value)
})


const removeItem = ((index) => {
    props.kosar[index].decreaseDarabszam() //nem reaktiv
    vegsoKosar.value[index].decreaseDarabszam()
})
</script>

<template>
    <div>
        <button @click="back">Vásárlás</button>
        <button @click="goToFizetes">Fizetés</button>
    </div>

    <div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Termék</th>
                    <th scope="col">darabszám</th>
                    <th scope="col">Ár</th>
                    <th scope="col">Törlés</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(egyProduct, index) in props.kosar">
                    <th scope="row">{{ egyProduct.getName() }}</th>
                    <td>{{ egyProduct.getDarabszam() }}</td>
                    <td>{{ egyProduct.getPrice() * egyProduct.getDarabszam() }} Ft</td>
                    <td @click="removeItem(index)">Törlés</td>
                </tr>
            </tbody>
        </table>
    </div>
    <span class="osszar">Összár: {{ osszar }} Ft</span>
</template>

<style scoped></style>