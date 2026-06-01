package com.codingshuttle.module2.controllers;

import com.codingshuttle.module2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
   /* @GetMapping("/getSecretMessage")
    //getMySecretMessage is called by dispacter servlet
    public String getMySecretMessage(){
        return "Secret message : asdfghjkl;'dftyuhgvbnm";
    }
    */

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return new EmployeeDTO(id,"sadwika","pabba.sadwika@gmail.com",22, LocalDate.of(2024,5,6),true);

    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false,name = "inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "age is :" + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }


    @PutMapping
    public String updateEmployee(){
        return "Hello from update employee";
    }

}
