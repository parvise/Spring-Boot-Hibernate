package com.javasampleapproach.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SkillSet")
public class SkillSet {
	
	public SkillSet(){}
	
	public SkillSet(int skillId,String skillName){
		super();
		this.skillId=skillId;
		this.skillName=skillName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	private String skillName;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "SkillSet [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

}
