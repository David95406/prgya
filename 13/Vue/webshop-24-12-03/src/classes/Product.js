export default class Product {
    #name
    #price
    #piece

    constructor(name, price, piece) {
        this.setName(name)
        this.setPrice(price)
        this.setPiece(piece)

        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)
        this.setPrice = this.setPrice.bind(this)
        this.getPrice = this.getPrice.bind(this)
        this.setPiece = this.setPiece.bind(this)
        this.getPiece = this.getPiece.bind(this)
        this.addPiece = this.addPiece.bind(this)
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

    setPiece(piece) {
        this.#piece = piece
    }

    getPiece() {
        return this.#piece
    }

    addPiece() {
        this.setPiece(this.getPiece() + 1)
    }

}