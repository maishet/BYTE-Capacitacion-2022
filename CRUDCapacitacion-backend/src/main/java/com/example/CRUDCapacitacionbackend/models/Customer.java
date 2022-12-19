package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "customers", indexes = {
        @Index(columnList = "City"),
        @Index(columnList = "CompanyName"),
        @Index(columnList = "PostalCode"),
        @Index(columnList = "Region")
})
public class Customer {
    @Id
    @Getter @Setter @Column(length = 5)
    private String customerID;
    @Getter @Setter @Column(length = 40)
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customer")
    private List<Order> ordercustomers;
}
