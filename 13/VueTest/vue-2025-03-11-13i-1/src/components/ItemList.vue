<script setup>
import { defineProps, defineEmits } from 'vue';
const props = defineProps({
    items: Array
});

const emit = defineEmits(["item-selected"]);

const selected = (item) =>{
    emit("item-selected", item);
}
</script>

<template>
    <ul>
        <li v-for="item in items" @click="selected(item)">{{ item.name }}</li>
    </ul>
</template>