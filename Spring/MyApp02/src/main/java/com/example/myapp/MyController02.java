package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController02 {
	@RequestMapping("/third")
	public String third() {
		return "third";
	}

	@RequestMapping("/fourth")
	public String fourth(Model m) {
		m.addAttribute("name", "山田太郎");
		return "fourth";
	}

	@RequestMapping("/fifth")
	public ModelAndView fifth(ModelAndView mv) {
		mv.addObject("name", "山田太郎");
		mv.setViewName("fifth");

		return mv;
	}
}
