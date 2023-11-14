package com.Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Crud.model.Product;
import com.Crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getById/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id) {
		return new ResponseEntity<Product>(service.getProductById(id),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<Product>(service.createProduct(product),HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> update(@PathVariable int id,@RequestBody Product product){
		return new ResponseEntity<Product>(service.updateProduct(id, product),HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id){
		//return new ResponseEntity<String>(service.deleteProduct(id),HttpStatus.OK);
		service.deleteProduct(id);
	}
}
