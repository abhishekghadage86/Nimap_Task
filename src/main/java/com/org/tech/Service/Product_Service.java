package com.org.tech.Service;



import org.springframework.data.domain.Page;


import com.org.tech.Model.Product;

public interface Product_Service {

public Page<Product> findAllProds(int page,int size);
	
	public Product saveProd(Product p);
	
	Product getProdById(int pid);
	
	public boolean DelProdById(int pid);
	
	public Product UpdateProd(int pid,Product p);
}
