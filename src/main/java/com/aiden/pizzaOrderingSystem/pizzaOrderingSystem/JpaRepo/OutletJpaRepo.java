package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.JpaRepo;

import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletJpaRepo extends JpaRepository<Outlet, Integer> {

}
