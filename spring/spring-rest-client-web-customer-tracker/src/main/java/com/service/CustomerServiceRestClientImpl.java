package com.service;

import java.util.List;
import java.util.logging.Logger;

import com.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {
    private RestTemplate restTemplate;
    private String crmRestUrl;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public CustomerServiceRestClientImpl(RestTemplate restTemplate,
            @Value("${crm.rest.rul}") String crmRestUrl) {
        this.restTemplate = restTemplate;
        this.crmRestUrl = crmRestUrl;
        logger.info("Loaded property: crm.rest.url " + crmRestUrl);
    }

    @Override
    public List<Customer> getCustomers() {
        
        return null;
    }

    @Override
    public Customer getCustomer(int customerId) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        
    }

    @Override
    public void updateCustomer(Customer customer) {
        
    }

    @Override
    public void deleteCustomer(int customerId) {
        
    }

}
