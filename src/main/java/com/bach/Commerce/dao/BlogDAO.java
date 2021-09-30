package com.bach.Commerce.dao;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.bach.Commerce.entity.Blog;


public interface BlogDAO {
	
	public List<Blog> getAllBlogs();
	
	public Blog getOneBlog(Integer id);
	
	public void addNewBlog(Blog blog);
	
	public void deleteBlog(Blog blog);
	
	public void editBlog(Blog blog);
	
	//public List<Blog> getBlogForBlogPage(String keyword, String categoryForBlog, String month, Pageable pageable);
	
}
