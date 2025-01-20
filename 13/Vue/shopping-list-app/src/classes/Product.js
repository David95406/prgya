export default class Product {
    #name
    #quantity

    constructor(name, quantity) {
        this.#name = name
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.#quantity = quantity
        this.setQuantity = this.setQuantity.bind(this)
        this.getQuantity = this.getQuantity.bind(this)
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setQuantity(quantity) {
        this.#quantity = quantity
    }

    getQuantity() {
        return this.#quantity
    }

}