import { createRouter, createWebHistory } from "vue-router";
import Favorites from "../components/Favorites.vue";
import Home from "../components/Home.vue";

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/favorites',
        name: 'Favorites',
        component: Favorites
    }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

export default router