import Vue from 'vue'
import Router from 'vue-router'
import Hotel from '@/components/Hotel'

Vue.use(Router);

const router = new Router({
    mode: 'history', // uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
    routes: [
        { path: '/', component: Hotel },

        // otherwise redirect to home
        { path: '*', redirect: '/' }
    ]
});

export default router;