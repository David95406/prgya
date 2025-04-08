import { createRouter, createWebHistory } from "vue-router";
import Fooldal from "../components/Fooldal.vue";
import Kedvencek from "../components/Kedvencek.vue";

const routes = [
    {
        path: '/',
        component: Fooldal,
    },
    {
        path: "/kedvencek",
        component: Kedvencek
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router