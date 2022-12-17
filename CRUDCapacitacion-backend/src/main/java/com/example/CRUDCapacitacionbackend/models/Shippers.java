package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shippers")
public class Shippers {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShipperID;
    @Getter @Setter @Column(length = 40) @NonNull
    private String CompanyName;
    @Getter @Setter @Column(length = 24)
    private String Phone;
}
