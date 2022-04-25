package springDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.validation.Valid;

import springDemo.dao.CustomerDao;
import springDemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;

	@GetMapping("/list-customers")
	public String listCustomers(Model model) {
		List<Customer> customers = customerDao.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@RequestMapping("/add-customer-form")
	public String getAddCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "add-customer-form";
	}

	@RequestMapping("/add-customer")
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, Model model,
			BindingResult bindingResult) {
		String path = "redirect:/customer/add-customer-form";
		if (!bindingResult.hasErrors()) {
			int id = customerDao.saveCustomer(customer);
			path = "redirect:/customer/edit-customer-form?id=" + id + "&result=add";
		}
		return path;
	}

	@RequestMapping("/edit-customer-form")
	public String getUpdateCustomerForm(@RequestParam(name = "id") int customerId, Model model) {
		Customer customer = customerDao.getCustomer(customerId);
		model.addAttribute("customer", customer);
		return "update-customer-form";
	}

	@RequestMapping(value = "/update-customer", method = RequestMethod.POST)
	public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer, Model model,
			BindingResult bindingResult) {
		model.addAttribute("customer", customer);
		boolean result = false;
		if (!bindingResult.hasErrors()) {
			result = customerDao.updateCustomer(customer);
		}
		String path = "redirect:/customer/edit-customer-form?id=" + customer.getId() + "&result=" + result;
		return path;
	}

	@GetMapping("/delete-customer")
	public String getDeleteCustomerForm(@RequestParam(name = "id") int customerId, Model model) {
		customerDao.deleteCustomer(customerId);
		return "redirect:/customer/list-customers";
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
