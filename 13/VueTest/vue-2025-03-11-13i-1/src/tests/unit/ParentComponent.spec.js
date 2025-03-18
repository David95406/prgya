import { mount } from "@vue/test-utils";
import { describe, test, expect, it } from "vitest";
import ParentComponent from "../../components/ParentComponent.vue";
import ChildComponenet from "../../components/ChildComponenet.vue";

describe("ParentComponent", ()=>{
    const name = "Anna";
    const wrapper = mount(ParentComponent);
    const child = wrapper.findComponent(ChildComponenet);

    test("Set name to props correct from input field.", async ()=>{
        const input = wrapper.find("input");
        await input.setValue(name);
        expect(child.props("name")).toBe(name);
    });

    test("Emit message from Child Componenet.", async ()=>{
       /*const button = child.find("button");
       await button.trigger("click");
       expect(child.emitted("greet")).toBeTruthy()*/
       await child.vm.$emit("greet", "Hello "+ name + " in VueWorld!");
       await wrapper.vm.$nextTick();
       
       expect(wrapper.find("p").text()).toContain("Hello "+ name + " in VueWorld!");
    });
})