package com.javasampleapproach.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restapi.model.Skills;

@Repository
public interface StudentSkillsDao extends CrudRepository<Skills, Integer> {

	/*@Modifying
	@Query("UPDATE Skills s SET s.experience = ?1 where s.skill_id=?2")
	public Skills updateSKills(int experience, int studentId);*/

}
