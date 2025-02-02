import { defineStore } from "pinia";
import { ref } from "vue";

export const notes = defineStore("notes", (() => {
    const notes = ref([]);

    function addNote(note) {
        notes.value.push(note)
    }

    function getNotes() {
        return notes.value
    }

    function getLength() {
        return notes.value.length
    }

    return {
        addNote,
        getNotes,
        getLength
    }
}))