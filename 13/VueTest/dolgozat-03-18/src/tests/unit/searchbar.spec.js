import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import SearchBar from "../../components/SearchBar.vue";


describe("Searchbar tests", () => {
    const wrapper = mount(SearchBar)

    test('input is reactive', async () => {
        const input = wrapper.find('input')
        await input.setValue("Hello")
        //expect(wrapper.vm.$searchQuery).toBe("Hello")
        expect(input.element.value).toBe("Hello")

        await input.setValue("Hello World!")
        expect(input.element.value).toBe("Hello World!")
    })

    test('reset button works', async () => {
        const input = wrapper.find('input')
        const resetButton = wrapper.find('button')

        await input.setValue("Hello")
        expect(input.element.value).toBe("Hello")

        await resetButton.trigger('click')
        expect(input.element.value).toBe("")
    })
})