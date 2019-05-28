package com.cafe24.jblog2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.dao.BlogDAO;
import com.cafe24.jblog2.dao.CategoryDAO;
import com.cafe24.jblog2.dao.PostDAO;
import com.cafe24.jblog2.vo.Blog;
import com.cafe24.jblog2.vo.Category;
import com.cafe24.jblog2.vo.Post;
import com.cafe24.jblog2.vo.User;

@Service
public class BlogService {

	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	public void create(User user) {
		blogDAO.create(user);
	}

	public Blog getBlog(String id) {
		
		return blogDAO.getBlog(id);
	}

	public List<Category> getCategoryList(String id) {
		
		return categoryDAO.getCategoryList(id);
	}
	
	public List<Post> getPostList(Long category_no) {
		
		return postDAO.getPostList(category_no);
	}
	
	public Long findNoById(String id) {
		return categoryDAO.getNoById(id);
	}

}
