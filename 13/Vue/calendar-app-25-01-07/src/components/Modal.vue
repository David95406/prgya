<script setup>
import { ref, defineProps, defineEmits, watch } from 'vue';
import { state } from '../state/state.js'
import Event from '../classes/Event.js';

const props = defineProps({
    show: Boolean,
})
//const show = computed(() => props.show)

const emit = defineEmits(
    ['closeModal', 'addEvent']
)

const closeModal = (() => {
    emit('closeModal')
})


const dayInput = ref(0)
const nameInput = ref("")
const fromInput = ref("")
const toInput = ref("")
const add = (() => {
    const newEvent = new Event(
        nameInput.value,
        fromInput.value,
        toInput.value,
    )

    state.events[dayInput.value].push(newEvent)

    dayInput.value = 0
    nameInput.value = ""
    fromInput.value = ""
    toInput.value = ""
    closeModal()
})

</script>

<template>
    <div class="modal" v-if="show">
        <h2>Add event</h2>
        <p>
            <label>Day:</label>
            <select v-model="dayInput">
                <option :value="0">Monday</option>
                <option :value="1">Tuesday</option>
                <option :value="2">Wednesday</option>
                <option :value="3">Thursday</option>
                <option :value="4">Friday</option>
                <option :value="5">Saturday</option>
                <option :value="6">Sunday</option>
            </select>
        </p>
        <p>
            <label>Name:</label>
            <input v-model="nameInput" type="text" />
        </p>
        <p>
            <label>From:</label>
            <input v-model="fromInput" type="time" />
        </p>
        <p>
            <label>To:</label>
            <input v-model="toInput" type="time" />
        </p>
        <p class="buttons">
            <button @click="closeModal">Cancel</button>
            <button @click="add">Add</button>
        </p>
    </div>
</template>

<style scoped>
.modal {
    width: 300px;
    background-color: #efefef;
    color: #000;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 20px 30px;
}

h2 {
    margin: 0;
    padding: 0 0 10px 0;
    border-bottom: 1px solid #aaa;
}

label,
button {
    font-weight: 700;
}

label,
input,
select {
    display: block;
    width: 100%;
}

label,
input,
select,
button {
    border: none;
}

input,
select {
    padding: 7px 10px;
    width: calc(100% - 20px);
}

select {
    width: 100% !important;
}

.buttons,
h2 {
    text-align: center;
}

.buttons button {
    padding: 10px 20px;
    margin: 0px 10px;
    border-radius: 10px;
    color: #fff;
}

.buttons button:first-child {
    background-color: red;
}

.buttons button:last-child {
    background-color: green;
}
</style>