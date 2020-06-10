package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.controller;

import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Pizza;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("/rest/pizza/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable("id") Integer pizzaId) {
        Pizza pizza = this.pizzaService.getPizzaById(pizzaId);
        if (pizza == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pizza, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/rest/pizza", method = RequestMethod.POST)
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
        Pizza createdPizza = this.pizzaService.createPizza(pizza);
        if (createdPizza == null)
            return new ResponseEntity<>(createdPizza, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(createdPizza, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rest/pizza/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pizza> updatePizza(@PathVariable("id") int id, @RequestBody Pizza pizza) {
        pizza.setId(id);
        Pizza updatedPizza = this.pizzaService.updatePizza(pizza);
        if (updatedPizza == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/rest/pizza/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pizza> deletePizza(@PathVariable("id") Integer id) {
        this.pizzaService.deletePizza(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
