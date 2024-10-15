<script setup>
import { ref, watch, watchEffect } from 'vue';
import Blog from './components/Blog.vue';
import { blogDatas } from './data/blogs';

const blogs = ref(blogDatas)
const sortType = ref(0)

const setVisibile = (() => {
  blogs.value.forEach((blog) => {
    if (sortType.value == 1 && blog.likes == 0) {
      blog.show = false
    } else {
      blog.show = true
    }
  })
  /*
  if (sortType.value == 1) {
    blogs.value.forEach((blog) => {
      if (blog.likes == 0) {
        blog.show = false;
      }
    })
  } else {
    blogs.value.forEach((blog) => {
      blog.show = true;
    })
  }
    */

})

watch(sortType, (() => {
  setVisibile()
}))

const readIndex = ref(-1)
const readMore = ((index) => {
  readIndex.value = index
})

const back = (() => {
  readIndex.value = -1
})

</script>

<template>
  <header>
    <h1>Bloglist</h1>
  </header>
  <main>
    <section v-if="readIndex == -1">
      <select v-model="sortType">
        <option value="0" selected>All</option>
        <option value="1">Popular</option>
      </select>
    </section>

    <section>
      <div v-for="(blog, index) in blogs" v-if="readIndex == -1">
        <!-- <Blog :title="blog.title" :body="blog.body" :likes="blog.likes" :show="blog.show" /> -->
        <!-- <Blog v-bind="blog"/>-->
        <Blog :blog="blog" v-if="blog.show" @increase-likes="blog.likes++" @read-more="readMore(index)" :isReading="flase"/>
      </div>
      <div v-else>
        <Blog :blog="blogs[readIndex]" isReading @back="back()"/>
      </div>
    </section>
  </main>
  <footer>
    <p>Copyright &copy; </p>
  </footer>
</template>

<style scoped>
main {
  padding: 10px;
}

select {
  padding: 10px;
  width: 100%;
}
</style>
