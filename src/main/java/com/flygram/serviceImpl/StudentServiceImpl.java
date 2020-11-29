package com.flygram.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flygram.Domain.Student;
import com.flygram.dao.StudentDao;
import com.flygram.service.IStudentService;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student createStudent(Student s) throws NullPointerException {

		if (s == null) {
			throw new NullPointerException("No data found to be inserted");
		}
		studentDao.save(s);
		return s;
	}

	@Override
	public List<Student> viewStudent() {
		return (List<Student>) studentDao.findAll();
	}

	@Override
	public Student findStudentById(Long id) throws Exception {

		if (id == null) {
			throw new Exception("Invalid null id");
		}
		Object s = studentDao.findById(id);
		return (Student) s;
	}

	@Override
	public Student updateStudent(Student s) {
		Object sss = studentDao.findById(s.getStudentId());
		Student ss = (Student) sss;
		if (ss == null) {
			throw new NullPointerException("Student not found ");
		} else {
			return studentDao.save(ss);
		}
	}

	@Override
	public void deleteStudent(Student s) {
		if (s == null) {
			throw new NullPointerException("Student does not exist");
		}
		studentDao.delete(s);
	}

}
