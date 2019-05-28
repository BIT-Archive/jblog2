package com.cafe24.jblog2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.Post;

@Repository
public class PostDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<Post> getPostList(Long category_no) {
		return sqlSession.selectList("post.getList", category_no);
	}
	
	public List<Post> getPostList() {
		return sqlSession.selectList("post.getAllList");
	}

}
