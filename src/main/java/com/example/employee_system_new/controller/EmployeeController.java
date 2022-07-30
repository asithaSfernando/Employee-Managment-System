package com.example.employee_system_new.controller;


import com.example.employee_system_new.exception.ResourceNotFoundException;
import com.example.employee_system_new.model.Employee;
import com.example.employee_system_new.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.employee_system_new.repository.EmployeeRepository.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id : " +id));

        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id : " +id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);

    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee (@PathVariable long id){
        Employee employee =employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee Not exist with id : "+id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
