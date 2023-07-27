<template>
  <div class="list row justify-content-center">
    <div class="col-md-20">
      <div>
        <h4 class="judul">
          Daftar Karyawan
        </h4>
      </div>

      <div class="input-group mx-3">
        <input
          type="text"
          class="form-control"
          placeholder="Cari name"
          v-model="name"
        />

        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button">
            Search
          </button>
          <div class="tambah">
            <button @click="$router.push('add')" class="btn btn-success">
              Tambah
            </button>
          </div>
        </div>
      </div>
      <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover">
          <thead>
            <tr>
              <th>NIK</th>
              <th>Name</th>
              <th>Hired Date</th>
              <th>Expired Date</th>
              <th>Salary</th>
              <th>Birth Date</th>
              <th>NPWP</th>
              <th>Sex</th>
              <th>Type</th>
              <th class="action">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="employee in employees" :key="employee.id">
              <td>{{ employee.nik }}</td>
              <td>{{ employee.name }}</td>
              <td>
                {{ new Date(employee.hired_date).toLocaleDateString("en-GB") }}
              </td>
              <td>
                {{
                  new Date(employee.expired_date).toLocaleDateString("en-GB")
                }}
              </td>
              <td>{{ employee.salary }}</td>
              <td>
                {{ new Date(employee.birth_date).toLocaleDateString("en-GB") }}
              </td>
              <td>{{ employee.npwp }}</td>
              <td>{{ lookupsex.find((e) => e.id === employee.sex).description}}</td>
              <td>{{ lookupemployeetype.find((e) => e.id === employee.type).description}}</td>
              <td class="edit">
                <button @click="editData(employee.id)" class="btn btn-primary">
                  Edit
                </button>
                <button @click="deleteData(employee.id)" class="btn btn-danger">
                  Hapus
                </button>
                <button @click="showDetail(employee.id)" class="btn btn-info">
                  Status
                </button>
                <!-- <td><router-link :to="'/leave/' + employee.id">Lihat Detail Cuti</router-link></td> -->
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import EmployeeService from "../services/EmployeeService";

export default {
  name: "employees-list",
  data() {
    return {
      employees: [],
      lookupemployeetype: [],
      lookupsex: [],
    };
  },
  // computed: {
  //   employeeList() {
  //     return this.$store.state.employee;
  //   },

  //   created() {
  //     this.$store.dispatch("fetchEmployee");
  //   },
  // },
  methods: {
    editData(id) {
      this.$router.push({ name: "edit", params: { id } });
    },
    async getEmployeeAll() {
      const employeeDb = await EmployeeService.getAllEmployee();
      this.employees = employeeDb.data;
    },

    showDetail(id) {
      this.$router.push({ name: "leave", params: { id } });
    },

    deleteData(id) {
      if (confirm("Apakah Anda yakin ingin menghapus data ini?")) {
        EmployeeService.delete(id)
          .then(() => {
            alert("Data berhasil dihapus");
            this.getEmployeeAll();
          })
          .catch((error) => {
            console.log(error);
            alert("Terjadi kesalahan saat menghapus data");
          });
      }
    },

    searchName() {
      EmployeeService.findByName(this.name)
        .then((response) => {
          this.employees = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },

  mounted() {
    this.getEmployeeAll();
    EmployeeService.getAllLookup("SEX")
        .then((response) => {
          this.lookupsex = response.data;
        })
        EmployeeService.getAllLookup("EMPLOYEE_TYPE")
        .then((response) => {
          this.lookupemployeetype = response.data;
        })
  },
};
</script>

<style src="./EmployeeList.css"></style>

