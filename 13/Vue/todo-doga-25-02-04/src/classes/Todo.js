export default class Todo {
    #name;
    #date;
    #status;

    constructor(name, date, status) {
        this.setName(name);
        this.setDate(date);
        this.setStatus(status);

        this.getName = this.getName.bind(this);
        this.getDate = this.getDate.bind(this);
        this.getStatus = this.getStatus.bind(this);
        this.setStatus = this.setStatus.bind(this);

        this.getStatusText = this.getStatusText.bind(this)
    }

    getStatusText() {
        if (this.getStatus()) {
            return "Done"
        } 
        return "Pending"
    }

    setName(name) {
        this.#name = name;
    }

    setDate(date) {
        this.#date = date;
    }

    setStatus(status) {
        this.#status = status;
    }

    getName() {
        return this.#name;
    }

    getDate() {
        return this.#date;
    }

    getStatus() {
        return this.#status;
    }

}