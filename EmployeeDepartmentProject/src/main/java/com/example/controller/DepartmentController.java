package com.example.controller;

import com.example.model.Department;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/delete/{id}")
    public void deleteDepartement(@PathVariable Long id) {
    	departmentService.deleteDepartment(id);
    }
    
    /*
     *  @RestController: Marks this as a REST API controller.
 • @RequestMapping("/departments"): Base URL for department-related operations.
 • @PostMapping: Handles saving a department.
 • @GetMapping: Retrieves all departments.

     */
}
