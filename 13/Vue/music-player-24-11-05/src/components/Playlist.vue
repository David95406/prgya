<script setup>
import { t as trackFile } from '../data/tracks';
import Track from '../classes/Track';
import { ref, defineEmits } from 'vue';

const tracks = []
trackFile.forEach((track) => {
    tracks.push(new Track(
        track["title"],
        track["artist"],
        track["file"]
    ))
})


const emit = defineEmits(
    ['changeTrack']
)

const changeTrack = ((track) => {
    emit('changeTrack', track)
})

</script>

<template>
    <section>
        <h2>Lejátszási lista</h2>
        <ul>
            <li v-for="track in tracks" @click="changeTrack(track)">
                {{ track.getTitle() }} - {{ track.getArtist() }}
            </li>
        </ul>
    </section>
</template>

<style scoped>
section {
    border-bottom: 1px solid #fff;
    padding-bottom: 15px;
}

ul {
    padding: 0;
    width: 70%;
}

li {
    list-style-type: none;
    background-color: lightgray;
    padding: 5px 10px;
    margin-bottom: 5px;
    border-radius: 5px;
}

li:hover {
    background-color: #efefef;
    cursor: pointer;
}
</style>