export default class Event {
    #name
    #timeFrom
    #timeTo
    #color

    constructor(name, timeFrom, timeTo) {
        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setTimeFrom(timeFrom)
        this.setTimeFrom = this.setTimeFrom.bind(this)
        this.getTimeFrom = this.getTimeFrom.bind(this)

        this.setTimeTo(timeTo)
        this.setTimeTo = this.setTimeTo.bind(this)
        this.getTimeTo = this.getTimeTo.bind(this)

        this.setColor()
        this.getColor = this.getColor.bind(this)
    }

    getTime() {
        return this.getTimeFrom() + " - " + this.getTimeTo()
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setTimeFrom(timeFrom) {
        this.#timeFrom = timeFrom
    }

    getTimeFrom() {
        return this.#timeFrom
    }

    setTimeTo(timeTo) {
        this.#timeTo = timeTo
    }

    getTimeTo() {
        return this.#timeTo
    }

    setColor() {
        var letters = "0123456789ABCDEF"
        var color = "#"
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)]
        }

        this.#color = color
    }

    getColor() {
        return this.#color
    }

    toString() {
        return `Event: ${this.#name} from ${this.#timeFrom} to ${this.#timeTo}`
    }

}