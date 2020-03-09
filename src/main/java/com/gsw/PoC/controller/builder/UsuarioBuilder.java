package com.gsw.PoC.controller.builder;

import org.springframework.stereotype.Service;

import com.gsw.PoC.controller.dto.UsuarioDTO;
import com.gsw.PoC.model.entity.Usuario;

@Service
public class UsuarioBuilder {

	private Usuario usuario;
	
	public Usuario builder(UsuarioDTO usuarioDTO) {
		return usuario = Usuario.builder().nome(usuarioDTO.getNome()).email(usuarioDTO.getEmail())
				.build(); 
	}
}
