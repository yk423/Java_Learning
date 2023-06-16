package com.example.myapp.web01;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private HttpSession session;

	@RequestMapping("/index")
	public String index() {
		return "web01/index";
	}

	@PostMapping("/login")
	public String login(
			Model m,
			@RequestParam("email") String email,
			@RequestParam("password") String password
	) {
		User user = null;

		Query query =
				manager
				.createNamedQuery("findUser")
				.setParameter("email", email)
				.setParameter("password", password);

		try {
			user = (User)query.getSingleResult();
		} catch (NoResultException e) {}

		if (user == null) {
			session.invalidate();
			return "web01/index";
		}

		session.setAttribute("user", user);
		m.addAttribute("user", user);

		return "web01/main";
	}

	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();

		return "web01/index";
	}
}
