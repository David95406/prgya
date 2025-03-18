<script setup>

const props = defineProps({
    message: String,
    type: String
})

const getColorFromType = () => {
    switch (props.type) {
        case "success": return "color: green;";
        case "warning": return "color: yellow;";
        case "error": return "color: red;";
        default: return "";
    }
}

</script>

<template >
    <span :style="getColorFromType()">{{ message }}</span>
</template>

<style></style>