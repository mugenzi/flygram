package com.flygram.service;

import java.util.List;

import com.flygram.Domain.Student;

public interface IStudentService {
	public Student createStudent(Student s);

	public List<Student> viewStudent();

	public Student findStudentById(Long id) throws Exception;

	public Student updateStudent(Student s);

	public void deleteStudent(Student s);
}
