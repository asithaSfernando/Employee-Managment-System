package com.example.employee_system_new.repository;

import com.example.employee_system_new.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void createEmployee() {
        Employee employee = new Employee(123, "Ranil", "Perera", "ranil@gmail.com");
        Employee savedEmployee = employeeRepository.save(employee);
        Employee newEmployee = employeeRepository.findById(savedEmployee.getId()).get();
        assertEquals("Ranil", newEmployee.getFirstName());
        assertEquals("Perera", newEmployee.getLastName());
        assertEquals("ranil@gmail.com", newEmployee.getEmailId());
    }

    @Test
    public void findAllEmployees()  {
        List<Employee> employees = employeeRepository.findAll();
        assertNotNull(employees);
    }

}
