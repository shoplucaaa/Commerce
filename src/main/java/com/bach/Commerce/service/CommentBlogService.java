package com.bach.Commerce.service;

import java.util.List;

import com.bach.Commerce.model.CommentBlogDTO;

public interface CommentBlogService {

	public List<CommentBlogDTO> getAll();
	
	void delete(int id);
	
	void add(CommentBlogDTO commentBlogDTO);
	
	public List<CommentBlogDTO> getComment(int id);
	
	public CommentBlogDTO getById(int id);
	
}
