package com.org.tech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.tech.Model.Categories;

@Repository
public interface Categories_Repo extends JpaRepository<Categories,Integer>{

}
