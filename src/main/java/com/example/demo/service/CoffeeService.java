package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Coffee;
import com.example.demo.repository.CoffeeDao;

@Service
public class CoffeeService implements CoffeeServiceImplement {
	
	private CoffeeDao coffeeDao;
	

	public CoffeeService(CoffeeDao coffeeDao) {
		this.coffeeDao = coffeeDao;
	}
	 // call the repository
	@PostConstruct
	private void loadData() {
		coffeeDao.saveAll(
				List.of(new Coffee("Distributeur"),
						new Coffee("Café Cereza"),
						new Coffee("Café Ganador"),
						new Coffee("Café Lareno")
						));
		
	}
	
	@Override
	public Iterable <Coffee> getAllCoffees(){
		return coffeeDao.findAll();
	}
	 @Override
	public Coffee postAcoffee(Coffee coffee) {
   	 return coffeeDao.save(coffee);
    }
	@Override
	public  Optional<Coffee> getAcoffeeById(String id){
    	 return coffeeDao.findById(id);
     }
	@Override
	public  ResponseEntity<Coffee> putAcoffee(String id ,Coffee coffee){
    	 return (coffeeDao.existsById(id))
    			 ? new ResponseEntity<>(coffeeDao.save(coffee), HttpStatus.OK)
    			 : new ResponseEntity<>(coffeeDao.save(coffee), HttpStatus.CREATED);
    				 
     }
	@Override
	 public List <Coffee> getCoffeesByName(String name) {
		return coffeeDao.findByName(name);
	}
	@Override
	public  void deleteAcoffee(String id) {
    	 coffeeDao.deleteById(id);
     }
}
