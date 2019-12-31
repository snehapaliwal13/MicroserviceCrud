/**
 * 
 */
package com.restMicroCrud.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import com.restMicroCrud.demo.dao.UserRepository;
import com.restMicroCrud.demo.entity.User;

/**
 * @author sneha
 *
 */
@RestController
public class CrudController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EurekaClient eurekaClient;

	@RequestMapping("/")
	public String homePage() {
		System.out.println("crud controller");
		return "home.jsp";
	}

	@PostMapping("/user")
	public User addUserDetails(@RequestBody User user) {
		userRepository.save(user);
		System.out.println("user datails saved :"+user);
		return user;
	}

	@PutMapping("/user")
	public User updateUserDetails(@RequestBody User user) {
		User user1=userRepository.findById(user.getUserId()).orElse(null);
		if(null!=user1) {
		userRepository.save(user);
		}
		return user;
	}

	@PatchMapping("/user")
	public User updateUserDetailsbyPatch(@RequestBody User user) {
		User  user1=userRepository.findById(user.getUserId()).orElse(null);
		if(null!=user1) {
			if(null!=user.getAccountDetails()) {
				user1.setAccountDetails(user.getAccountDetails());
			}
			if(null!=user.getAddressLine1()) {
				user1.setAddressLine1(user.getAddressLine1());
			}
			if(null!=user.getAddressLine2()) {
				user1.setAddressLine2(user.getAddressLine2());
			}
			if(null!=user.getEmail()) {
				user1.setEmail(user.getEmail());
			}

			if(null!=user.getPhoneNumber()) {
				user1.setPhoneNumber(user.getPhoneNumber());
			}
			if(null!=user.getFirstName()) {
				user1.setFirstName(user.getFirstName());
			}
			if(null!=user.getLastName()) {
				user1.setLastName(user.getLastName());
			}
			userRepository.save(user1);
		}
		return user1;
	}

	@DeleteMapping("/user/{userId}")
	public String deleteUserDetails(@PathVariable int userId) {
		userRepository.deleteById(userId);
		return "Deleted";
	}

	@GetMapping(path = "/users", produces = "application/json", consumes = "application/json")
	public List<User> fetchAllUsers() {
		List<User> users= userRepository.findAll();
		System.out.println("data fetched : "+users);
		return users;
	}

	@GetMapping("/user/{userId}")
	public Optional<User> fetchUserById(@PathVariable int userId) {
		Optional<User> user= userRepository.findById(userId);
		System.out.println("data fetched : "+user);
		return user;
	}

	@GetMapping("/applications")
	public Applications getApplications() {
		return eurekaClient.getApplications();
	}

}

