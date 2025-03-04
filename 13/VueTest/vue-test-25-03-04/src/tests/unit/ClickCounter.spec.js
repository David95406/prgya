import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import ClickCounter from "../../components/ClickCounter.vue";

describe(ClickCounter, (() => {
    const wrapper = mount(ClickCounter)

    test("ClickerCounter button clicking test", (async () => {
        const button = wrapper.find("button")
        
        await button.trigger("click")
        await button.trigger("click")

        expect(wrapper.find(".clicker").text()).toContain(2)
    }))


    // img
    test("Image alt is correct", (() => {
        expect(wrapper.find("img").attributes("alt")).toBe("Logo")
    }))

    test("Image src is correct", (() => {
        expect(wrapper.find("img").attributes("src")).toBe("/src/assets/vue.svg")
    }))


}))