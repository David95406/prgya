import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import InputField from "../../components/InputField.vue";

describe("InputField", () => {
    const wrapper = mount(InputField)

    test("Submit form test", async () => {
        const button = wrapper.find("button")
        const input = wrapper.find("input")

        await input.setValue("Test")
        await button.trigger("click")

        expect(wrapper.find("p").text()).toBe("Test")
    })
})
