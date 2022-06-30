package com.javasampleapproach.restapi.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.javasampleapproach.restapi.model.Employee;

//@Repository
public class EmployeeDAOSession {
	@Autowired
	private SessionFactory sessionFactory;

	public Employee deleteById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class, id);
			if (emp != null) {
				session.delete(emp);
				tx.commit();
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return null;
	}

}
