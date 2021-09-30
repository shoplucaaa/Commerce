package com.bach.Commerce.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bach.Commerce.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	@Query("SELECT b FROM Blog b JOIN b.tags t WHERE b.title LIKE %?1% AND b.categoriesForBlog.type LIKE %?2% AND b.created_month LIKE %?3% AND t.type LIKE %?4%")
	public List<Blog> findAll(String keyword, String categoryForBlog, String month, String tag, Pageable pageable);
	
}
