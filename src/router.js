import { createWebHistory, createRouter } from "vue-router";
// import Vue from "vue";
// import VueRouter from "vue-router";
// import Karyawan from "./components/EmployeeList.vue";
// import Leave from "./components/LeaveList.vue";
const routes = [
  {
    path: "/",
    alias: "/employee",
    name: "employee",
    component: () => import("./components/EmployeeList"),
  },

  {
    path: "/add",
    name: "add",
    component: () => import("./components/AddEmployee"),
  },
  {
    path: "/edit",
    name: "edit",
    component: () => import("./components/AddEmployee"),
  },
  {
    path: "/lookup",
    name: "lookup",
    component: () => import("./components/LookupList"),
  },
  {
    path: "/leave",
    name: "leave",
    component: () => import("./components/LeaveList"),
  },
  {
    path: "/leave/add",
    name: "addleave",
    component: () => import("./components/AddLeave"),
  },
  // {
  //   path: "/employee/:id/leave",
  //   component: () => import("./components/EmployeeList"),
  // },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
