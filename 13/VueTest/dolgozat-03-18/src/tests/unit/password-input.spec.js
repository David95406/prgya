import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import PasswordInput from "../../components/PasswordInput.vue"

describe("PasswordInput tests", () => {
    const wrapper = mount(PasswordInput)

    test('input type is password at start', () => {
        const input = wrapper.find('input')
        expect(input.attributes('type')).toBe("password")
    })

    test('input type change on checkbox click', async () => {
        const input = wrapper.find('input')
        const showPassword = wrapper.find('#showPassword')

        await showPassword.setChecked(true)
        expect(input.attributes('type')).toBe("text")
        
    })

    test('input text is reactive', async () => {
        var text1 = "Hello"
        var text2 = text1 + " World!"
        const input = wrapper.find('input')
        
        await input.setValue(text1)
        expect(input.element.value).toBe(text1)
        
        await input.setValue(text2)
        expect(input.element.value).toBe(text2)
    })
})