<script setup>
import axios from 'axios';
import Karakter from '../classes/Karakter';
import { ref, onMounted } from 'vue';
import karakterLista from './karakterLista.vue';
import { useSzerepjatekKarakterek } from '../state/state';

const api = "https://reeldev.hu/api/probavizsga/karakterek";

const szerepjatekKarakterek = useSzerepjatekKarakterek()

const karakterek = ref([])

const karkterekLekerese = async () => {
    await axios.get(api)
        .then((response) => {
            const adatok = response.data

            adatok.forEach((adat) => {    
                if (!szerepjatekKarakterek.isDuplicate(adat)) { 
                    karakterek.value.push(new Karakter(adat['nev'], adat['faj'], adat['leiras'], adat['szint']))
                }

                
            })
            szerepjatekKarakterek.setKarakterek(karakterek.value)
        })
        .catch((error) => {
            console.error(error)
        })
}
karkterekLekerese()

const handleKivalaszt = (index) => {
    szerepjatekKarakterek.addKarakter(karakterek.value.at(index))
    karakterek.value.splice(index, 1)
}

</script>

<template>
    <section>
        <h2>Kezdőlap</h2>
    </section>
    <section>
        <karakterLista :isHome="true" :karakterek="karakterek" @kivalaszt="handleKivalaszt" />
    </section>
</template>

<style scoped></style>
