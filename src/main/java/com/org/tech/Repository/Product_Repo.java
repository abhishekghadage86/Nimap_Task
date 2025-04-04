package com.org.tech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.tech.Model.Products;

@Repository
public interface Product_Repo extends JpaRepository<Products, Integer>{

	
}
