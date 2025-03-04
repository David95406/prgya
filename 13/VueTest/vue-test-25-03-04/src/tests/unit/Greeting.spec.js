import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import Greeting from "../../components/Greeting.vue";

describe("Greeting", (() => {
    const wrapper = mount(Greeting)

    test("Greeting component contains 'Welcome to Vue!'", (() => {
        expect(wrapper.find("h1").text()).toContain('Welcome to Vue!')
    }))

    test("Greeting component contains 'Vue is a very good framework!'", (() => {
        expect(wrapper.find("p").text()).toContain("Vue is a very good framework!")
    }))
}))

