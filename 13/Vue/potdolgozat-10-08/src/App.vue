<script setup>
import Telek from './components/Telek.vue';
</script>

<template>
  <header>
    <h1>Plots for sale App</h1>
  </header>
  <main>
    <section>
      <Telek />
    </section>
  </main>
  <footer>
    <p>
      &copy; Plots for sale App
    </p>
  </footer>
</template>

<style scoped>
header,
footer {
  background-color: #3AB982;
  color: white;
  padding: 10px 0px;
}

main {
  background-image: url("/assets/plots-bg.jpg");
  min-height: 500px;
  background-size: cover;
  background-repeat: no-repeat;
}

section {
  background-color: rgba(255, 255, 255, 0.7);
  width: calc(90% - 40px);
  margin: 0px auto;
  display: block;
  padding-top: 5%;
  border-radius: 10px;
}

footer {
  text-align: center;
  font-weight: 700;
}

</style>
