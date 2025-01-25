export default class Todo {
    #name
    #desc
    #date
    #status

    constructor(name, desc, date, status) {
        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setDesc(desc)
        this.setDesc = this.setDesc.bind(this)
        this.getDesc = this.getDesc.bind(this)

        this.setDate(date)
        this.setDate = this.setDate.bind(this)
        this.getDate = this.getDate.bind(this)
        this.getRawDate = this.getRawDate.bind(this)

        this.setStatus(status)
        this.setStatus = this.setStatus.bind(this)
        this.getStatus = this.getStatus.bind(this)
        this.changeStatus = this.changeStatus.bind(this)    

        this.toString = this.toString.bind(this)
    }

    toString() {
        return `Name: ${this.getName()}, Desc: ${this.getDesc()}, Date: ${this.getDate()}, Status: ${this.getStatus()}`
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setDesc(desc) {
        this.#desc = desc
    }

    getDesc() {
        return this.#desc
    }

    setDate(date) {
        this.#date = date
    }

    getRawDate() {
        return this.#date
    }

    getDate() {
        const date = new Date(this.#date)
        return date.toLocaleString()
    }

    setStatus(status) {
        this.#status = status
    }

    changeStatus() {
        this.setStatus(!this.getStatus())
        console.log("Status changed to: " + this.getStatus())
    }

    getStatus() {
        return this.#status
    }

}