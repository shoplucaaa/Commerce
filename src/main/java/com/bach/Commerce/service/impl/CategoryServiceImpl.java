package com.bach.Commerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bach.Commerce.dao.CategoryDAO;
import com.bach.Commerce.entity.Categories;
import com.bach.Commerce.model.CategoriesDTO;
import com.bach.Commerce.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired 
	CategoryDAO categoryDAO;

	@Override
	public List<CategoriesDTO> getAll() {
		
		List<Categories> entityCategory = categoryDAO.getAll();
		
		List<CategoriesDTO> listCategory = new ArrayList<CategoriesDTO>();
		
		for(Categories cate : entityCategory) {
			
			CategoriesDTO categoryDTO = new CategoriesDTO();
			
			categoryDTO.setId_cate(cate.getId());
			
			categoryDTO.setType(cate.getType());
			
			listCategory.add(categoryDTO);
			
		}
		
		return listCategory;
	}

}
