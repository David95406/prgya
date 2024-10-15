<script setup>
import { defineProps, defineEmits } from 'vue';

const props = defineProps({
    /*
    title: String,
    body: String,
    likes: Number,
    show: Boolean,
    */
    blog: Object,
})

const emit = defineEmits(
    ['increase-likes']
)

const sendMessage = (() => {
    emit('increase-likes')
})

</script>

<template>
    <div class="blog">
        <h2>{{ blog["title"] }}</h2>
        <p>{{ blog["body"] }}</p>
        <div class="df">
            <p>Likes: {{ blog["likes"] }}</p>
            <p>
                <a @click="sendMessage()">Like</a>
            </p>
        </div>
    </div>

</template>

<style scoped>
.blog {
    border-bottom: 1px solid #fff;
}

.df {
    display: flex;
    justify-content: space-between;
}

a {
    background-color: #ccc;
    color: black;
    padding: 5px 10px;
    border-radius: 10px;
    cursor: pointer;
}
a:hover {
    background-color: black;
    color: #ccc;
}
</style>