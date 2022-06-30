package com.javasampleapproach.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.StudentDao;
import com.javasampleapproach.restapi.model.Student;

@Service
public class StudentService {

	@Autowired
	public StudentDao dao;

	public List<Student> getStudentList() {
		return (List<Student>) dao.findAll();
	}

	public Student saveStudent(Student student) {
		
		return dao.save(student);
	}

	public Optional<Student> getStudent(int id) {
		return dao.findById(id);
	}
	
	public void deleteStudent(Student student){
		dao.delete(student);
	}
}
