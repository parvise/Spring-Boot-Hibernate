package com.javasampleapproach.restapi.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.MaterialTableDao;
import com.javasampleapproach.restapi.model.MaterialTable;

@Service
public class MaterialTableService {

	private MaterialTableDao materialTableDao;

	private DataSource datasource;

	@Autowired
	public MaterialTableService(MaterialTableDao materialTableDao, DataSource datasource) {
		this.materialTableDao = materialTableDao;
		this.datasource = datasource;
	}

	public List<MaterialTable> getData() {
		System.out.println("datasource" + datasource);
		return (List<MaterialTable>) materialTableDao.findAll();
	}

	public MaterialTable save(MaterialTable data) {
		return materialTableDao.save(data);
	}

	public MaterialTable findById(int id) {
		return materialTableDao.findById(id).get();

	}

	public void deleteData(MaterialTable data) {
		materialTableDao.delete(data);
	}
}
