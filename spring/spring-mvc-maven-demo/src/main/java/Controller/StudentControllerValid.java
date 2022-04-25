package Controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.StudentValid;

@Controller
@RequestMapping("/student-valid")
public class StudentControllerValid {
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		StudentValid student = new StudentValid();
		model.addAttribute("student", student);
		return "student-form-valid";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") StudentValid student, BindingResult bindingResult) {
		String fileName = "student-confirmation-valid";
		if (bindingResult.hasErrors())
			fileName = "student-form-valid";
		return fileName;
	}

	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
