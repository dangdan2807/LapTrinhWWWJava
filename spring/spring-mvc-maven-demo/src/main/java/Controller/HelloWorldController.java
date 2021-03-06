package Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}

	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request) {
		String name = request.getParameter("studentName");
		request.setAttribute("message", name);
		return "helloWorld";
	}

	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		// create message
		String result = "Yo! " + name.toUpperCase();
		model.addAttribute("message", result);
		return "helloWorld";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
		// create message
		String result = "Hey! my friend from: " + name.toUpperCase();
		model.addAttribute("message", result);
		return "helloWorld";
	}
}
