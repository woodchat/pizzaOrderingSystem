package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Outlet {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    private String city;

    private String address;

    private String email;

    private String phone;

    private Time openAt;

    private Time closeAt;

    @OneToMany(mappedBy = "outlet", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pizza> pizzaMenu;

    public Outlet() {
    }

    public Outlet(int id, String name, String city, String address, String email, String phone, Date openAt,
                      Date closeAt) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.openAt = new Time(openAt.getTime());
        this.closeAt = new Time(closeAt.getTime());
    }
}
