package com.example.employee_system_new;

import com.example.employee_system_new.model.Employee;
import com.example.employee_system_new.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.CommonDataSource;

@SpringBootApplication
public class EmployeeSystemNewApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSystemNewApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();
        employee.setFirstName("Asitha");
        employee.setLastName("Fernando");
        employee.setEmailId("abc@gmail.com");
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Shivantha");
        employee1.setLastName("Fernando");
        employee1.setEmailId("pqr@gmail.com");
        employeeRepository.save(employee1);




    }
}
