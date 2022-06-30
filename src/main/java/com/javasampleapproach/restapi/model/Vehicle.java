package com.javasampleapproach.restapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "VEHICLE")
public class Vehicle extends AbstractPersistable<Integer> {
	private String vehicleName;
	@ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users users;

	private transient int userId;

	public Vehicle() {
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleName=" + vehicleName + ", users=" + users + ", userId=" + userId + "]";
	}

}
