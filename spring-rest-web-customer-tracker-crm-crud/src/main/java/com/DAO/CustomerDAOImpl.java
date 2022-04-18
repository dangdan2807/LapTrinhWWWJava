package com.DAO;

import java.util.ArrayList;
import java.util.List;

import com.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer", Customer.class);

        customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomer(int customerId) {
        Customer customer = new Customer();
        String queryStr = "from Customer where id = :customerId";
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery(queryStr, Customer.class);
        query.setParameter("customerId", customerId);

        customer = query.getSingleResult();

        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        session.delete(customer);
    }

    @Override
    public int getNumberOfCustomer() {
        Session session = sessionFactory.getCurrentSession();
        String queryStr = "select count(*) from Customer";
        Query<Long> query = session.createQuery(queryStr, Long.class);
        Long count = query.getSingleResult();
        return count.intValue();
    }
}
