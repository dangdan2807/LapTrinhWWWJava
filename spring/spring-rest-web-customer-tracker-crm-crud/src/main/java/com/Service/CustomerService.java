package com.Service;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
    public List<Customer> getCustomers();
    
    public Customer getCustomer(int customerId);

    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    public int getNumberOfCustomer();
}
