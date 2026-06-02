package com.codingshuttle.module2.services;

import com.codingshuttle.module2.dto.EmployeeDTO;
import com.codingshuttle.module2.entities.EmployeeEntity;
import com.codingshuttle.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employee =  employeeRepository.findById(id).orElse(null);
      //  return new EmployeeDTO(employee.getId(), employee.getName(), employee.getEmail(), employee.getAge(), employee.getDateOfJoining(),employee.getIsActive());

        return modelMapper.map(employee,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());

    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {

        EmployeeEntity inputEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity employee =  employeeRepository.save(inputEntity);
        return modelMapper.map(employee,EmployeeDTO.class);
    }


}
