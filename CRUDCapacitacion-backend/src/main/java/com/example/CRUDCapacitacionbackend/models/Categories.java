package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {

    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoryID;
    @Getter @Setter @Column(length = 15) @NonNull
    private String CategoryName;
    @Getter @Setter
    private String Description;
    @Getter @Setter
    private byte[] Picture;
}
