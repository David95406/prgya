import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import ItemList from "../../components/ItemList.vue";

describe(ItemList, (() => {
    const wrapper = mount(ItemList)

    test("ItemList has correct size", (() => {
        const items = wrapper.findAll('.items li')

        expect(items.length).toBe(3)
    }))

    test("ItemList renders all items correctly - manually", (() => {
        const items = wrapper.findAll('.items li')

        expect(items[0].text()).toBe('apple')
        expect(items[1].text()).toBe('banana')
        expect(items[2].text()).toBe('orange')
    }))

    test("ItemList renders all items correctly - with forEach", (() => {
        const items = wrapper.findAll('.items li')
        const fruits = ["apple", "banana", "orange"]

        fruits.forEach((fruit, i) => {
            expect(items[i].text()).toBe(fruit)

        })
    }))
}))