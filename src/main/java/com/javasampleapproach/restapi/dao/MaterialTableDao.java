package com.javasampleapproach.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restapi.model.MaterialTable;

@Repository
public interface MaterialTableDao extends CrudRepository<MaterialTable, Integer> {

}
