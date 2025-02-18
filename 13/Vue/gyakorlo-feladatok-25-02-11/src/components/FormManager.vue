<script setup>
import { ref } from 'vue'

const textInput = ref('')
const checkbox = ref(false)
const multiCheckbox = ref([])
const names = ['Jack', 'John', 'Mike']
const radioOptions = ['One', 'Two']
const selectedRadio = ref(null)
const selectOptions = ['A', 'B', 'C']
const selectedOption = ref(selectOptions[0])
const multiSelect = ref([])
</script>

<template>
    <div>
        <h2>Beviteli mezok</h2>

        <label>Szovegmezo:</label>
        <input v-model="textInput" type="text" />
        <p>Beirt szoveg: {{ textInput }}</p>

        <label>
            <input type="checkbox" v-model="checkbox" /> Egyszeru checkbox
        </label>
        <p>Checkbox allapota: {{ checkbox }}</p>

        <label>Multi Checkbox:</label>
        <div v-for="name in names" :key="name">
            <input type="checkbox" :value="name" v-model="multiCheckbox" /> {{ name }}
        </div>
        <p>Kivalasztott: {{ multiCheckbox }}</p>

        <label>Radio valasztogomb:</label>
        <div v-for="option in radioOptions" :key="option">
            <input type="radio" :value="option" v-model="selectedRadio" /> {{ option }}
        </div>
        <p>Kivalasztott: {{ selectedRadio }}</p>

        <label>Lenyilo lista:</label>
        <select v-model="selectedOption">
            <option v-for="option in selectOptions" :key="option" :value="option">{{ option }}</option>
        </select>
        <p>Kivalasztott: {{ selectedOption }}</p>

        <label>Multi Select:</label>
        <select v-model="multiSelect" multiple>
            <option v-for="option in selectOptions" :key="option" :value="option">{{ option }}</option>
        </select>
        <p>Kivalasztott: {{ multiSelect }}</p>
    </div>
</template>