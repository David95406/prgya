<script setup>
  import ButtonComponent from "./components/ButtonComponent.vue";
  import ToggleButton from "./components/ToggleButton.vue";
  import FormComponent from "./components/FormComponent.vue";
  import ParentComponent from "./components/ParentComponent.vue";
</script>

<template>
  <ButtonComponent />
  <ToggleButton :checked="false"/>
  <FormComponent />
  <ParentComponent />
</template>


