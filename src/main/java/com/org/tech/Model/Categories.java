package com.org.tech.Model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Categories {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)

	 @JsonIgnoreProperties("category")
    private List<Products> products;
}
