<script setup>
import { notes as noteState } from '../state/state';

const notes = noteState()
</script>

<template>
    <div class="notes-box">
        <div class="notes">
            <h3>Notes</h3>
            <p v-for="note in notes.getNotes()">
                {{ note.getText() }}
            </p>
        </div>
        <div class="timestamp">
            <h3>Timestamp</h3>
            <p v-for="note in notes.getNotes()">
                {{ note.getTime() }}
            </p>
        </div>
    </div>
</template>

<style scoped>
.notes-box {
    display: inline-flex;
}

.notes {
    padding-right: 100px;
}

.timestamp {
    padding-left: 100px;
}
</style>