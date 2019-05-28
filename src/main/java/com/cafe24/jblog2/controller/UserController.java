package com.cafe24.jblog2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join_GET() {
		System.out.println("join");
		return "user/join";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join_POST(@ModelAttribute @Valid User user,
							BindingResult result,
							Model model) {
		
		if(result.hasErrors()) {
			
		
		model.addAllAttributes(result.getModel());
		
		
		return "/user/join";
		}
		
		userService.join(user);
		
		return "redirect:/";
	}
	
	
}
