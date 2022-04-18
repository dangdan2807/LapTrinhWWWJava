package com.RestControlller;

import java.util.List;

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

import com.Service.CustomerService;
import com.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getStudent(@PathVariable int customerId) throws Exception {
		Customer customer = customerService.getCustomer(customerId);
		if ((customerId < 0) || customer == null) {
			throw new StudentNotFoundException("customer id not found - " + customerId);
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customer;
	}

	@PutMapping({"/customers"})
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int customerId) {
		if (customerId < 0) {
			throw new StudentNotFoundException("customer id not found - " + customerId);
		}
		customerService.updateCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if ((customerId < 0) || customer == null) {
			throw new StudentNotFoundException("customer id not found - " + customerId);
		}
		customerService.deleteCustomer(customerId);

		return "Deleted customer id - " + customerId;
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(StudentNotFoundException exc) {
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
