<script setup>
import { computed, ref } from 'vue'
import { useSzerepjatekKarakterek } from '../state/state'

const props = defineProps({
    karakterek: Array,
    isHome: Boolean
})

const emit = defineEmits(['kivalaszt'])

const kivalaszt = (index) => {
    emit('kivalaszt', index)
}
</script>

<template>
    <table class="table">
        <thead>
            <tr>
                <th>Név</th>
                <th>Faj</th>
                <th>Szint</th>
                <th v-if="isHome">Kivalaszt</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(karakter, index) in karakterek">
                <td>{{ karakter.getNev() }}</td>
                <td>{{ karakter.getFaj() }}</td>
                <td>{{ karakter.getSzint() }}</td>
                <td v-if="isHome">
                    <button @click="kivalaszt(index)">Kérem!</button>
                </td>
            </tr>
        </tbody>
    </table>
</template>

<style scoped></style>