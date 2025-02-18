import { defineStore } from "pinia";
import { ref } from "vue";

export const useUserState = defineStore('user-state', (() => {
    const users = ref([])
    const selectedUserIndex = ref(0)

    function getUsers() {
        return users.value
    }

    function addUser(newUser) {
        users.value.push(newUser)
    }

    function getUserFromIndex(index) {
        return users.value[index]
    }

    function setSelectedUserIndex(index) {
        selectedUserIndex.value = index
    }

    function getSelectedUserIndex() {
        return selectedUserIndex.value
    }

    function getSelectedUser() {
        return users.value[selectedUserIndex.value]
    }

    function removeUser(index) {
        users.value.splice(index, 1)
    }

    function removeSelectedUser() {
        users.value.splice(selectedUserIndex.value, 1)
    }

    function updateSelectedUser(updateedUser) {
        users.value.splice(selectedUserIndex.value, 1, updateedUser)
    }

    return {
        getUsers,
        addUser,
        getUserFromIndex,
        setSelectedUserIndex,
        getSelectedUserIndex,
        getSelectedUser,
        removeUser,
        removeSelectedUser,
        updateSelectedUser
    }
}))
