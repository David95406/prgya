import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import ParentComponent from "../../components/ParentComponent.vue";
import ChildComponent from "../../components/ChildComponent.vue";

describe('ParentComponent', () => {
    const wrapper = mount(ParentComponent)
    const NAME = "Anna"

    test("Set name to props correct from input filed", async () => {
        const input = wrapper.find("input")

        await input.setValue(NAME)

        const child = wrapper.findComponent(ChildComponent)
        expect(child.props("name")).toBe(NAME)
    })

    test("Emit message from Child component", async () => {
        const child = wrapper.findComponent(ChildComponent)
        const childButton = child.find("button")

        await childButton.trigger('click')

        expect(child.emitted('greet')).toBeTruthy()

        expect(wrapper.find("p").text()).toContain(NAME)
    })

    test("szebb mint a fenti teszt", async () => {
        const child = wrapper.findComponent(ChildComponent)

        await child.vm.$emit('greet', "Hello " + NAME + " in VueWorld!")
        await wrapper.vm.$nextTick()

        expect(wrapper.find("p").text()).toContain(NAME)
    })
})