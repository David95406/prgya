const props = defineProps({
    currentType: Number,
});

const emit = defineEmits(['selected'])
emit('selected', index)


const app = createApp(App)
const pinia = createPinia()
app.use(pinia)
app.mount('#app')

export const favorites = defineStore("favorites", (() => {
	const test = ref([])
	
	function getTest() {
		return test.value
	}

	function setTest(test) {
		test.value = test
	}

	return {
		getTest,
		setTest
	}
}))



export default class Favorite {
    #type
    #data

    constructor(type, data) {
        this.setType(type)
        this.setType = this.setType.bind(this)
        this.getType = this.getType.bind(this)

        this.setData(data)
        this.setData = this.setData.bind(this)
        this.getData = this.getData.bind(this)


}

function getImageUrl(name) {
    return new URL("../" + name, import.meta.url).href
}

const date = new Date();
const formattedDate = date.toISOString().split('T')[0]; // "2025-02-04"
console.log(formattedDate);
