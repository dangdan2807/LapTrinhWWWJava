package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private List<Customer> customerList = new ArrayList<>();
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @RequestMapping("/processForm")
    private String processForm(@ModelAttribute("customer") Customer customer, Model model) {
        customerList.add(customer);
        model.addAttribute("customerList", customerList);
        return "customer-confirmation";
    }
}
