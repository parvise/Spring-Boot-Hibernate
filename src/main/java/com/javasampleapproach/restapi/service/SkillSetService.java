package com.javasampleapproach.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.SkillSetDao;
import com.javasampleapproach.restapi.model.SkillSet;

@Service
public class SkillSetService {

	@Autowired
	public SkillSetDao dao;
	
	public List<SkillSet> addSkillSet(List<SkillSet> skills){
		return (List<SkillSet>) dao.saveAll(skills);
	}
	
	public List<SkillSet> fetchSkillSet(){
		return (List<SkillSet>) dao.findAll();
	}
}
