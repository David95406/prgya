<script setup>
import Planet from '../classes/Planet';
import { usePlanetStore } from '../state/store';
import { computed } from 'vue';

defineProps({
  planet: Planet
})

const planetState = usePlanetStore()

const isUppercase = computed(() => planetState.getUppercase())

</script>

<template>
  <div v-if="planet" class="card" style="width: 18rem;">
    <img v-if="false" src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">{{ isUppercase ? planet.getName().toUpperCase() : planet.getName() }}</h5>
      <p class="card-text">Population: {{ isUppercase ? planet.getPopulation().toUpperCase() : planet.getPopulation() }}</p>
      <p class="card-text">Climate: {{ isUppercase ? planet.getClimate().toUpperCase() : planet.getClimate() }}</p>
    </div>
  </div>
</template>

<style scoped>
  
</style>