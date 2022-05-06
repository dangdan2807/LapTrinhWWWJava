package com.RestController;

import java.util.List;
import java.util.Optional;

import com.DAO.EmployeeServiceImpl;
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
@RequestMapping("/api")
public class RestEmployController {
    private EmployeeServiceImpl employeeDao;

    @Autowired
    public RestEmployController(EmployeeServiceImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws Exception {
        Employee employee = employeeDao.getById(id);
        // if ((id < 0) || employee == null) {
        //     throw new EmployeeNotFoundException("Employee id not found - " + id);
        // }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeDao.saveAndFlush(employee);
        return employee;
    }
    
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeDao.saveAndFlush(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteCustomer(@PathVariable int id) throws Exception {
        employeeDao.deleteById(id);
        // if ((id < 0) || employee == null) {
        //     throw new EmployeeNotFoundException("Employee id not found - " + id);
        // }
        // employeeDao.deleteEmployeeById(id);

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
