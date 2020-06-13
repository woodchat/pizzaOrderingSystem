package com.aiden.pizzaOrderingSystem.pizzaOrderingSystem.Model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(name = "open_at", nullable = false)
    private Time openAt;

    @Column(name = "close_at", nullable = false)
    private Time closeAt;


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
