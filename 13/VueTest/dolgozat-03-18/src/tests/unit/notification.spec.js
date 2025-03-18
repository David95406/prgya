import { describe, test, expect } from "vitest";
import { mount } from "@vue/test-utils";
import Notification from "../../components/Notification.vue";

describe('Notification tests', () => {
    const message = "Hello"
    const type = "success"

    const wrapper = mount(Notification, {
        props: {
            message: message,
            type: type
        }
    })

    test('Notification message is right', () => {
        const span = wrapper.find('span')

        expect(span.text()).toBe(message)
    })

    test('Notification color change test', () => {
        console.log("okokokk")

        const span = wrapper.find('span')

        expect(span.attributes('style')).toBe('color: green;')

        wrapper.setProps({
            type: "error"
        })
       // expect(span.attributes('style')).toBe('color: red;')


        wrapper.setProps({
            type: "warning"
        })
        expect(span.attributes('style')).toBe('color: yellow;')
    })

})