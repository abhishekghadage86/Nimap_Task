package com.org.tech.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.org.tech.Model.Categories;
import com.org.tech.Model.Products;
import com.org.tech.Repository.Product_Repo;

@Service
public class Product_Service_Impl implements Product_Service{
	
	@Autowired
	Product_Repo pr;

	@Autowired
	Categories_Service categoriesService;
	@Override
	public Page<Products> findAllProds(int page, int size) {
		// TODO Auto-generated method stub
		Page<Products> prod=pr.findAll(PageRequest.of(page, size));
		return prod;
	}

	@Override
	public Products saveProd(Products p) {
		// TODO Auto-generated method stub
		int cid=p.getCategory().getId();
		Categories cat=categoriesService.getCatbyId(cid);
		if(cat==null) 
			return null;
		
		p.setCategory(cat);
		
		Products pc=pr.save(p);
		return pc;
	}

	@Override
	public Products getProdById(int pid) {
		// TODO Auto-generated method stub
		Optional<Products> op=pr.findById(pid);
		if(op.isPresent()) {
			return op.get();
		}
		else {
		return null;
	}
	}

	@Override
	public boolean DelProdById(int pid) {
		// TODO Auto-generated method stub
		Optional<Products> oc = pr.findById(pid);
		if(oc.isPresent()) {
		pr.deleteById(pid);
		return true;
		}
		else {
		return false;
	}
	}

	@Override
	public Products UpdateProd(int pid, Products p) {
		// TODO Auto-generated method stub
		Optional<Products> op = pr.findById(pid);
	    if (op.isPresent()) {
	        Products prod = op.get();
	        prod.setPname(p.getPname());
	        prod.setPrice(p.getPrice());

	       
	        int newcid = p.getCategory().getId();

	    
	        Categories newCat = categoriesService.getCatbyId(newcid);
	        if (newCat != null) {
	            prod.setCategory(newCat);  
	        }

	        pr.save(prod);
	        return prod;
	    }
	    return null;

	}

	
}
