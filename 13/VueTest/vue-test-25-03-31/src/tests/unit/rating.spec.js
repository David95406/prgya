import {
    test,
    describe,
    expect
} from "vitest";
import {
    mount
} from "@vue/test-utils";
import Rating from "../../components/Rating.vue";

describe('Rating test', () => {
    test('1. feladat', () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 5,
                initialRating: 3,
                showRatingText: true
            }
        })

        const ratingList = wrapper.findAll('span')

        ratingList.forEach((rating, index) => {
            if (index < 3) {
                expect(rating.classes()).toContain('active')
            } else {
                expect(rating.classes().length).toBe(1)
            }
        })
    })

    test('2. feladat', async () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 5,
                initialRating: 1,
                showRatingText: true
            }
        })

        const ratingText = wrapper.find('.rating-text')
        const ratingList = wrapper.findAll('span')
        const secondRating = ratingList[1]

        expect(ratingText.text()).toBe('Értékelés: 1 / 5')
        expect(wrapper.vm.rating).toBe(1)
        await secondRating.trigger('click')
        expect(wrapper.vm.rating).toBe(2)
        expect(ratingText.text()).toBe('Értékelés: 2 / 5')
    })

    test('3. feladat', () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 5,
                initialRating: 3,
                showRatingText: false
            }
        })

        const ratingText = wrapper.find('.rating-text')
        expect(ratingText.exists()).toBe(false)
    })

    test('4. feladat', async () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 5,
                initialRating: 3,
                showRatingText: false
            }
        })

        const ratingList = wrapper.findAll('span')
        expect(ratingList.length).toBe(5)

        await wrapper.setProps({
            maxRating: 10
        })

        const updatedRatingList = wrapper.findAll('span')
        expect(updatedRatingList.length).toBe(10)
    })

    // ...

    test('props test', () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 10,
                initialRating: 1,
                showRatingText: true
            }
        })

        expect(wrapper.props()).toStrictEqual({
            maxRating: 10,
            initialRating: 1,
            showRatingText: true
        })
    })

    test('default props test', () => {
        const wrapper = mount(Rating)

        expect(wrapper.props()).toStrictEqual({
            maxRating: 5,
            initialRating: 0,
            showRatingText: true
        })
    })

    test('maxRating test', () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 10,
                initialRating: 1,
                showRatingText: true
            }
        })

        const ratingList = wrapper.findAll('span')
        expect(ratingList.length).toBe(10)
    })

    test('rating-text test', async () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 5,
                initialRating: 1,
                showRatingText: true
            }
        })
        const ratingText = wrapper.find('.rating-text')
        expect(ratingText.text()).toBe('Értékelés: 1 / 5')
    })

    test('emit after rate test', async () => {
        const wrapper = mount(Rating, {
            props: {
                maxRating: 5,
                initialRating: 1,
                showRatingText: true
            }
        })

        const ratingList = wrapper.findAll('span')
        const secondRating = ratingList[1]

        await secondRating.trigger('click')
        expect(wrapper.emitted())
        expect(wrapper.emitted()['update:rating'][0][0]).toBe(2)

    })

})