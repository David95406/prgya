import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import FormComponent from "../../components/FormComponent.vue";

describe(FormComponent, (() => {
    const wrapper = mount(FormComponent)

    test("Reset form works, send emit and clear input", async () => {
        const resetButton = wrapper.find('#resetButton')
        const inputField = wrapper.find('input')

        await inputField.setValue('Hello World!')
        expect(inputField.element.value).toBe('Hello World!')

        await resetButton.trigger('click')
        expect(inputField.element.value).toBe('')
        expect(wrapper.emitted('reset')).toBeTruthy()
    })

    test("ResetForm emit input value", async () => {
        const submitButton = wrapper.find('#submitButton')
        const inputField = wrapper.find('input')
        const form = wrapper.find('form')

        await inputField.setValue('Hello World!')
        //await submitButton.trigger('click')
        await form.trigger('submit')
        expect(wrapper.emitted('submitForm')).toBeTruthy()
        expect(wrapper.emitted('submitForm')[0]).toEqual(["Hello World!"])
    })
    
}))