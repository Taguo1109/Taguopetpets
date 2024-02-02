// router.js
import { createRouter, createWebHistory } from 'vue-router';
import Index from './views/Index.vue';
import AllCustomers from './views/customer/AllCustomer.vue';

const routes = [
  { path: '/', component: Index },
  { path: '/customers', component: AllCustomers },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;

