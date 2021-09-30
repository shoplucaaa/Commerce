package com.bach.Commerce.model;

public class CommentBlogDTO {
	private int id;
	private String comment;
	private String name;
	private String email;
	private BlogDTO blogDTO;
	
	public CommentBlogDTO() {
		
	}

	public CommentBlogDTO(int id, String comment, String name, String email, BlogDTO blogDTO) {
		super();
		this.id = id;
		this.comment = comment;
		this.name = name;
		this.email = email;
		this.blogDTO = blogDTO;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BlogDTO getBlogDTO() {
		return blogDTO;
	}
	public void setBlogDTO(BlogDTO blogDTO) {
		this.blogDTO = blogDTO;
	}
}
