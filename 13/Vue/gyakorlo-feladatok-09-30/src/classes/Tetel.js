export default class Tetel {
    #name
    #price

    #setName(name) {
        this.#name = name
    }

    #setPrice(price) {
        this.#price = price
    }

    getName() {
        return this.#name
    }

    getPrice() {
        return this.#price
    }

    constructor(name, price) {
        this.#setName(name)
        this.#setPrice(price)
    }

    toString() {
        return this.getName() + ": " + this.getPrice() + "Ft."
    }
}