package com.javasampleapproach.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.EmployeeDao;
import com.javasampleapproach.restapi.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeDao dao;

	public void save(Employee emp) {
		dao.save(emp);
	}

	public Employee find(int empId) {
		return dao.findById(empId).get();
	}

}
