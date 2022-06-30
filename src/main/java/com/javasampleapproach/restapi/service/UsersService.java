package com.javasampleapproach.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.restapi.dao.UserRepository;
import com.javasampleapproach.restapi.model.Users;

@Service
public class UsersService {

	private UserRepository userRepository;

	@Autowired
	public UsersService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<Users> getUserList() {
		return userRepository.findAll();
	}

	public Users saveUser(Users user) {
		return userRepository.save(user);
	}

	public Users findById(int id) {
		return userRepository.findById(id).get();
	}
}
