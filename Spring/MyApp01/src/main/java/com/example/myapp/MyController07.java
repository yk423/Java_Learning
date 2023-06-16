package com.example.myapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController07 {
	@PersistenceContext
	private EntityManager memberManager;

	@SuppressWarnings("unchecked")
	@RequestMapping("/db11")
	public String db11(Model m) {
		Query query = memberManager.createNamedQuery("findAllMembers");
		List<Member> members = query.getResultList();

		m.addAttribute("members", members);

		return "db11";
	}

	@RequestMapping("/db12")
	public String db12(Model m) {
		Member member = null;

		Query query = memberManager.createNamedQuery("findMemberById").setParameter("id", "002");

		try {
			member = (Member)query.getSingleResult();
		} catch (NoResultException e) {}

		m.addAttribute("member", member);

		return "db12";
	}

	@RequestMapping("/db13")
	@Transactional
	public String db13(Model m) {
		Member member = new Member("004", "山本", 28);
		memberManager.persist(member);

		m.addAttribute("message", "正常に登録できました。");

		return "db13";
	}

	@RequestMapping("/db14")
	@Transactional
	public String db14(Model m) {
		Member member = memberManager.find(Member.class, "004");
		member.setAge(30);
		memberManager.merge(member);

		m.addAttribute("message", "正常に変更できました。");

		return "db14";
	}

	@RequestMapping("/db15")
	@Transactional
	public String db15(Model m) {
		Member member = memberManager.find(Member.class, "004");
		memberManager.remove(member);

		m.addAttribute("message", "正常に削除できました。");

		return "db15";
	}
}
