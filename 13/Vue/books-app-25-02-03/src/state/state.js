import { ref } from "vue";
import { defineStore } from "pinia";

export const useBooksState = defineStore('books_state', (() => {
    const books = ref([])

    function getBooks() {
        return books.value
    }

    function addBook(book) {
        books.value.push(book)
    }

    function clearState() {
        books.value = []
    }

    function editBook(index, newBook) {
        books.value.splice(index, 1, newBook)
        //books.value[index] = newBook
    }

    return {
        getBooks,
        addBook,
        clearState,
        editBook
    }
}))