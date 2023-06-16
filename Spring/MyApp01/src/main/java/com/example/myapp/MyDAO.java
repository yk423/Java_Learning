package com.example.myapp;

import java.io.Serializable;
import java.util.List;

public interface MyDAO<E> extends Serializable {
	public List<E> findAll();
	public E find(String id);
	public boolean insert(E entity);
	public boolean update(E entity);
	public boolean delete(E entity);
}
