package com.example.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController06 {
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/db06")
	public String db06(Model m) {
		List<Product> products = productRepository.findByPriceBetween(200, 400);

		m.addAttribute("products", products);

		return "db06";
	}

	@RequestMapping("/db07")
	public String db07(Model m) {
		Integer[] list = {200, 500};
		List<Product> products = productRepository.findByPriceIn(list);

		m.addAttribute("products", products);

		return "db07";
	}

	@RequestMapping("/db08")
	public String db08(Model m) {
		List<Product> products = productRepository.findAllOrderByPriceAsc();

		m.addAttribute("products", products);

		return "db08";
	}

	@RequestMapping("/db09")
	public String db09(Model m) {
		List<Product> products = productRepository.findAllOrderByPriceDesc();

		m.addAttribute("products", products);

		return "db09";
	}

	@RequestMapping("/db10")
	public String db10(Model m) {
		List<Product> products = productRepository.findByPrice(300);

		m.addAttribute("products", products);

		return "db10";
	}
}
