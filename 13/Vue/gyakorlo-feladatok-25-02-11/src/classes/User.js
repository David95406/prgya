export default class User {
    #name
    #surname

    constructor(name, surname) {
        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setSurname(surname)
        this.setSurname = this.setSurname.bind(this)
        this.getSurname = this.getSurname.bind(this)
    }

    toString() {
        return this.getName() + ", " + this.getSurname()
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setSurname(surname) {
        this.#surname = surname
    }

    getSurname() {
        return this.#surname
    }

}