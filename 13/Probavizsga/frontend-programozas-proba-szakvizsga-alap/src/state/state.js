import {
    defineStore
} from "pinia";
import {
    ref
} from "vue";

export const useSzerepjatekKarakterek = defineStore("karakterek", () => {
    const karakterek = ref([])
    const userKarakterek = ref([])

    function setKarakterek(karakterek) {
        karakterek.value = karakterek
    }

    function getKarakterek() {
        return karakterek.value
    }

    function getUserKarakterek() {
        return userKarakterek.value
    }

    function addKarakter(karakter) {
        userKarakterek.value.push(karakter)
    }

    function isDuplicate(adat) {
        return this.getUserKarakterek().some(k => k.getNev() == adat['nev'] && k.getFaj() == adat['faj'] && k.getSzint() == adat['szint'] && k.getLeiras() == adat['leiras'])
    }

    return {
        setKarakterek,
        getKarakterek,
        getUserKarakterek,
        addKarakter,
        isDuplicate
    }
});