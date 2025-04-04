package com.org.tech.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private Double price;
	
	 @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)   
	    @JoinColumn(name = "category_id", referencedColumnName = "cid")  
	   
	  @JsonIgnoreProperties("product") 
	    private Categories category; 
}
