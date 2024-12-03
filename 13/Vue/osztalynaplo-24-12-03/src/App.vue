<script setup>
import { ref, watch, computed } from 'vue'
import students from "./data/student.js"
import Student from './classes/Student'
import Statisztika from './components/Statisztika.vue'
import Grademanager from './components/Grademanager.vue'

const search = ref("")
var searchResults
const isSort = ref(true)
const isTable = ref(true)
const isStat = ref(false)
const isGradeM = ref(false)

const studentList = ref([])
students.forEach((student) => {
  studentList.value.push(new Student(
    student.id,
    student.name,
    student.class,
    student.grades,
    student.absences
  ))
})
/*
searchResults = studentList
watch(studentList => {
  searchResults = studentList
})


seatchResults = computed(() => {
  return studentList.value.filter((student) => {
    return student.getName().toLowerCase().includes(search.value.toLowerCase()) || 
    student.getClassname().toLowerCase().includes(search.value.toLowerCase())
  })
})
*/

const sortType = ref('Csökkenő sorrend')

const changeSortType = ((type) => {
  switch (type) {
    case 0:
      sortType.value = "Csökkenő sorrend";
      break;
    case 1:
      sortType.value = "Növekvő sorrend";
      break;
    default:
      break;
  }
})

const atlag = computed(() => {
  var sum = 0;
  studentList.value.forEach((student) => {
    sum += student.getAtlag();
  })
  return sum / studentList.value.length;
})

const addAbsence = ((id) => {
  studentList.value.forEach((student, index) => {
    if (student.getId() == id) {
      var ujStudent = studentList.value[index];
      ujStudent.addAbsence();
      studentList.value.splice(index, 1);
      studentList.value.push(ujStudent);
    }
  })
})

const gradeId = ref(-1)
const addGrade = ((grade) => {
  studentList.value.forEach((student, index) => {
    if (student.getId() == gradeId.value) {
      var ujStudent = studentList.value[index];
      ujStudent.addGrade(grade);
      studentList.value.splice(index, 1);
      studentList.value.push(ujStudent);
    }
  })
  gradeId.value = -1;
  back()
})

const back = (() => {
  isSort.value = true;
  isTable.value = true;
  isStat.value = false;
  isGradeM.value = false;
})

const goToStat = (() => {
  isSort.value = false;
  isTable.value = false;
  isStat.value = true;
})

const goToGrade = ((id) => {
  gradeId.value = id;
  isSort.value = false;
  isTable.value = false;
  isGradeM.value = true;
})

</script>

<template>
  <header>Osztálynapló</header>
  <main>
    <section v-if="isSort">
      <button @click="goToStat">Hiányzások</button>
      <span>Átlag: {{ atlag }}</span>
      <div class="mb-3">
        <input v-model="search" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Név vagy osztály">
      </div>
      <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
          {{ sortType }}
        </button>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" @click="changeSortType(0)">Csökkenő sorrend</a></li>
          <li><a class="dropdown-item" @click="changeSortType(1)">Növekvő sorrend</a></li>
        </ul>
      </div>
    </section>

    <section v-if="isTable">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Diák</th>
            <th scope="col">Osztály</th>
            <th scope="col">Jegyek</th>
            <th scope="col">Hiányzás</th>
            <th scope="col">Új jegy</th>
            <th scope="col">Hiányzás</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(student, index) in studentList">
            <th :title="student.getTitle()">{{ student.getName() }}</th>
            <td>{{ student.getClassname() }}</td>
            <td>{{ student.printGrades() }}</td>
            <td>{{ student.getAbsences() }}</td>
            <td @click="goToGrade(student.getId())">Új jegy</td>
            <td @click="addAbsence(student.getId())">Hiányzás</td>
          </tr>
        </tbody>
      </table>
    </section>
    <section v-if="isStat">
      <Statisztika :students="studentList" @back="back" />
    </section>
    <section v-if="isGradeM">
      <Grademanager @add="addGrade" />
    </section>
  </main>
  <footer></footer>
</template>

<style scoped></style>
