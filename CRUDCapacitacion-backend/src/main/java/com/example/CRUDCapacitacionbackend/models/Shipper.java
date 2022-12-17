package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shippers")
public class Shipper {
    @Id
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShipperID;
    @Getter @Setter @Column(length = 40)
    private String CompanyName;
    @Getter @Setter @Column(length = 24)
    private String Phone;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "shipper")
    private Set<Order> ordershipper = new HashSet<>();
}
