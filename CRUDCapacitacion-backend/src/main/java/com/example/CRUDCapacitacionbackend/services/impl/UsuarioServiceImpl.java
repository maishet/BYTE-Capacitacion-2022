package com.example.CRUDCapacitacionbackend.services.impl;

import com.example.CRUDCapacitacionbackend.models.Usuario;
import com.example.CRUDCapacitacionbackend.repositories.UsuarioRepository;
import com.example.CRUDCapacitacionbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario saveUsuario(Usuario usuario){
        Usuario usuariolocal =usuarioRepository.findByName(usuario.getName());
        if (usuariolocal != null){
            System.out.println("El usuario ya existe");
            //throw new UsuarioFoundException("El usuario ya esta presente");
        }else {
            usuariolocal = usuarioRepository.save(usuario);
        }
        return usuariolocal;
    }

    @Override
    public Usuario getUsuario(String username) {
        return usuarioRepository.findByName(username);
    }

    @Override
    public void updateUsuario(String usuario) {

    }

    @Override
    public void deteleUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}
