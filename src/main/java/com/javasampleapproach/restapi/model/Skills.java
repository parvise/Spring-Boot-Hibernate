package com.javasampleapproach.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Skills")
@DynamicUpdate
public class Skills {

	public Skills() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	private String skillName;
	private int experience;
	private String proficeincy;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Student student;*/

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + skillId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skills other = (Skills) obj;
		if (skillId != other.skillId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skillName=" + skillName + ", experience=" + experience
				+ ", proficeincy=" + proficeincy + "]";
	}

}
