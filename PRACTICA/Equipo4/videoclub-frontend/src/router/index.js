import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
    {path: '/', name: "Home", component: () => import('../views/Home.vue')},
    {path: '/peliculas', name: "Peliculas", component: () => import('../views/Peliculas.vue')},
    {path: '/login', name: "Login", component: () => import('../views/Login.vue')}
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router