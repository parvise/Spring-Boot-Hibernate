package com.javasampleapproach.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillSetDao extends CrudRepository<com.javasampleapproach.restapi.model.SkillSet, Integer> {

}
