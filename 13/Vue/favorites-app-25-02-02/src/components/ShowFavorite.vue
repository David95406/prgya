<script setup>
import { computed, watch, ref } from 'vue';
import { favorites } from '../state/state';
const favoritesState = favorites()


const props = defineProps({
    currentType: Number,
});
const currentType = ref(props.currentType)

watch(props, (() => {
    currentType.value = props.currentType
}))

const remove = ((index) => {
    if (confirm("Biztos?")) {
        favoritesState.removeData(currentType.value, index)
        refresh()
    }
})

</script>

<template>
    <p class="keep-fresh">Keeping the site fresh {{ favoritesState.getFresh() }}</p>
    <div class="favorite" v-for="(data, index) in favoritesState.getDataFromTypeIndex(currentType)">
        <h3>{{ data.getTitle() }}</h3>
        <h4>{{ data.getAuthor() }}</h4>
        <img :src="data.getImage()">
        <button @click="remove(index)" type="button" class="btn btn-danger">Remove</button>
    </div>
</template>

<style scoped>
.keep-fresh {
    display: none;
}

.favorite {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    background-color: #f9f9f9;
}
</style>