package com.javasampleapproach.restapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Users extends AbstractPersistable<Integer> {

	private String userName;
	// @OneToMany(targetEntity = Vehicle.class, mappedBy = "users", fetch =
	// FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Vehicle> vehicleList = new ArrayList<>();

	public Users() {
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", vehicleList=" + vehicleList + "]";
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
