package com.example.demo.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Coffee;
import com.example.demo.repository.CoffeeDao;
import com.example.demo.service.CoffeeServiceImplement;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
	 private CoffeeServiceImplement coffeeService;
	//private  CoffeeDao coffeeDao;
	
	@Autowired
	 public RestApiDemoController(CoffeeServiceImplement coffeeService) {
			this.coffeeService = coffeeService;
		}			
//	private List<Coffee> coffees = new ArrayList<>(); // arraylist par indice comme arrays 
//	
//    public RestApiDemoController() {
//		coffees.addAll(
//				List.of(new Coffee("Distributeur"),
//						new Coffee("Café Cereza"),
//						new Coffee("Café Ganador"),
//						new Coffee("Café Lareno")));
//	}
    /* **
     * @GetMapping 
     */
	 
     @GetMapping 
     Iterable< Coffee> getCoffees(){
    	 //return coffeeDao.findAll();
    	return coffeeService.getAllCoffees();
     }

//     public List<Coffee> getCoffees() {
//    	return coffees;
//    	}
     /**
      * 
      * @param coffee @requestBody transform an objet java 
      * @return return l'objet coffee en form json
      */
     @PostMapping
     Coffee postCoffe(@RequestBody Coffee coffee) {
    	 return coffeeService.postAcoffee(coffee);
     }
//     public Coffee postCoffe(@RequestBody Coffee coffee) {
//    	 //coffee.setId(UUID.randomUUID().toString());
//    	 coffees.add(coffee);
//		return coffee;
//	}
    /**
     * Optional pour eviter  un null pointer. on a une boite soit 
     * vide ou un element
     * @param id
     * @return
     */
     @GetMapping ("/name/{name}") 
     public List <Coffee> getAcoffeeByName(@PathVariable String name){
    	 return (List<Coffee>) coffeeService.getCoffeesByName(name);
     }

     @GetMapping ("/{id}") 
     Optional<Coffee> getCoffeeById(@PathVariable String id){
    	 return coffeeService.getAcoffeeById(id);
     }
//    public Optional<Coffee> getCoffeeById(@PathVariable String id) {
//    	 for (Coffee coffee : coffees) {
//			if(coffee.getId().equals(id)) {
//				return Optional.of(coffee); // return un optional avec objet coffee
//			}
//		}
//    	return Optional.empty(); // static factorial
//		
//	}
//     @GetMapping ("/coffees/{id}") 
//     public Coffee getCoffeeById(@PathVariable String id) {
//     	 for (Coffee coffee : coffees) {
// 			if(coffee.getId().equals(id)) {
// 				return coffee; // return un optional avec objet coffee
// 			}
// 			
// 		}
//     	return null;
//     	//return Optional.empty(); // static factorial
// 		
// 	}
     /**
      * 
      * @param id
      * @param coffee fluid json transformer en objet json
      * @coffeeIndex stock les index
      * for boocle sur tout les element
      * indexOf recupere son emplacement dans la liste
      * 
      * @return
      */
     @PutMapping("/{id}") 
     ResponseEntity<Coffee> putCoffee(@PathVariable String id , @RequestBody Coffee coffee){
    	 return coffeeService.putAcoffee(id, coffee);				 
     }
     
//     public ResponseEntity<Coffee> putCoffee(@PathVariable String id , @RequestBody Coffee coffee){
//    	 int coffeIndex = -1;
//    	 for (Coffee c : coffees) {
//			if(c.getId().equals(id)) {
//				coffeIndex  = coffees.indexOf(c);
//				coffees.set(coffeIndex, c);
//			}
//	
//		}
//    	 return (coffeIndex ==-1) ? new ResponseEntity<Coffee>(postCoffe(coffee), HttpStatus.CREATED) : 
//    		 new ResponseEntity<Coffee> (coffee, HttpStatus.OK );
//		
//	}
     @DeleteMapping("/{id}")
     void deleteCoffee(@PathVariable String id) {
    	coffeeService.deleteAcoffee(id);
     }
     
//    public void deleteCoffee(@PathVariable String id) {
//    	 Coffee coffee;
//    	 for (Coffee c : coffees) {
//			if(c.getId().equals(id)) {
//				coffees.remove(id);
//				
//			}
//		}
//		//coffees.removeIf(coffee -> coffee.getId().equals(id));
//    	 
//    	 
//	} 
  }

