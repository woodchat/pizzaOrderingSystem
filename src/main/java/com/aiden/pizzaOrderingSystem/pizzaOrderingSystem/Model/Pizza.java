package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pizza {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OUTLET_ID", referencedColumnName="ID", insertable=false, updatable=false)
    @JsonBackReference
    private Outlet outlet;

    private int outletId;

    @NotNull
    private String name;

    private char size;

    private String description;

    private double price;


}
