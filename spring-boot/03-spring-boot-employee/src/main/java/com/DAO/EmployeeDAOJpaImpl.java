package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAOJpa {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    @Transactional
    public Employee getLastEmployee() {
        Query query = entityManager.createQuery("from Employee ORDER BY id DESC LIMIT 1");
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
