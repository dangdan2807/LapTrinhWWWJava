package com.DAO;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDAO {
    public List<Employee> getEmployees();

    public Employee getEmployeeById(int id);

    public Employee getLastEmployee();

    public void saveEmployee(Employee employee);

    public void deleteEmployeeById(int id);
}
