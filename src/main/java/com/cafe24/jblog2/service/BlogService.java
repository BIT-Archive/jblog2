package com.cafe24.jblog2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog2.dao.BlogDAO;
import com.cafe24.jblog2.vo.User;

@Service
public class BlogService {

	
	@Autowired
	private BlogDAO blogDAO;
	
	public void create(User user) {
		blogDAO.create(user);
	}

	

}
