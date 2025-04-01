export default class Planet {
    #name
    #population
    #climate

    constructor(name, population, climate) {
        this.setName(name)
        this.setName = this.setName.bind(this)
        this.getName = this.getName.bind(this)

        this.setPopulation(population)
        this.setPopulation = this.setPopulation.bind(this)
        this.getPopulation = this.getPopulation.bind(this)

        this.setClimate(climate)
        this.setClimate = this.setClimate.bind(this)
        this.getClimate = this.getClimate.bind(this)

        this.getJSON = this.getJSON.bind(this)
    }
    
    getJSON() {
        return {
            name: this.getName(),
            population: this.getPopulation(),
            climate: this.getClimate()
        }
    }

    setName(name) {
        this.#name = name
    }

    getName() {
        return this.#name
    }

    setPopulation(population) {
        this.#population = population
    }

    getPopulation() {
        return this.#population
    }

    setClimate(climate) {
        this.#climate = climate
    }

    getClimate() {
        return this.#climate
    }

    toString() {
        return `Planet Name: ${this.getName()}, Population: ${this.getPopulation()}, Climate: ${this.getClimate()}`;
    }

}