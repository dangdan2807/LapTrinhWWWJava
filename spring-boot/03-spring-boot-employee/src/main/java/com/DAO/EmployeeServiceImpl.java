package com.DAO;

import java.util.List;
import java.util.Optional;

import com.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeDAOSpringData {
    private EmployeeRepositorySpringData employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepositorySpringData employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if(optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee id not found - " + id);
        }
        return employee;
    }

    @Override
    public Employee getLastEmployee() {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}
