export default class Room {
    #id
    #name
    #options
    #price

    constructor(id, name, options) {
        this.#id = id
        this.getId = this.getId.bind(this)
        this.setId = this.setId.bind(this)

        this.#name = name
        this.getName = this.getName.bind(this)
        this.setName = this.setName.bind(this)

        this.#options = options
        this.getOptions = this.getOptions.bind(this)
        this.setOptions = this.setOptions.bind(this)
        this.addOption = this.addOption.bind(this)
        this.removeOption = this.removeOption.bind(this)

        this.#price = 0
        this.getPrice = this.getPrice.bind(this)
        this.setPrice = this.setPrice.bind(this)
    }

    setId(id) {
        this.#id = id
    }

    getId() {
        return this.#id
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setOptions(options) {
        this.#options = options
    }

    getOptions() {
        return this.#options
    }

    addOption(option) {
        this.#options.push(option)
    }

    removeOption(option) {
        const index = this.#options.indexOf(option)
        this.#options.splice(index, 1)
    }

    setPrice(price) {
        this.#price = price
    }

    getPrice() {
        return this.#price
    }

    toString() {
        return "{id: " + this.getId() +
            ", name: " + this.getName() +
            ", options: " + this.getOptions() + "}"
    }
}