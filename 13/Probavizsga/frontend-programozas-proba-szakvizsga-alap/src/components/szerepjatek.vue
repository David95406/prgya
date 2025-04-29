<script setup>
import { ref } from 'vue';
const fajok = ['ember', 'ork', 'elf', 'törpe'];
const kivalasztottFaj = ref('');
</script>

<template>
  <div class="faj-valaszto">
    <h2>Faj választása</h2>
    <select v-model="kivalasztottFaj" class="form-select">
      <option disabled value="">Válassz egy fajt...</option>
      <option v-for="faj in fajok" :key="faj" :value="faj">
        {{ faj }}
      </option>
    </select>
    <div v-if="kivalasztottFaj" class="faj-leiras mt-3">
      <p>Kiválasztott faj: <strong>{{ kivalasztottFaj }}</strong></p>
    </div>
  </div>
</template>
<style scoped>
.faj-valaszto {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
}

.form-select {
  width: 100%;
  padding: 8px;
  margin-top: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
</style>