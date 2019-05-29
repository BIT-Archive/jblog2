package com.cafe24.jblog2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.vo.Blog;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/{id}" )
	public String index_id(@PathVariable("id") String id, Model model) {
		
		
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("category", blogService.getCategoryList(id));
		model.addAttribute("post", blogService.recentPost(id));

		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/{category_no}" )
	public String index_id_categoryno(@PathVariable("id") String id,
									  @PathVariable("category_no") Long category_no,
									  Model model) {
		
		
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("category", blogService.getCategoryList(id));
		model.addAttribute("post", blogService.getPostList(category_no));

		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/{category_no}/{post_no}" )
	public String index_id_categoryno(@PathVariable("id") String id,
									  @PathVariable("category_no") Long category_no,
									  @PathVariable("post_no") Long post_no,
									  Model model) {
		
		
		model.addAttribute("blog", blogService.getBlog(id));
		model.addAttribute("category", blogService.getCategoryList(id));
		model.addAttribute("post", blogService.getPost(post_no));

		return "blog/blog-main";
	}
	
	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.GET)
	public String admin_get(@PathVariable("id") String id,
							HttpSession session,
							Model model) {
		
		
		model.addAttribute("blog", blogService.getBlog(id));
		
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.POST)
	public String admin_get(@PathVariable("id") String id,
							HttpSession session,
							@ModelAttribute Blog blog,
							Model model) {
		
		
		model.addAttribute("blog", blogService.getBlog(id));
		
		return "blog/blog-admin-basic";
	}
	
	
	

}
