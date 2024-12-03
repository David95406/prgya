<script setup>
import { defineProps, defineEmits } from 'vue'

const props = defineProps({
    students: Array,
})

const emit = defineEmits(
    ['back']
)

const atlagosHianyzas = (() => {
    var sum = 0;
    props.students.forEach((student) => {
        sum += student.getAbsences();
    })
    return (sum / props.students.length);
})

const legjobbTanulo = (() => {
    var legjobb = props.students[0];
    props.students.forEach((student) => {
        if (student.getAtlag() > legjobb.getAtlag()) {
            legjobb = student;
        }
    })
    return legjobb;
})

const legrosszabbTanulo = (() => { //ism
    var legrosszabb = props.students[0];
    props.students.forEach((student) => {
        if (student.getAtlag() < legrosszabb.getAtlag()) {
            legrosszabb = student;
        }
    })
    return legrosszabb;
})

const legtobbetHianyzott = (() => {
    var legtobbet = props.students[0];
    props.students.forEach((student) => {
        if (student.absences > legtobbet.absences) {
            legtobbet = student;
        }
    })
    return legtobbet;
})

const back = (() => {
    emit('back')
})

</script>

<template>
    <div>
        <h1>Statisztika</h1>
        <p>Átlagos hiányzás: {{ atlagosHianyzas() }} nap</p>
        <p>A legjobb tanuló: {{ legjobbTanulo().getName() }}</p>
        <p>A legrosszabb tanuló: {{ legrosszabbTanulo().getName() }}</p>
        <p>A legtöbbet hiányzó tanuló: {{ legtobbetHianyzott().getName() }} ({{ legtobbetHianyzott().getAbsences() }}
            nap)
        </p>
    </div>
    <button @click="back">Vissza</button>
</template>

<style scoped></style>