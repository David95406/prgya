import axios from 'axios';

export default class Pokemon {
    #name
    #url

    constructor(name, url) {
        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setUrl(url)
        this.setUrl = this.setUrl.bind(this)
        this.getUrl = this.getUrl.bind(this)

        this.toString = this.toString.bind(this)
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setUrl(url) {
        this.#url = url
    }

    getUrl() {
        return this.#url
    }

    toString() {
        return `Name: ${this.#name}, URL: ${this.#url}`;
    }

}