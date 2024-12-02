<script setup>
import { defineProps, ref, defineEmits } from 'vue';
const props = defineProps({
    books: Array
})

const emits = defineEmits(
    ['back']
)

const back = (() => {
    emits('back', props.books)
})
props.books = props.books.sort((a, b) => a.getAzon() - b.getAzon())

const selectedBook = ref("Válasszon!")
const selectedBookIndex = ref(-1)
const selectBook = ((book, index) => {
    selectedBook.value = book.getName()
    selectedBookIndex.value = index
    console.log("ok")
})

const removeItem = (() => {
    if (selectedBookIndex.value != -1) {
        if (confirm("Bizosan vissza akarja adni?")) {
            props.books.splice(selectedBookIndex.value, 1)
            selectedBook.value = "Válasszon!"
            selectedBookIndex.value = -1
            alert("Sikeres vissza")
            if (props.books.length == 0) { back() }
        }
    }
})

</script>

<template>
    <div class="dropdown">
        <p>Kölcsönzött könyvek: {{ props.books.length }} db</p>
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
            aria-expanded="false">
            {{ selectedBook }}
        </a>

        <ul class="dropdown-menu">
            <li v-for="(book, index) in props.books">
                <a class="dropdown-item" @click="selectBook(book, index)">{{ book.toString() }}</a>
            </li>
        </ul>
        <br><button type="button" class="btn btn-primary" @click="removeItem">Visszaad</button>
    </div>
    <div>
        <br>
        <button type="button" class="btn btn-success" @click="back">Vissza</button>
    </div>
</template>

<style scoped></style>