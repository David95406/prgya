import { mount } from "@vue/test-utils";
import { describe, test, expect } from "vitest";
import FormComponent from "../../components/FormComponent.vue";

describe("FormComponent", ()=>{
    const wrapper = mount(FormComponent);
    const input = wrapper.find("input");

    test("FormComponent resetButton send 'reset' emit and clear input.", async ()=>{
        const resetButton = wrapper.find("button[type='reset']");
       
        await input.setValue("Vue Teszt!");
        await resetButton.trigger("click");

        expect(wrapper.emitted("reset")).toBeTruthy();
        expect(input.element.value).toBe("");
    });

    test("FormComponent submitButton send 'submit' emit and send input data.", async ()=>{
        const submitButton = wrapper.find("button[type='submit']");
        await input.setValue("Vue Teszt!");
        await submitButton.trigger("click");

        expect(wrapper.emitted("submit")).toBeTruthy();
        expect(wrapper.emitted("submit")[0]).toEqual(["Vue Teszt!"]);
    });
})