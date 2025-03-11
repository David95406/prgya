import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import ButtonComponent from "../../components/ButtonComponent.vue";

describe(ButtonComponent, (() => {
    const wrapper = mount(ButtonComponent)

    test("ButtonComponents emits onClick event", async () => {
        const button = wrapper.find('button')

        await button.trigger('click')

        expect(wrapper.emitted("onClick")).toBeTruthy()
    })
}))