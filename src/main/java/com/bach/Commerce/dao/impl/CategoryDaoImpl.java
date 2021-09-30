package com.bach.Commerce.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bach.Commerce.dao.CategoryDAO;
import com.bach.Commerce.entity.Categories;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Categories> getAll() {
		String jql = "Select c FROM Categories c";
		return entityManager.createQuery(jql, Categories.class).getResultList();
	}

}
