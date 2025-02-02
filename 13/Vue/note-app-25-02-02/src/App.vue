<script setup>
import ShowNote from './components/ShowNote.vue';
import Note from './classes/Note';
import { ref } from 'vue';
import { notes as noteSate } from './state/state';

const notes = noteSate()
const newNote = ref("")

const addNewNote = (() => {
  if (confirm("Hozzáadás?")) {
    notes.addNote(new Note(newNote.value))
    newNote.value = ""
  } 
})
</script>

<template>
  <header></header>
  <main>
    <section>
      <ShowNote />
    </section>
    <section>
      <form @submit.prevent="addNewNote">
        <input v-model="newNote" type="text" placeholder="Enter a note">
      </form>
    </section>
    <section>
      <p>Note count: <b>{{ notes.getLength() }}</b></p>
    </section>
  </main>
  <footer>
    <p>Copyright &copy;</p>
  </footer>
</template>

<style scoped>
input {
  width: 700px;
  height: 25px;
}
</style>