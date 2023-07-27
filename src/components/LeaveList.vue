<template>
  <h4 class="judul">
    Info Karyawan
  </h4>
  <div class="submit-form">
    <!-- <div v-if="!submitted"> -->
    <div class="table-responsive">
      <table class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th>NIK</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          <td>{{ bean.nik }}</td>
          <td>{{ bean.name }}</td>
        </tbody>
      </table>
    </div>
    <div></div>
  </div>
  <div class="list row justify-content-center">
    <div class="col-md-8">
      <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover">
          <thead class="judul-kolom">
            <tr>
              <th>Employee ID</th>
              <th>From Date</th>
              <th>To Date</th>
              <th>Type</th>
              <th>Reason</th>
              <!-- <th class="action">Action</th> -->
            </tr>
          </thead>
          <tbody>
            <tr v-for="leave in leaves" :key="leave.id">
              <td>{{ leave.employee_id }}</td>
              <td>
                {{ new Date(leave.from_date).toLocaleDateString("en-GB") }}
              </td>
              <td>
                {{ new Date(leave.to_date).toLocaleDateString("en-GB") }}
              </td>
              <td>{{ leave.type }}</td>
              <td>{{ leave.reason }}</td>
              <!-- <td class="edit">
                <button @click="editData(employee.id)" class="btn btn-primary">
                  Edit
                </button>
                <button @click="deleteData(employee.id)" class="btn btn-danger">
                  Hapus
                </button>
              </td> -->
            </tr>
          </tbody>
        </table>
        <button @click="$router.push('/leave/add')" class="btn btn-success">
          Tambah
        </button>
        <button class="btn btn-primary" onclick="location.href='/employee'">
          Back
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import EmployeeService from "../services/EmployeeService";
import { format_date } from "../convertdate";
export default {
  name: "detail-employee",
  data() {
    return {
      leaves: [],
      bean: {
        id: null,
        nik: null,
        name: null,
        hired_date: null,
        expired_date: null,
        salary: null,
        birth_date: null,
        npwp: null,
        sex: null,
        type: null,
      },

      submitted: false,

      action: "ADD",
    };
  },

  mounted() {
    this.employeeId = this.$route.params.id;

    if (this.$route.params.id) {
      EmployeeService.getEmployeeID(this.employeeId)
        .then((response) => {
          this.bean = response.data;
          this.bean.hired_date = format_date(this.bean.hired_date);
          this.bean.expired_date = format_date(this.bean.expired_date);
          this.bean.birth_date = format_date(this.bean.birth_date);
          this.action = "STATUS";
        })
        .catch((e) => {
          console.log(e);
        });
    }

    this.getLeaveAll();
  },
  // computed: {
  //   employee() {
  //     const employeeId = this.$route.params.id;
  //     return (
  //       this.$store.state.employee.find(
  //         (employee) => employee.id === employeeId
  //       ) || {}
  //     );
  //   },
  //   cutiList() {
  //     return this.$store.state.leave;
  //   },
  // },
  // created() {
  //   const employeeId = this.$route.params.id;
  //   this.$store.dispatch("fetchLeave", employeeId);
  // },

  methods: {
    async getLeaveAll() {
      const leaveDb = await EmployeeService.getAllLeave(this.employeeId);
      this.leaves = leaveDb.data;
    },
  },
};
</script>

<style>
.submit-form {
  max-width: 400px;
  margin: auto;
}

.edit {
  position: center;
}

.action {
  text-align: center;
}

.judul-kolom {
  justify-content: center;
  align-items: center;
}
</style>
