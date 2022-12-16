package com.Cinemania.Cinemaniabackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //en la tabla el iD se autoincremente
    @Getter @Setter
    private int rol_id;
    @Getter @Setter
    private String rol_nombre;
    @Getter @Setter
    private String rol_estado;

    @OneToMany(mappedBy = "rol",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //los cambios se reflejan a las entidades hijas (cascade.all)
    private Set<Usuario> usuarios = new HashSet<>();

}
