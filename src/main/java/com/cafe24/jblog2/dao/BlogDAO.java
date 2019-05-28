package com.cafe24.jblog2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.Blog;
import com.cafe24.jblog2.vo.User;

@Repository
public class BlogDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void create(User user) {
		sqlSession.insert("blog.create", user);
	}

	public Blog getBlog(String id) {
		
		return sqlSession.selectOne("blog.getblog", id);
	}

}
