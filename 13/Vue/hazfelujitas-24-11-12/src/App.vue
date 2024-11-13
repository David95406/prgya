<script setup>
import { ref, watch } from "vue";
import { rooms } from "./data/rooms"

const roomData = ref(rooms)
const helyiseg = ref("")
const options = ref([])

watch(helyiseg, () => {
  options.value = roomData.value.find(room => room.name == helyiseg.value).options
})

</script>

<template>
  <header>
    <h1>Házfelújítás</h1>
  </header>
  <main>
    <section>
      <form>
        <div class="mb-3">
          <label class="form-label">Helyiség:</label>
          <select class="form-select" v-model="helyiseg">
            <option value="">Válasszon</option>
            <option v-for="room in roomData" :value="room.name">{{ room.name }}</option>
          </select>
        </div>
        <div v-if="helyiseg">
          <div class="mb-3">
            <label class="form-label">Felújitási munka:</label>
            <div class="form-check" v-for="munka in options">
              <input class="form-check-input" type="checkbox" :value="munka" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                {{ munka }}
              </label>
            </div>
          </div>
          <div class="mb-3">
            <label class="form-label">Becsült összeg:</label>
            <input type="number" class="form-control">
          </div>
          <div class="mb-3">
            <button type="button" class="btn btn-warning">Tovább</button>
          </div>
        </div>
        <div v-else>
          <span>Nincs kijelölve helyiség</span>
        </div>
      </form>
    </section>
  </main>
  <footer>
    <p>&copy;Copyright</p>
  </footer>
</template>

<style scoped>
form {
  width: 80%;
  margin: 30px auto;
}

label {
  font-weight: 600;
}

.form-check {
  padding-left: 40px;
}
</style>
