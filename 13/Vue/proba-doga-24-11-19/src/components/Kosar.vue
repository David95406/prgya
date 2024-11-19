<script setup>
import { defineProps, ref, watch } from 'vue';
import Product from '../classes/Product';

const props = defineProps({
    kosar: Array
})


</script>

<template>
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
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped></style>