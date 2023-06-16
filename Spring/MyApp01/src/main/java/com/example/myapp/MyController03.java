package com.example.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController03 {
	@RequestMapping("/sample01")
	public String sample01(Model m) {
		String[] list = {"山田", "佐藤", "鈴木"};

		m.addAttribute("list", list);

		return "sample01";
	}

	@RequestMapping("/sample02")
	public String sample02(Model m) {
		int age = 22;
		m.addAttribute("age", age);

		return "sample02";
	}

	@RequestMapping("/sample03")
	public String sample03(Model m) {
		int data = 4;
		m.addAttribute("data", data);

		return "sample03";
	}

	@RequestMapping("/sample04")
	public String sample04(Model m) {
		Human h = new Human("山田太郎", 23);
		m.addAttribute("h", h);

		return "sample04";
	}

	@RequestMapping("/sample05")
	public String sample05(Model m) {
		Human h = new Human("山田太郎", 23);
		m.addAttribute("h", h);

		return "sample05";
	}
}
