<script setup>
import { ref, defineProps, defineEmits } from 'vue';

const props = defineProps({
    kosar: Array
})

const emit = defineEmits(
    ['vegso_fizetes']
)

const fizetes = (() => {
    emit('vegso_fizetes')
    //clear
})
</script>

<template>
    <div>
        <div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Termék</th>
                        <th scope="col">darabszám</th>
                        <th scope="col">Ár</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(egyProduct, index) in props.kosar">
                        <th scope="row">{{ egyProduct.getName() }}</th>
                        <td>{{ egyProduct.getDarabszam() }}</td>
                        <td>{{ egyProduct.getPrice() * egyProduct.getDarabszam() }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <button @click="fizetes">Fizetés</button>
    </div>
</template>

<style scoped></style>