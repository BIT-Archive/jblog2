package com.cafe24.jblog2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.User;

@Repository
public class BlogDAO {

	private SqlSession sqlSession;
	
	public void create(User user) {
		sqlSession.insert("blog.create", user);
	}

}
