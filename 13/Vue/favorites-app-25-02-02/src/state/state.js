import {
    ref
} from "vue";
import {
    defineStore
} from "pinia";

export const favorites = defineStore("favorites", (() => {
    const favorites = ref([])
    const keepFresh = ref(false)
    const refresh = (() => keepFresh.value = !keepFresh.value)

    function getFresh() {
        return keepFresh.value
    }

    function addFavorites(newFavorites) {
        favorites.value.push(newFavorites)
        refresh()
    }

    function addDataToFavorites(index, data) {
        favorites.value[index].addData(data)
        refresh()
    }

    function getFavorites() {
        return favorites.value
    }

    function getTypes() {
        return favorites.value.map(favorite => favorite.getType());
    }

    function getDataFromTypeIndex(index) {
        const favorite = favorites.value[index];
        return favorite ? favorite.getData() : null;
    }

    function removeData(typeIndex, dataIndex) {
        favorites.value[typeIndex].removeData(dataIndex)
        refresh()
    }

    return {
        addFavorites,
        getFavorites,
        getTypes,
        getDataFromTypeIndex,
        addDataToFavorites,
        removeData,
        getFresh
    }
}))