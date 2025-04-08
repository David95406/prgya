import { test, describe, expect } from "vitest";
import { mount } from "@vue/test-utils";
import RandomQuote from "../../components/RandomQuote.vue";
import { computed } from "vue";

describe('RandomQuote unit test', () => {
    const wrapper = mount(RandomQuote)
    const quotes = [
        "Az élet szép.",
        "Tanulni jó.",
        "A Vue fantasztikus!"
      ]

    test('Betöltéskor jelenik meg idézet.', () => {
        const qP = wrapper.find('p')
        expect(qP.text().length > 0).toBeTruthy()
    })

    test('Gombra kattintva új idézet jelenik meg (nem garantáltan másik, de mindig van).', async () => {
        const qP = computed(() => wrapper.find('p'))
        const btn = wrapper.find('button')

        const regi = qP.value.text()
        while (qP.value.text() == regi) {
            await btn.trigger('click')
        }
        expect(qP.value.text() != regi).toBeTruthy()
    })

    test('Az idézet mező sosem üres.', async () => {
        const qP = computed(() => wrapper.find('p'))
        const btn = wrapper.find('button')

        for (let i = 0; i < 100; i++) {
            expect(qP.value != "").toBeTruthy()
            await btn.trigger('click')
        }
    })
})