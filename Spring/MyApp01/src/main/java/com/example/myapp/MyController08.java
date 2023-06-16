package com.example.myapp;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController08 {
	@PersistenceContext
	private EntityManager manager;

	private MemberDAO dao;

	@PostConstruct
	public void init() {
		dao = new MemberDAO(manager);
	}

	@RequestMapping("/db16")
	public String db16(Model m) {
		List<Member> members = dao.findAll();

		m.addAttribute("members", members);

		return "db16";
	}

	@RequestMapping("/db17")
	public String db17(Model m) {
		Member member = dao.find("002");
		m.addAttribute("member", member);

		return "db17";
	}

	@RequestMapping("/db18")
	@Transactional
	public String db18(Model m) {
		Member member = new Member("004", "山本", 28);
		String message = dao.insert(member) ? "正常に登録できました。" : "登録に失敗しました。";

		m.addAttribute("message", message);

		return "db18";
	}

	@RequestMapping("/db19")
	@Transactional
	public String db19(Model m) {
		Member member = dao.find("004");

		String message = "指定したIDに該当するレコードがありません。";

		if (member != null) {
			member.setAge(30);
			message = dao.update(member) ? "正常に変更できました。" : "変更に失敗しました。";
		}

		m.addAttribute("message", message);

		return "db19";
	}

	@RequestMapping("/db20")
	@Transactional
	public String db20(Model m) {
		Member member = dao.find("004");

		String message = "指定したIDに該当するレコードがありません。";

		if (member != null) {
			message = dao.delete(member) ? "正常に削除できました。" : "削除に失敗しました。";
		}

		m.addAttribute("message", message);

		return "db20";
	}
}
