package com.org.tech.Controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.org.tech.Model.Product;
import com.org.tech.Service.Product_Service;

@RestController
@RequestMapping("/api/products")
public class Product_Controller {

	Product_Service porser;
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProds(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
				
		Page<Product> prods=porser.findAllProds(page, size);
		
		return ResponseEntity.ok(prods);
	}
	
	

	@PostMapping
	public Product AddProd(@RequestBody Product p) {
		return porser.saveProd(p);
	}
	
	

	@GetMapping(value="/{pid}")
	public Product getProdById(@PathVariable int pid) {
			
			Product pr = porser.getProdById(pid);
			if(pr!=null) {
				return pr;
			}
			else {
				throw new RuntimeException("Product Not Found");
			}
	}
	
	
	

	@PutMapping("/{pid}")
	public Product UpdateProd(@PathVariable int pid,@RequestBody Product p)
	{
		return porser.UpdateProd(pid,p);
	}
	
	
	
	@DeleteMapping("/{cid}")
	public String DelProdById(@PathVariable int cid) {

		boolean b = porser.DelProdById(cid);
		if (b) {
			return "Record \t" + cid + "\tdeleted Successfully.";
		} else {
			return "Some Problem is there...";
		}
	}
	
}
