<script setup>

const props = defineProps({
    dogs: Array,
    isFavorite: {
        type: Boolean,
        default: false
    }
})

const emit = defineEmits(['addFavorite', 'removeFavorite', 'likeDog'])

const addToFavorite = (dawg) => {
    emit('addFavorite', dawg)
}

const removeFavorite = (dawg) => {
    if (confirm('sure?')) {
        emit('removeFavorite', dawg)        
    }
}

const likeDog = (dawg) => {
    emit('likeDog', dawg)
}

</script>

<template>
    <section>
        <div class="cards d-flex flex-wrap justify-content-center">
            <div class="card m-2" style="width: 18rem;">
                <div class="card-body" v-for="dog in dogs">
                    <p class="m-0"><img :src="dog.getUrl()"></p>
                    <i :class="[isFavorite ? 'red' : '']" @click="addToFavorite(dog)" class="bi bi-star-fill"></i>
                    <i v-if="isFavorite" class="bi bi-trash trash" @click="removeFavorite(dog)"></i>
                    <i v-if="isFavorite" class="bi bi-hand-thumbs-up-fill like" @click="likeDog(dog)">{{ dog.getLikes() }}</i>
                </div>
            </div>
        </div>
    </section>
</template>

<style scoped>
  img {
    height: 100%;
    width: 100%;
    object-fit: conver;
    object-position: center;
  }
  i {
    cursor: pointer;
    color: orange;
  }
  i.red {
    color: red;
  }
  i.trash {
    color: black;
  }
  i.like {
    color: blue;
  }
</style>
