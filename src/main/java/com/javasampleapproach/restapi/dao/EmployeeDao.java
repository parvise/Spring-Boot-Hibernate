package com.javasampleapproach.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restapi.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
