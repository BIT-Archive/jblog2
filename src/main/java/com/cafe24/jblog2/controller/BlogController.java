package com.cafe24.jblog2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.vo.Blog;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/{id}" )
	public String home(@PathVariable("id") String id, Model model) {
		
		Blog blog = blogService.getBlog(id);
		model.addAttribute("blog", blog);
		model.addAttribute("category", blogService.getCategoryList(id));
		
		Long category_no = blogService.findNoById(id);
		model.addAttribute("post", blogService.getPostList(category_no));
		//맵으로 하는게 나을지
		return "blog/blog-main";
	}
	

}
