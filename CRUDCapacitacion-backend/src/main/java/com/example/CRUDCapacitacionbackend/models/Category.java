package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoryID;
    @Getter @Setter @Column(length = 15)
    private String CategoryName;
    @Getter @Setter
    private String Description;
    @Getter @Setter
    private byte[] Picture;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "category")
    private List<Product> productcatecory;
    //private Set<Product> productcatecory = new HashSet<>();
}
