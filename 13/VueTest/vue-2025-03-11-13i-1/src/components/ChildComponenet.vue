<script setup>
import { defineProps, defineEmits } from 'vue';
const props = defineProps({
    name: String
});

const emit = defineEmits(["greet"]);

const sendGreeting = () =>{
    if(props.name!=""){
        const greeting = "Hello " + props.name + " in VueWorld!";
        emit("greet", greeting);
    }
}
</script>

<template>
   <h2>Child</h2>
    <div><button @click="sendGreeting">Send message!</button></div>
</template>