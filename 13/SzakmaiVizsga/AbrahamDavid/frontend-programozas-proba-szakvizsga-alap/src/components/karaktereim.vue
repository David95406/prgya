<script setup>
import { computed } from 'vue';
import { useSzerepjatekKarakterek } from '../state/state';
import karakterLista from './karakterLista.vue';

const szerepjatekKarakterek = useSzerepjatekKarakterek()
const karakterek = computed(() => szerepjatekKarakterek.getUserKarakterek())

</script>

<template>
    <section>
        <h2>Saját karakterek</h2>
        <karakterLista :isHome="false" :karakterek="karakterek"/>
    </section>
</template>

<style scoped>
</style>
