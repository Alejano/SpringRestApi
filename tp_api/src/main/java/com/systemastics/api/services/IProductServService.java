package com.systemastics.api.services;

import java.util.List;

import com.systemastics.api.models.ProductService;

public interface IProductServService {
	public List<ProductService> findAll();
	
	public List<ProductService> findAlluserproducts(Long user);
	
	public void save(ProductService product);
	
	public ProductService findOne(Long product);
	
	public void delete(Long product);
	

	
}
