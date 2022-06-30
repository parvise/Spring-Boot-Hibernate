package com.javasampleapproach.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.restapi.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
