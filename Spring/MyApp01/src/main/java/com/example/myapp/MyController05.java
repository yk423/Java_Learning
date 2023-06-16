package com.example.myapp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController05 {
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/db01")
	public String db01(Model m) {
		List<Product> products = productRepository.findAll();

		m.addAttribute("products", products);

		return "db01";
	}

	@RequestMapping("/db02")
	public String db02(Model m) {
		Product p = null;

		Optional<Product> record = productRepository.findById("0102");
		if (!record.isEmpty()) {
			p = record.get();
		}

		m.addAttribute("product", p);

		return "db02";
	}

	@RequestMapping("/db03")
	@Transactional
	public String db03(Model m) {
		Product p = new Product("0104", "ぶどう", 550);

		productRepository.saveAndFlush(p);

		m.addAttribute("message", "正常に登録できました。");

		return "db03";
	}

	@RequestMapping("/db04")
	@Transactional
	public String db04(Model m) {
		Product p = new Product("0104", "ぶどう", 600);

		productRepository.saveAndFlush(p);

		m.addAttribute("message", "正常に変更できました。");

		return "db04";
	}

	@RequestMapping("/db05")
	@Transactional
	public String db05(Model m) {
		Product p = new Product("0104", "ぶどう", 600);
		productRepository.delete(p);

		//productRepository.deleteById("0104");

		m.addAttribute("message", "正常に削除できました。");

		return "db05";
	}
}
