package com.javasampleapproach.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.restapi.model.Users;
import com.javasampleapproach.restapi.model.Vehicle;
import com.javasampleapproach.restapi.service.MaterialTableService;
import com.javasampleapproach.restapi.service.UsersService;
import com.javasampleapproach.restapi.service.VehicleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
@ResponseBody
public class UsersRestApi {

	private UsersService userService;
	private VehicleService vehicleService;
	private MaterialTableService materialTableService;

	@Autowired
	public UsersRestApi(UsersService userService, VehicleService vehicleService,
			MaterialTableService materialTableService) {
		this.userService = userService;
		this.vehicleService = vehicleService;
		this.materialTableService = materialTableService;
	}

	@GetMapping(value = "/vehicles/get")
	public List<Vehicle> getVehicles() {

		List<Vehicle> list = vehicleService.getVehicles();
		for (Vehicle vehicle : list) {
			System.out.println(vehicle.getUsers());
		}

		return list;
	}

	@GetMapping(value = "/vehicles/get/{id}")
	public Vehicle findById(@PathVariable int id) {
		return vehicleService.findOne(id);
	}

	@DeleteMapping(value = "/vehicles/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return vehicleService.deleteVehicle(id);
	}

	@RequestMapping(value = "/vehicles/save")
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		System.out.println("---------" + vehicle);
		return vehicleService.saveVehicle(vehicle);
	}

	@GetMapping(value = "/get")
	public List<Users> getList() {
		return userService.getUserList();
	}

	@GetMapping(value = "/get/{id}")
	public Users findUserId(@PathVariable int id) {
		return userService.findById(id);
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Users saveUser(@RequestBody Users user) {
		Users users = userService.saveUser(user);

		return users;
	}

}
