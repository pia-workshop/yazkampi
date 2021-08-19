package com.pia.workshop.service;

import java.util.Objects;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pia.workshop.dto.ProductDTO;
import com.pia.workshop.model.Product;
import com.pia.workshop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public ProductDTO addProduct(ProductDTO dto) {
		Product product;
		Product existProduct = productRepository.findByCode(dto.getCode());
		if (Objects.nonNull(existProduct)) {
			existProduct.setName(dto.getName());
			existProduct.setPrice(dto.getPrice());
			product = productRepository.save(existProduct);
			return mapProductDTO(product);
		} else {
			product = mapProduct(dto);
			return mapProductDTO(productRepository.save(product));
		}
	}

	public Boolean deleteProductByCode(String code) {
		Product product = productRepository.findByCode(code);
		if (Objects.isNull(product)) {
			throw new RuntimeErrorException(null, "boyle bir product yok");
		}

		productRepository.delete(product);
		return true;
	}

	public ProductDTO findByCode(String code) {
		return mapProductDTO(productRepository.findByCode(code));
	}

	private ProductDTO mapProductDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setCode(product.getCode());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		return dto;
	}

	private Product mapProduct(ProductDTO dto) {
		Product product = new Product();
		product.setId(UUID.randomUUID());
		product.setCode(dto.getCode());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		return product;
	}
}
