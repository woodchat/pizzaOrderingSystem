package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.JpaRepo;

import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Outlet;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaJpaRepo extends JpaRepository<Pizza, Integer> {

     List<Pizza> findByOutlet(Optional<Outlet> outlet);
     Pizza findByOutletAndName(Outlet outlet, String name);
     List<Pizza> findByNameLike(String name);

}
