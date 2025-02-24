<script setup>
import axios from 'axios';
import Diak from "./classes/Diak.js"
import { ref } from "vue"

const SOR = 6
const OSZLOP = 5
const ulesrend = ref(new Array(SOR).fill(null).map(() => new Array(OSZLOP).fill(null)));

const setUlesrend = async () => {
  for (let i = 0; i < ulesrend.value.length; i++) {
    for (let j = 0; j < ulesrend.value[i].length; j++) {
      await axios.get("http://localhost/ulesrend/api/get_tanulo.php?sor=" + i + "&oszlop=" + j)
        .then(response => {
          if (response.data.id != undefined) {
            ulesrend.value[i][j] = new Diak(response.data.id, response.data.nev, i, j);
          } else {
            ulesrend.value[i][j] = new Diak(-1, "", i, j);
          }
        })
        .catch(error => {
          console.error("Error: " + error);
        })
    }
  }
}
setUlesrend();

const del = async (did) => {
  await axios.delete("http://localhost/ulesrend/api/index.php", {
    params: {
      id: parseInt(did)
    }
  })
    .then(response => {
      setUlesrend();
    })
    .catch(error => {
      console.error("Error: " + error);
    })
}

const set = async (did) => {
  var ujnev = prompt("Diák neve:");
  await axios.put("http://localhost/ulesrend/api/index.php", {
    id: did,
    nev: ujnev
  })
    .then(response => {
      setUlesrend();
    })
    .catch(error => {
      console.error("Error: " + error);
    })
}

const add = async (i, j) => {
  var ujnev = prompt("Diák neve:");
  await axios.post("http://localhost/ulesrend/api/index.php", {
    nev: ujnev,
    sor: i,
    oszlop: j
  })
    .then(response => {
      setUlesrend();
    })
    .catch(error => {
      console.error("Error: " + error);
    })
}
</script>

<template>
  <main>
    <h1>Ülérend</h1>
    <section>
      <div class="rows df" v-for="(sor, i) in ulesrend">
        <div class="cols" v-for="(oszlop, j) in sor">
          <div>
            <p @click="set(oszlop.getId())">{{ oszlop.getNev() }}</p>
            <p v-if="oszlop.getId() == -1"><i @click="add(i, j)" class="bi bi-plus-circle-fill"></i></p>
            <p v-else><i class="bi bi-trash-fill" @click="del(oszlop.getId())"></i></p>
          </div>
        </div>
      </div>
    </section>
  </main>
</template>

<style scoped>
h1 {
  text-align: center;
}

.df {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}

.df div {
  background-color: aqua;
  width: 200px;
  padding-top: 20px;
  color: #000;
  font-weight: 600;
  cursor: pointer;
  text-align: center;
}

.df div:hover {
  background-color: antiquewhite;
}

.cols {
  margin: 20px;
}
</style>
