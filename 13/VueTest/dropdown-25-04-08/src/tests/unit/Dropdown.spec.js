import { test, describe, expect } from "vitest";
import { mount } from "@vue/test-utils";
import Dropdown from "../../components/Dropdown.vue";

describe('Dropdown test', () => {
    const wrapper = mount(Dropdown)
    const fruits = [null, 'Alma', 'Banán', 'Cseresznye']

    test('Fruits and default test', () => {
        const options = wrapper.findAll('option')
        
        options.forEach((o, index) => {
            if (index == 0) {
                expect(o.text()).toBe('Válassz egyet')
            } else {
                expect(o.text()).toBe(fruits.at(index))
            }
        })
    })

    test('Select test', async () => {
        const options = wrapper.findAll('option')

        await options[1].setSelected()
        const selected = wrapper.find('p')

        expect(selected.text()).toBe('Kiválasztott: ' + fruits[1])
        
        await options[2].setSelected()
        expect(selected.text()).toBe('Kiválasztott: ' + fruits[2])
    })

 })