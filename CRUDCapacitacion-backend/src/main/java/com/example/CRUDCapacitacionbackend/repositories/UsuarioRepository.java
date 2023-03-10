package com.example.CRUDCapacitacionbackend.repositories;

import com.example.CRUDCapacitacionbackend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByName(String username);
}
