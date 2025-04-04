package com.org.tech.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.org.tech.Model.Categories;
import com.org.tech.Model.Product;
import com.org.tech.Repository.Product_Repo;

@Service
public class Product_Service_Impl implements Product_Service{
	
	@Autowired
	Product_Repo pr;

	@Autowired
	Categories_Service categoriesService;
	@Override
	public Page<Product> findAllProds(int page, int size) {
		// TODO Auto-generated method stub
		Page<Product> prod=pr.findAll(PageRequest.of(page, size));
		return prod;
	}

	@Override
	public Product saveProd(Product p) {
		// TODO Auto-generated method stub
		int cid=p.getCategory().getCid();
		Categories cat=categoriesService.getCatbyId(cid);
		if(cat==null) 
			return null;
		
		p.setCategory(cat);
		
		Product pc=pr.save(p);
		return pc;
	}

	@Override
	public Product getProdById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product> op=pr.findById(pid);
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
		Optional<Product> oc = pr.findById(pid);
		if(oc.isPresent()) {
		pr.deleteById(pid);
		return true;
		}
		else {
		return false;
	}
	}

	@Override
	public Product UpdateProd(int pid, Product p) {
		// TODO Auto-generated method stub
		Optional<Product> op = pr.findById(pid);
	    if (op.isPresent()) {
	        Product prod = op.get();
	        prod.setPname(p.getPname());
	        prod.setPrice(p.getPrice());

	       
	        int newcid = p.getCategory().getCid();

	    
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
