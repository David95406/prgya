import { test, expect, describe } from "vitest";
import { mount } from "@vue/test-utils";
import TodoList from "../../components/TodoList.vue";
import { data } from "../../data/data";

describe(TodoList, () => {
    const wrapper = mount(TodoList);

    test("TodoObjList render is correct", () => {
        const todos = wrapper.findAll(".todo")

        expect(todos.length).toBe(data.length)
    });


    test("TodoObjList render is correct", () => {
        const todos = wrapper.findAll(".todo")

        todos.forEach((todo, index) => {
            expect(todo.text()).contain(data[index].text)
        })
    });

});
