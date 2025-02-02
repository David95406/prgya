export default class Favorite {
    #type
    #data

    constructor(type, data) {
        this.setType(type)
        this.setData(data)

        this.getType = this.getType.bind(this)
        this.getData = this.getData.bind(this)
        this.addData = this.addData.bind(this)
        this.removeData = this.removeData.bind(this)
    }

    setType(type) {
        this.#type = type
    }

    getType() {
        return this.#type
    }

    setData(data) {
        this.#data = data
    }

    addData(data) {
        this.#data.push(data)
    }

    removeData(index) {
        this.#data.splice(index, 1)
    }

    getData() {
        return this.#data
    }

}