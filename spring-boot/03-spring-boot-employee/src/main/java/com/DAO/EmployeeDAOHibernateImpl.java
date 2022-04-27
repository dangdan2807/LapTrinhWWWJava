package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAOHibernate {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryStr = "SELECT * from Employee";
        List<Employee> results = currentSession.createNativeQuery(queryStr, Employee.class)
                .getResultList();
        return results;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        return employee;
    }

    @Override
    @Transactional
    public Employee getLastEmployee() {
        Session currentSession = entityManager.unwrap(Session.class);
        String queryStr = "SELECT * from Employee ORDER BY id DESC LIMIT 1";
        Employee employee = currentSession.createNativeQuery(queryStr, Employee.class)
                .getSingleResult();
        return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<?> query = currentSession.createQuery("DELETE FROM Employee WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
    
}
