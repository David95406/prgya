<script setup>
import { ref } from 'vue';
import ButtonComponent from './components/ButtonComponent.vue';
import ToggleButton from './components/ToggleButton.vue';
import FormComponent from './components/FormComponent.vue';
import ItemList from './components/ItemList.vue';
import ParentComponent from './components/ParentComponent.vue';
import ChildComponent from './components/ChildComponent.vue';

const onclick = (() => {
  alert("ok")
})

const toggleButtonChecked = ref(true)
const handleButtonUpdate = (() => {
  console.log("ok")
  toggleButtonChecked.value = !toggleButtonChecked.value
})


const items = ['alma', 'banan', 'narancs', 'balna']
const showSelectedItem = (item) => {
  alert(item)
}
</script>

<template>
  <h1>Hello</h1>
  <ButtonComponent @onClick="onclick"/>
  <br><br>
  <ToggleButton :checked="toggleButtonChecked" @update="handleButtonUpdate"/>
  <br><br>
  <FormComponent />
  <br><br>
  <ItemList :items="items" @item-selected="showSelectedItem"/>
  <br><br>
  <ParentComponent />
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
