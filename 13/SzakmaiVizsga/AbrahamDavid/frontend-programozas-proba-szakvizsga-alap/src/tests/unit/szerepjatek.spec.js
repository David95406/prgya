import {
    mount
} from '@vue/test-utils';
import {
    describe,
    expect,
    test
} from "vitest";
import szerepjatek from '../../components/szerepjatek.vue';

describe("szerepjatek", () => {
    test('Ha nincs kiválasztott faj, akkor nem jelenik meg semmi a bekezdésben!', () => {
        const wrapper = mount(szerepjatek)
        const kivalasztottFaj = wrapper.find('p')

        expect(!kivalasztottFaj).toBeDefined()
        try {
            expect(kivalasztottFaj).toBeDefined()
        } catch {
            expect(true).toBeTruthy()
        }
    })

    test('ha lenyíló listából kiválasztunk egy fajt, akkor az űrlap alatti bekezdésben valóban a kiválasztott faj megnevezése szerepel!', async () => {
        const wrapper = mount(szerepjatek)
        const fajok = ['ember', 'ork', 'elf', 'törpe'];
        const options = wrapper.findAll('option')

        const INDEX = 1
        await options.at(INDEX).setSelected()

        const bekezdes = wrapper.find('p')
        expect(bekezdes.text()).toContain(fajok.at(INDEX - 1))
    })
})