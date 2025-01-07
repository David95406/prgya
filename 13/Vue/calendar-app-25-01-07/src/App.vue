<script setup>
import Modal from './components/Modal.vue';
import { ref, watchEffect } from 'vue';
import { state } from './state/state';

const showModal = ref(false);
const toggleModal = (() => {
  showModal.value = !showModal.value;
})

const actualEvents = ref([[], [], [], [], [], [], []])
watchEffect(() => {
  if (state.events) {
    actualEvents.value = state.events

    actualEvents.value.forEach((day) => {
      day.sort((a, b) => { // ?
        return a.getFromTime().localCompare(b.getFromTime())
      })
    })
  }
})

const removeItem = (dayIndex, eventIndex) => {
  const eventName = state.events[dayIndex][eventIndex].getName()
  if (confirm('Biztosan törölni akarja a "' + eventName + '" eseményt?')) {
    state.events[dayIndex].splice(eventIndex, 1)
  }
}

</script>

<template>
  <Modal :show="showModal" @closeModal="toggleModal" />
  <header>
    <h1>Calendar App</h1>
  </header>

  <main>
    <section>
      <button @click="toggleModal">Add event</button>
      <table>
        <thead>
          <tr>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednesday</th>
            <th>Thursday</th>
            <th>Friday</th>
            <th>Saturday</th>
            <th>Sunday</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td v-for="(events, dayIndex) in actualEvents">
              <div v-for="(event, eventIndex) in events" class="event" :style="{ backgroundColor: event.getColor() }">
                <button @click="removeItem(dayIndex, eventIndex)">kuka</button>
                <h3>{{ event.getName() }}</h3>
                <p>{{ event.getTime() }}</p>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
  </main>

  <footer>
    <p>Copyright - All rights reserved!</p>
  </footer>
</template>

<style scoped>
h1,
footer,
.event {
  text-align: center;
}

section {
  margin: 0 auto;
  width: 90%;
}

table,
table td {
  border: 1px solid #fff;
  border-collapse: collapse;
}

table {
  width: 100%;
}

table td {
  width: calc(100% / 7);
}

td {
  padding: 5px;
}

table th {
  background-color: greenyellow;
  padding: 10px;
}

table,
.event,
button {
  color: #000;
}

.event {
  background-color: red;
  border-radius: 10px;
  padding: 10px 5px;
  margin: 10px;
}

.event,
h3,
.event p {
  margin: 0;
  padding: 0;
}
</style>