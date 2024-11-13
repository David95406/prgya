<script setup>
import { ref } from 'vue';
import GameArea from './components/GameArea.vue';

const isGame = ref(false)
const score = ref(0)

const startGame = (() => {
  isGame.value = true
  score.value = 0
})

const updateScore = ((pont) => {
  score.value += pont

  if (score.value == 10) {
    alert("Gratulalok gyoztel")
    isGame.value = false
  }
  if (score.value == -10) {
    alert("Sajnalom vesztettel")
    isGame.value = false
  }
})
</script>

<template>
  <header>
    <h1>Játék</h1>
  </header>
  <main>
    <div class="container">
      <div class="row">
        <div class="col-lg-9">
          <section>
            <GameArea :isGame="isGame" @updateScore="updateScore"/>
          </section>
        </div>
        <div class="col-lg-3">
          <aside>
            <div class="score">Pont: {{ score }}</div>
            <h2>Játékszabályok</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tincidunt gravida sapien non
              scelerisque. Nulla sit amet auctor diam. Donec sit amet scelerisque risus. Sed varius purus at nulla
              pharetra tempus. Mauris interdum neque id metus fermentum elementum. Cras vel risus quam.</p>
            <p><button class="btn btn-warning" @click="startGame()">Játék indítása</button></p>
          </aside>
        </div>
      </div>
    </div>
  </main>
  <footer>
    <p>&copy;Copyright</p>
  </footer>
</template>

<style scoped>
header,
footer {
  text-align: center;
  padding: 10px 0px;
  background-color: #D6322F;
  color: #fff;
}

header {
  border-bottom: 5px solid #fff;
}

footer {
  border-top: 5px solid #fff;
}

main {
  background-image: url(assets/bg.webp);
  background-attachment: fixed;
  background-size: cover;
}

aside {
  background-color: rgba(0, 0, 0, 0.5);
  padding: 20px;
  color: #fff;
  text-align: center;
  min-height: 585px;
}

.score {
  background-color: #D6322F;
  padding: 10px 20px;
  color: #fff;
  display: inline-block;
  margin-bottom: 20px;
  font-size: 20px;
  font-weight: 600;
}
</style>
