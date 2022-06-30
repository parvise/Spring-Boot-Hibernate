package com.javasampleapproach.restapi.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.StudentSkillsDao;
import com.javasampleapproach.restapi.model.Skills;

@Service
public class StudentSkillsService {

	@Autowired
	public StudentSkillsDao dao;

	public List<Skills> addStudentSkills(Collection<Skills> skills) {
		return (List<Skills>) dao.saveAll(skills);
	}

	/*public List<Skills> updateSKills(int studentId, Collection<Skills> skills) {
		List<Skills> list = new ArrayList<>();
		for (Skills skills2 : skills) {
			Skills dbSkill = dao.updateSKills(skills2.getExperience(), skills2.getSkillName(), skills2.getProficeincy(),
					skills2.getSkillId(), studentId);
			list.add(dbSkill);

		}
		return list;

	}
*/}
