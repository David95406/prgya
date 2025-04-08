import { test, describe, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { computed } from "vue";
import Tabs from "../../components/Tabs.vue"

describe('Tabs unit test', () => {
    const wrapper = mount(Tabs)

    test('Button text test', () => {
        const buttonTexts = ['Főoldal', 'Rólunk']
        const buttons = wrapper.findAll('button')

        buttons.forEach((b, index) => {
            expect(b.text()).toBe(buttonTexts.at(index))
        })
    })

    test('Home default site shows', () => {
        const fooldalDiv = wrapper.findAll('div').at(1)
        expect(fooldalDiv.text()).toBe("Üdv a főoldalon!")
    })

    test('Switch sites and about site shows', async () => {
        const wrapper = mount(Tabs)

        const homeSiteBtn = wrapper.findAll('button').at(0)
        const aboutSiteBtn = wrapper.findAll('button').at(1)


        await aboutSiteBtn.trigger('click')
        var currentSite = computed(() => wrapper.findAll('div').at(1))
        expect(currentSite.value.text()).toBe('Rólunk oldal tartalma')

        await homeSiteBtn.trigger('click')
        //currentSite = wrapper.findAll('div').at(1) // ha nem computed
        expect(currentSite.value.text()).toBe('Üdv a főoldalon!')
    })
})