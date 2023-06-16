package com.example.myapp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController01 {
	@RequestMapping("/first")
	public String first() {
		return "山田太郎";
	}

	@RequestMapping("/second/{num}")
	public String second(@PathVariable int num) {
		return "パラメータ：" + num;
	}
}
