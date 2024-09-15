<script setup>
import { a, b, c, d } from "../data/arrays.js"
import { ref } from "vue"

const bs = ref("");

const generateBullshit = (() => {
    var ai = Math.floor(Math.random() * a.length)
    var bi = Math.floor(Math.random() * b.length)
    var ci = Math.floor(Math.random() * c.length)
    var di = Math.floor(Math.random() * d.length)
    bs.value = a[ai] + " " + b[bi] + " " + c[ci] + " " + d[di] + "."
})
</script>


<template>
    <p><img src="../assets/bs.png" alt="BullshitGenerator" title="BullshitGenerator"></p>
    <p><a class="btn" href="" @click.prevent="generateBullshit()">Bullshit generálása</a></p>
    <p v-if="bs.length != 0">Sok szituációban jól jöhet egy igazi bullshit:</p>
    <p v-if="bs.length != 0" class="bs">{{ bs }}</p>
</template>


<style scoped>
.btn,
.bs {
    background-color: #3AB982;
    padding: 10px 20px;
    border-radius: 10px;
    display: inline;
}

p {
    margin: 40px 0px;
}

.bs {
    display: block;
}

.btn:hover,
.bs {
    background-color: #34495F;
}
</style>