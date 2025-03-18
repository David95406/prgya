import { mount } from "@vue/test-utils";
import { describe, test, expect } from "vitest";
import ToggleButton from "../../components/ToggleButton.vue";

describe("ToggleButton", ()=>{
    test("ToggleButton text is OFF when props is false.", ()=>{
        const wrapper = mount(ToggleButton, {
            props: {
                checked: false
            }
        });
        const button = wrapper.find("button");
        expect(button.text()).toBe("OFF");
    });

    test("ToggleButton text is ON when props is true.", ()=>{
        const wrapper = mount(ToggleButton, {
            props: {
                checked: true
            }
        });
        const button = wrapper.find("button");
        expect(button.text()).toBe("ON");
    });

    test("ToggleButton toggles the checked state.", async ()=>{
        const wrapper = mount(ToggleButton, {
            props: {
                checked: false
            }
        });
        const button = wrapper.find("button");
        expect(button.text()).toBe("OFF");
        await button.trigger("click");

        expect(wrapper.emitted("update")).toBeTruthy();
        expect(button.text()).toBe("ON");

        await button.trigger("click");
        expect(button.text()).toBe("OFF");
    });
})