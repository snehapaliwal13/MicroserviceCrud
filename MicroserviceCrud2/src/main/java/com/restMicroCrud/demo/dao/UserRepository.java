package com.restMicroCrud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restMicroCrud.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
            