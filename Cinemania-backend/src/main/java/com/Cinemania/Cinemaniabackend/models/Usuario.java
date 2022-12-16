package com.Cinemania.Cinemaniabackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id //valor unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //en la tabla el iD se autoincremente
    @Getter @Setter
    private int usr_id;
    @Getter @Setter
    private String usr_username;
    @Getter @Setter
    private String usr_password;
    @Getter @Setter
    private String usr_fullname;
    @Getter @Setter
    private String usr_email;
    @Getter @Setter
    private String usr_photo;
    @Getter @Setter
    private boolean usr_estado = true;
    @Getter @Setter
    private String usr_ultima_sesion;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_rol")
    private Rol rol;

}
