package com.RestControlller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Minh", "Nguyen"));
		theStudents.add(new Student("Hung", "Vo"));
		theStudents.add(new Student("Thanh", "Tran"));
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		List<Student> theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Minh", "Nguyen"));
		theStudents.add(new Student("Hung", "Vo"));
		theStudents.add(new Student("Thanh", "Tran"));
		
		if((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
