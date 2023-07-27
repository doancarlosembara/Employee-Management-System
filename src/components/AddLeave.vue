<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <h2 class="spasi">Spasi</h2>
        <label for="employee_id">Employee ID</label>
        <input
          type="text"
          class="form-control"
          id="employee_id"
          required
          v-model="bean.employee_id"
          name="employee_id"
        />
      </div>

      <div class="form-group">
        <label for="from_date">From Date</label>
        <input
          type="date"
          class="form-control"
          id="from_date"
          required
          v-model="bean.from_date"
          name="from_date"
          format="yyyy-MM-dd"
        />
      </div>
      <div class="form-group">
        <label for="to_date">To Date</label>
        <input
          type="date"
          class="form-control"
          id="to_date"
          required
          v-model="bean.to_date"
          name="to_date"
        />
      </div>
      <div class="form-group">
        <label for="type">Type</label>
        <input
          type="text"
          class="form-control"
          id="type"
          required
          v-model="bean.type"
          name="type"
        />
      </div>
      <div class="form-group">
        <label for="reason">Reason</label>
        <input
          type="text"
          class="form-control"
          id="reason"
          required
          v-model="bean.reason"
          name="reason"
        />
      </div>

      <button @click="saveLeave" class="btn btn-success">Submit</button>
    </div>

    <div v-else class="text-center">
      <h4>You submitted successfully!</h4>
      <button class="btn btn-success" @click="newLeave">Add</button>
      <button class="btn btn-primary" onclick="location.href='/employee'">
        Back
      </button>
    </div>
  </div>
</template>

<script>
import EmployeeService from "../services/EmployeeService";
import { format_date } from "../convertdate";
export default {
  name: "addleave",
  data() {
    return {
      bean: {
        id: null,
        employee_id: null,
        from_date: null,
        to_date: null,
        type: null,
        reason: null,
      },
      submitted: false,
      action: "ADD",
    };
  },
  mounted() {
    console.log("tes", this.$route.params.id);
    if (this.$route.params.id) {
      EmployeeService.getLeaveID(this.$route.params.id)
        .then((response) => {
          this.bean = response.data;
          this.bean.expired_date = format_date(this.bean.from_date);
          this.bean.birth_date = format_date(this.bean.to_date);
          this.action = "EDIT";
        })
        .catch((e) => {
          console.log(e);
        });
    }
  },
  methods: {
    saveLeave() {
      EmployeeService.createleave(this.bean)
        .then((response) => {
          this.bean.id = response.data.id;
          this.submitted = true;
        })
        .catch((e) => {
          console.log(e);
        });
    },

    newLeave() {
      this.submitted = false;
      this.bean = {};
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
/* .container {
    /* display: flex; */
/* justify-content: center; */
/* align-items: center; */
/* height: 100vh; */

/* .content h4 {
    margin-top: 0;
    margin-bottom: 10px;
    font-size: 24px;
  }
  
  .content button {
    margin-right: 10px;
  } */

.spasi {
  color: white;
}
</style>
