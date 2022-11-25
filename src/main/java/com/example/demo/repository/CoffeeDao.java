package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coffee;

public interface CoffeeDao extends JpaRepository<Coffee, String>{
	List<Coffee> findByName(String name);

}
