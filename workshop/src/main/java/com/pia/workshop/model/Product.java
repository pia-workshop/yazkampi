package com.pia.workshop.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private UUID id;
	private String code;
	private String name;
	private Double price;
		
}
