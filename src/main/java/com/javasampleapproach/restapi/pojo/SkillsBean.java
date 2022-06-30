package com.javasampleapproach.restapi.pojo;

public class SkillsBean {
	private int skillId;
	private String skillName;
	private int experience;
	private String proficeincy;

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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getProficeincy() {
		return proficeincy;
	}

	public void setProficeincy(String proficeincy) {
		this.proficeincy = proficeincy;
	}

	@Override
	public String toString() {
		return "SkillsBean [skillId=" + skillId + ", skillName=" + skillName + ", experience=" + experience
				+ ", proficeincy=" + proficeincy + "]";
	}

}
