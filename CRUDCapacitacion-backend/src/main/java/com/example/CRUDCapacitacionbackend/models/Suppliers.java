package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SupplierID;
    @Getter @Setter @Column(length = 40) @NonNull
    private String CompanyName;
    @Getter @Setter @Column(length = 30)
    private String ContactName;
    @Getter @Setter @Column(length = 30)
    private String ContactTitle;
    @Getter @Setter @Column(length = 60)
    private String Address;
    @Getter @Setter @Column(length = 15)
    private String City;
    @Getter @Setter @Column(length = 15)
    private String Region;
    @Getter @Setter @Column(length = 10)
    private String PostalCode;
    @Getter @Setter @Column(length = 15)
    private String Country;
    @Getter @Setter @Column(length = 24)
    private String Phone;
    @Getter @Setter @Column(length = 24)
    private String Fax;
    @Getter @Setter
    private String HomePage;

}
