<script setup>
import Hazfelujitas from './components/Hazfelujitas.vue';
import Room from './classes/Room';
import { rooms } from './data/rooms';
import { ref, watch } from 'vue';

const roomList = ref([])
rooms.forEach((room) => {
    roomList.value.push(new Room(
        room["id"],
        room["name"],
        room["options"]
    ))
})
const selectedRoom = ref(null)


const felujitandoRooms = ref([])
const updateFelujitas = (felujitandoRoom) => {
    const index = felujitandoRooms.value.findIndex((room) => room.getId() == felujitandoRoom.getId())

    if (index == -1) {
        felujitandoRooms.value.push(felujitandoRoom)
    } else {
        felujitandoRooms.value[index] = felujitandoRoom
    }
}

const getOsszKoltseg = (() => {
    var osszKoltseg = 0
    felujitandoRooms.value.forEach((room) => {
        osszKoltseg += room.getPrice()
    })

    return osszKoltseg
})

const isOsszegzes = ref(false)
const osszegzes = (() => {
    isOsszegzes.value = confirm("Biztos?")
})

</script>

<template>

    <header>
        <h1>Házfelújítás</h1>
    </header>
    <main>
        <section v-if="!isOsszegzes">
            <h3>Helyiség</h3>
            <select v-model="selectedRoom">
                <option v-bind:value="null" selected>...</option>
                <option v-for="room in roomList" v-bind:value="room">{{ room.getName() }}</option>
            </select>
            <div v-if="selectedRoom">
                <Hazfelujitas :room="selectedRoom" @onOptionChange="updateFelujitas" />
            </div>
            <button v-if="felujitandoRooms.length != 0" @click="osszegzes">Összegzés</button>

        </section>
        <section v-else>
            <div>
                <h3>Összegzés</h3>
                <div v-for="room in felujitandoRooms">
                    <p>{{ room.getName() }}</p>
                    <ul>
                        <li v-for="job in room.getOptions()">{{ job }}</li>
                    </ul>
                </div>
                <p>Becsült költség: {{ getOsszKoltseg() }} Ft</p>
            </div>
        </section>
    </main>
    <footer>
        <hr>
        <p>&copy;Copyright</p>
    </footer>
</template>

<style scoped></style>
