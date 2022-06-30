package com.javasampleapproach.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restapi.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer>{

}
