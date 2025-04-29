import {
    createRouter,
    createWebHistory
} from "vue-router";
import kezdolap from "../components/kezdolap.vue";
import karaktereim from "../components/karaktereim.vue";


const routes = [
    {
        path: "/",
        component: kezdolap
    },
    {
        path: "/karaktereim",
        component: karaktereim
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;