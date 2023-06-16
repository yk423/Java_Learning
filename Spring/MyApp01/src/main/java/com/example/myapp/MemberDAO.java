package com.example.myapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements MyDAO<Member> {
	private EntityManager manager;

	public MemberDAO(EntityManager manager) {
		this.manager = manager;
	}

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
