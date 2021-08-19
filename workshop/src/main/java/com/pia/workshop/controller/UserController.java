package com.pia.workshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pia.workshop.dto.UserDTO;
import com.pia.workshop.model.User;
import com.pia.workshop.service.UserService;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add-user")
	public User addUser(@Valid@RequestBody UserDTO userDTO) {
		return userService.addUser(userDTO);
	}
	
	@GetMapping("/get-user/{name}")
	public List<User> getUsers(@PathVariable("name") String name){
		return userService.getUsersByName(name);
	}	
}
