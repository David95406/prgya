export default class Student {
    #id
    #name
    #className
    #grades
    #absences
    //isVisible = true

    constructor(id, name, className, grades, absences) {
        this.setId(id)
        this.getId = this.getId.bind(this)

        this.setName(name)
        this.getName = this.getName.bind(this)

        this.setClassname(className)
        this.getClassname = this.getClassname.bind(this)

        this.setGrades(grades)
        this.setGrades = this.setGrades.bind(this)
        this.getGrades = this.getGrades.bind(this)

        this.setAbsences(absences)
        this.getAbsences = this.getAbsences.bind(this)

        this.addAbsence = this.addAbsence.bind(this)
        this.getAtlag = this.getAtlag.bind(this)
        this.printGrades = this.printGrades.bind(this)
        this.addGrade = this.addGrade.bind(this)
    }

    getTitle() {
        return "átlag: " + this.getAtlag() + ", hianyzasok: " + this.getAbsences() + " nap"
    }

    addGrade(grade) {
        this.getGrades().push(grade)
    }

    getAtlag() {
        var sum = 0
        this.getGrades().forEach((grade => {
            sum += grade
        }))
        return sum / this.getGrades().length
    }

    printGrades() {
        var value = ""
        this.getGrades().forEach(grade => {
            value += grade + " "
        })
        return value
    }

    addAbsence() {
        this.setAbsences(this.getAbsences() + 1)
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

    setClassname(className) {
        this.#className = className
    }

    getClassname() {
        return this.#className
    }

    setGrades(grades) {
        this.#grades = grades
    }

    getGrades() {
        return this.#grades
    }

    setAbsences(absences) {
        this.#absences = absences
    }

    getAbsences() {
        return this.#absences
    }

}