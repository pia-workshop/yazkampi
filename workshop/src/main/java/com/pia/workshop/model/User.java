package com.pia.workshop.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {		
	@Id
	private UUID id;
	private String name;
	private String surname;
	private String username;

}
