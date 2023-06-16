package com.example.myapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names="MyBean01")//types=MyBean01.class)
public class MyController10 {
	@Autowired
	private HttpSession session;

	@Autowired
	private MyBean02 bean;

	@RequestMapping("/session01")
	public String session01(Model m) {
		Integer count = (Integer)session.getAttribute("count");

		if (count == null) {
			count = 0;
		}

		count++;

		session.setAttribute("count", count);
		m.addAttribute("count", count);

		return "session01";
	}

	@ModelAttribute("MyBean01")
	public MyBean01 setBean(MyBean01 bean) {
		return bean;
	}

	@RequestMapping("/session02")
	public String session02(Model m, @ModelAttribute("MyBean01") MyBean01 bean) {
		Integer count = bean.getCount();

		count++;

		bean.setCount(count);

		m.addAttribute("count", count);

		return "session02";
	}

	@RequestMapping("/session03")
	public String session03(Model m) {
		Integer count = bean.getCount();

		count++;

		bean.setCount(count);

		m.addAttribute("count", count);

		return "session03";
	}
}
