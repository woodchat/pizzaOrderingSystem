package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.controller;

import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model.Outlet;
import com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OutletController {

    @Autowired
    private OutletService outletService;

    @RequestMapping("/rest/outlet/{id}")
    public ResponseEntity<Outlet> getOutletById(@PathVariable("id") int id) {
        Outlet outlet = this.outletService.getOutletById(id);
        if (outlet==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }

    @RequestMapping(value = "/rest/outlet", method = RequestMethod.POST)
    public ResponseEntity<Outlet> createOutlet(@RequestBody Outlet Outlet) {
        Outlet createdOutlet = this.outletService.createOutlet(Outlet);
        if (createdOutlet == null)
            return new ResponseEntity<>(createdOutlet, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(createdOutlet, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/rest/outlet/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Outlet> updateOutlet(@PathVariable("id") int id, @RequestBody Outlet Outlet) {
        Outlet.setId(id);
        Outlet updatedOutlet = this.outletService.updateOutlet(Outlet);
        if (updatedOutlet == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/rest/outlet/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Outlet> deleteOutlet(@PathVariable("id") Integer id) {
        this.outletService.deleteOutlet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
