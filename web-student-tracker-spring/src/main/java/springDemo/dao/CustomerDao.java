package springDemo.dao;

import springDemo.entity.Customer;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CustomerDao {
    public List<Customer> getCustomers();

    public int saveCustomer(Customer customer);
    
    public boolean updateCustomer(Customer customer);

    public Customer getCustomer(int id);

    public boolean deleteCustomer(int id);
}
