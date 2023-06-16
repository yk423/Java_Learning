package com.example.myapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class MemberService implements MyDAO<Member> {
	@PersistenceContext
	private EntityManager manager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Member> findAll() {
		List<Member> list = null;

		Query query = manager.createNamedQuery("findAllMembers");
		list = query.getResultList();

		return list;
	}

	@Override
	public Member find(String id) {
		Member entity = manager.find(Member.class, id);

		return entity;
	}

	@Override
	@Transactional
	public boolean insert(Member entity) {
		manager.persist(entity);

		return true;
	}

	@Override
	@Transactional
	public boolean update(Member entity) {
		manager.merge(entity);

		return true;
	}

	@Override
	@Transactional
	public boolean delete(Member entity) {
		manager.remove(entity);

		return true;
	}

}
