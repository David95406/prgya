import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import { createPinia } from 'pinia'
import { createRouter } from 'vue-router'

const app = createApp(App)
const pinia = createPinia()
const router = createRouter()

app.use(pinia)
app.use(router)
app.mount('#app')