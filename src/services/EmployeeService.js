import http from "../http-common";

class EmployeeService {
  getAllEmployee() {
    return http.get("/employee/list");
  }

  getAllLookup(group_name) {
    return http.get(`/lookup/list/${group_name}`);
  }

  getAllLeave(employeeId) {
    return http.get("/leave/get/" + employeeId);
  }

  getEmployeeID(id) {
    return http.get(`/employee/get/${id}`);
  }

  getLeaveID(id) {
    return http.get(`/leave/get/${id}`);
  }

  create(data) {
    return http.post("/employee/add", data);
  }

  createleave(data) {
    return http.post("/leave/add", data);
  }

  update(id, data) {
    return http.post(`employee/update/${id}`, data);
  }

  delete(id) {
    return http.delete(`/employee/delete/${id}`);
  }

  searchLookup() {
    return http.get(`/lookup?nama=$nama`);
  }
}

export default new EmployeeService();
