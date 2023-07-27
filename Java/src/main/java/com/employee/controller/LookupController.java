package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.Leave;
import com.employee.model.Lookup;
import com.employee.repository.LookupRepository;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lookup")
public class LookupController {

    @Autowired
    private EmployeeService lookupService;

    @GetMapping("/list/{group_name}")
    public List<Lookup> list (@PathVariable(value = "group_name") String group_name) {
        System.out.println("group name = " + group_name);
        return lookupService.getAllLookup(group_name);
    }

    @PostMapping ("/add")
    public Lookup add (@RequestBody Lookup lookup){

        return lookupService.save(lookup);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        System.out.println("deleteById = "+id);
        lookupService.deleteLookupById(id);
        return "Data Lookup telah dihapus";
    }

    @PostMapping("/update")
    public String update(@RequestBody Lookup lookup) {
        Lookup lookupdb = lookupService.getLookupById(lookup.getId());
        lookupdb.setId(lookup.getId());
        lookupdb.setGroup_name(lookup.getGroup_name());
        lookupdb.setDescription(lookup.getDescription());
        lookupdb.setCreated_date(lookup.getCreated_date());
        lookupdb.setCreated_by(lookup.getCreated_by());
        lookupdb.setModified_date(lookup.getModified_date());
        lookupdb.setModified_by(lookup.getModified_by());
        lookupService.save(lookupdb);
        return "Data Lookup telah diupdate";

    }

//    @GetMapping("/lookup")
//    public List<Lookup> getLookupByGroupName () {
//        return lookupService.getLookupByGroupName();
//    }
    //
//
//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee){
//        employeeService.save(employee);
//        return "redirect:/";
//    }
//
//    @GetMapping("updateform/{id}")
//    public String updateForm(@PathVariable(value = "id") long id, Model model){
//        Employee employee = employeeService.getById(id);
//        model.addAttribute("employee", employee);
//        return "update";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteById(@PathVariable(value = "id") long id){
//        employeeService.deleteById(id);
//        return "redirect:/";
//    }
//

}
