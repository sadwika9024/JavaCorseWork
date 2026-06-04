package com.codingshuttle.module2.services;

import com.codingshuttle.module2.dto.EmployeeDTO;
import com.codingshuttle.module2.entities.EmployeeEntity;
import com.codingshuttle.module2.exceptions.ResourceNotFoundException;
import com.codingshuttle.module2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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

  public Optional<EmployeeDTO> getEmployeeById(Long id) {
//    Optional<EmployeeEntity> employee = employeeRepository.findById(id);
//    return employee.map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));

    return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));

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
    EmployeeEntity employee = employeeRepository.save(inputEntity);
    return modelMapper.map(employee,EmployeeDTO.class);
  }

  public EmployeeDTO updateTheEmployeeDetails(EmployeeDTO employee,Long id){
     isIdExists(id);
    EmployeeEntity employeeEntity = modelMapper.map(employee,EmployeeEntity.class);
    employeeEntity.setId(id);
    return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
  }

  public void isIdExists(Long id){

    boolean exists = employeeRepository.existsById(id);
    if(!exists) throw new ResourceNotFoundException("employee Doesn't exists with id : "+id);
  }

  public boolean deleteEmployee(Long id)
  {
    isIdExists(id);
   employeeRepository.deleteById(id);
    return true; 
  }

  public EmployeeDTO updatePartialDataBasedOnData(Map<String,Object> update, Long id){
    isIdExists(id);
    EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
    update.forEach((field,value) -> {
      Field filedToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class,field);
        filedToBeUpdated.setAccessible(true);
      ReflectionUtils.setField(filedToBeUpdated,employeeEntity,value);

    });

    return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
  }


}