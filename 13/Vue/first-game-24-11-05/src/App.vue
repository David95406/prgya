<script setup>

</script>

<template>
  <header>
    <h1>Játék</h1>
  </header>
  <main>
    <div class="container">
      <div class="row">
        <div class="col-lg-9">
          <section class="game-area"></section>
        </div>
        <div class="col-lg-3">
          <aside>
            <div class="score">Pont: 0</div>
            <h2>Játékszabályok</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tincidunt gravida sapien non
              scelerisque. Nulla sit amet auctor diam. Donec sit amet scelerisque risus. Sed varius purus at nulla
              pharetra tempus. Mauris interdum neque id metus fermentum elementum. Cras vel risus quam.</p>
            <p><button class="btn btn-warning">Játék indítása</button></p>
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

.game-area {
  background-color: #add8e6;
  border: 2px solid #D6322F;
  width: 400px;
  height: 500px;
  margin: 30px auto;
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
