<script setup>
import AudioPlayer from 'vue3-audio-player'
import 'vue3-audio-player/dist/style.css'
import { defineProps, computed, ref } from 'vue';
import Track from '../classes/Track';

const props = defineProps({
    track: Track
})

const trackInfo = computed(() => {
    props.track ? props.track.getTitle() + " - " + props.track.getArtist() : "Jelenlen nincs kiválasztva szám!"
})

const getAudioUrl = ((audioSrc) => {
    return new URL(audioSrc, import.meta.url).href
})

const audioOptions = computed(() => ({
    src: (props.track ? getAudioUrl(props.track.getFile()) : ''),
    title: (props.track ? props.track.getTitle() : 'Nincs zeneszám')
}))

const audioRef = ref(null)
const start = (() => {
    if (props.track && audioRef.value) {
        audioRef.value.play()
    } else {
        alert("Nincs zene")
    }
})

const stop = (() => {
    if (props.track && audioRef.value) {
        audioRef.value.pause()
    }
})

</script>

<template>
    <section v-if="props.track">
        <h2>Jelenlegi szám: {{ props.track.getTitle() }}</h2>
        <AudioPlayer ref="audioRef" :option="audioOptions" />
        <button @click="start()">Lejátszás</button>
        <button @click="stop()">Megállítás</button>

    </section>
    <section v-else>
        <h2>Jelenlen nincs kiválasztva szám!</h2>
    </section>

    <!--
    <section>
        <h2>Jelenlegi szám: {{ trackInfo }}</h2>
        <AudioPlayer />
        <button>Lejátszás</button>
        <button>Megállítás</button>
    </section>-->
</template>

<style scoped>
section {
    text-align: center;
}

h2 {
    font-size: 20px;
}

button {
    margin: 5px;
    padding: 10px 10px;
    border: none;
    color: #fff;
    background-color: #007bff;
    border-radius: 5px;
}
</style>