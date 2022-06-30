package com.javasampleapproach.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restapi.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

}
