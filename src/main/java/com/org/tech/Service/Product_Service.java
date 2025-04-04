package com.org.tech.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.org.tech.Model.Product;

public interface Product_Service {

	public Page getAllProducts(int page, int size);
	boolean savepro(Product p);
	List<Product> viewAllp();
	Product viewpbyid(int id);
	Product updatep(Product c);
	boolean delp(int id);
}
