<script setup>

</script>


<template>
    <section v-for="i in 3" class="df">
        <div><img src="../assets/film-1.jpg" alt="film1" title="Film 1"></div>
        <div>
            <div class="df">
                <h2>Lorem Ipsum</h2>
                <div><strong>Vote</strong> | {{ 1 }}</div>
            </div>
            <p></p>
        </div>
    </section>
</template>


<style scoped>
.df {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

section {
    background-color: lightgray;
    padding: 10px;
    width: 60%;
    margin: 0px auto;
    margin-bottom: 20px;
}

strong {
    color: green;
}

img {
    margin-right: 20px;
}

h2 {
    margin: 0;
    padding: 0;
}
</style>