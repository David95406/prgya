import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import StyleDiv from "../../components/StyleDiv.vue";

describe(StyleDiv, (() => {
    const wrapper = mount(StyleDiv)

    test("StyleDiv has correct color (red)", (() => {
        expect(wrapper.find('.styleDiv').attributes('style')).toContain('red')
    }))
}))