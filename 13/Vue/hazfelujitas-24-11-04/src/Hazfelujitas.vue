<script setup>
import { ref, watch, defineProps, defineEmits } from 'vue';
import Room from '../classes/Room';

const emit = defineEmits(
    ['onOptionChange'],
)

const props = defineProps({
    room: Object
})
const room = props.room //legyen ref

const felujitandoRoom = ref(new Room(
    room.getId(),
    room.getName(),
    []
))

const changeFelujitando = ((job) => {
    console.log(job)
    if (!felujitandoRoom.value.getOptions().includes(job)) {
        felujitandoRoom.value.addOption(job)
    } else {
        felujitandoRoom.value.removeOption(job)
    }
    console.log(felujitandoRoom.value.getOptions())
    emit('onOptionChange', felujitandoRoom.value)
})

const osszeg = ref(0)
watch(osszeg, ((osszeg) => { //nem kell .value
    console.log(osszeg)
    felujitandoRoom.value.setPrice(osszeg)
    emit('onOptionChange', felujitandoRoom.value)
}))


</script>

<template>
    <div>
        <span>Felujitasi munka:</span>
        <div v-for="job in room.getOptions()" :key="job">
            {{ job }}<input type="checkbox" @click.prevent="changeFelujitando(job)"
                :checked="felujitandoRoom.getOptions().includes(job)"> 
        </div>
    </div>
    <div>
        <span>Becsült összeg:</span>
        <input type="number" v-model="osszeg" min="0">
    </div>
</template>

<style scoped></style>