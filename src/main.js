import { createApp } from "vue";
import App from "./App.vue";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import router from "./router";
import { format_date } from "./convertdate";

// import moment from "moment";

// const MyPlugin = {
//   install(Vue) {
//     Vue.prototype.formatDate = (value) => {
//       if (value) {
//         return moment(String(value)).format("DD/MM/YYYY");
//       }
//     };
//   },
// };

createApp(App)
  .use(router)
  .use(format_date)
  .mount("#app");
