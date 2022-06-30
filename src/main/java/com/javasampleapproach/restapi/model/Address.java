package com.javasampleapproach.restapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	public Address() {
	}

	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	private String city;
	private String state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [id=" + ", city=" + city + ", state=" + state + "]";
	}

}
