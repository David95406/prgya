<script setup>
import { reactive, ref } from 'vue'
import NoteForm from './NoteForm.vue'

const props = defineProps({
    notes: Array
})

const emit = defineEmits(['delete', 'modify'])

const targetContent = ref("")
const targetId = ref(-1)

const editViewState = reactive({
    show: false,
    open(target = null) {
        this.show = true
        targetContent.value = target.content
        targetId.value = target.id
    },
    close() {
        this.show = false
        targetContent.value = ""
        targetId.value = -1
    }
})

const deleteNote = (note) => {
    const id = note.id
    emit('delete', id)
}

const updateNote = () => {
    if (targetContent.value.length != 0 && targetId.value != -1) {
        const note = {
            id: targetId.value,
            content: targetContent.value
        }

        editViewState.close()
        emit('modify', note)
    }
}
</script>

<template>
    <ul>
        <li v-if="!editViewState.show" v-for="note in notes">
            <p>{{ note.content }}</p>
            <button @click="deleteNote(note)">Delete</button>
            <button @click="editViewState.open(note)">Modify</button>
        </li>
    </ul>
    <div v-if="editViewState.show">
        <form @submit.prevent="updateNote">
            <input v-model="targetContent" type="text">
            <button type="submit">Update</button>
            <button @click="editViewState.close">Close</button>
        </form>
    </div>
</template>

<style scoped></style>