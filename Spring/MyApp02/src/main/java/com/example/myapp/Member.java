package com.example.myapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Members")
@NamedQueries({
		@NamedQuery(name="findAllMembers", query="SELECT m FROM Member m"),
		@NamedQuery(name="findMemberById", query="SELECT m FROM Member m WHERE m.id = :id")
})
public class Member {
	@Id
	private String id;
	private String name;
	private int age;

	public Member() {}

	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
