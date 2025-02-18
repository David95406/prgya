<script setup>
import { computed, ref, watch, watchEffect } from 'vue';
import { useUserState } from '../state/state';
import User from '../classes/User';

const userState = useUserState()

const name = ref(userState.getSelectedUser().getName())
const surname = ref(userState.getSelectedUser().getSurname())

watch(() => userState.getSelectedUser(), (newValue) => {
    name.value = newValue.getName();
    surname.value = newValue.getSurname();
})

const create = (() => {
    if (confirm("biztos?")) {
        userState.addUser(new User(name.value, surname.value))
    }
})

const update = (() => {
    if (confirm('biztos?')) {
        let updateedUser = new User(name.value, surname.value)
        userState.updateSelectedUser(updateedUser)
    }
})

const remove = (() => {
    if (confirm("biztos?")) {
        userState.removeSelectedUser()
    }
})
</script>

<template>
    <div>
        <label>Name</label>
        <input v-model="name" type="text">
        <label>Surname:</label>
        <input v-model="surname" type="text">
    </div>
    <div>
        <button @click="create">Create</button>
        <button @click="update">Update</button>
        <button @click="remove">Delete</button>
    </div>
</template>

<style scoped></style>