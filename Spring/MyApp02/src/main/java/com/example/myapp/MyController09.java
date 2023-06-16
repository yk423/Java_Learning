package com.example.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController09 {
	@Autowired
	private MyService myService;

	@Autowired
	private MemberService memberService;

	@RequestMapping("/service01")
	public String service01(Model m) {
		String name = myService.getName();
		m.addAttribute("name", name);

		return "service01";
	}

	@RequestMapping("/service02")
	public String service02(Model m) {
		List<Member> members = memberService.findAll();

		m.addAttribute("members", members);

		return "service02";
	}
}
