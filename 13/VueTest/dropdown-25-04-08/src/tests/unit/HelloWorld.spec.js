import { test, describe, expect } from "vitest";
import { mount } from "@vue/test-utils";
import HelloWorld from "../../components/HelloWorld.vue";

describe('HelloWorld test', () => {
    test('props test', () => {
        const wrapper = mount(HelloWorld, {
            props: {
                msg: "Hello World!"
            }
        })

        const msgPropsShow = wrapper.find('h1')
        expect(msgPropsShow.text()).toBe('Hello World!')
    })

    test('Count is reactive', async () => {
        const wrapper = mount(HelloWorld, {
            props: {
                msg: "Hello World!"
            }
        })

        const button = wrapper.find('button')
        expect(button.text()).toBe('count is 0')
        await button.trigger('click')
        expect(button.text()).toBe('count is 1')

    })
})
 