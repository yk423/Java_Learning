package com.example.myapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	public List<Product> findByPriceBetween(Integer value1, Integer value2);
	public List<Product> findByPriceIn(Integer[] values);

	@Query("SELECT p FROM Product p ORDER BY p.price ASC")
	public List<Product> findAllOrderByPriceAsc();

	@Query(
		value="SELECT id, price, name FROM Products ORDER BY price DESC",
		nativeQuery=true
	)
	public List<Product> findAllOrderByPriceDesc();

	@Query("SELECT p FROM Product p WHERE p.price >= :price")
	public List<Product> findByPrice(@Param("price") Integer price);
}
