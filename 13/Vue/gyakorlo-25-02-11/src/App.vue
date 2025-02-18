<script setup>
import { ref, watch } from 'vue';
import HelloWorld from './components/HelloWorld.vue';
import UserManager from './components/UserManager.vue';
import User from './classes/User';
import users from './data/users';
import { useUserState } from './state/state';
import { computed } from 'vue';
import gridData from './data/gridData';
import Grid from './classes/Grid';
import GridTable from './components/GridTable.vue';
import ListManager from './components/ListManager.vue';
import Modal from './components/Modal.vue';

const userState = useUserState()

users.forEach((user) => {
  let newUser = new User(user['name'], user['surname'])
  userState.addUser(newUser)
})

const filterValue = ref("")
const filteredUsers = computed(() => {
  return userState.getUsers().filter((user) => user.toString().toLowerCase().includes(filterValue.value.toLowerCase()))
})

const selectedUserIndex = ref(0)
watch(selectedUserIndex, (() => {
  userState.setSelectedUserIndex(selectedUserIndex.value)
}))

//2 - szures es rendezes
const sortGrid = ref("")

const grids = ref([])
gridData.forEach((grid) => {
    grids.value.push(new Grid(grid.name, grid.power))
})

//3 - modal
const showModal = ref(false)
const handleModal = (() => {
  showModal.value = !showModal.value
})
</script>

<template>
  <header>

  </header>
  <main>
    <section>
      <input type="text" v-model="filterValue">
      <br>
      <select size="5" v-model="selectedUserIndex">
        <option v-for="(user, index) in filteredUsers" :value="index">{{ user.toString() }}</option>
      </select>
    </section>
    <section>
      <UserManager />
    </section>

    <section>
      <br><br>
      <input v-model="sortGrid" type="text" placeholder="Search...">
      <GridTable :filter="sortGrid" :grids="grids"/>
    </section>
    <section>
      <br><br>
      <HelloWorld/>
    </section>
    <section>
      <br><br>
      <ListManager/>
    </section>
    <section>
      <button @click="handleModal">Show Modal</button>
      <Modal v-if="showModal"/>
    </section>
  </main>
  <footer>

  </footer>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}

.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}

.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}

</style>
