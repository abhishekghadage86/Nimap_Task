package com.org.tech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.org.tech.Model.Categories;
import com.org.tech.Repository.Categories_Repo;

@Service
public class Categories_Service_Impl implements Categories_Service{

	@Autowired
	private Categories_Repo cr;

	@Override
	public boolean saveCat(Categories c) {
		Categories c11 = cr.save(c);
		return c11 != null;
	}

	@Override
	public List<Categories> viewAllc() {
		return cr.findAll();
	}

	@Override
	public Categories viewbyid(int id) {
		Optional<Categories> ic = cr.findById(id);
		if (ic.isPresent()) {
			return ic.get();
		} else {
			return null;
		}
	}

	@Override
	public Categories updatcat(Categories c) {
		Optional<Categories> o = cr.findById(c.getId());
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public boolean delcat(int id) {

		Optional<Categories> r = cr.findById(id);
		if (r.isPresent()) {
			cr.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Page<Categories> getAllCategories(int page, int size) {
		Pageable pagable=PageRequest.of(page, size);
		return cr.findAll(pagable);
	}

	@Override
	public Page<Categories> findAllCategories(int page, int size) {
		// Pageable pagable=PageRequest.of(page, size);
		return cr.findAll(pagable);
	}

	@Override
	public Categories getCatbyId(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean DelCatById(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(int id, Categories c) {
		// TODO Auto-generated method stub
		return false;
	}
}
