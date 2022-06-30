package com.javasampleapproach.restapi.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class MaterialTableBean {

	private int id;
	private String fullName;
	private String email;
	private String gender;
	private String department;
	private Date hireDate;
	private boolean permanent;
	private MultipartFile uplodaFile;
	private String fileName;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public MultipartFile getUplodaFile() {
		return uplodaFile;
	}

	public void setUplodaFile(MultipartFile uplodaFile) {
		this.uplodaFile = uplodaFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "MaterialTableBean [id=" + id + ", fullName=" + fullName + ", email=" + email + ", gender=" + gender
				+ ", department=" + department + ", hireDate=" + hireDate + ", permanent=" + permanent + "]";
	}

}
