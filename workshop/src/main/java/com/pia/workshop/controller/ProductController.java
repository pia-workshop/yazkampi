package com.pia.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pia.workshop.dto.ProductDTO;
import com.pia.workshop.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add-product")
	public ProductDTO addProduct(@RequestBody ProductDTO dto) {
		return productService.addProduct(dto);
	}

	@DeleteMapping("/delete-product/{code}")
	public Boolean deleteProduct(@PathVariable("code") String code) {
		return productService.deleteProductByCode(code);
	}

	@GetMapping("/findProductByCode/{code}")
	public ProductDTO findProductByCode(@PathVariable("code") String code) {
		return productService.findByCode(code);
	}
	
}
