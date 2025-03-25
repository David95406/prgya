<script setup>
import { ref, watch } from 'vue';
import axios from 'axios';

const props = defineProps({
    url: String,
})

const modalId = ref(`pokemon-modal-${Math.floor(Math.random() * 10000)}`)
const abilites = ref([])
const stats = ref([])

const getPokemonDetails = async () => {
    abilites.value = []
    stats.value = []
    
    try {
        const response = await axios.get(props.url)
        const abilitesResponse = response.data['abilities']
        const statsResponse = response.data['stats']
        
        abilitesResponse.forEach((ability) => {
            abilites.value.push(ability["ability"])
        })
        
        statsResponse.forEach((stat) => {
            stats.value.push(stat)
        })
    } catch (error) {
        console.error(error)
    }
}

getPokemonDetails()

watch(props, () => {
    getPokemonDetails()
}, { deep: true })

const getStatColor = (value) => {
    if (value < 50) return 'danger';
    if (value < 70) return 'warning';
    if (value < 90) return 'info';
    return 'success';
}
</script>

<template>
    <div>
        <button type="button" class="btn btn-secondary w-100" data-bs-toggle="modal" :data-bs-target="`#${modalId}`">
            Show Pokemon Details
        </button>
        <div class="modal fade" :id="modalId" tabindex="-1" aria-labelledby="`${modalId}Label`" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
                <div class="modal-content">
                    <div class="modal-header bg-danger text-white">
                        <h5 class="modal-title" :id="`${modalId}Label`">Pokemon Details</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-4">
                            <h5 class="border-bottom pb-2 mb-3">Stats</h5>
                            <div v-for="stat in stats" :key="stat.stat.name" class="mb-3">
                                <div class="d-flex justify-content-between mb-1">
                                    <span class="text-capitalize fw-bold">{{ stat.stat.name }}</span>
                                    <span>{{ stat.base_stat }}/150</span>
                                </div>
                                <div class="progress" style="height: 10px;">
                                    <div class="progress-bar bg-{{ getStatColor(stat.base_stat) }}" role="progressbar"
                                        :style="`width: ${(stat.base_stat / 150) * 100}%`" 
                                        :aria-valuenow="stat.base_stat" 
                                        aria-valuemin="0" aria-valuemax="150">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <h5 class="border-bottom pb-2 mb-3">Abilities</h5>
                            <ul class="list-group">
                                <li v-for="ability in abilites" :key="ability.name" 
                                    class="list-group-item d-flex justify-content-between align-items-center text-capitalize">
                                    {{ ability.name }}
                                    <span class="badge bg-primary rounded-pill">Ability</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
