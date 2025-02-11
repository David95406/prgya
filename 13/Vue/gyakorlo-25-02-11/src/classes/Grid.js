export default class Grid {
    #name
    #power

    constructor(name, power) {
        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setPower(power)
        this.setPower = this.setPower.bind(this)
        this.getPower = this.getPower.bind(this)
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setPower(power) {
        this.#power = power
    }

    getPower() {
        return this.#power
    }

}