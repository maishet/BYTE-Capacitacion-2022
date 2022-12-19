package com.example.CRUDCapacitacionbackend;

import com.example.CRUDCapacitacionbackend.models.Usuario;
import com.example.CRUDCapacitacionbackend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class CrudCapacitacionBackendApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void crearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setName("admin");
		usuario.setClave(bCryptPasswordEncoder.encode("12345"));
		Usuario retorno = userRepository.save(usuario);
		assertTrue(retorno.getClave().equalsIgnoreCase(usuario.getClave()));
	}

}
