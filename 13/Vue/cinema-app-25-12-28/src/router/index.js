import { createRouter, createWebHistory } from "vue-router";
import Home from "../components/FilmList.vue"; // a fooldal
import Film from "../components/Film.vue";
import SuccessReserved from "../components/SuccessReserved.vue";

const routes = [{
        path: "/",
        component: Home,
    },
    {
        path: "/film",
        component: Film,
    },
    {
        path: "/success-reserved",
        component: SuccessReserved,
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
