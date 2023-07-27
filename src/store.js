// import Vue from "vue";
// import Vuex from "vuex";

// Vue.use(Vuex);

// const store = new Vuex.Store({
//   state: {
//     employee: [],
//     leave: [],
//   },
//   mutations: {
//     setEmployee(state, employee) {
//       state.employee = employee;
//     },
//     setLeave(state, leave) {
//       state.leave = leave;
//     },
//   },
//   actions: {
//     async fetchEmployee({ commit }) {
//       const response = await fetch("https:localhost:8081/employee/list");
//       const employee = await response.json();
//       commit("setEmployee", employee);
//     },
//     async fetchLeave({ commit }, id) {
//       const response = await fetch(`https:localhost:8081/employee/${id}/leave`);
//       const leave = await response.json();
//       commit("setLeave", leave);
//     },
//   },
// });

// export default store;
