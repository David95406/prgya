<script setup>
import { ref, watch } from 'vue';
const termekTomb = ref([])

const termekNeve = ref("");
const termekAra = ref(0);
const errorField = ref(0)
const errorMessage = ref("");
const termekTombSzamlalo = ref(0);

const hozzaAd = () => {
    errorField.value = 0;
    errorMessage.value = "";


    if (termekNeve.value == "") {
        errorField.value = 1;
        errorMessage.value = "A termék neve kötelező";
    } else if (termekNeve.value.length > 30) {
        errorField.value = 1;
        errorMessage.value = "A termék neve nem lehet 30 karakternél hosszabb";
    }
    else if (termekAra.value > 1000000) {
        errorField.value = 2;
        errorMessage.value = "A termék ára nem lehet 1.000.000 forintnál több";
    }
    else {
        var t = {"nev": termekNeve.value, 
        "ar": termekAra.value}
        termekTomb.value.push(t);
        //termekNeve.value = termekAra.value = "";
    }
}

watch(termekTomb, () =>{
        if(termekTomb.length > 0){
            termekTombSzamlalo++;
            console.log(termekTombSzamlalo.value)
        }
    })
</script>
<template>
    <div class="formAlign">
        <form>
            <label for="#termekNeve">Termék neve</label>
            <input v-model="termekNeve" id="#termekNeve" type="text" placeholder="Termék neve">
            <label for="#termekAra">Termék ára</label>
            <input v-model="termekAra" id="#termekAra" type="number" placeholder="Termék ára (Ft)">
            <button @click.prevent="hozzaAd()">Hozzáadás</button>
        </form>
    </div>
    <div class="tableAlign">
        <h1>A lista üres</h1>
        <div>
            <table>
                <thead>
                    <tr>
                        <th><a href="#" class="thBtn">Termékek neve &uarr;</a></th>
                        <th><a href="#" class="thBtn">Termékek Ára &uarr;</a></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="termek in termekTomb">
                        <td>{{ termek["nev"] }}</td>
                        <td>{{ termek["ar"] }}</td>
                        <td class="deleteTd"><a href="#" class="deleteBtn">Törlés</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<style scoped>
.formAlign {
    display: flex;
    justify-content: center;
}

.tableAlign {
    display: flex;
    justify-content: center;
    margin-top: 50px;
}

th {
    padding: 10px;
}

table,
th,
td {
    border: 1px solid black;
}

.deleteTd {
    padding: 5px;
    background-color: red;
}

.deleteBtn,
.thBtn {
    text-decoration: none;
    color: white;
}

form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 200px;
    width: 300px;
    background-color: #e5eaf5;
    color: black;
    border-radius: 10px;
    opacity: 70%;
}

input {
    margin: 10px;
    width: 200px;
}
</style>