import {
    defineStore
} from "pinia";
import {
    ref
} from "vue";
import Question from "../classes/Question";
//                                      👇 store azonosito
export const questionState = defineStore('questionState', (() => {
    const questions = ref([])
    const userAnswers = ref([])
    const questionsIndexes = ref([])

    function addQuestion(question) {
        questions.value.push(question)
    }

    function getQuestions() {
        return questions.value
    }

    function getQuestionByIndex(index) {
        return questions.value[index]
    }

    function addUserAnswer(answer) {
        userAnswers.value.push(answer)
    }

    function getUserAnswers() {
        return userAnswers.value
    }

    function getUserAnswersByIndex(index) {
        return userAnswers.value[index]
    }

    function getQuestionsLength() {
        return questions.value.length
    }

    function getQuestionsIndexes() {
        return questionsIndexes.value
    }

    function setQuestionsIndexes(indexes) {
        questionsIndexes.value = indexes
    }

    function clearState() {
        questions.value = []
        userAnswers.value = []
        questionsIndexes.value = []
    }

    return {
        addQuestion,
        getQuestions,
        addUserAnswer,
        getUserAnswers,
        getQuestionsLength,
        getQuestionByIndex,
        getQuestionsIndexes,
        setQuestionsIndexes,
        clearState,
    }
}))