package com.javasampleapproach.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.UserRepository;
import com.javasampleapproach.restapi.dao.VehicleRepository;
import com.javasampleapproach.restapi.model.Vehicle;

@Service
public class VehicleService {

	private VehicleRepository vehicleRepository;
	private UserRepository userRepository;

	@Autowired
	public VehicleService(VehicleRepository vehicleRepository,UserRepository userRepository) {
		this.vehicleRepository = vehicleRepository;
		this.userRepository=userRepository;
	}

	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}
	
	public Vehicle findOne(Integer id){
		return vehicleRepository.findById(id).get();
	}

	public Vehicle saveVehicle(Vehicle vehicle) {
		vehicle.setUsers(userRepository.findById(vehicle.getUserId()).get());
		return vehicleRepository.save(vehicle);
	}
	
	public String deleteVehicle(Integer id){
		vehicleRepository.deleteById(id);
		return "{'message':'Delete Suucessufully'}";
	}
}
