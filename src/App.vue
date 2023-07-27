<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container d-flex justify-content-center align-items-center">
        <a class="navbar-brand" href="#">Simian</a>
        <!-- <div class="input-group mx-3">
          <input
            type="text"
            class="form-control"
            placeholder="Cari nama"
            v-model="nama"
          />
          <div class="input-group-append">
            <button class="btn btn-outline-secondary" type="button">
              Search
            </button>
          </div>
        </div> -->
      </div>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link to="/employee" class="nav-link" active-class="active"
              >Employee</router-link
            >
          </li>
          <li class="nav-item">
            <router-link to="/lookup" class="nav-link" active-class="active"
              >Lookup</router-link
            >
          </li>
          <!-- <li class="nav-item">
            <router-link to="/leave" class="nav-link" active-class="active"
              >Leave</router-link
            >
          </li> -->
        </ul>
      </div>
    </nav>
    <router-view />
  </div>
</template>
<script>
export default {
  name: "app",
};
</script>

<style src="./App.css"></style>
