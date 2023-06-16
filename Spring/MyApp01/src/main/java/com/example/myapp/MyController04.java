package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController04 {
	@RequestMapping("/send01")
	public String send01() {
		return "send01";
	}

	@PostMapping("/receive01")
	public String receive01(
			Model m,
			@RequestParam("NAME") String name,
			@RequestParam("PASS") String pass,
			@RequestParam("CONTENT") String content
	) {
		m.addAttribute("name", name);
		m.addAttribute("pass", pass);
		m.addAttribute("content", content);

		return "receive01";
	}

	@RequestMapping("/send02")
	public String send02() {
		return "send02";
	}

	@PostMapping("/receive02")
	public String receive02(
			Model m,
			@RequestParam("SEX") String sex,
			@RequestParam("SUBJECTS") String[] subjects
	) {
		m.addAttribute("sex", sex);
		m.addAttribute("subjects", subjects);

		return "receive02";
	}

	@RequestMapping("/send03")
	public String send03() {
		return "send03";
	}

	@PostMapping("/receive03")
	public String receive03(
			Model m,
			@RequestParam("PREF") String pref,
			@RequestParam("JOBS") String[] jobs
	) {
		m.addAttribute("pref", pref);
		m.addAttribute("jobs", jobs);

		return "receive03";
	}

}
