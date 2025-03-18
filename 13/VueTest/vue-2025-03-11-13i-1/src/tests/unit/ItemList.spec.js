import { mount } from "@vue/test-utils";
import { describe, test, expect, it } from "vitest";
import ItemList from "../../components/ItemList.vue";

describe("ItemList", ()=>{
    const items = [
        {id: 1, name: "Apple"},
        {id: 2, name: "Banana"}
    ];
    const wrapper = mount(ItemList, {
        props:{
            items
        }
    });
    const lisitems = wrapper.findAll("li");

    test("ItemList length is correct.", ()=>{
        expect(lisitems.length).toBe(items.length);
    });

    test("ItemList item values are correct.", ()=>{
        for (let i = 0; i < lisitems.length; i++) {
            expect(lisitems[i].text()).toBe(items[i].name);
        }
    });

    test("ItemList emits item-selected event.", async ()=>{
        const firstItem = wrapper.find("li");
        await firstItem.trigger("click");

        expect(wrapper.emitted("item-selected")).toBeTruthy();
        expect(wrapper.emitted("item-selected")[0]).toEqual([items[0]]);
    });
});