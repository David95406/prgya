<script setup>
import { ref } from 'vue';


const props = defineProps({
    checked: Boolean
})

const emit = defineEmits(["update"])

const buttonCheck = ref(props.checked)

const toggleButton = () => {
    buttonCheck.value = !buttonCheck.value
    emit("update")
}
</script>

<template>
    <button @click="toggleButton">{{ buttonCheck ? "on" : "off" }}</button>
</template>

<style scoped>
  
</style>