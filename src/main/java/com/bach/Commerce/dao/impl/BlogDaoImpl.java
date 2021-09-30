 package com.bach.Commerce.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.bach.Commerce.dao.BlogDAO;
import com.bach.Commerce.dao.BlogRepository;
import com.bach.Commerce.entity.Blog;


@Transactional
@Repository
public class BlogDaoImpl implements BlogDAO {
	
	@Autowired
	EntityManager enityManger;

	@Autowired
	BlogRepository blogRepo;
	
	@Override
	public List<Blog> getAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public Blog getOneBlog(Integer id) {
		return blogRepo.getById(id);
	}

	@Override
	public void addNewBlog(Blog blog) {
		enityManger.persist(blog);
	}

	@Override
	public void deleteBlog(Blog blog) {
		enityManger.remove(blog);
	}

	@Override
	public void editBlog(Blog blog) {
		enityManger.merge(blog);
	}

	/*
	 * @Override public List<Blog> getBlogForBlogPage(String keyword, String
	 * categoryForBlog, String month, Pageable pageable) {
	 * 
	 * return blogRepo.findAll(keyword, categoryForBlog, month, pageable); }
	 */	
}
