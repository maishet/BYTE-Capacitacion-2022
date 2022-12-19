package com.example.CRUDCapacitacionbackend.controllers;

import com.example.CRUDCapacitacionbackend.models.Usuario;
import com.example.CRUDCapacitacionbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        usuario.setClave(this.bCryptPasswordEncoder.encode(usuario.getClave()));
        return usuarioService.saveUsuario(usuario);
    }
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        usuarioService.updateUsuario(username);
        return usuarioService.getUsuario(username);
    }
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") int usuarioId){
        usuarioService.deteleUsuario(usuarioId);
    }
}
