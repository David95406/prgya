export default class Product {
    #id
    #name
    #price
    #img
    #darabszam

    constructor(id, name, price, img) {
        this.#id = id
        this.setId = this.setId.bind(this)
        this.getId = this.getId.bind(this)

        this.#name = name
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.#price = price
        this.setPrice = this.setPrice.bind(this)
        this.getPrice = this.getPrice.bind(this)

        this.#img = img
        this.setImg = this.setImg.bind(this)
        this.getImg = this.getImg.bind(this)

        this.#darabszam = 0
        this.setDarabszam = this.setDarabszam.bind(this)
        this.getDarabszam = this.getDarabszam.bind(this)
    }

    setDarabszam(darabszam) {
        this.#darabszam = darabszam
    }

    getDarabszam() {
        return this.#darabszam
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

    setPrice(price) {
        this.#price = price
    }

    getPrice() {
        return this.#price
    }

    setImg(img) {
        this.#img = img
    }

    getImg() {
        return this.#img
    }

    toString() {
        return this.getName() + ": " + this.getPrice()
    }
}