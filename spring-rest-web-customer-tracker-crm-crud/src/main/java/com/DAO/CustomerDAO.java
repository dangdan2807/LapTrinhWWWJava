package com.DAO;

import java.util.List;

import com.entity.Customer;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    public Customer getCustomer(int customerId);

    public void saveCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    public int getNumberOfCustomer();
}
