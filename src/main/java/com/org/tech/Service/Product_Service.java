package com.org.tech.Service;



import org.springframework.data.domain.Page;


import com.org.tech.Model.Products;

public interface Product_Service {

public Page<Products> findAllProds(int page,int size);
	
	public Products saveProd(Products p);
	
	Products getProdById(int pid);
	
	public boolean DelProdById(int pid);
	
	public Products UpdateProd(int pid,Products p);
}
