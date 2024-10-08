export class Item {
    #name
    #price

    constructor(name, price) {
        this.#name = name
        this.#price = price

        //bind
        this.getName = this.getName.bind(this)
        this.setName = this.setName.bind(this)
        this.getPrice = this.getPrice.bind(this)
        this.setPrice = this.setPrice.bind(this)
    }

    toString() {
        return this.getName() + ": " + this.getPrice()
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setPrice(price) {
        this.#price = price
    }

    getPrice() {
        return this.#price
    }

}

