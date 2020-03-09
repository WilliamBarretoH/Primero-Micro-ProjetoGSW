package com.gsw.PoC.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsw.PoC.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	
	boolean existsByEmail(String email);
}
