package com.flygram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flygram.Domain.Student;
import com.flygram.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	IStudentService studentService;

	@GetMapping("/viewstudents")
	public List<Student> viewStudent() {
		return studentService.viewStudent();
	}

	@PostMapping("/savestudent")
	public Student saveStudent(@RequestBody Student s) {
		return studentService.createStudent(s);
	}

	@GetMapping("/findstudent{id}")
	public Student findStudent(@PathVariable Long id) {
		try {
			return studentService.findStudentById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping("/updatestudent")
	public Student updateStudent(@RequestBody Student s) {
		return studentService.updateStudent(s);
	}

	@DeleteMapping("/removestudent{id}")
	public void removeStudent(@PathVariable Long id) {
		try {
			Student s = studentService.findStudentById(id);
			studentService.deleteStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
