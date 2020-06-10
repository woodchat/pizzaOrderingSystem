package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Service;

import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.JpaRepo.OutletJpaRepo;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Outlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutletService {

    @Autowired
    private OutletJpaRepo outletJpaRepo;

    public Outlet getOutletById(Integer id) {
        return this.outletJpaRepo.findById(id).orElse(null);
    }

    public Outlet createOutlet(Outlet outlet) {
        if (outlet.getId()!=0) return null;
        else {
            return this.outletJpaRepo.save(outlet);
        }
    }

    public Outlet updateOutlet(Outlet outlet) {
        Outlet getOutlet = this.outletJpaRepo.findById(outlet.getId()).orElse(null);
        if (getOutlet==null) return null;
        else return this.outletJpaRepo.save(outlet);
    }

    public void deleteOutlet(Integer id) {
        Outlet outlet = this.outletJpaRepo.findById(id).orElse(null);
        if (outlet!=null) this.outletJpaRepo.delete(outlet);
    }
}
