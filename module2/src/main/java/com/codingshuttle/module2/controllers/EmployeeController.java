package com.codingshuttle.module2.controllers;

import com.codingshuttle.module2.dto.EmployeeDTO;
import com.codingshuttle.module2.entities.EmployeeEntity;
import com.codingshuttle.module2.repositories.EmployeeRepository;
import com.codingshuttle.module2.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   /* @GetMapping("/getSecretMessage")
    //getMySecretMessage is called by dispacter servlet
    public String getMySecretMessage(){
        return "Secret message : asdfghjkl;'dftyuhgvbnm";
    }
    */

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false,name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }


    @PutMapping
    public String updateEmployee(){
        return "Hello from update employee";
    }

}
