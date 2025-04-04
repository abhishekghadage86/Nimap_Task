package com.org.tech.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.org.tech.Model.Categories;
import com.org.tech.Repository.Categories_Repo;

@Service
public class Categories_Service_Impl implements Categories_Service{

	@Autowired
	private Categories_Repo cr;

	@Override
	public Page<Categories> findAllCategories(int page, int size) {
		// TODO Auto-generated method stub
		Page<Categories> categ=cr.findAll(PageRequest.of(page, size));
		return categ;
	}

	@Override
	public boolean saveCat(Categories c) {
		// TODO Auto-generated method stub
		Categories cat=cr.save(c);
		return cat!= null ;
	}

	@Override
	public Categories getCatbyId(int cid) {
		// TODO Auto-generated method stub
		Optional<Categories> oc=cr.findById(cid);
		if(oc.isPresent()) {
			return oc.get();
		}
		else {
			return null;
		}
	}

	@Override
	public boolean DelCatById(int cid) {
		// TODO Auto-generated method stub
		Optional<Categories> oc = cr.findById(cid);
		if(oc.isPresent()) {
		cr.deleteById(cid);
		return true;
		}
		else {
		return false;
	}
	}

	@Override
	public boolean updateCategory(int id, Categories c) {
		// TODO Auto-generated method stub
		Optional<Categories>opcat=cr.findById(id);
		if(opcat.isPresent())
		{
			Categories cat=opcat.get();
			cat.setName(c.getName());
			cr.save(cat);
			return true;
		}
	
		return false;
	}

	
}
