package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showHome() {
		return "h";
	}
	
	@RequestMapping("/showMyLoginPage")
	public String home() {
		return "login-page";
	}
	
	@RequestMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	@RequestMapping("/systems")
	public String showSystems() {
		return "systems";
	}
	
	@RequestMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
