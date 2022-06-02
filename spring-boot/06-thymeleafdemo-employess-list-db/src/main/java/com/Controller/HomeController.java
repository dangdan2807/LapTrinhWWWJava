package com.Controller;

import com.entity.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class HomeController {
	static final String URL_EMPLOYEES = "http://localhost:8081/employees";
	
	@GetMapping("")
	public String showHomePage(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);
		model.addAttribute("status", -1);
		model.addAttribute("msg", "");
		model.addAttribute("employees", list);
		return "home";
	}

	@GetMapping("/add-employee")
	public String showAddEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "add-employee-form";
	}

	@PostMapping("/add-employee")
	public String addEmployee(ModelMap modelMap, @ModelAttribute("employee") Employee employee) {
		modelMap.addAttribute("employee", employee);
		RestTemplate restTemplate = new RestTemplate();
		employee.setId(0);
		restTemplate.postForObject(URL_EMPLOYEES, employee, Employee.class);
		return "redirect:/";
	}

	@GetMapping("/delete-employee/{id}")
	public String deleteEmployee(Model model, @PathVariable(name = "id") int id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL_EMPLOYEES + "/" + id);
		return "redirect:/";
	}
}
