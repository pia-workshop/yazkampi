package com.pia.workshop.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.pia.workshop.model.Product;

public interface ProductRepository extends CrudRepository<Product, UUID>{
		Product findByCode(String code);
}
