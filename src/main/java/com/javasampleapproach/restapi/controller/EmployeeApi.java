package com.javasampleapproach.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.restapi.model.Address;
import com.javasampleapproach.restapi.model.Employee;
import com.javasampleapproach.restapi.service.EmployeeService;

@RestController
public class EmployeeApi {

	@Autowired
	public EmployeeService service;

	@GetMapping(value = "/emp/Save")
	public Employee save() {

		Address address = new Address("Tirupathi", "AP");
		Address address1 = new Address("Bangalore", "KA");
		Employee emp = new Employee("Pervez", 1000);
		emp.setHomeAddress(address);
		emp.setOfficeAddress(address1);
		
		emp.getAddressList().add(address);
		emp.getAddressList().add(address1);
		
		service.save(emp);
		
		
		return service.find(1);
	}
}

