import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
test("asd", () => {
    expect("")
})
/*


import ItemList from "../../components/ItemList.vue";

describe(ItemList, () => {
    test("")
    
    const wrapper = mount(ItemList, {
        props: {
            items: Array
        }
    })
    const items = ['alma', 'banan', 'narancs', 'balna']
    const itemsLi = wrapper.findAll('li')

    test('items list lenght is correct', () => {
        expect(itemsLi.length).toBe(items.length)
    })

    test('ItemList item alues are correct', () => {
        for (let i = 0; i < itemsLi.length; i++) {
            expect(itemsLi[i].text()).toBe(items[i])
        }
    })

    test('ItemList emits item-selected event.', async () => {
        const firsItem = wrapper.find('li')
        await firsItem.trigger('click')

        expect(wrapper.emitted('item-selected')).toBeTruthy()
        expect(wrapper.emitted('item-selected')[0]).toEqual(itemsLi[0])
    })
})
    */