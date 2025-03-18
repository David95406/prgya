<script setup>
import { ref, defineEmits, defineProps } from 'vue';

const props = defineProps({
    checked: Boolean
});

const buttonChecked = ref(props.checked);
const emit = defineEmits(["update"]);

const toggle = () =>{
    buttonChecked.value = !buttonChecked.value;
    emit("update");
}
</script>

<template>
    <p><button @click="toggle">{{ buttonChecked ? 'ON' : 'OFF' }}</button></p>
</template>