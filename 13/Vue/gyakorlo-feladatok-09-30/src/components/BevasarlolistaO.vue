<script setup>
import { ref } from "vue";
import "../classes/Tetel"

const errorMessage = ref("")
const errorMessages = ["A név csak az angol ábécé kisbetűit tartalmazhatja, maximum 30 karakter hosszúságig!", "Az ár csak pozitív egész szám lehet, maximum értéke 1 millió forint."]
const nameInput = ref("")
const priceInput = ref(0)

const bevasarlolista = ref([])
const t = new Tetel("asd", 12)
bevasarlolista.value.push(t)
console.log(bevasarlolista.value[0])
console.log("Hello")
console.log(t.toString())
console.log(t.getName())
const igen = bevasarlolista.value[0]
console.log(igen.toString())

const regex = /^[a-z0-9 ]{1,30}$/;

function testName(name) {
    console.log(regex.text("asd"))
    return regex.test(name)
}

const addToList = (() => {
    errorMessage.value = ""
    if (testName(nameInput.value)) {
        if (priceInput.value > 0 && priceInput.value <= 1000000) {
            bevasarlolista.value.push(new Tetel(nameInput.value, priceInput.value))
        } else {
            errorMessage.value = errorMessages[1]
        }

    } else {
        errorMessage.value = errorMessages[0]
    }
})

const sortPrice = (() => {
    bevasarlolista.value.sort((a, b) => a.getPrice() - b.getPrice())
})

const sortName = (() => {
    bevasarlolista.value.sort((a, b) => a.getName().localeCompare(b.getName()))
})

</script>

<template>
    <div class="bl_form">
        <form @submit.prevent="addToList">
            <label for="nameInput">Név: </label>
            <input type="text" name="nameInput" v-model="nameInput" required>

            <br>

            <label for="priceInput">Ár: </label>
            <input type="number" name="priceInput" v-model="priceInput" required>

            <br>
            <span class="error">{{ errorMessage }}</span>
            <button class="btn" type="submit">Hozzáadaás</button>
        </form>
    </div>


    <button class="btn" @click="sortPrice">Ár szerint</button>
    <button class="btn" @click="sortName">Név szerint</button>
    <br>
    <div v-if="bevasarlolista.length != 0" v-for="(egyTetel, index) in bevasarlolista">
        <div class="itemCard">
            <p>{{ egyTetel.getName() }}</p>
            <p>{{ egyTetel.getPrice() }}</p>
            <button class="btn delete-btn" @click="bevasarlolista.splice(index, 1)">Törlés</button>
        </div>
    </div>
    <div v-else>
        <p>A lista üres!</p>
    </div>
</template>

<style scoped>
.error {
    color: red;
}

.itemCard {
    border: 1px solid black;

}

.btn {
    background-color: black;
    color: white;
}

.delete-btn {
    background-color: #f44336;
}
</style>