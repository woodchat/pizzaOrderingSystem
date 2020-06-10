package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Service;

import java.util.List;
import java.util.Optional;

import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.JpaRepo.OutletJpaRepo;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.JpaRepo.PizzaJpaRepo;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Outlet;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaService {

    @Autowired
    PizzaJpaRepo pizzaJpaRepo;

    @Autowired
    OutletJpaRepo outletJpaRepo;

    public List<Pizza> getAllPizzas() {
        return this.pizzaJpaRepo.findAll();
    }

    public List<Pizza> getAllPizzasByOutlets(int outletId) {
        Optional<Outlet> outlet = this.outletJpaRepo.findById(outletId);
        return this.pizzaJpaRepo.findByOutlet(outlet);
    }

    public Pizza getPizzaById(int pizzaId) {
        return this.pizzaJpaRepo.findById(pizzaId).orElse(null);
    }

    public List<Pizza> getPizzasByName(String name) {
        return this.pizzaJpaRepo.findByNameLike("%" + name.toLowerCase() + "%");
    }

    public Pizza createPizza(Pizza pizza) {
        Outlet parentOutlet = outletJpaRepo.findById(pizza.getOutletId()).orElse(null);
        if (parentOutlet == null)
            return null;
        else {
            pizza.setOutlet(parentOutlet);
            return this.pizzaJpaRepo.save(pizza);
        }
    }

    public Pizza updatePizza(Pizza pizza) {
        Pizza getPizza = this.pizzaJpaRepo.findById(pizza.getId()).orElse(null);
        if (getPizza == null)
            return null;
        return this.pizzaJpaRepo.save(getPizza);
    }
    public void deletePizza(int pizzaId) {
        Pizza pizza = this.pizzaJpaRepo.findById(pizzaId).orElse(null);
        if (pizza!=null) this.pizzaJpaRepo.delete(pizza);
    }
}
