import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import ToggleButton from "../../components/ToggleButton.vue";

describe(ToggleButton, (() => {

    test("ToggleButton text is off when props is false", () => {
        const wrapper = mount(ToggleButton, {
            props: {
                checked: false
            }
        })

        const button = wrapper.find("button")

        expect(button.text()).toBe("off")
    })

    test("ToggleButton text is on when props is true", () => {
        const wrapper = mount(ToggleButton, {
            props: {
                checked: true
            }
        })

        const button = wrapper.find("button")

        expect(button.text()).toBe("on")
    })

    test("ToggleButton toggles the checked state", async () => {
        const wrapper = mount(ToggleButton, {
            props: {
                checked: false
            }
        })

        const button = wrapper.find("button")

        expect(button.text()).toBe("off")
        await button.trigger('click')
        expect(wrapper.emitted("update")).toBeTruthy()
        expect(button.text()).toBe("on")

        await button.trigger('click')
        expect(button.text()).toBe("off")
        
    })
}))