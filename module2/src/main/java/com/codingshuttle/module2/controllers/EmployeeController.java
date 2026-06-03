package com.codingshuttle.module2.controllers;

import com.codingshuttle.module2.dto.EmployeeDTO;
import com.codingshuttle.module2.entities.EmployeeEntity;
import com.codingshuttle.module2.repositories.EmployeeRepository;
import com.codingshuttle.module2.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                             @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeByID(@RequestBody EmployeeDTO employee, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateTheEmployeeDetails(employee, employeeId));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId) {
        boolean isDeleted = employeeService.deleteEmployee(employeeId);
        if (isDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialData(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId) {

        EmployeeDTO employeeDTO = employeeService.updatePartialDataBasedOnData(updates, employeeId);
        if (employeeDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);

    }
}