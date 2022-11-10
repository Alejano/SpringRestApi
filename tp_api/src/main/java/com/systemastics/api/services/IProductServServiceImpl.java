package com.systemastics.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.systemastics.api.models.ProductService;
import com.systemastics.api.models.dao.IProductServDao;

@Service
public class IProductServServiceImpl implements IProductServService {
	@Autowired
	private IProductServDao productdao;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<ProductService> findAll() {
		// TODO Auto-generated method stub
		return (List<ProductService>) productdao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductService> findAlluserproducts(Long user) {
		// TODO Auto-generated method stub
		return (List<ProductService>) productdao.findAlluserproducts(user);
	}

	@Override
	public void save(ProductService product) {
		// TODO Auto-generated method stub
		productdao.save(product);
	}


	@Override
	@Transactional(readOnly = true)
	public ProductService findOne(Long product) {
		// TODO Auto-generated method stub
		return productdao.findById(product).orElse(null);
	}

	@Override
	public void delete(Long product) {
		// TODO Auto-generated method stub
		productdao.deleteById(product);
	}



}
