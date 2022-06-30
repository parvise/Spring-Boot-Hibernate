package com.javasampleapproach.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.CustomerDao;
import com.javasampleapproach.restapi.model.Customer;

@Service
public class CustomerService {

	@Autowired
	public CustomerDao dao;

	public void saveCustomer(Customer c) {
		dao.save(c);

	}
}
