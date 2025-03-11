<script setup>

const props = defineProps({
    items: Array
})

const emit = defineEmits(['item-selected'])

const selectItem = (item) => {
    emit('item-selected', item)
}
</script>

<template>
  <ul v-for="item in items">
    <li @click="selectItem(item)">{{ item }}</li>
  </ul>
</template>

<style scoped>
  
</style>