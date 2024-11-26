export default class Book {
    #azon
    #name
    #authors
    #img

    constructor(azon, name, authors, img) {
        this.setAzon(azon)
        this.setAzon = this.setAzon.bind(this)
        this.getAzon = this.getAzon.bind(this)

        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setAuthors(authors)
        this.setAuthors = this.setAuthors.bind(this)
        this.getAuthors = this.getAuthors.bind(this)

        this.setImg(img)
        this.setImg = this.setImg.bind(this)
        this.getImg = this.getImg.bind(this)
    }

    setAzon(azon) {
        this.#azon = azon
    }

    getAzon() {
        return this.#azon
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setAuthors(authors) {
        this.#authors = authors
    }

    getAuthors() {
        return this.#authors
    }

    setImg(img) {
        this.#img = img
    }

    getImg() {
        return this.#img
    }

}