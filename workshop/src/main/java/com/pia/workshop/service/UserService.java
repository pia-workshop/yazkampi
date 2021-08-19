package com.pia.workshop.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pia.workshop.dto.UserDTO;
import com.pia.workshop.model.User;
import com.pia.workshop.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User addUser(UserDTO userDto) {
		
		User existUSer= userRepository.findByUsername(userDto.getUsername());
		
		if(Objects.nonNull(existUSer)) {
			throw new RuntimeException("Username exist!!!");			
		}
		
		User newUser= new User();
		newUser.setId(UUID.randomUUID());
		newUser.setName(userDto.getName());
		newUser.setSurname(userDto.getSurname());
		newUser.setUsername(userDto.getUsername());		
		return userRepository.save(newUser);
	}
	
	public List<User> getUsersByName(String name){
		return userRepository.findByName(name);
	}
	
	
}
