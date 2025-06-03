<script setup>
import { onMounted, reactive, ref } from 'vue';
import axios from 'axios';
import NoteList from './components/NoteList.vue';
import NoteForm from './components/NoteForm.vue';
import { CRUD_URL_NOTES } from './secret/secret';

const getUrl = (param) => {
  return CRUD_URL_NOTES + "/" + param
}

const notes = ref([])

const getNotes = async () => {
  notes.value = []

  await axios.get(CRUD_URL_NOTES)
    .then((response) => {
      const datas = response.data
      datas.forEach((data) => {
        notes.value.push({
          id: data.id,
          content: data.content
        })
      })
    })
    .catch((error) => {
      console.log(error)
    })
}
onMounted(() => getNotes())

const viewState = reactive({
  showAddNoteButton: false,
  switch() {
    this.showAddNoteButton = !this.showAddNoteButton
  },
  open() {
    this.showAddNoteButton = true
  },
  close() {
    this.showAddNoteButton = false
  }
})

const createNote = async (content) => {
  await axios.post(CRUD_URL_NOTES, {
    content: content
  })
    .then((response) => {
      console.log(response.data)
    })
    .catch((error) => {
      console.log(error)
    })
    .finally(() => viewState.close())

  getNotes()
}

const deleteNote = async (id) => {
  await axios.delete(getUrl(id))
    .then((response) => {
      console.log(response.data)
    })
    .catch((error) => {
      console.log(error)
    })
    .finally(() => getNotes())
}

const modifyNote = async (newNote) => {
  await axios.put(getUrl(newNote.id), { content: newNote.content })
    .then((response) => {
      console.log(response.data)
    })
    .catch((error) => {
      console.log(error)
    })
    .finally(() => getNotes())
}
</script>

<template>
  <header>
    <h1>Notes App</h1>
  </header>

  <main>
    <section>
      <button @click="viewState.switch">Add new Note</button>
      <div v-if="viewState.showAddNoteButton">
        <NoteForm @create="createNote" @close="viewState.close()" />
      </div>
    </section>
    <section v-if="!viewState.showAddNoteButton">
      <NoteList :notes="notes" @delete="deleteNote" @modify="modifyNote" />
    </section>
  </main>

  <footer>
    <p>Copyright</p>
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
