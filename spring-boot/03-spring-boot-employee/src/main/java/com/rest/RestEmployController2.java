package com.rest;

import java.util.List;

import com.DAO.*;
import com.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class RestEmployController2 {
    private EmployeeDAOJpa employeeDao;

    @Autowired
    public RestEmployController2(EmployeeDAOJpa employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws Exception {
        Employee employee = employeeDao.getEmployeeById(id);
        if ((id < 0) || employee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + id);
        }
        return employeeDao.getEmployeeById(id);
    }

    @GetMapping("/employees/last")
    public Employee getEmployeeById(){
        return employeeDao.getLastEmployee();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeDao.saveEmployee(employee);
        return employee;
    }
    
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeDao.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteCustomer(@PathVariable int id) throws Exception {
        Employee employee = employeeDao.getEmployeeById(id);
        if ((id < 0) || employee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + id);
        }
        employeeDao.deleteEmployeeById(id);

        return "Deleted Employee id - " + id;
    }

    
    @ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
