package com.flygram.dao;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.Student;

public interface StudentDao extends CrudRepository<Student, Long> {
	public Student findByName(String name);
}
