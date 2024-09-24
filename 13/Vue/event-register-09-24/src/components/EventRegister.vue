<script setup>
import { ref, watch } from 'vue';
import { Guest } from '../classes/Guests';

const newUser = ref(null)
const userList = []

const seats = ref(3);
const errorMessages = ["Fill the name!", "Fill the email!", "Fill the password!", "Fill the select!", "Fill the pet's name!"]

//inputs
const nameInput = ref("")
const emailInput = ref("")
const passwordInput = ref("")
const isPetInput = ref(null)
const petNameInput = ref("")
const errorMessage = ref("")

const saveUser = () => {
    errorMessage.value = ""

    if (nameInput.value == "") {
        errorMessage.value = errorMessages[0]
    } else if (emailInput.value == "") {
        errorMessage.value = errorMessages[1]
    } else if (passwordInput.value == "") {
        errorMessage.value = errorMessages[2]
    } else if (isPetInput.value === null) {
        errorMessage.value = errorMessages[3]
    } else if (isPetInput.value && petNameInput.value == "") {
        errorMessage.value = errorMessages[4]
    } else {
        //const ujUser = new Guest(nameInput.value, emailInput.value, ((isPetInput.value) ? petNameInput.value : "X"))
        newUser.value = {
            "name": nameInput.value,
            "email": emailInput.value,
            "pet": {
                "name": petNameInput.value,
                "isPet": isPetInput.value
            }
        }
        userList.push(newUser)
        console.log(userList)
        seats.value--

        //clear
        nameInput.value = ""
        emailInput.value = ""
        passwordInput.value = ""
        isPetInput.value = ""
        petNameInput.value = ""
    }
}

const reset = () => {
    location.reload()
    //userList = []
    //seats.value = 3
}

/*
watch (isPetInput.value, (isPet) => {
    if (!isPet) {
        petNameInput.value = ""
    }
})
*/

</script>

<template>
    <div v-if="seats > 0">
        <h1>Registration App</h1>
        <p>Free seats: {{ seats }}</p>
        <p>Hurry up!</p>
        <form @submit.prevent="saveUser">
            <p v-if="errorMessage.length != 0" class="error">{{ errorMessage }}</p>

            <label for="name">Name:</label>
            <input type="text" v-model="nameInput">

            <label for="email">Email:</label>
            <input type="email" v-model="emailInput">

            <label for="password">Password:</label>
            <input type="password" v-model="passwordInput">

            <label for="pet-select">Do your bring any pet?</label>
            <select v-model="isPetInput">
                <option v-bind:value="null">Choose!</option>
                <option v-bind:value="true">Yes</option>
                <option v-bind:value="false">No</option>
            </select>

            <div v-if="isPetInput">
                <label for="pet-name">Pet?</label>
                <input type="text" v-model="petNameInput">
            </div>

            <button type="submit">Mentés</button>
        </form>
    </div>
    <div v-else>
        <p>No more seats!</p>
        <table>
            <caption>Registered guests</caption>
            <thead>
                <tr>
                    <th>name</th>
                    <th>Email</th>
                    <th>pet</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in userList">
                    <td>{{ user.value.name }}</td>
                    <td>{{ user.value.email }}</td>
                    <td>{{ user.value.pet.isPet ? user.value.pet.name : "X" }}</td>
                </tr>
            </tbody>
        </table>
        <button @click="reset">Reset</button>
    </div>
</template>

<style scoped>
p {
    font-weight: 700;
    text-align: center;
}

label,
input,
select {
    display: block;
}

label {
    color: #34495F;
    font-weight: 700;
    padding: 5px 0px;
}

input,
select {
    width: calc(100% - 10px);
    padding: 5px;
}

select {
    width: 100%;
}

button {
    background-color: #3AB982;
    padding: 10px 20px;
    text-transform: uppercase;
    border: none;
    margin: 20px auto 0 auto;
    display: block;
    cursor: pointer;
}

button:hover {
    background-color: #34495F;
}

button,
.error {
    color: #fff;
}

.error {
    background-color: red;
    padding: 5px 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
}

td,
th {
    padding: 5px;
    border: 1px solid #000;
}
</style>