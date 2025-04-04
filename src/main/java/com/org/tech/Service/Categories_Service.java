package com.org.tech.Service;

import org.springframework.data.domain.Page;

import com.org.tech.Model.Categories;

public interface Categories_Service {

	public Page<Categories> findAllCategories(int page, int size);

	boolean saveCat(Categories c);

	Categories getCatbyId(int cid);

	public boolean DelCatById(int cid);

	boolean updateCategory(int id, Categories c);
}
