package com.cafe24.jblog2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog2.vo.Category;
import com.cafe24.jblog2.vo.User;

@Repository
public class CategoryDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Category> getCategoryList(String id) {
		return sqlSession.selectList("category.getList", id);
	}

	public List<Long> getNoById(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("category.getNoById",id);
	}

	public void initCategory(User user) {
		sqlSession.insert("category.init", user);
	}

}
