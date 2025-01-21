export default class Question {
    #question
    #answer

    constructor(question, answer) {
        this.setQuestion(question)
        this.getQuestion = this.getQuestion.bind(this)

        this.setAnswer(answer)
        this.getAnswer = this.getAnswer.bind(this)
    }

    toString() {
        return this.getQuestion() + " - " + this.getAnswer()
    }

    setQuestion(question) {
        this.#question = question
    }

    getQuestion() {
        return this.#question
    }

    setAnswer(answer) {
        this.#answer = answer
    }

    getAnswer() {
        return this.#answer
    }

}