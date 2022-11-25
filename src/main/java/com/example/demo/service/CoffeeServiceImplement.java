package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Coffee;

public interface CoffeeServiceImplement {

	Iterable<Coffee> getAllCoffees();  //get la liste des tout les coffees

	Coffee postAcoffee(Coffee coffee); //modifie a coffee

	Optional<Coffee> getAcoffeeById(String id); //Optional quand on essaie de  modier un obet coffee si il exit pas il cree l'ojet

	ResponseEntity<Coffee> putAcoffee(String id, Coffee coffee);

	void deleteAcoffee(String id);

	List<Coffee> getCoffeesByName(String name);

}