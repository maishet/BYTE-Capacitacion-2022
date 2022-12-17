package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employees {
    @Id @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmployeeID;
    @Getter @Setter @Column(length = 20) @NonNull
    private String LastName;
    @Getter @Setter @Column(length = 10) @NonNull
    private String FirstName;
    @Getter @Setter @Column(length = 30)
    private String Title;
    @Getter @Setter @Column(length = 25)
    private String TitleOfCourtesy;
    @Getter @Setter
    private Timestamp BirthDate;
    @Getter @Setter
    private Timestamp HireDate;
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
    private String HomePhone;
    @Getter @Setter @Column(length = 4)
    private String Extension;
    @Getter @Setter
    private byte[] Photo;
    @Getter @Setter
    private String Notes;
    @Getter @Setter
    private int ReportsTo;
}
