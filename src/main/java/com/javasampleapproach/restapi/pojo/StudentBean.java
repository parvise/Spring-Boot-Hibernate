package com.javasampleapproach.restapi.pojo;

import java.util.ArrayList;
import java.util.Collection;

public class StudentBean {
	private int id;
	private String fullName;
	private String email;
	private String phone;
	private String contactPrefer;
	private Collection<SkillsBean> skills = new ArrayList();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContactPrefer() {
		return contactPrefer;
	}

	public void setContactPrefer(String contactPrefer) {
		this.contactPrefer = contactPrefer;
	}

	public Collection<SkillsBean> getSkills() {
		return skills;
	}

	public void setSkills(Collection<SkillsBean> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", contactPrefer=" + contactPrefer + ", skills=" + skills + "]";
	}

}
