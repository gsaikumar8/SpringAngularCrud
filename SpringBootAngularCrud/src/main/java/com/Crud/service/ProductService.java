package com.Crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Crud.model.Product;
import com.Crud.model.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> getAllProduct(){
		return (List<Product>)repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found.."));
		
	}
	
	public Product createProduct(Product product) {
		return repository.save(product);
	}
	
	public void deleteProduct(int id) {
		Product prod = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		repository.delete(prod);
		//return "Deleted";
	}
	
	public Product updateProduct(int id,Product product) {
		Product prod = repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		
		if (prod != null) {
			prod.setName(product.getName());
			prod.setPrice(product.getPrice());
		}
		
		return repository.save(prod);
	}
}
