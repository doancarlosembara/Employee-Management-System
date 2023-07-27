<template>
  <div class="list row justify-content-center">
    <div class="col-md-20">
      <div>
        <h4 class="judul">
          Daftar Loookup
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
          <button
            class="btn btn-outline-secondary"
            type="button"
            @click="searchData"
          >
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
              <th>Group Name</th>
              <th>Description</th>
              <th class="action">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="lookup in lookups" :key="lookup.id">
              <td>{{ lookup.group_name }}</td>
              <td>{{ lookup.description }}</td>
              <td class="edit">
                <button @click="editData" class="btn btn-primary">
                  Edit
                </button>

                <button @click="deleteData(lookup.id)" class="btn btn-danger">
                  Hapus
                </button>
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
  name: "lookups-list",
  data() {
    return {
      lookups: [],
      name: "", // tambahkan variabel untuk menyimpan input search
    };
  },
  methods: {
    editData(id) {
      this.$router.push({ name: "edit", params: { id } });
    },
    async getLookupAll() {
      const lookupDb = await EmployeeService.getAllLookup();
      this.lookups = lookupDb.data;
    },
    deleteData(id) {
      if (confirm("Apakah Anda yakin ingin menghapus data ini?")) {
        EmployeeService.delete(id)
          .then(() => {
            alert("Data berhasil dihapus");
            this.getLookupAll();
          })
          .catch((error) => {
            console.log(error);
            alert("Terjadi kesalahan saat menghapus data");
          });
      }
    },
    searchData() {
      // tambahkan method untuk melakukan search
      EmployeeService.searchLookup(this.group_name) // panggil method searchLookup pada EmployeeService dan lewatkan parameter name
        .then((response) => {
          this.lookups = response.data;
        })
        .catch((error) => {
          console.log(error);
          alert("Terjadi kesalahan saat mencari data");
        });
    },
  },
  mounted() {
    this.getLookupAll();
  },
};
</script>
<style></style>
