package com.example.CRUDCapacitacionbackend.services;

import com.example.CRUDCapacitacionbackend.models.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario) throws Exception;

    Usuario getUsuario(String username);

    void updateUsuario(String usuario);

    void deteleUsuario(int id);
}
