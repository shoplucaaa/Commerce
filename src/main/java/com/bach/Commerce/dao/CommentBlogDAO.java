package com.bach.Commerce.dao;

import java.util.List;

import com.bach.Commerce.entity.CommentBlog;

public interface CommentBlogDAO {
	
	public List<CommentBlog> getAllComment();

	void add(CommentBlog commentBlog);

	void delete(CommentBlog commentBlog);
	
	public List<CommentBlog> getComment(int blogId);
	
	public CommentBlog getById(int id);
	
	public Long countById(int id);
}
